package com.openapi.entity.hr;

import java.util.Date;

public class HrStoreEntity  {
    private String setId;

    private String cPhyStoId;

    private String effdt;

    private String cDescription;

    private String cSimDescr;

    private String cShopStation;

    private String cStrShopDt;

    private String cAddress;

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

    public String getcPhyStoId() {
        return cPhyStoId;
    }

    public void setcPhyStoId(String cPhyStoId) {
        this.cPhyStoId = cPhyStoId == null ? null : cPhyStoId.trim();
    }

    public String getEffdt() {
        return effdt;
    }

    public void setEffdt(String effdt) {
        this.effdt = effdt == null ? null : effdt.trim();
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription == null ? null : cDescription.trim();
    }

    public String getcSimDescr() {
        return cSimDescr;
    }

    public void setcSimDescr(String cSimDescr) {
        this.cSimDescr = cSimDescr == null ? null : cSimDescr.trim();
    }

    public String getcShopStation() {
        return cShopStation;
    }

    public void setcShopStation(String cShopStation) {
        this.cShopStation = cShopStation == null ? null : cShopStation.trim();
    }

    public String getcStrShopDt() {
        return cStrShopDt;
    }

    public void setcStrShopDt(String cStrShopDt) {
        this.cStrShopDt = cStrShopDt == null ? null : cStrShopDt.trim();
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
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