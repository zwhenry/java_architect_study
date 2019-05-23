package com.zhangwei.factory.func;

import com.zhangwei.factory.Milk;
import com.zhangwei.factory.Yili;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 2:16 PM
 * @since 1.0.0
 **/
public class YiliFactory implements Factory {
    public Milk getMilk() {
        return new Yili();
    }
}
