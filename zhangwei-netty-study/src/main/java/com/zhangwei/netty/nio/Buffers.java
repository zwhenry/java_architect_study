package com.zhangwei.netty.nio;

import java.nio.ByteBuffer;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 1:47 PM
 * @since 1.0.0
 **/
public class Buffers {
    ByteBuffer readBuffer;
    ByteBuffer writeBuffer;

    public Buffers(int readCapacity, int writeCapacity){
        this.readBuffer=ByteBuffer.allocate(readCapacity);
        this.writeBuffer=ByteBuffer.allocate(writeCapacity);
    }

    public ByteBuffer getReadBuffer() {
        return readBuffer;
    }

    public ByteBuffer getWriteBuffer() {
        return writeBuffer;
    }
}
