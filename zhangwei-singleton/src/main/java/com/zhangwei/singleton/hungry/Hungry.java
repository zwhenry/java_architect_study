package com.zhangwei.singleton.hungry;

/**
 * 饿汉式
 *
 * @author zhangwei10
 * @create 2018-11-01 12:55 PM
 * @since 1.0.0
 **/

//饿汉式单例
// 它是在类加载的时候就立即初始化，并且创建单例对象

//优点：没有加任何的锁、执行效率比较高，
//在用户体验上来说，比懒汉式更好

//缺点：类加载的时候就初始化，不管你用还是不用，我都占着空间
//浪费了内存，有可能占着茅坑不拉屎

//绝对线程安全，在线程还没出现以前就是实例化了，不可能存在访问安全问题
public class Hungry {

    public Hungry() {
    }
    //先静态，后动态
    //先熟悉，后方法
    //线上后下
    private static final Hungry hungry = new Hungry();


    public static Hungry getInstance() {
        return hungry;
    }
}
