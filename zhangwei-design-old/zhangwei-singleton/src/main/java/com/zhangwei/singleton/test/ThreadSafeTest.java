package com.zhangwei.singleton.test;

import com.zhangwei.singleton.hungry.Hungry;
import com.zhangwei.singleton.lazy.LazyOne;
import com.zhangwei.singleton.lazy.LazyTwo;

import java.util.concurrent.CountDownLatch;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-01 1:00 PM
 * @since 1.0.0
 **/
public class ThreadSafeTest {

    public static void main(String[] args) {

        int count = 200;
        final CountDownLatch latch = new CountDownLatch(count);

        Long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 阻塞
                        // count = 0 就会释放所有的共享锁
                        // 万箭齐发
                        latch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Object object = LazyTwo.getInstance();
                    System.out.println(System.currentTimeMillis() + ":" + object);

                }
            }.start();//每循环一次，就启动一个线程,具有一定的随机性

            //每次启动一个线程，count --
            latch.countDown();
        }
        Long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));

    }
}
