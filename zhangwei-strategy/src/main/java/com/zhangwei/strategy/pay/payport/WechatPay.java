package com.zhangwei.strategy.pay.payport;

import com.zhangwei.strategy.pay.PayState;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 7:07 PM
 * @since 1.0.0
 **/
public class WechatPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用微信支付");
        System.out.println("直接从微信红包扣款");
        return new PayState(200,"支付成功",amount);
    }
}
