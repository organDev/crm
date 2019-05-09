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
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author maikec
 * @date 2019/4/29
 */
public class ProcessingHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RequestDTO requestDTO = (RequestDTO) msg;

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode( requestDTO.getAge()<<1 );

        ChannelFuture channelFuture = ctx.writeAndFlush( responseDTO );
        channelFuture.addListener( ChannelFutureListener.CLOSE );

        System.out.println( requestDTO );
    }
}
