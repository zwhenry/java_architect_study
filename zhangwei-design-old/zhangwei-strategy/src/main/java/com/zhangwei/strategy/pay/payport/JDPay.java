package com.zhangwei.strategy.pay.payport;

import com.zhangwei.strategy.pay.PayState;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 7:08 PM
 * @since 1.0.0
 **/
public class JDPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用京东白条");
        System.out.println("查询账户余额，开始扣款");
        return new PayState(200, "支付成功", amount);
    }
}
