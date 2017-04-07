package com.openapi.service;

import com.google.inject.Inject;
import com.openapi.annotation.mvc.Service;
import com.openapi.config.ConfigHolder;
import com.openapi.dao.*;
import com.openapi.entity.JxHouseTuitui;
import com.openapi.entity.JxRent;
import com.openapi.exception.ShowTextException;
import com.openapi.util.CosineSimilarAlgorithm;
import com.openapi.util.StringUtil;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author liuzeyuan
 */
@Service("jxRentServiceImpl")
public class JxRentServiceImpl extends BaseService implements JxRentService {

	@Inject
	JxRentMapper jxRentMapper;
	@Inject
	JxRentTagMapper jxRentTagMapper;
	@Inject
	JxRentPicMapper			jxRentPicMapper;
	@Inject
	BasisDicInfoMapper basisDicInfoMapper;
	@Inject
	JxHouseTuituiMapper jxHouseTuituiMapper;
	@Inject
	JxHouseTuituiComMapper jxHouseTuituiComMapper;

	@Override
	public Integer tuituiRefresh(String houseId, Long agent_id) {
		return this.jxRentMapper.tuituiRefresh(houseId, agent_id);
	}

	public Integer tuituiDelete(String rent_id) {
		return this.jxRentMapper.disableHouse(rent_id);
	}

	public List<JxRent> selectAvaliableByAgentIdTuitui(Long agent_id) {
		return this.jxRentMapper.selectAvaliableByAgentIdTuitui(agent_id);
	}

	@Override
	@Transactional
	public String tuituiRegist(Map<String, String> params, final String type, final String token, final String pkId, final Long agent_id, final JxHouseTuitui tuituiInfo) throws ShowTextException {
		final String house_title = params.get("Topic");
		//
		String rent_id = null;
		// 修改房源的时候不修改图片了，为了让图片服务器不用再删除
		if (tuituiInfo != null && tuituiInfo.getHouseId() != null) {// 修改房源
			params.put("HOUSE_ID", tuituiInfo.getHouseId() + "");
			rent_id = params.get("HOUSE_ID");
			this.jxRentMapper.tuituiUpdate(params);
			jxHouseTuituiMapper.refresh(token, pkId, type);
		} else {// --> insert发布房源
			String Thumbnail = StringUtil.trim(params.get("Thumbnail"));
			if (!(Thumbnail.toLowerCase().startsWith("http") && Thumbnail.toLowerCase().endsWith("jpg"))) {
				throw new ShowTextException("封面图片格式不正确[jpg]:" + Thumbnail);
			}
			//
			// 新插入数据时,判断是否是重复的
			List<JxRent> jxRents = this.selectAvaliableByAgentIdTuitui(agent_id);
			// 限制50条生效房源
			if (jxRents != null && jxRents.size() >= ConfigHolder.getAgentHasHouseMaxCount()) {
				throw new ShowTextException("房源超过数量" + ConfigHolder.getAgentHasHouseMaxCount() + "个限制!");
			}
			//
			for (JxRent jxRent : jxRents) {
				final String m_house_tilte = jxRent.getHouseTitle();
				// String m_house_text = jxRent.getHouseText();
				double titleSimilarityRate = CosineSimilarAlgorithm.getSimilarity(house_title.toLowerCase(), m_house_tilte.toLowerCase());
				// double textSimilarityRate = CosineSimilarAlgorithm.getSimilarity(house_text, m_house_text);
				if (titleSimilarityRate == 1.0) {
					throw new ShowTextException("您的扎根账户下已经存在此租房房源");
				}
			}

			// 执行插入
			this.jxRentMapper.tuituiInsert(params);
			rent_id = params.get("HOUSE_ID");
			// 插入主键+来源 唯一标识列
			jxHouseTuituiMapper.insert(rent_id, token, pkId, agent_id, type);
			// -->配套设施
			String Infrastructure = StringUtil.trim(params.get("Infrastructure"));
			if (StringUtil.isNotBlank(Infrastructure)) {
				String[] Infrastructures = Infrastructure.split(",");
				List<String> codes = basisDicInfoMapper.selectCodeIdsByNames(Infrastructures);
				if (codes != null && codes.size() > 0) {
					int tag_cnt = 0;
					for (String code : codes) {
						if (tag_cnt < 3) {// ios端说要求标签只有三个
							jxRentTagMapper.insert(rent_id, code, "0");// 0表示配套设施
							tag_cnt++;
						}
					}
				}
			}
			boolean hasPicFlag = false;// 有无除封面图片外的其图片标识
			// -->插入图片
			// 户型图
			String Floorplans = StringUtil.trim(params.get("Floorplans"));
			if (StringUtil.isNotBlank(Floorplans)) {
				String[] paths = Floorplans.split(",");
				for (String path : paths) {
					path = StringUtil.trim(path);
					if (path != null && !path.endsWith("/")) {
						if (StringUtil.isNotBlank(path)) {
							hasPicFlag = true;
							jxRentPicMapper.insert(rent_id, "0", path);
						}
					}
				}
			}
			// 室内图
			String PhotoInterior = StringUtil.trim(params.get("PhotoInterior"));
			if (StringUtil.isNotBlank(PhotoInterior)) {
				String[] paths = PhotoInterior.split(",");
				for (String path : paths) {
					path = StringUtil.trim(path);
					if (path != null && !path.endsWith("/")) {
						if (StringUtil.isNotBlank(path)) {
							hasPicFlag = true;
							jxRentPicMapper.insert(rent_id, "1", path);
						}
					}
				}
			}
			// 小区图
			String PhotoOutdoor = StringUtil.trim(params.get("PhotoOutdoor"));
			if (StringUtil.isNotBlank(PhotoOutdoor)) {
				String[] paths = PhotoOutdoor.split(",");
				for (String path : paths) {
					path = StringUtil.trim(path);
					if (path != null && !path.endsWith("/")) {
						if (StringUtil.isNotBlank(path)) {
							hasPicFlag = true;
							jxRentPicMapper.insert(rent_id, "2", path);
						}
					}
				}
			}
			if (!hasPicFlag) {// 如果没有非封面图片
				// 封面图
				if (StringUtil.isNotBlank(Thumbnail)) {
					// 封面图插入到室内图
					jxRentPicMapper.insert(rent_id, "1", Thumbnail);
				}
			}
		}
		return rent_id;

	}
}
