package com.openapi.entity;

import java.util.Date;

public class JxTuituiBlacklist {
	private Long	id;				// '主键id',
	private String	name;			// '黑名单内容',
	private Integer	type;			// '黑名单类型:1经纪人;2经济公司',
	private Integer	status;			// '状态:0失效,1生效',
	private String	token;			// '来源token',
	private Date	lastModifyTime;	// '最后修改时间',

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}
