package com.openapi.entity;

import java.util.Date;

public class JxHouse {
	private Long	id;
	private String	houseCode;
	private String	buildingCode;		// '楼栋编号来源于楼盘字典系统，在销售系统、楼盘字典系统中本编号是唯一和统一的。',
	private Integer	communityId;		// '小区楼盘的主键',
	private String	buildingName;		// '楼栋的名称',
	private String	houseTitle;			// '房源标题',
	private String	hasKey;				// '标明该房源是否有钥匙可以直接看房',
	private Double	houseTotalPrice;	// '房源的售价',
	private Double	houseUnitPrice;		// '房源的每平米售价',
	private Integer	floorNo;			// '楼层',
	private Integer	totalFloors;		// '总楼层',
	private Integer	bedroomNums;		// '卧室数',
	private Integer	hallNums;			// '大厅数',
	private Integer	bathroomNums;		// '浴室数',
	private Integer	kitchenNums;		// '厨房数',
	private Integer	balconyNums;		// '阳台数',
	private Integer	hoId;				// '房屋朝向ID 与字典表 basis_dic_info 关联',
	private Integer	storehouseNums;		// '储藏室数',
	private Integer	gardenNums;			// '花园数',
	private Double	buildingArea;		// '建筑面积',
	private Double	usefulArea;			// '使用面积',
	private Integer	warmingType;		// '采暖类型 与basis_dic_info关联',
	private Double	propertyFee;		// '房源的物业费用包括：物业费管理费、卫生费等',
	private Integer	hdId;				// '装修分类主键 与basis_dic_info关联',
	private String	finishedYear;		// '房源的建成年代',
	private Integer	hpId;				// '房源产权性质表 与basis_dic_info关联',
	private Integer	hbtId;				// '建筑类型表 与basis_dic_info关联',
	private String	recommReason;		// '推荐理由',
	private String	houseInfo;			// '对该房源的整体描述信息，小于150个汉字',
	private String	fullViewPath;		// '列表页标题图120*90，相当于文件服务器挂接点的目录路径',
	private Integer	houseStatus;		// '0 下线待发布 1发布上线 -1删除 -2 管理员下线 2 管理员推优 -3 过期房源
	// -4违规房源 -5违规修改后待审核房源',
	private Integer	pv;					// '房源点击pv',
	private String	creatorId;			// '发布房源信息的经纪人id，来源于销售系统',
	private Date	createTime;			// '本房源数据的创建时间，来源于销售系统',
	private String	updaterId;			// '更新房源信息的经纪人ID，来源于销售系统',
	private Date	updateTime;			// '更新房源信息的时间，来源于销售系统',
	private String	cityId;				// '城市id',
	private Integer	houseType;			// '住宅类别 与basis_dic_info 关联',
	private Date	checkTime;			// '审核时间',
	private Integer	recommReasonStatus;	// '房源推优标记位 0：未推优 1：推优',
	private String	communityName;		// '楼盘名称',
	private String	interHouseCode;		// '内部房源编号,由系统自动生成',
	private Integer	seeHouseTime;		// '看房时间 0 随时可看 1非工作日看房 2 电话预约',
	private Long	agentId;			// '经纪人主键 与jx_agent表关联',
	private Integer	ifHaveBasement;		// '是否有地下室 0 没有 1 有',
	private Integer	ifHaveGarden;		// '是否有花园 0 没有 1 有',
	private Integer	ifHaveCarage;		// '是否有车库 0 没有 1 有',
	private Integer	ifHaveParking;		// '是否有车位 0 没有 1 有',
	private Integer	type;				// '房屋类型 0 普通二手房 1 别墅',
	private Integer	ifRecommend;		// '是否个人推荐房源 0 未推荐 1 推荐 个人最多设置4',
	private Integer	myRecommend;		// '是否店长推荐 0否 1是',
	private Integer	ifAdminRecommend;	// '是否管理员推荐',
	private String	adminRecommReason;	// '管理员推荐理由',
	private Integer	source;				// '1:我爱我家 2:链家 3:中大恒基',
	private Date	lastModifyTime;
	private Integer	bdId;				// '区域id',
	private Integer	bbdId;				// '商圈id',
	private String	adminOfflineCode;	// '下线原因',
	private String	adminOfflineOther;	// '下线自定义原因',
	private Double	charge;				// '手续费 -1未填写',
	private Integer	ident;				// '身份标识 1个人 2经纪人',
	private Integer	uid;				// '用户ID',
	private String	mobile;				// '个人使用其他手机',
	private String	gender;				// 'm男 f女',
	private String	seller;
	private String	houseText;			// '不带标签的kineditor',
	private Integer	entrust;			// '0 一般房源 1委托房源',
	private Integer	assignStatus;		// '0未分配 1已分配',
	private String	buildingType;		// '别墅建筑形式　如联排 ',

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getHouseTitle() {
		return houseTitle;
	}

