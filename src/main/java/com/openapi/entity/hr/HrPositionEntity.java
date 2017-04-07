package com.openapi.entity.hr;

import java.util.Date;

public class HrPositionEntity  {
    private String setId;

    private String cQuartersId;

    private String effdt;

    private String descr;

    private String cBusinessType;

    private String cBusinessSub;

    private String cDividingLine;

    private String cQuteOrder;

    private String cQuteSonOrder;

    private String cState;

    private String jobCode;

    private String cQuteShortName;

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

    public String getcQuartersId() {
        return cQuartersId;
    }

    public void setcQuartersId(String cQuartersId) {
        this.cQuartersId = cQuartersId == null ? null : cQuartersId.trim();
    }

    public String getEffdt() {
        return effdt;
    }

    public void setEffdt(String effdt) {
        this.effdt = effdt == null ? null : effdt.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
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

    public String getcDividingLine() {
        return cDividingLine;
    }

    public void setcDividingLine(String cDividingLine) {
        this.cDividingLine = cDividingLine == null ? null : cDividingLine.trim();
    }

    public String getcQuteOrder() {
        return cQuteOrder;
    }

    public void setcQuteOrder(String cQuteOrder) {
        this.cQuteOrder = cQuteOrder == null ? null : cQuteOrder.trim();
    }

    public String getcQuteSonOrder() {
        return cQuteSonOrder;
    }

    public void setcQuteSonOrder(String cQuteSonOrder) {
        this.cQuteSonOrder = cQuteSonOrder == null ? null : cQuteSonOrder.trim();
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState == null ? null : cState.trim();
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode == null ? null : jobCode.trim();
    }

    public String getcQuteShortName() {
        return cQuteShortName;
    }

    public void setcQuteShortName(String cQuteShortName) {
        this.cQuteShortName = cQuteShortName == null ? null : cQuteShortName.trim();
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