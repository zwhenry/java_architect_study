package com.zhangwei.jvm;

import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2019-02-25 3:09 PM
 * @since 1.0.0
 **/
public class OOMTest {
    /**
     * 运行参数 -Xmx1k -Xms1k -XX:+PrintGCDetails 打印GC详细信息
     * @param args
     */
    public static void main(String[] args) {
        String str = "www.google.com" ;
        while(true) {
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);

        }
    }
}
