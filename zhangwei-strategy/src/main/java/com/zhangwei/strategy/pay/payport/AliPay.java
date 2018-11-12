package com.zhangwei.strategy.pay.payport;

import com.zhangwei.strategy.pay.PayState;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 7:07 PM
 * @since 1.0.0
 **/
public class AliPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用支付宝");
        System.out.println("查询账户余额，开始扣款");
        return new PayState(200, "支付成功", amount);
    }
}
