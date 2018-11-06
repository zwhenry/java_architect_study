package com.zhangwei.proxy.staticed;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-06 2:21 PM
 * @since 1.0.0
 **/
public class StaticProxyTest {
    public static void main(String[] args) {
        //只能帮儿子找对象
        //不能帮表妹、不能帮陌生人
        Father father=new Father(new Son());
        father.findLove();
    }
}
