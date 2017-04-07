package com.openapi.entity.hr;

import java.util.Date;

public class HrDpartmentTreeEntity  {
    private String treeName;

    private String effdt;

    private String setId;

    private String treeNode;

    private String parentNodeName;

    private String treeLevelNum;

    private String flag;

    private String transferId;

    private String batchNum;

    private String transferDateTime;

    private String pushDataType;

    private Date createTime;

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName == null ? null : treeName.trim();
    }

    public String getEffdt() {
        return effdt;
    }

    public void setEffdt(String effdt) {
        this.effdt = effdt == null ? null : effdt.trim();
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId == null ? null : setId.trim();
    }

    public String getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(String treeNode) {
        this.treeNode = treeNode == null ? null : treeNode.trim();
    }

    public String getParentNodeName() {
        return parentNodeName;
    }

    public void setParentNodeName(String parentNodeName) {
        this.parentNodeName = parentNodeName == null ? null : parentNodeName.trim();
    }

    public String getTreeLevelNum() {
        return treeLevelNum;
    }

    public void setTreeLevelNum(String treeLevelNum) {
        this.treeLevelNum = treeLevelNum == null ? null : treeLevelNum.trim();
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