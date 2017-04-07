package com.openapi.entity.hr;

import java.util.Date;

public class HrDpartmentEntity {
    private String setId;

    private String deptId;

    private String effdt;

    private String effStatus;

    private String descr;

    private String descrShort;

    private String company;

    private String cDeptType;

    private String cDeptStype;

    private String cBusinessType;

    private String cBusinessSub;

    private String cPhysiStore;

    private String managerId;

    private String managerPosn;

    private String cDeptIdType;

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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getEffdt() {
        return effdt;
    }

    public void setEffdt(String effdt) {
        this.effdt = effdt == null ? null : effdt.trim();
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getcDeptType() {
        return cDeptType;
    }

    public void setcDeptType(String cDeptType) {
        this.cDeptType = cDeptType == null ? null : cDeptType.trim();
    }

    public String getcDeptStype() {
        return cDeptStype;
    }

    public void setcDeptStype(String cDeptStype) {
        this.cDeptStype = cDeptStype == null ? null : cDeptStype.trim();
    }

    public String getcBusinessType() {
        return cBusinessType;
    }

    public void setcBusinessType(String cBusinessType) {
        this.cBusinessType = cBusinessType == null ? null : cBusinessType.trim();
    }

    public String getcBusinessSub() {
        return cBusinessSub;
    }

    public void setcBusinessSub(String cBusinessSub) {
        this.cBusinessSub = cBusinessSub == null ? null : cBusinessSub.trim();
    }

    public String getcPhysiStore() {
        return cPhysiStore;
    }

    public void setcPhysiStore(String cPhysiStore) {
        this.cPhysiStore = cPhysiStore == null ? null : cPhysiStore.trim();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getManagerPosn() {
        return managerPosn;
    }

    public void setManagerPosn(String managerPosn) {
        this.managerPosn = managerPosn == null ? null : managerPosn.trim();
    }

    public String getcDeptIdType() {
        return cDeptIdType;
    }

    public void setcDeptIdType(String cDeptIdType) {
        this.cDeptIdType = cDeptIdType == null ? null : cDeptIdType.trim();
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