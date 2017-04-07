package com.openapi.dao.hr;

import com.openapi.annotation.mvc.Repository;
import com.openapi.entity.JxUserBaidu;
import com.openapi.entity.hr.DataBlockEntity;
import com.openapi.entity.hr.HrSetIdEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Repository
public interface HrSetIdMappper {

	@Insert({"INSERT INTO `hr_set_id` " ,
			"(`set_id`, `descr`, `descr_short`, `flag`, `transfer_id`, `batch_num`, `transfer_date_time`, `push_data_type`, `create_time`)" ,
			" VALUES" ,
			" (#{setId}, #{descr}, #{descrShort}, #{flag}, #{transferId}, #{batchNum}, #{transferDateTime}, #{pushDataType}, now())"})
	Integer insert(HrSetIdEntity entity);


	/**
	 * 批量插入
	 * @param list
	 * @return
     */
	@Insert({ "<script>",

			"INSERT INTO `hr_set_id` " ,
			"(`set_id`, `descr`, `descr_short`, `flag`, `transfer_id`, `batch_num`, `transfer_date_time`, `push_data_type`, `create_time`)" ,
			" VALUES" ,
			"<foreach item='item' index='index' collection='list' separator=','>",
			"(#{item.setId}, #{item.descr}, #{item.descrShort}, #{item.flag}, #{item.transferId}, #{item.batchNum}, #{item.transferDateTime}, #{item.pushDataType}, now())",
			"</foreach>",
			"</script>" })

	Integer insertBatch(List<HrSetIdEntity> list);

	@Insert({ "<script>",
			"INSERT INTO `hr_set_id` " ,
			"(`set_id`, `descr`, `descr_short`, `flag`, `transfer_id`, `batch_num`, `transfer_date_time`, `push_data_type`, `create_time`)" ,
			" VALUES" ,
			"<foreach item='item' index='index' collection='batchLines' separator=','>",
			"(#{item.setId}, #{item.descr}, #{item.descrShort}, #{flag}, #{transferId}, #{batchNum}, #{transferDateTime}, #{pushDataType}, now())",
			"</foreach>",
			"</script>" })
	Integer insertBatchEntity(DataBlockEntity<HrSetIdEntity> entity);
}
