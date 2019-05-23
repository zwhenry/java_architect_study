package com.zhangwei.factory.abstr;

import com.zhangwei.factory.Milk;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 2:20 PM
 * @since 1.0.0
 **/
public abstract class AbstractFactory {

    public abstract Milk getMengniu();

    public abstract Milk getYili();

    public abstract Milk getTelunsu();

}
