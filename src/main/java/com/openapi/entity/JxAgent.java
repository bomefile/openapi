package com.openapi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class JxAgent {
    private Long id;                    // '主键'
    private String cityId;                // '城市 '
    private String bdId;                // '城区 '
    private String bbdId;                // '商圈 '
    private String orgId;
    private String agentName;            // '姓名 '
    private String position;            // '职务 '
    private String mobile;                // '电话 '
    private String photoPath;            // '头像'
    private String smallPhotoPath;        // '头像小区'
    private String info;                // '个人简介'
    private String servicesYears;        // '从业年限'
    private Integer sex;                // '性别 1 男 0 女'
    private Date birthday;            // '出生日期'
    private String integration;        // '积分'
    private String hometown;            // '籍贯'
    private String motto;                // '座右铭'
    private String interest;            // '兴趣'
    private String qq;                    // 'QQ'
    private String wechat;                // '微信'
    private String email;                // '邮箱'
    private String createTime;            // '创建时间'
    private String updateTime;            // '更新时间'
    private String level;                // '级别'
    private String password;            // '密码'
    private String orgType;            // '组织机构类型 0 物业 1 经纪公司'
    private Integer status;                // '状态，1有效，0无效，-1冻结-2删除'
    private String updaterId;
    private String bdDd1;                // '城区id1'
    private String bbdId1;                // '商圈id1'
    private String bdId2;                // '城区id2'
    private String bbdId2;                // '商圈id2'
    private String storeName;            // '门店名称'
    private String storeAddr;            // '门店地址'
    private String phone;                // '座机号'
    private String userCode;            // '经纪人的系统号'
    private Date lastModifyTime;
    private Integer source;
    private String shopPlacard;        // '店铺公告'
    private String companyName;        // '公司名称'
    private String freeCode;            // '经纪人冻结时间code'
    private String freeTime;            // '冻结时间'
    private String houseCode;
    private Integer qrcode;                // '二维码 '
    private Integer saleid;
    private Integer authCheckStatus;    // '0待审核 1 已审核'
    private Integer authSfCheckStatus;    // '身份证 0待审核 1 审核成功 -1 审核失败'
    private Integer authMpCheckStatus;    // '名片 0待审核 1 审核成功 -1 审核失败'
    private Integer authZgCheckStatus;    // '资格证 0待审核 1 审核成功 -1 审核失败'


}
