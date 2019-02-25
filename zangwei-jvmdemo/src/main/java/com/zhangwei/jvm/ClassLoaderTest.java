package com.zhangwei.jvm;

/**
 * 加载器
 *
 * @author zhangwei10
 * @create 2019-02-25 2:32 PM
 * @since 1.0.0
 **/
public class ClassLoaderTest {
    public static void test01(){}
    public static void test02(){}
    public static void test03(){}

    public static void main(String[] args) {
        System.out.println(new ClassLoaderTest().getClass().getClassLoader().getParent().getParent());
        System.out.println(new ClassLoaderTest().getClass().getClassLoader().getParent());
        System.out.println(new ClassLoaderTest().getClass().getClassLoader());
        System.out.println("===============");
        System.out.println(new Object().getClass().getClassLoader());
    }
}
