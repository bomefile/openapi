package com.openapi.util;

import lombok.Data;

/**
 * ResponseJsonRender
 */
@Data
public class ResponseJsonRender {

    private boolean success;
    /**
     * 消息
     */
    private String msg = "";
    private String reason = "";


    private int code = 0;


    private Object data;

    /**
     * 只添加成功数据
     *
     * @param data
     */
    public ResponseJsonRender(Object data) {

        this(ResponseCode.SUCCESS, "", "");
        this.data = data;
    }

    /**
     * 消息
     *
     * @param msg
     */
    public ResponseJsonRender(String msg) {
        this(ResponseCode.SUCCESS, msg, "");
    }

    /**
     * @param code
     * @param msg
     */
    public ResponseJsonRender(ResponseCode code, String msg, String reason) {
        this.code = code.getCode();
        this.msg = msg;
        this.reason = reason;
    }

    /**
     * 状态码、消息、数据
     *
     * @param code
     * @param msg
     * @param data
     */
    public ResponseJsonRender(ResponseCode code, String msg, Object data) {
        this.code = code.getCode();
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        success = code >= 0;
        return success;
    }
}
