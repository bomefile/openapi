package com.openapi.service;

import com.google.inject.Inject;
import com.openapi.annotation.aop.IntercepterBy;
import com.openapi.annotation.mvc.Service;
import com.openapi.config.ConfigHolder;
import com.openapi.constants.TuituiConstants;
import com.openapi.dao.*;
import com.openapi.entity.JxAgent;
import com.openapi.exception.ShowTextException;
import com.openapi.interceptor.Intercept;
import com.openapi.util.QRCodeUtil;
import com.openapi.util.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.mybatis.guice.transactional.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @author liuzeyuan
 */
@Service("JxAgentServiceImpl")
public class JxAgentServiceImpl extends BaseService implements JxAgentService {

	@Inject
	JxAgentMapper jxAgentMapper;
	@Inject
	AgentOrgMapper agentOrgMapper;
	@Inject
	JxAgentAuthMapper			jxAgentAuthMapper;
	@Inject
	BasisCityMapper basisCityMapper;
	@Inject
	BasisDistrictMapper basisDistrictMapper;
	@Inject
	BasisBusinessDistrictMapper basisBusinessDistrictMapper;

	@Override
	@IntercepterBy(Intercept.class)
	public JxAgent tuituiLogin(String mobile, String password) {
//		password = DigestUtils.md5Hex(password);
		//
		System.out.println("3tuituituitutituituitutitiu");
		return null;
	}

	@Override
	@Transactional
	public void tuituiRegist(String zone, String street, Map<String, String> values) throws ShowTextException {
		String mobile = values.get("Mobile");
		int mobile_cnt = this.jxAgentMapper.selectByMobileCnt(mobile);
		if (mobile_cnt > 0) {
			throw new ShowTextException("手机号被占用");
		}
		String cityName = TuituiConstants.getCity(values.get("city"));
		String city_id = basisCityMapper.selectCityCodeByName(cityName + "%");
		String bd_id = basisDistrictMapper.selectBdIdByName(zone);
		String bbd_id = basisBusinessDistrictMapper.selectBBdIdByName(street);
		String org_id = agentOrgMapper.selectAoIdByName(values.get("Company1"));
		values.put("ORG_ID", org_id);
		values.put("CITY_ID", city_id);
		values.put("BD_ID", bd_id);
		values.put("BBD_ID", bbd_id);
		values.put("userKey", DigestUtils.md5Hex(values.get("userKey")));
		values.put("USER_CODE", DateFormatUtils.format(new Date(), "yyyyMMdd") + RandomStringUtils.randomNumeric(5));
		if (values.get("Photo") == null || values.get("Photo").endsWith("/")) {
			values.put("Photo", "");
		}
		// 注册经纪人 并返回了经纪人ID-->AGENT_ID
		this.jxAgentMapper.tuituiInsert(values);
		String agent_id = values.get("AGENT_ID");
		// 产生二维码
		try {
			QRCodeUtil.write(ConfigHolder.getFileServerPath() + ConfigHolder.getAgentQrCodePath() + agent_id + ".png", ConfigHolder.getAgentBaseUrl(agent_id), 132, 1);
		} catch (IOException e) {
			throw new ShowTextException("二维码生成失败");
		}
		if (StringUtil.isNotBlank(values.get("PhotoIDCard")) && !values.get("PhotoIDCard").endsWith("/")) {
			this.jxAgentAuthMapper.tuituiInsertIDCard(values);
		}
	}
}