	public void setHouseTitle(String houseTitle) {
		this.houseTitle = houseTitle;
	}

	public String getHasKey() {
		return hasKey;
	}

	public void setHasKey(String hasKey) {
		this.hasKey = hasKey;
	}

	public Double getHouseTotalPrice() {
		return houseTotalPrice;
	}

	public void setHouseTotalPrice(Double houseTotalPrice) {
		this.houseTotalPrice = houseTotalPrice;
	}

	public Double getHouseUnitPrice() {
		return houseUnitPrice;
	}

	public void setHouseUnitPrice(Double houseUnitPrice) {
		this.houseUnitPrice = houseUnitPrice;
	}

	public Integer getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(Integer floorNo) {
		this.floorNo = floorNo;
	}

	public Integer getTotalFloors() {
		return totalFloors;
	}

	public void setTotalFloors(Integer totalFloors) {
		this.totalFloors = totalFloors;
	}

	public Integer getBedroomNums() {
		return bedroomNums;
	}

	public void setBedroomNums(Integer bedroomNums) {
		this.bedroomNums = bedroomNums;
	}

	public Integer getHallNums() {
		return hallNums;
	}

	public void setHallNums(Integer hallNums) {
		this.hallNums = hallNums;
	}

	public Integer getBathroomNums() {
		return bathroomNums;
	}

	public void setBathroomNums(Integer bathroomNums) {
		this.bathroomNums = bathroomNums;
	}

	public Integer getKitchenNums() {
		return kitchenNums;
	}

	public void setKitchenNums(Integer kitchenNums) {
		this.kitchenNums = kitchenNums;
	}

	public Integer getBalconyNums() {
		return balconyNums;
	}

	public void setBalconyNums(Integer balconyNums) {
		this.balconyNums = balconyNums;
	}

	public Integer getHoId() {
		return hoId;
	}

	public void setHoId(Integer hoId) {
		this.hoId = hoId;
	}

	public Integer getStorehouseNums() {
		return storehouseNums;
	}

	public void setStorehouseNums(Integer storehouseNums) {
		this.storehouseNums = storehouseNums;
	}

	public Integer getGardenNums() {
		return gardenNums;
	}

	public void setGardenNums(Integer gardenNums) {
		this.gardenNums = gardenNums;
	}

