package com.openapi.dao;

import com.openapi.entity.JxHousePic;
import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Repository
public interface JxHousePicMapper {

	@Insert("INSERT INTO jx_house_pic (HOUSE_ID, PIC_TYPE, PIC_PATH, PIC_SMALL_PATH, PIC_BIG_PATH, PIC_LIST_PATH, STATUS) "//
			+ " VALUES (#{HOUSE_ID}, #{PIC_TYPE},#{PIC_PATH}, #{PIC_PATH}, #{PIC_PATH}, #{PIC_PATH}, '1')")
	Long insert(@Param("HOUSE_ID") String house_id, @Param("PIC_TYPE") String pic_type, @Param("PIC_PATH") String pic_path);

	@Delete("delete from jx_house_pic where house_id=#{house_id}")
	void realDeleteByHouseId(@Param("house_id") Long house_id);

	@Delete("delete from jx_house_pic where id=#{id}")
	void realDeleteById(@Param("id") String id);

	@Update("update jx_house_pic  set STATUS=0  where id=#{id}")
	void softDeleteById(@Param("id") String id);

	@Update("update jx_house_pic  set STATUS=0  where house_id=#{house_id}")
	void softDeleteByHouseId(@Param("house_id") Long house_id);

	@Select("select * from jx_house_pic  where house_id=#{house_id} and STATUS!=0")
	List<JxHousePic> selectByHouseId(@Param("house_id") String house_id);

	@Update("update jx_house_pic set PIC_PATH=#{picPath},PIC_SMALL_PATH=#{picSmallPath},PIC_BIG_PATH=#{picBigPath},PIC_LIST_PATH=#{picListPath} where id=#{id}")
	void updatePicPath(@Param("id") long id, @Param("picPath") String picPath, @Param("picSmallPath") String picSmallPath, @Param("picBigPath") String picBigPath, @Param("picListPath") String picListPath);

	@Select("SELECT * FROM jx_house_pic p WHERE p.STATUS!=0 AND p.PIC_PATH LIKE 'http%' and p.LAST_MODIFY_TIME>=#{lastModifyTime} order by p.LAST_MODIFY_TIME desc")
	List<JxHousePic> selectHouseIdWithStartHttp(@Param("lastModifyTime") Date lastModifyTime);

}
