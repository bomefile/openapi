package com.openapi.entity;

import lombok.Data;

import java.util.Date;


@Data
public class JxRentPic {
	private Long	id;			//
	private Long	rentId;			// '房源表主键',
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

}
