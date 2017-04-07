package com.openapi.entity;

import java.util.Date;

public class JxRent {
	private Long	rentId;
	private Long	uid;				// '用户ID',
	private Long	agentId;			// '经纪人id',
	private Integer	ident;				// '1个人,2经纪人',
	private String	houseCode;			// '用户输入房源编号',
	private String	interHouseCode;		// '系统生成房源编号',
	private Integer	bdId;				// '区县',
	private Integer	bbdId;				// '商圈',
	private Integer	communityId;		// '社区或商圈',
	private String	communityName;		// '小区',
	private Integer	floorNo;			// '楼层位置',
	private Integer	totalFloor;			// '总楼层',
	private Integer	bedroomTotal;		// '卧室数量',
	private Integer	hallTotal;			// '客厅个数',
	private Integer	bathroomTotal;		// '卫数',
	private Integer	kitchenTotal;		// '厨房数',
	private Integer	balconyTotal;		// '阳台数',
	private String	hoId;				// '朝向',
	private String	hdId;				// '装修',
	private Integer	houseStatus;		// '房源状态(新：0待审核 1管理员审核通过后上线 2管理员推优 -1经纪人删除
	// -2经纪人下架 -3 过期 -4违规 -6已成交 -11
	// 管理员删除)　0下线状态　1在线　-1删除　-2管理员下线　-3过期　-5 委托经纪人',
	private Date	createTime;			// '创建时间',
	private Date	updateTime;			// '刷新时间',
	private Integer	updaterId;			// '更新者id',
	private String	houseType;			// '字典表 basis_dic_info WHERE TYPE=2',
	private Double	rental;				// '租金',
	private Integer	rentalUnit;			// '租金单位 1平方米 2方平米月 3月　',
	private Integer	rentalExtra;		// '例如 1压一付三',
	private Integer	rentType;			// '住宅赁租方式 dict_info.type=41',
	private Integer	checkingTime;		// '看房时间',
	private String	shopAddr;			// '商铺地址',
	private Integer	shopType;			// '商铺类型',
	private Integer	shopStatus;			// '商铺状态',
	private Integer	includePropertyFee;	// '是否含物业费',
	private Double	propertyFee;		// '物业费',
	private Integer	transfer;			// '是否转让',
	private Double	buildingArea;		// '建筑面积',
	private Integer	ifPartition;		// '是否可以分割 1可以 2不可以',
	private Integer	officeType;			// '写字楼类型',
	private Integer	officeTank;			// '写字楼级别',
	private String	houseTitle;			// '标题',
	private String	houseInfo;			// '房源描述',
	private String	houseText;			// '房源描述',
	private String	titleImg;			// '房源标题图',
	private String	finishedYear;		// '房屋的建成时间 例如 2014',
	private String	cityId;				// '城市id',
	private String	mobile;				// '其他手机号',
	private String	gender;				// '性别 m男 f女',
	private String	contacts;			// '个人房源 其他联系人',
	private String	adminOfflineCode;	// '下线原因',
	private String	adminOfflineOther;	// '下线自定义原因',

	public Long getRentId() {
		return rentId;
	}

