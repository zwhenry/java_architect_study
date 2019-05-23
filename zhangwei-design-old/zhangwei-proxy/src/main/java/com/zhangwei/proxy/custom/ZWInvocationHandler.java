package com.zhangwei.proxy.custom;

import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-06 2:54 PM
 * @since 1.0.0
 **/
public interface ZWInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
