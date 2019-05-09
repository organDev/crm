package com.crm.netty.bootstrap;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.netty.channelhandler.ProcessingHandler;
import com.crm.netty.coder.RequestDecoder;
import com.crm.netty.coder.ResponseEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author maikec
 * @date 2019/4/29
 * netty服务端
 */
public class NettyServer {
    private Integer port;

    public NettyServer(Integer port){
        this.port = port;
    }

    public static void main(String[] args) throws Exception{
        int port = args.length>0?Integer.parseInt( args[0] ):8080;
        new NettyServer(port).run();
    }

    private void run() throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup(  );
        EventLoopGroup workerGroup = new NioEventLoopGroup(  );

        try {
            ServerBootstrap  serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group( bossGroup,workerGroup )
                    .channel( NioServerSocketChannel.class )
                    .childHandler( new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast( new RequestDecoder(),new ResponseEncoder(),new ProcessingHandler() );
                        }
                    } )
                    .option( ChannelOption.SO_BACKLOG,128 )
                    .childOption( ChannelOption.SO_KEEPALIVE,true );

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
