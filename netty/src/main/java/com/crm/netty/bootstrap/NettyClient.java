package com.crm.netty.bootstrap;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.netty.channelhandler.ClientHandler;
import com.crm.netty.coder.RequestEncoder;
import com.crm.netty.coder.ResponseDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author maikec
 * @date 2019/4/29
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        String host = "localhost";
        int port = 8080;

        EventLoopGroup workerGroup = new NioEventLoopGroup(  );

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap
                    .group( workerGroup )
                    .channel( NioSocketChannel.class )
                    .option( ChannelOption.SO_KEEPALIVE,true )
                    .handler( new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast( new RequestEncoder(),new ResponseDecoder(),new ClientHandler() );
                        }
                    } );
            ChannelFuture channelFuture = bootstrap.connect( host,port ).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
        }
    }
}
