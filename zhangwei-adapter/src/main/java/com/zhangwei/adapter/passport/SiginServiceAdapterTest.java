package com.zhangwei.adapter.passport;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 5:46 PM
 * @since 1.0.0
 **/
public class SiginServiceAdapterTest {
    public static void main(String[] args) {
        SiginServiceAdapter service = new SiginServiceAdapter();

        //不改变原来的代码，也要能够兼容新的需求
        //还可以再加一层策略模式
        service.loginForQQ("1234asdasdwpoi");
    }
}
