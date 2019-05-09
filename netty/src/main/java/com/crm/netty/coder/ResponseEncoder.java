package com.crm.netty.coder;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.netty.dto.ResponseDTO;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author maikec
 * @date 2019/4/29
 */
public class ResponseEncoder extends MessageToByteEncoder<ResponseDTO> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ResponseDTO msg, ByteBuf out) throws Exception {
        out.writeInt( msg.getCode() );
    }
}
