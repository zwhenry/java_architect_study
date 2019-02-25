package com.zhangwei.jvm;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2019-02-25 2:59 PM
 * @since 1.0.0
 **/
public class StackTest {
    private static final String name = "";
    private static  String staicname = "";

    interface test{}

    public StackTest() {
    }

    public static void add(int a , int b){
        int result = a + b ;

    }
    public static void test02(){
        test02();
    }
    public static void test03(){}

    public static void main(String[] args) {
        add(1,2);
        test02();


    }
}
