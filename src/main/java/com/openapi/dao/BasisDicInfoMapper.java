package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Repository
public interface BasisDicInfoMapper {

	@Select("select CODE from basis_dic_info where NAME like #{name} and type =#{type} limit 1")
	String selectCodeIdByName(@Param("name") String name, @Param("type") int type);

	// @Select("select CODE from basis_dic_info where FIND_IN_SET(NAME,${names})<>0")
	@Select({ "<script>", //
			"select CODE from basis_dic_info where NAME IN", //
			"<foreach item='item' index='index' collection='names' open='(' separator=',' close=')'>",//
			"#{item}", //
			"</foreach>",//
			"</script>" })
	List<String> selectCodeIdsByNames(@Param("names") String[] names);
}
