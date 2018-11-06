package com.zhangwei.proxy.jdk;

import com.zhangwei.proxy.staticed.Person;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-06 2:27 PM
 * @since 1.0.0
 **/
public class ZhangWei implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
    }

    @Override
    public void zufangzi() {
        System.out.println("租房子");
    }

    @Override
    public void findJob() {
        System.out.println("找工作");
    }
}
