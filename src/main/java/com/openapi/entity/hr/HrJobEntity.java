package com.openapi.entity.hr;

import java.util.Date;

public class HrJobEntity {
    private String setId;

    private String jobCode;

    private String effDt;

    private String effStatus;

    private String descr;

    private String descrShort;

    private String cHoldingNm;

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

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode == null ? null : jobCode.trim();
    }

    public String getEffDt() {
        return effDt;
    }

    public void setEffDt(String effDt) {
        this.effDt = effDt == null ? null : effDt.trim();
    }

    public String getEffStatus() {
        return effStatus;
    }

    public void setEffStatus(String effStatus) {
        this.effStatus = effStatus == null ? null : effStatus.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getDescrShort() {
        return descrShort;
    }

    public void setDescrShort(String descrShort) {
        this.descrShort = descrShort == null ? null : descrShort.trim();
    }

    public String getcHoldingNm() {
        return cHoldingNm;
    }

    public void setcHoldingNm(String cHoldingNm) {
        this.cHoldingNm = cHoldingNm == null ? null : cHoldingNm.trim();
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