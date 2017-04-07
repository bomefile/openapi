package com.openapi.service;

import com.google.inject.Inject;
import com.openapi.annotation.mvc.Service;
import com.openapi.dao.BasisDicInfoMapper;

import java.util.List;

/**
 * @author liuzeyuan
 */
@Service("basisDicInfoServiceImpl")
public class BasisDicInfoServiceImpl implements BasisDicInfoService {

	@Inject
	BasisDicInfoMapper	basisDicInfoMapper;

	@Override
	public String selectCodeIdByName(String name, int type) {
		return this.basisDicInfoMapper.selectCodeIdByName(name, type);
	}

	@Override
	public List<String> selectCodeIdsByNames(String[] names) {
		return this.basisDicInfoMapper.selectCodeIdsByNames(names);
	}

}
