package com.zhangwei.netty.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-10 12:38 PM
 * @since 1.0.0
 **/
@Slf4j
public class ClientNetty implements Runnable {
    @Override
    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel socketChannel) throws Exception {
                                    ChannelPipeline pipeline = socketChannel.pipeline();
                                    pipeline.addLast("frameDecoder",
                                            new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                                    pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                                    pipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
                                    pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                                    pipeline.addLast("handler", new ClientHandler());
                                }
                            }
                    );
            for (int i = 0; i < 10; i++) {
                ChannelFuture f = bootstrap.connect("127.0.0.1", 6789).sync();
                f.channel().writeAndFlush("hello service !" + Thread.currentThread().getName() + ":---->" + i);
                f.channel().closeFuture().sync();
            }
        } catch (Exception e) {
            log.error("", e);
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new ClientNetty(), ">>> this thread " + i).start();
        }
    }
}
