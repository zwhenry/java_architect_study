package com.zhangwei.netty.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.util.Date;

/**
 * 服务相关的设置的代码写完之后，我们再来编写主要的业务代码。
 * 使⽤用Netty编写 [业务层 ]的代码， 我们需要继承 ChannelInboundHandlerAdapter 或 SimpleChannelInboundHandler 类，在这 ⾥里里顺便便说下它们两的区别吧。
 * 继承 SimpleChannelInboundHandler 类之后，会在接收到数据后会 ⾃自动 release 掉数据占⽤用的 Bytebuffer 资源。并且继承该类需要指定数据格式。
 * 而继 承ChannelInboundHandlerAdapter 则不不会⾃自动释放，需要⼿手动调⽤用 ReferenceCountUtil.release() 等⽅方法进⾏行行释放。继承该类不不需要指定数据格式。
 * 所以在这⾥里里，个⼈人 推荐服务端继承 ChannelInboundHandlerAdapter ，⼿手动进⾏行行释放，防⽌止数据未处理理完就⾃自动释放 了了。
 * ⽽而且服务端可能有多个客户端进⾏行行连接，并且每⼀一个客户端请求的数据格式都不不⼀一致，这时便便可 以进⾏行行相应的处理理。
 * 客户端根据情况可以继承 SimpleChannelInboundHandler 类。好处是直接指 定好传输的数据格式，就不不需要再进⾏行行格式的转换了了。
 *
 * @author zhangwei10
 * @create 2018-11-10 12:30 PM
 * @since 1.0.0
 **/
@Slf4j
//@Sharable  这⾥里里有个注解， 该注解 Sharable 主要是为了了多个handler可以被多个channel安全地共享，也就是保 证线程安全。
public class ServiceHandler extends ChannelInboundHandlerAdapter {
    /**
     * 建⽴立连接时，发送⼀一条庆祝消息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("chanelActive>>>>>>>");
        // 为新连接发送庆祝
        ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName() + "!/r/n");
        ctx.write("It is " + new Date() + " now./r/n");
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("server receive message:" + msg);
        ctx.channel().writeAndFlush("accept message " + msg);
        ctx.close();
    }

    /**
     * 异常处理理
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("get server exception :" + cause.getMessage());
    }
}
