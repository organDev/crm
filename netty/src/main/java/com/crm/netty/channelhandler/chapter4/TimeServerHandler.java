package com.crm.netty.channelhandler.chapter4;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.Date;

/**
 * @author maikec
 * @date 2019/5/8
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    private Integer counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.writeBytes( req );

        String body = new String(req,CharsetUtil.UTF_8 ).substring( 0,
                req.length-System.getProperty( "line.separator" ).length() );
        System.out.println( "The time server receive Order :" + body + ";the counter is:" + ++counter );

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase( body )?
                new Date( System.currentTimeMillis() ).toString():"BAD ORDER";
        currentTime+=System.getProperty( "line.separator" );
        ByteBuf resp = Unpooled.copiedBuffer( currentTime.getBytes() );

        ctx.writeAndFlush( resp );
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
