package com.openapi.entity;

import java.util.Date;

public class JxAgentAuth {
	private Long	id;			// '主键',
	private Long	agentId;		// '经纪人主键 外键关联',
	private String	name;			// '名称',
	private String	cardNums;		// '证书号码',
	private int		type;			// '0 身份证认证、1 名片认证 2、资格认证',
	private String	imagePath1;		// '证件照片路径正面',
	private String	imagePath2;		// '证件照片路径反面',
	private Date	createTime;		// '创建时间',
	private Date	checkTime;		// '审核时间',
	private String	updatorId;		// '与jx_agent表关联',
	private Integer	checkStatus;	// '0待审核 1 审核成功 -1 审核失败',
	private Date	lastModifyTime;	// '记录更新时间',

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNums() {
		return cardNums;
	}

	public void setCardNums(String cardNums) {
		this.cardNums = cardNums;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImagePath1() {
		return imagePath1;
	}

	public void setImagePath1(String imagePath1) {
		this.imagePath1 = imagePath1;
	}

	public String getImagePath2() {
		return imagePath2;
	}

	public void setImagePath2(String imagePath2) {
		this.imagePath2 = imagePath2;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getUpdatorId() {
		return updatorId;
	}

	public void setUpdatorId(String updatorId) {
		this.updatorId = updatorId;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}
