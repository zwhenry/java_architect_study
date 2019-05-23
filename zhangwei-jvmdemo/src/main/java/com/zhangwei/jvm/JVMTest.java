package com.zhangwei.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * OOM 并打印 同时打印GC日志
 *
 * @author zhangwei10
 * @create 2019-02-25 2:54 PM
 * @since 1.0.0
 **/
public class JVMTest {
    private static final String  a = new String("12");

    public static  JVMTest create(){
        return new JVMTest();
    }

    byte[] byteArray = new byte[1 * 1024 * 1024];

    /**
     *   -Xms1m -Xmx8M -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        //逃逸
        JVMTest jvmTest = JVMTest.create();

        List<JVMTest> list = new ArrayList<>();
        int count = 0;
        try {
            while (true){
                list.add(new JVMTest());
                count ++;
            }
        }catch (Throwable e){
            System.out.println("count:"+ count);
            e.printStackTrace();
        }

    }
}
