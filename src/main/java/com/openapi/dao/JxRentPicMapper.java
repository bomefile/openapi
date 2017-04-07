package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import com.openapi.entity.JxRentPic;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Repository
public interface JxRentPicMapper {

	@Insert("INSERT INTO jx_rent_pic (rent_id, PIC_TYPE, PIC_PATH, PIC_SMALL_PATH, PIC_BIG_PATH, PIC_LIST_PATH, STATUS) "//
			+ " VALUES (#{rent_id}, #{PIC_TYPE},#{PIC_PATH}, #{PIC_PATH}, #{PIC_PATH}, #{PIC_PATH}, '1')")
	Long insert(@Param("rent_id") String rent_id, @Param("PIC_TYPE") String pic_type, @Param("PIC_PATH") String pic_path);

	@Delete("delete from jx_rent_pic where rent_id=#{rent_id}")
	void realDeleteByRentId(@Param("rent_id") Long rent_id);

	@Delete("delete from jx_rent_pic where id=#{id}")
	void realDeleteById(@Param("id") String id);

	@Update("update jx_rent_pic  set STATUS=0  where id=#{id}")
	void softDeleteById(@Param("id") String id);

	@Update("update jx_rent_pic  set STATUS=0  where rent_id=#{rent_id}")
	void softDeleteByHouseId(@Param("rent_id") Long rent_id);

	@Select("select * from jx_rent_pic  where rent_id=#{rent_id} and STATUS!=0")
	List<JxRentPic> selectByHouseId(@Param("rent_id") String rent_id);

	@Update("update jx_rent_pic set PIC_PATH=#{picPath},PIC_SMALL_PATH=#{picSmallPath},PIC_BIG_PATH=#{picBigPath},PIC_LIST_PATH=#{picListPath} where id=#{id}")
	void updatePicPath(@Param("id") long id, @Param("picPath") String picPath, @Param("picSmallPath") String picSmallPath, @Param("picBigPath") String picBigPath, @Param("picListPath") String picListPath);

	@Select("SELECT * FROM jx_rent_pic p WHERE p.STATUS!=0 AND p.pic_path LIKE 'http%' and p.LAST_MODIFY_TIME>=#{lastModifyTime} order by p.LAST_MODIFY_TIME desc")
	List<JxRentPic> selectHouseIdWithStartHttp(@Param("lastModifyTime") Date lastModifyTime);

}
