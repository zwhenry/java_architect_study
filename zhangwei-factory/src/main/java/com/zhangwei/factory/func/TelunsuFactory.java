package com.zhangwei.factory.func;

import com.zhangwei.factory.Milk;
import com.zhangwei.factory.Telunsu;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 2:16 PM
 * @since 1.0.0
 **/
public class TelunsuFactory implements Factory {
    public Milk getMilk() {
        return new Telunsu();
    }
}
