package com.openapi.util;

import java.util.Arrays;

/**
 * @author:wzn Description:
 * Date: Created in 2017/1/6.
 * Modified By:
 */
public class BatchHeader {

    /*
     * 批次号，适用于批量传输数据的场景	"批量传输数据的时
     * 候，来源系统提供发送的消息中包含此字段（批次ID），则直接将来源消息中的batchNum回传"
     */
    private String batchNum;

    private String returnFlag = "S";        //接口调用返回成功标识	"E：失败 S：成功  W：其他状态"

    private String returnMsg;               //接口调用返回消息	成功则返回成功消息；失败则返回失败消息；其他状态则返回相应的消息

    /*
     * 错误编码	"E0000001~E9999999
     * 具体错误参考各系统的接入规范中的错误编码范围
     *“E”+”3位系统序号”+”4位流水号”，每个系统预留10000个错误编码"
     */
    private String errorCode;

    private ResponseBatchDetailType[] batchDetail;    //批次详情	批量数据传输出错的时候，此结构必输

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
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

    public ResponseBatchDetailType[] getBatchDetail() {
        return batchDetail;
    }

    public void setBatchDetail(ResponseBatchDetailType[] batchDetail) {
        this.batchDetail = batchDetail;
    }

    @Override
    public String toString() {
        return "{" +
                "batchNum='" + batchNum + '\'' +
                ", returnFlag='" + returnFlag + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", batchDetail=" + Arrays.toString(batchDetail) +
                '}';
    }
}
