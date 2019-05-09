package com.crm.netty.channelhandler;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.netty.dto.RequestDTO;
import com.crm.netty.dto.ResponseDTO;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.java.Log;

/**
 * @author maikec
 * @date 2019/4/29
 */
@Log
public class SimpleProcessingHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println( "Handler added" );
        buf = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println( "Handler removed" );
        buf.release();
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        buf.writeBytes( byteBuf );
        byteBuf.release();

        if (buf.readableBytes()>4){
            RequestDTO requestDTO = new RequestDTO();
            requestDTO.setAge( buf.readInt() );

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setCode( requestDTO.getAge()<<1 );

            ChannelFuture channelFuture = ctx.writeAndFlush( responseDTO );
            channelFuture.addListener( ChannelFutureListener.CLOSE );
        }
    }
}
