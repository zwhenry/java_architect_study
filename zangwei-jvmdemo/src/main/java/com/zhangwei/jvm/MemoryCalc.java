package com.zhangwei.jvm;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2019-02-25 3:09 PM
 * @since 1.0.0
 **/
public class MemoryCalc {


    /**
     * 运行参数   -Xmx1024M -Xms1024M -XX:+PrintGCDetails 打印GC详细信息
     * 新生代 养老区 元空间
     * @param args
     */
    public static void main(String[] args) {

        long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
        System.out.println("MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");


    }
}
