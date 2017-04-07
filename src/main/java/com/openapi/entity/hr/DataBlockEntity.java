package com.openapi.entity.hr;

import lombok.Data;

import java.util.List;

/**
 * @author:wzn Description: esb请求数据实体
 * Date: Created in 2017/1/5.
 * Modified By:
 */
//@Data
public class DataBlockEntity<T> {

    private List<T> batchLines;     //表数据

    private String flag;            //表名标记

    private String transferId;      //传输ID

    private String batchNum;        // 批次号，适用于批量传输数据的场景

    private String transferDateTime;//传输时间 格式yyyy/mm/dd hh24:mi:ss

    private String pushDataType;    //同步类型 AL：全量；AD：增量

    public List<T> getBatchLines() {
        return batchLines;
    }

    public void setBatchLines(List<T> batchLines) {
        this.batchLines = batchLines;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getTransferDateTime() {
        return transferDateTime;
    }

    public void setTransferDateTime(String transferDateTime) {
        this.transferDateTime = transferDateTime;
    }

    public String getPushDataType() {
        return pushDataType;
    }

    public void setPushDataType(String pushDataType) {
        this.pushDataType = pushDataType;
    }
}
