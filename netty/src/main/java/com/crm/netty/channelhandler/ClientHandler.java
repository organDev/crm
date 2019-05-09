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
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author maikec
 * @date 2019/4/29
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setAge( 123 );
        requestDTO.setName( "Hi" );
        ChannelFuture channelFuture = ctx.writeAndFlush( requestDTO );
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg );
        ctx.close();
    }
}
