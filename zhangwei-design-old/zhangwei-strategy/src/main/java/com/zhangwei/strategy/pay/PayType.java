package com.zhangwei.strategy.pay;

import com.zhangwei.strategy.pay.payport.*;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 7:06 PM
 * @since 1.0.0
 **/
public enum PayType {
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WechatPay()),
    UNION_PAY(new UnionPay()),
    JD_PAY(new JDPay());

    private Payment payment;
    PayType(Payment payment){
        this.payment = payment;
    }

    public Payment get(){ return  this.payment;}
}
