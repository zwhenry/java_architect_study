package com.zhangwei.strategy.pay.payport;

import com.zhangwei.strategy.pay.PayState;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 7:06 PM
 * @since 1.0.0
 **/
public interface Payment {
    public PayState pay(String uid, double amount);
}
