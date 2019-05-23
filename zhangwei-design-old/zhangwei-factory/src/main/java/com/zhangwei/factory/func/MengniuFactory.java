package com.zhangwei.factory.func;

import com.zhangwei.factory.Mengniu;
import com.zhangwei.factory.Milk;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 2:15 PM
 * @since 1.0.0
 **/
public class MengniuFactory implements Factory {
    public Milk getMilk() {
        return new Mengniu();
    }
}
