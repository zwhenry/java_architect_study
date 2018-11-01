package com.zhangwei.singleton.lazy;

/**
 * //懒汉式单例
 *
 *
 *
 * @author zhangwei10
 * @create 2018-11-01 1:11 PM
 * @since 1.0.0
 **/
public class LazyTwo {
    private LazyTwo() {
    }

    private static LazyTwo lazyTwo =null;

    public static synchronized LazyTwo getInstance() {

        if (lazyTwo == null) {
            lazyTwo = new LazyTwo();
        }
        return lazyTwo;
    }
}
