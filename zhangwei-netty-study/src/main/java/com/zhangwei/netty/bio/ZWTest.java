package com.zhangwei.netty.bio;

import java.io.IOException;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-03 2:41 PM
 * @since 1.0.0
 **/
public class ZWTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                BIOService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);

        final char[] op = {'+', '-', '*', '/'};
        final Random random = new Random(System.currentTimeMillis());
        new Thread(() -> {
            while (true) {
                String expression = random.nextInt(10) + "" + op[random.nextInt(4)] +
                        (random.nextInt(10) + 1);
                Client.send(expression);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
