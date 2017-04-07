package com.openapi.entity.hr;

import java.util.Date;

public class HrEmployeeJobEntity  {
    private String emplId;

    private String emplRcd;

    private String effDt;

    private String effSeq;

    private String setidDept;

    private String deptId;

    private String setIdJobCode;

    private String company;

    private String jobCode;

    private String cRankCode;

    private String cRankDescr;

    private String cQuartersId;

    private String supervisorId;

    private String hrStatus;

    private String cWorkShop;

    private String cWorkShopDeptId;

    private String lastHireDt;

    private String terminationDt;

    private String action;

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

    public String getEmplRcd() {
        return emplRcd;
    }

    public void setEmplRcd(String emplRcd) {
        this.emplRcd = emplRcd == null ? null : emplRcd.trim();
    }

    public String getEffDt() {
        return effDt;
    }

    public void setEffDt(String effDt) {
        this.effDt = effDt == null ? null : effDt.trim();
    }

    public String getEffSeq() {
        return effSeq;
    }

    public void setEffSeq(String effSeq) {
        this.effSeq = effSeq == null ? null : effSeq.trim();
    }

    public String getSetidDept() {
        return setidDept;
    }

    public void setSetidDept(String setidDept) {
        this.setidDept = setidDept == null ? null : setidDept.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getSetIdJobCode() {
        return setIdJobCode;
    }

    public void setSetIdJobCode(String setIdJobCode) {
        this.setIdJobCode = setIdJobCode == null ? null : setIdJobCode.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode == null ? null : jobCode.trim();
    }

    public String getcRankCode() {
        return cRankCode;
    }

    public void setcRankCode(String cRankCode) {
        this.cRankCode = cRankCode == null ? null : cRankCode.trim();
    }

    public String getcRankDescr() {
        return cRankDescr;
    }

    public void setcRankDescr(String cRankDescr) {
        this.cRankDescr = cRankDescr == null ? null : cRankDescr.trim();
    }

    public String getcQuartersId() {
        return cQuartersId;
    }

    public void setcQuartersId(String cQuartersId) {
        this.cQuartersId = cQuartersId == null ? null : cQuartersId.trim();
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId == null ? null : supervisorId.trim();
    }

    public String getHrStatus() {
        return hrStatus;
    }

    public void setHrStatus(String hrStatus) {
        this.hrStatus = hrStatus == null ? null : hrStatus.trim();
    }

    public String getcWorkShop() {
        return cWorkShop;
    }

    public void setcWorkShop(String cWorkShop) {
        this.cWorkShop = cWorkShop == null ? null : cWorkShop.trim();
    }

    public String getcWorkShopDeptId() {
        return cWorkShopDeptId;
    }

    public void setcWorkShopDeptId(String cWorkShopDeptId) {
        this.cWorkShopDeptId = cWorkShopDeptId == null ? null : cWorkShopDeptId.trim();
    }

    public String getLastHireDt() {
        return lastHireDt;
    }

    public void setLastHireDt(String lastHireDt) {
        this.lastHireDt = lastHireDt == null ? null : lastHireDt.trim();
    }

    public String getTerminationDt() {
        return terminationDt;
    }

    public void setTerminationDt(String terminationDt) {
        this.terminationDt = terminationDt == null ? null : terminationDt.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
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