package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Repository
public interface JxTuituiBlackwordMapper {

	@Select("SELECT word from jx_tuitui_blackword ")
	List<String> selectALLWords();

}
