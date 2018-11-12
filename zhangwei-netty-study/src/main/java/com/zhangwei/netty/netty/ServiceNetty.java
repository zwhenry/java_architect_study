package com.zhangwei.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-10 12:23 PM
 * @since 1.0.0
 **/
@Slf4j
public class ServiceNetty {

    private static final String IP = "127.0.0.1";
    private static final int PORT = 6789;

    private static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors() * 2;

    private static final int BIZTHREADSIZE = 100;

    //Configure the server
    //创建两个EventLoopGroup对象
    //创建boss线程组 ⽤用于服务端接受客户端的连接
    //    boss 线程组: ⽤用于服务端接受客户端的 连接 。连接
    //    worker 线程组: ⽤用于进⾏行行客户端的SocketChannel的 数据读写 。
    private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
    // 创建 worker 线程组 ⽤用于进⾏行行 SocketChannel 的数据读写
    private static final EventLoopGroup workGroup = new NioEventLoopGroup(BIZTHREADSIZE);


    public static void start() throws InterruptedException {
        // 创建 ServerBootstrap 对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //设置使⽤用的EventLoopGroup
        serverBootstrap.group(bossGroup, workGroup)
                //设置要被实例例化的为 NioServerSocketChannel 类
                .channel(NioServerSocketChannel.class)
                // 设置 NioServerSocketChannel 的处理理器器
                .handler(new LoggingHandler(LogLevel.INFO))
                // 设置连⼊入服务端的 Client 的 SocketChannel 的处理理器器
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        // 添加帧限定符来防⽌止粘包现象
                        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                        // 解码和编码，应和客户端⼀一致
                        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                        // 业务逻辑实现类
                        pipeline.addLast(new ServiceHandler());
                    }
                });

        // 绑定端⼝口，并同步等待成功，即启动服务端 sync好像不需要
        //先 调⽤用 #bind(int port) ⽅方法，绑定端⼝口， 后 调⽤用 ChannelFuture#sync() ⽅方 法，阻塞等待成功。这个过程，就是“ 启动服务端 ”。
        ChannelFuture channelFuture = serverBootstrap.bind(IP, PORT).sync();
        // 监听服务端关闭，并阻塞等待
        channelFuture.channel().closeFuture().sync();
        log.info("server start");
    }


    protected static void shutdown() {
        //关闭两个 EventLoopGroup 对象
        workGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        log.info("启动Server...");
        ServiceNetty.start();
    }
}
