package com.zhangwei.factory.func;

import com.zhangwei.factory.Milk;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 2:18 PM
 * @since 1.0.0
 **/
public class FactoryTest {

    public static void main(String[] args) {
        //跟进不同情况换相应的工厂
        Factory factory=new MengniuFactory();
        Milk milk=factory.getMilk();
        System.out.println(milk);
    }
}
