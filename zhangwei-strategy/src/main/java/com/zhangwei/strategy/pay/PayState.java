package com.zhangwei.strategy.pay;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 7:05 PM
 * @since 1.0.0
 **/
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState(int code, String msg,Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String toString(){
        return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
    }
}
