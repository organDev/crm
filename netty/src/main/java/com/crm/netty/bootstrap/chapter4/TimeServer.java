package com.crm.netty.bootstrap.chapter4;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.netty.channelhandler.chapter4.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author maikec
 * @date 2019/5/8
 */
public final class TimeServer {
    public static void main(String[] args) throws Exception{
        Integer port = 8080;
        if (null != args && args.length >0){
            port = Integer.valueOf( args[0] );
        }

        new TimeServer().bind(port);
    }

    private void bind(Integer port) throws Exception{
        NioEventLoopGroup bossGroup = new NioEventLoopGroup( 1 );
        NioEventLoopGroup workGroup = new NioEventLoopGroup( 3 );

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group( bossGroup,workGroup )
                    .channel( NioServerSocketChannel.class )
                    .option( ChannelOption.SO_BACKLOG,1024 )
                    .childHandler( new TimeServerHandler() );

            ChannelFuture future = bootstrap.bind( port ).sync();
            future.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