	public Double getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Double buildingArea) {
		this.buildingArea = buildingArea;
	}

	public Double getUsefulArea() {
		return usefulArea;
	}

	public void setUsefulArea(Double usefulArea) {
		this.usefulArea = usefulArea;
	}

	public Integer getWarmingType() {
		return warmingType;
	}

	public void setWarmingType(Integer warmingType) {
		this.warmingType = warmingType;
	}

	public Double getPropertyFee() {
		return propertyFee;
	}

	public void setPropertyFee(Double propertyFee) {
		this.propertyFee = propertyFee;
	}

	public Integer getHdId() {
		return hdId;
	}

	public void setHdId(Integer hdId) {
		this.hdId = hdId;
	}

	public String getFinishedYear() {
		return finishedYear;
	}

	public void setFinishedYear(String finishedYear) {
		this.finishedYear = finishedYear;
	}

	public Integer getHpId() {
		return hpId;
	}

	public void setHpId(Integer hpId) {
		this.hpId = hpId;
	}

	public Integer getHbtId() {
		return hbtId;
	}

	public void setHbtId(Integer hbtId) {
		this.hbtId = hbtId;
	}

	public String getRecommReason() {
		return recommReason;
	}

	public void setRecommReason(String recommReason) {
		this.recommReason = recommReason;
	}

	public String getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(String houseInfo) {
		this.houseInfo = houseInfo;
	}

	public String getFullViewPath() {
		return fullViewPath;
	}

	public void setFullViewPath(String fullViewPath) {
		this.fullViewPath = fullViewPath;
	}

	public Integer getHouseStatus() {
		return houseStatus;
	}

	public void setHouseStatus(Integer houseStatus) {
		this.houseStatus = houseStatus;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
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

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public Integer getHouseType() {
		return houseType;
	}

	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Integer getRecommReasonStatus() {
		return recommReasonStatus;
	}

	public void setRecommReasonStatus(Integer recommReasonStatus) {
		this.recommReasonStatus = recommReasonStatus;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getInterHouseCode() {
		return interHouseCode;
	}

	public void setInterHouseCode(String interHouseCode) {
		this.interHouseCode = interHouseCode;
	}

	public Integer getSeeHouseTime() {
		return seeHouseTime;
	}

	public void setSeeHouseTime(Integer seeHouseTime) {
		this.seeHouseTime = seeHouseTime;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Integer getIfHaveBasement() {
		return ifHaveBasement;
	}

	public void setIfHaveBasement(Integer ifHaveBasement) {
		this.ifHaveBasement = ifHaveBasement;
	}

	public Integer getIfHaveGarden() {
		return ifHaveGarden;
	}

	public void setIfHaveGarden(Integer ifHaveGarden) {
		this.ifHaveGarden = ifHaveGarden;
	}

	public Integer getIfHaveCarage() {
		return ifHaveCarage;
	}

	public void setIfHaveCarage(Integer ifHaveCarage) {
		this.ifHaveCarage = ifHaveCarage;
	}

	public Integer getIfHaveParking() {
		return ifHaveParking;
	}

	public void setIfHaveParking(Integer ifHaveParking) {
		this.ifHaveParking = ifHaveParking;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIfRecommend() {
		return ifRecommend;
	}

	public void setIfRecommend(Integer ifRecommend) {
		this.ifRecommend = ifRecommend;
	}

	public Integer getMyRecommend() {
		return myRecommend;
	}

	public void setMyRecommend(Integer myRecommend) {
		this.myRecommend = myRecommend;
	}

	public Integer getIfAdminRecommend() {
		return ifAdminRecommend;
	}

	public void setIfAdminRecommend(Integer ifAdminRecommend) {
		this.ifAdminRecommend = ifAdminRecommend;
	}

	public String getAdminRecommReason() {
		return adminRecommReason;
	}

	public void setAdminRecommReason(String adminRecommReason) {
		this.adminRecommReason = adminRecommReason;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
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

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	public Integer getIdent() {
		return ident;
	}

	public void setIdent(Integer ident) {
		this.ident = ident;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getHouseText() {
		return houseText;
	}

	public void setHouseText(String houseText) {
		this.houseText = houseText;
	}

	public Integer getEntrust() {
		return entrust;
	}

	public void setEntrust(Integer entrust) {
		this.entrust = entrust;
	}

	public Integer getAssignStatus() {
		return assignStatus;
	}

	public void setAssignStatus(Integer assignStatus) {
		this.assignStatus = assignStatus;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

}
