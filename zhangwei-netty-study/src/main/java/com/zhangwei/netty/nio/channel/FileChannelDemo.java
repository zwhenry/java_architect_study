package com.zhangwei.netty.nio.channel;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 3:02 PM
 * @since 1.0.0
 **/
@Slf4j
public class FileChannelDemo {
    public static void main(String[] args) {
        //写
        try {
            File file=new File("/Users/zhangwei/nio_utf8.text");
            if(!file.exists()){
                file.createNewFile();
            }

            FileOutputStream fos=new FileOutputStream(file);
            FileChannel fc=fos.getChannel();
            /*创建ByteBuffer对象， position = 0, limit = 128*/
            ByteBuffer bb=ByteBuffer.allocate(128);
            /*向ByteBuffer中放入字符串UTF-8的字节, position = 22, limit = 128*/
            bb.put("Hello,World zhangwei \n".getBytes("UTF-8"));
            /*flip方法  position = 0, limit = 22*/
            bb.flip();
            //写入
            fc.write(bb);
            /*clear方法使得position = 0， limit = 22*/
            bb.clear();

            //重复上面的 再来一次
            bb.put("你好，世界 张伟\n".getBytes("UTF-8"));
            bb.flip();
            fc.write(bb);
            bb.clear();

            fos.close();
            fc.close();

        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getLocalizedMessage());
        }

        //读
        try {
            Path path= Paths.get("/Users/zhangwei/nio_utf8.text");
            FileChannel fc=FileChannel.open(path);
            ByteBuffer bb =ByteBuffer.allocate((int) (fc.size()+1));

            Charset utf8 = Charset.forName("UTF-8");
            fc.read(bb);
            bb.flip();

            CharBuffer cb = utf8.decode(bb);
            log.info(cb.toString());

            bb.clear();
            fc.close();

        }catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
    }
}
