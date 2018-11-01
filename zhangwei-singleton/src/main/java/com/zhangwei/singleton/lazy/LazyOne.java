package com.zhangwei.singleton.lazy;

/**
 * //懒汉式单例
 *
 *     //在外部需要使用的时候才进行实例化
 *
 * @author zhangwei10
 * @create 2018-11-01 1:11 PM
 * @since 1.0.0
 **/
public class LazyOne {
    private LazyOne() {
    }

    private static LazyOne lazyOne=null;

    public static LazyOne getInstance() {
        if (lazyOne == null) {
            lazyOne = new LazyOne();
        }
        return lazyOne;
    }
}
