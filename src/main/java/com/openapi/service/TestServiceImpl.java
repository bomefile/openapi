package com.openapi.service;

import com.google.inject.Inject;
import com.openapi.annotation.mvc.Service;
import com.openapi.dao.TestMapper;
import org.mybatis.guice.transactional.Transactional;

/**
 * @author liuzeyuan
 */
@Service("testtttServiceImpl")
public class TestServiceImpl implements TestService {

	@Inject
	TestMapper	testMapper;

	@Override
	@Transactional
	public void dojob() {
		int count = this.testMapper.selectCnt();
		if (count < 50) {
			this.testMapper.insert();
		}
	}

}
