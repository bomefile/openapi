package com.openapi.service;

import com.google.inject.Inject;
import com.openapi.entity.JxTuituiBlacklist;
import com.openapi.annotation.mvc.Service;
import com.openapi.dao.JxTuituiBlacklistMapper;

/**
 * @author liuzeyuan
 */
@Service("jxTuituiBlacklistServiceImpl")
public class JxTuituiBlacklistServiceImpl implements JxTuituiBlacklistService {

	@Inject
	JxTuituiBlacklistMapper	jxTuituiBlacklistMapper;

	@Override
	public JxTuituiBlacklist selectExist(String name, String type) {
		return jxTuituiBlacklistMapper.selectExist(name, type);
	}

}
