package com.openapi.util;

/**
 * @author:wzn Description:
 * Date: Created in 2017/1/6.
 * Modified By:
 */
public class ResponseBatchDetailType {
    private String detailId;        //	批次明细的ID	一批数据中的每行数据的主键（多字段主键用”-“分开）
    private String returnFlag = "S";    //	接口调用返回成功标识	"E：失败 S：成功 W：其他状态"
    private String returnMsg;    //	接口调用返回消息	成功则返回成功消息；失败则返回失败消息；其他状态则返回相应的消息
    private String errorCode;    //	错误编码	"E0000001~E9999999  具体错误参考各系统的接入规范中的错误编码范围"

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(String returnFlag) {
        this.returnFlag = returnFlag;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "{" +
                "detailId='" + detailId + '\'' +
                ", returnFlag='" + returnFlag + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
