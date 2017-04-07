package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

@Repository
public interface TestMapper {

	@Insert("INSERT INTO `jx_event_gohome` (`line_name`, `line_id`, `date`, `add_date`) VALUES ('my line', 1000, '20141031', '2014-10-31 11:40:43')")
	void insert();

	@Select("SELECT count(*) count FROM (`jx_event_gohome`) WHERE `line_id` = 1000 AND `date` = 20141031")
	Integer selectCnt();
}
