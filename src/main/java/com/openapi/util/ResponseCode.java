package com.openapi.util;

/**
 * Created by yw on 2016/1/12.
 * 响应状态码
 */
public enum ResponseCode {

    /**
     * 成功
     */
    SUCCESS(0),

    /**
     * 失败，可预知的
     * 例：密码错误;用户不存在
     */
    FAILURE(-1000),
    /**
     * 错误，可预知的
     * 例：逻辑上是一条数据、根据查询返回多条数据
     */
    ERROR(-2000),
    /**
     * 未登录
     */
    ERROR_UNLOGIN(-2001),
    //客户端错误 -2000 开始
    /**
     * 客户端参数错误
     */
    CLIENT_PARAMS_ERROR(-2000),
    /**
     * 楼盘逾期
     */
    ESTATE_OVERDUE(-2006),
    /**
     * 楼盘不能上线
     */
    ESTATE_NOT_PROCESS(-2007),
    /**
     * 楼盘不能删除
     */
    ESTATE_NOT_DELETE(-2008),

    /**
     *导入错误
     */
    IMPORT_ERROR(-2020),
    /**
     * 文件解析错误
     */
    File_Format_Error(-2010),


    CUSTOMER_COMMEND_LIMIT(-2007),

    AGENCY_SHOP_NOT_EXIST(-2018),
    /**
     * 异常，系统异常，不可预知的异常
     */
    EXCEPTION(-3000);



    private int code;

    private ResponseCode(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
    @Override
    public String toString() {
        return this.code + "";
    }
    public static void main(String[]args){
        System.out.print(ResponseCode.SUCCESS);
        ResponseCode code = ResponseCode.SUCCESS;
        System.out.print(code);
    }
}
