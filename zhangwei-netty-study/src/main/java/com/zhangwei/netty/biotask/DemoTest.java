package com.zhangwei.netty.biotask;

import com.zhangwei.netty.bio.BIOService;
import com.zhangwei.netty.bio.Client;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-03 6:11 PM
 * @since 1.0.0
 **/
@Slf4j
public class DemoTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                ServiceDemo.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            while (true) {
                Scanner scanner=new Scanner(System.in);
                ClientDemo.send(scanner.next());
            }
        }).start();
    }
}
