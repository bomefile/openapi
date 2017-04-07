package com.openapi.entity;

import java.util.Date;

public class JxHouseTuituiCom {
	private Integer	id;
	private String	communityName;	// '小区名',
	private String	token;
	private Long	hits;			// '未找到对应小区的命中次数',
	private Date	lastModifyTime;	// '最后命中时间',

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}