	public void setRentId(Long rentId) {
		this.rentId = rentId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Integer getIdent() {
		return ident;
	}

	public void setIdent(Integer ident) {
		this.ident = ident;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getInterHouseCode() {
		return interHouseCode;
	}

	public void setInterHouseCode(String interHouseCode) {
		this.interHouseCode = interHouseCode;
	}

	public Integer getBdId() {
		return bdId;
	}

	public void setBdId(Integer bdId) {
		this.bdId = bdId;
	}

	public Integer getBbdId() {
		return bbdId;
	}

	public void setBbdId(Integer bbdId) {
		this.bbdId = bbdId;
	}

	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public Integer getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(Integer floorNo) {
		this.floorNo = floorNo;
	}

	public Integer getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(Integer totalFloor) {
		this.totalFloor = totalFloor;
	}

	public Integer getBedroomTotal() {
		return bedroomTotal;
	}

	public void setBedroomTotal(Integer bedroomTotal) {
		this.bedroomTotal = bedroomTotal;
	}

	public Integer getHallTotal() {
		return hallTotal;
	}

	public void setHallTotal(Integer hallTotal) {
		this.hallTotal = hallTotal;
	}

	public Integer getBathroomTotal() {
		return bathroomTotal;
	}

	public void setBathroomTotal(Integer bathroomTotal) {
		this.bathroomTotal = bathroomTotal;
	}

	public Integer getKitchenTotal() {
		return kitchenTotal;
	}

	public void setKitchenTotal(Integer kitchenTotal) {
		this.kitchenTotal = kitchenTotal;
	}

	public Integer getBalconyTotal() {
		return balconyTotal;
	}

	public void setBalconyTotal(Integer balconyTotal) {
		this.balconyTotal = balconyTotal;
	}

	public String getHoId() {
		return hoId;
	}

	public void setHoId(String hoId) {
		this.hoId = hoId;
	}

	public String getHdId() {
		return hdId;
	}

	public void setHdId(String hdId) {
		this.hdId = hdId;
	}

	public Integer getHouseStatus() {
		return houseStatus;
	}

	public void setHouseStatus(Integer houseStatus) {
		this.houseStatus = houseStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(Integer updaterId) {
		this.updaterId = updaterId;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public Double getRental() {
		return rental;
	}

	public void setRental(Double rental) {
		this.rental = rental;
	}

	public Integer getRentalUnit() {
		return rentalUnit;
	}

	public void setRentalUnit(Integer rentalUnit) {
		this.rentalUnit = rentalUnit;
	}

	public Integer getRentalExtra() {
		return rentalExtra;
	}

	public void setRentalExtra(Integer rentalExtra) {
		this.rentalExtra = rentalExtra;
	}

	public Integer getRentType() {
		return rentType;
	}

	public void setRentType(Integer rentType) {
		this.rentType = rentType;
	}

	public Integer getCheckingTime() {
		return checkingTime;
	}

	public void setCheckingTime(Integer checkingTime) {
		this.checkingTime = checkingTime;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public Integer getShopType() {
		return shopType;
	}

	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}

	public Integer getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(Integer shopStatus) {
		this.shopStatus = shopStatus;
	}

	public Integer getIncludePropertyFee() {
		return includePropertyFee;
	}

	public void setIncludePropertyFee(Integer includePropertyFee) {
		this.includePropertyFee = includePropertyFee;
	}

	public Double getPropertyFee() {
		return propertyFee;
	}

	public void setPropertyFee(Double propertyFee) {
		this.propertyFee = propertyFee;
	}

	public Integer getTransfer() {
		return transfer;
	}

	public void setTransfer(Integer transfer) {
		this.transfer = transfer;
	}

	public Double getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Double buildingArea) {
		this.buildingArea = buildingArea;
	}

	public Integer getIfPartition() {
		return ifPartition;
	}

	public void setIfPartition(Integer ifPartition) {
		this.ifPartition = ifPartition;
	}

	public Integer getOfficeType() {
		return officeType;
	}

	public void setOfficeType(Integer officeType) {
		this.officeType = officeType;
	}

	public Integer getOfficeTank() {
		return officeTank;
	}

	public void setOfficeTank(Integer officeTank) {
		this.officeTank = officeTank;
	}

	public String getHouseTitle() {
		return houseTitle;
	}

	public void setHouseTitle(String houseTitle) {
		this.houseTitle = houseTitle;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public String getFinishedYear() {
		return finishedYear;
	}

	public void setFinishedYear(String finishedYear) {
		this.finishedYear = finishedYear;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getAdminOfflineCode() {
		return adminOfflineCode;
	}

	public void setAdminOfflineCode(String adminOfflineCode) {
		this.adminOfflineCode = adminOfflineCode;
	}

	public String getAdminOfflineOther() {
		return adminOfflineOther;
	}

	public void setAdminOfflineOther(String adminOfflineOther) {
		this.adminOfflineOther = adminOfflineOther;
	}

	public String getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(String houseInfo) {
		this.houseInfo = houseInfo;
	}

	public String getHouseText() {
		return houseText;
	}

	public void setHouseText(String houseText) {
		this.houseText = houseText;
	}

}
