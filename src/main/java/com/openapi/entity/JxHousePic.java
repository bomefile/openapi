package com.openapi.entity;

import java.util.Date;

public class JxHousePic {
	private Long	id;			//
	private Long	houseId;		// '房源表主键',
	private String	picType;		// '0 户型图 1室内图 2 小区图',
	private String	picPath;		// '原始图片800*600，存放在文件系统中的相对于挂载点的路径',
	private String	picSmallPath;	// '详情页小缩略图67*50，存放在文件系统中的相对于挂载点的路径',
	private String	picBigPath;		// '详情页显示大图600*450，存放在文件系统中的相对于挂载点的路径',
	private String	picListPath;	// '列表页标题图120*90，存放在文件系统中的相对于挂载点的路径',
	private String	picDispOrder;	// '图片的显示顺序，从1开始。',
	private String	status;		// '1 有效 0 以下全为无效 ',
	private String	creatorId;
	private Date	createTime;
	private String	updaterId;
	private Date	updateTime;
	private Date	lastModifyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public String getPicType() {
		return picType;
	}

	public void setPicType(String picType) {
		this.picType = picType;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPicSmallPath() {
		return picSmallPath;
	}

	public void setPicSmallPath(String picSmallPath) {
		this.picSmallPath = picSmallPath;
	}

	public String getPicBigPath() {
		return picBigPath;
	}

	public void setPicBigPath(String picBigPath) {
		this.picBigPath = picBigPath;
	}

	public String getPicListPath() {
		return picListPath;
	}

	public void setPicListPath(String picListPath) {
		this.picListPath = picListPath;
	}

	public String getPicDispOrder() {
		return picDispOrder;
	}

	public void setPicDispOrder(String picDispOrder) {
		this.picDispOrder = picDispOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}
