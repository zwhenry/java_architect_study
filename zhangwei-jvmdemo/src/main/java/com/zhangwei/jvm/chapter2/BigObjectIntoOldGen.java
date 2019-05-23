package com.zhangwei.jvm.chapter2;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2019-02-25 5:57 PM
 * @since 1.0.0
 **/
public class BigObjectIntoOldGen {

    /**
     *  -Xms10M -Xmx10M -XX:+PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        byte[] bytes = new byte[6 * 1024 * 1024];
    }
}
