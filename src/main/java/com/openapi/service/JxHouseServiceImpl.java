package com.openapi.service;

import com.google.inject.Inject;
import com.openapi.annotation.mvc.Service;
import com.openapi.config.ConfigHolder;
import com.openapi.dao.*;
import com.openapi.entity.JxHouse;
import com.openapi.entity.JxHouseTuitui;
import com.openapi.exception.ShowTextException;
import com.openapi.util.CosineSimilarAlgorithm;
import com.openapi.util.StringUtil;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author liuzeyuan
 */
@Service("jxHouseServiceImpl")
public class JxHouseServiceImpl extends BaseService implements JxHouseService {

	@Inject
	JxHouseMapper jxHouseMapper;
	@Inject
	JxHouseTabMapper jxHouseTabMapper;
	@Inject
	JxHousePicMapper jxHousePicMapper;
	@Inject
	BasisDicInfoMapper basisDicInfoMapper;
	@Inject
	JxHouseTuituiMapper jxHouseTuituiMapper;

	@Override
	public Integer tuituiRefresh(String houseId, Long agent_id) {
		return this.jxHouseMapper.tuituiRefresh(houseId, agent_id);
	}

	public Integer tuituiDelete(String houseId) {
		return this.jxHouseMapper.disableHouse(houseId);
	}

	@Override
	@Transactional
	public String tuituiRegist(Map<String, String> params, final String type, final String token, final String pkId, final Long agent_id, final JxHouseTuitui tuituiInfo) throws ShowTextException {
		final String house_title = params.get("Topic");

		String house_id = null;
		// 修改房源的时候不修改图片了，为了让图片服务器不用再删除
		if (tuituiInfo != null && tuituiInfo.getHouseId() != null) {// 修改房源
			params.put("HOUSE_ID", tuituiInfo.getHouseId() + "");
			house_id = params.get("HOUSE_ID");
			this.jxHouseMapper.tuituiUpdate(params);
			jxHouseTuituiMapper.refresh(token, pkId, type);
		} else {// --> insert发布房源
			String Thumbnail = StringUtil.trim(params.get("Thumbnail"));
			if (!(Thumbnail.toLowerCase().startsWith("http") && Thumbnail.toLowerCase().endsWith("jpg"))) {
				throw new ShowTextException("封面图片格式不正确[jpg]:" + Thumbnail);
			}
			//
			// 新插入数据时,判断是否是重复的
			List<JxHouse> jxHouses = this.selectAvaliableByAgentIdTuitui(agent_id);
			// 限制60条生效房源
			if (jxHouses != null && jxHouses.size() >= ConfigHolder.getAgentHasHouseMaxCount()) {
				throw new ShowTextException("房源超过数量" + ConfigHolder.getAgentHasHouseMaxCount() + "个限制!");
			}
			//
			for (JxHouse jxHouse : jxHouses) {
				final String m_house_tilte = jxHouse.getHouseTitle();
				// String m_house_text = jxHouse.getHouseText();
				double titleSimilarityRate = CosineSimilarAlgorithm.getSimilarity(house_title.toLowerCase(), m_house_tilte.toLowerCase());
				// double textSimilarityRate = CosineSimilarAlgorithm.getSimilarity(house_text, m_house_text);
				if (titleSimilarityRate == 1.0) {
					throw new ShowTextException("您的扎根账户下已经存在此二手房房源");
				}
			}
			// 执行插入
			this.jxHouseMapper.tuituiInsert(params);
			house_id = params.get("HOUSE_ID");
			// 插入主键+来源 唯一标识列
			jxHouseTuituiMapper.insert(house_id, token, pkId, agent_id, type);
			// -->配套设施
			String Infrastructure = StringUtil.trim(params.get("Infrastructure"));
			if (StringUtil.isNotBlank(Infrastructure)) {
				String[] Infrastructures = Infrastructure.split(",");
				List<String> codes = basisDicInfoMapper.selectCodeIdsByNames(Infrastructures);
				if (codes != null && codes.size() > 0) {
					int tag_cnt = 0;
					for (String code : codes) {
						if (tag_cnt < 3) {// ios端说要求标签只有三个
							jxHouseTabMapper.insert(house_id, code, "0");// 0标示配套设施
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
							jxHousePicMapper.insert(house_id, "0", path);
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
							jxHousePicMapper.insert(house_id, "1", path);
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
							jxHousePicMapper.insert(house_id, "2", path);
						}
					}
				}
			}

			if (!hasPicFlag) {// 如果没有非封面图片
				// 封面图
				if (StringUtil.isNotBlank(Thumbnail)) {
					// 封面图插入到室内图
					jxHousePicMapper.insert(house_id, "1", Thumbnail);
				}
			}
		}
		return house_id;
	}

	@Override
	public List<JxHouse> selectAvaliableByAgentIdTuitui(Long agent_id) {
		return this.jxHouseMapper.selectAvaliableByAgentIdTuitui(agent_id);
	}

}
