package com.zhangwei.singleton.test;

import com.zhangwei.singleton.lazy.LazySimpleSingleton;
import com.zhangwei.singleton.threadlocal.ThreadLocalSingleton;

/**
 * Created by Tom.
 */
public class ExectorThread implements Runnable{
    @Override
    public void run() {
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
//        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
