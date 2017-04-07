package com.openapi.service;

import com.google.inject.Inject;
import com.openapi.dao.JxCommunityMapper;
import com.openapi.annotation.mvc.Service;

/**
 * @author liuzeyuan
 */
@Service("jxCommunityServiceImpl")
public class JxCommunityServiceImpl implements JxCommunityService {

	@Inject
	JxCommunityMapper jxCommunityMapper;

	@Override
	public String selectIDByComName(String community_name) {
		return this.jxCommunityMapper.selectIDByComName(community_name);
	}
}
