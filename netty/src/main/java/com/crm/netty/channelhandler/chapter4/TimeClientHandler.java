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
import lombok.extern.slf4j.Slf4j;

/**
 * @author maikec
 * @date 2019/5/8
 */
@Slf4j
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private Integer counter;
    private byte[] req;

    public TimeClientHandler(){
        req = ("QUERY TIME ORDER"+System.getProperty( "line.separator" )).getBytes();
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf msg = null;
        for (int i=0;i<100;i++){
            msg = Unpooled.buffer( req.length );
            msg.writeBytes( req );
            ctx.writeAndFlush( msg );
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.writeBytes( req );

        String body = new String( req,CharsetUtil.UTF_8 );
        System.out.println( "NOW IS :" + body + "the counter is:" + ++counter );
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info( cause.getMessage() );
        ctx.close();
    }
}
