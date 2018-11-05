package com.zhangwei.factory.abstr;

import com.zhangwei.factory.Mengniu;
import com.zhangwei.factory.Milk;
import com.zhangwei.factory.Telunsu;
import com.zhangwei.factory.Yili;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 2:21 PM
 * @since 1.0.0
 **/
public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getMengniu() {
        return new Mengniu();
    }

    @Override
    public Milk getYili() {
        return new Yili();
    }

    @Override
    public Milk getTelunsu() {
        return new Telunsu();
    }
}
