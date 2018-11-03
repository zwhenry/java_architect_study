package com.zhangwei.netty.biotask;

import com.zhangwei.netty.bio.Calculator;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 聊天处理
 *
 * @author zhangwei10
 * @create 2018-11-03 2:12 PM
 * @since 1.0.0
 **/
@Slf4j
public class MessageForwardHandler implements Runnable {
    private Socket socket;

    public MessageForwardHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String message;
            while (true) {
                //通过BufferedReader读取一行
                //如果已经读到输入流尾部，返回null,退出循环
                //如果得到非空值，就尝试计算结果并返回
                if ((message = in.readLine()) == null) break;
                log.info(("服务端收到信息：" + message));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getLocalizedMessage());
        } finally {
            //关闭流
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
