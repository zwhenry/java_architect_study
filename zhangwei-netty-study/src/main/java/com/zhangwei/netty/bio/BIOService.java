package com.zhangwei.netty.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-03 2:02 PM
 * @since 1.0.0
 **/
@Slf4j
public class BIOService {
    private static int DEFAULT_PORT = 7777;
    private static ServerSocket serverSocket;

    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    private static void start(int port) throws IOException {
        if (serverSocket != null) return;

        try {

            serverSocket = new ServerSocket(port);
            System.out.println("服务端已经启动，端口号:" + port);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServiceHandler(socket)).start();
            }
        } finally {
            if (null != serverSocket) {
                System.out.println("服务已经关闭。");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
