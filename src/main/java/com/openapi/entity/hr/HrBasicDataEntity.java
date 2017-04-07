package com.openapi.entity.hr;

import java.util.Date;

public class HrBasicDataEntity {
    private String setId;

    private String cValGather;

    private String cFatherVal;

    private String cFatherDescr;

    private String cSonVal;

    private String cSonDescr;

    private String cDeptidType;

    private String descr4;

    private String flag;

    private String transferId;

    private String batchNum;

    private String transferDateTime;

    private String pushDataType;

    private Date createTime;

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId == null ? null : setId.trim();
    }

    public String getcValGather() {
        return cValGather;
    }

    public void setcValGather(String cValGather) {
        this.cValGather = cValGather == null ? null : cValGather.trim();
    }

    public String getcFatherVal() {
        return cFatherVal;
    }

    public void setcFatherVal(String cFatherVal) {
        this.cFatherVal = cFatherVal == null ? null : cFatherVal.trim();
    }

    public String getcFatherDescr() {
        return cFatherDescr;
    }

    public void setcFatherDescr(String cFatherDescr) {
        this.cFatherDescr = cFatherDescr == null ? null : cFatherDescr.trim();
    }

    public String getcSonVal() {
        return cSonVal;
    }

    public void setcSonVal(String cSonVal) {
        this.cSonVal = cSonVal == null ? null : cSonVal.trim();
    }

    public String getcSonDescr() {
        return cSonDescr;
    }

    public void setcSonDescr(String cSonDescr) {
        this.cSonDescr = cSonDescr == null ? null : cSonDescr.trim();
    }

    public String getcDeptidType() {
        return cDeptidType;
    }

    public void setcDeptidType(String cDeptidType) {
        this.cDeptidType = cDeptidType == null ? null : cDeptidType.trim();
    }

    public String getDescr4() {
        return descr4;
    }

    public void setDescr4(String descr4) {
        this.descr4 = descr4 == null ? null : descr4.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId == null ? null : transferId.trim();
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum == null ? null : batchNum.trim();
    }

    public String getTransferDateTime() {
        return transferDateTime;
    }

    public void setTransferDateTime(String transferDateTime) {
        this.transferDateTime = transferDateTime == null ? null : transferDateTime.trim();
    }

    public String getPushDataType() {
        return pushDataType;
    }

    public void setPushDataType(String pushDataType) {
        this.pushDataType = pushDataType == null ? null : pushDataType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}