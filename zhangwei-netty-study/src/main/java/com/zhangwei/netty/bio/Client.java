package com.zhangwei.netty.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 堵塞式I/O
 *
 * @author zhangwei10
 * @create 2018-11-03 2:30 PM
 * @since 1.0.0
 **/
@Slf4j
public class Client {
    //默认的端口号
    private static int DEFAULT_SERVER_PORT = 7777;

    private static String DEFAULT_SERVER_IP = "127.0.0.1";

    public static void send(String expression) {
        send(DEFAULT_SERVER_PORT, expression);
    }

    private static void send(int port, String expression) {
        System.out.println("客服端开始发送消息：" + expression);
        Socket socket = null;

        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket(DEFAULT_SERVER_IP, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            //注意不要写成print  接收和发送要使用相同的
            out.println(expression);
            System.out.println("结果为：" + in.readLine());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                in = null;

            }

            if (out != null) {
                out.close();
                out = null;

            }

            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;

            }

        }
    }
}
