package com.crm.netty.coder;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.netty.dto.RequestDTO;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author maikec
 * @date 2019/4/29
 */
public class RequestDecoder extends ReplayingDecoder<RequestDTO> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setAge( in.readInt() );
        int strLen = in.readInt();
        requestDTO.setName( in.readCharSequence( strLen,Charset.forName( "UTF-8" ) ).toString() );
        out.add( requestDTO );
    }
}
