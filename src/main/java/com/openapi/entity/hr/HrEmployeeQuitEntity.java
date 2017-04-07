package com.openapi.entity.hr;

import java.util.Date;

public class HrEmployeeQuitEntity {
    private String emplId;

    private String setid;

    private String cApproveStatus;

    private String cLeaveStatus;

    private String flag;

    private String transferId;

    private String batchNum;

    private String transferDateTime;

    private String pushDataType;

    private Date createTime;

    public String getEmplId() {
        return emplId;
    }

    public void setEmplId(String emplId) {
        this.emplId = emplId == null ? null : emplId.trim();
    }

    public String getSetid() {
        return setid;
    }

    public void setSetid(String setid) {
        this.setid = setid == null ? null : setid.trim();
    }

    public String getcApproveStatus() {
        return cApproveStatus;
    }

    public void setcApproveStatus(String cApproveStatus) {
        this.cApproveStatus = cApproveStatus == null ? null : cApproveStatus.trim();
    }

    public String getcLeaveStatus() {
        return cLeaveStatus;
    }

    public void setcLeaveStatus(String cLeaveStatus) {
        this.cLeaveStatus = cLeaveStatus == null ? null : cLeaveStatus.trim();
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