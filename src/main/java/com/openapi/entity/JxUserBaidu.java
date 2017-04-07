package com.openapi.entity;

public class JxUserBaidu {
	private Long id;
	private Long userId;
	private Integer type;
	private String baiduuserid;
	private String baiduchannelid;
	private String devicecode;
	private Integer devicetype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getBaiduchannelid() {
		return baiduchannelid;
	}

	public void setBaiduchannelid(String baiduchannelid) {
		this.baiduchannelid = baiduchannelid;
	}

	public String getDevicecode() {
		return devicecode;
	}

	public void setDevicecode(String devicecode) {
		this.devicecode = devicecode;
	}

	public String getBaiduuserid() {
		return baiduuserid;
	}

	public void setBaiduuserid(String baiduuserid) {
		this.baiduuserid = baiduuserid;
	}

	public Integer getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(Integer devicetype) {
		this.devicetype = devicetype;
	}

}
