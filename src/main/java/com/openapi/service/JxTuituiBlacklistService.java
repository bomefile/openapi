package com.openapi.service;

import com.openapi.entity.JxTuituiBlacklist;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuzeyuan
 */
public interface JxTuituiBlacklistService {

	JxTuituiBlacklist selectExist(@Param("name") String name, @Param("type") String type);
}
