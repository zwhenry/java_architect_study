package com.zhangwei.proxy.jdk;

import com.zhangwei.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-06 2:28 PM
 * @since 1.0.0
 **/
public class JdkProxy implements InvocationHandler {
    private Person person;

    public Object getInstance(Person person) {
        this.person = person;
        Class<?> clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理对象：我要代理你");
        System.out.println("开始代理");

        method.invoke(this.person, args);
        System.out.println("完成代理");

        return null;
    }
}
