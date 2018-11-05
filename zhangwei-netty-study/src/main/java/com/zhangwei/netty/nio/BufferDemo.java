package com.zhangwei.netty.nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 1:12 PM
 * @since 1.0.0
 **/
public class BufferDemo {

    public static void encode(String str) {
        CharBuffer charBuffer = CharBuffer.allocate(128);
        charBuffer.append(str);
        charBuffer.flip();

        Charset charset = Charset.forName("UTF-8");
        //
        ByteBuffer byteBuffer = charset.encode(charBuffer);
        byte[] bytes = Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());
        System.out.println(Arrays.toString(bytes));
    }

    public static void decode(String str) throws UnsupportedEncodingException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put(str.getBytes("UTF-8"));
        byteBuffer.flip();


        Charset utf8 = Charset.forName("UTF-8");
        /*对bytebuffer中的内容解码*/
        CharBuffer charBuffer = utf8.decode(byteBuffer);

        /*array()返回的就是内部的数组引用，编码以后的有效长度是0~limit*/
        char[] charArr = Arrays.copyOf(charBuffer.array(), charBuffer.limit());
        System.out.println(Arrays.toString(charArr));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        encode("张伟测试");
        decode("张伟测试");
    }
}
