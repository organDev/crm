package com.crm.netty.bootstrap.chapter3;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.netty.channelhandler.chapter3.ChildChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务端
 * @author maikec
 * @date 2019/5/7
 */
@Slf4j
public final class TimeServer {
    public void bind(Integer port) throws Exception{
        NioEventLoopGroup bossGroup = new NioEventLoopGroup( 1 );
        NioEventLoopGroup workGroup = new NioEventLoopGroup( 3 );

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group( bossGroup,workGroup )
                    .channel( NioServerSocketChannel.class )
                    .option( ChannelOption.SO_BACKLOG,1024 )
                    .childHandler( new ChildChannelHandler() );

            ChannelFuture future = serverBootstrap.bind( port ).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws Exception{
        Integer port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf( args[0] );
            } catch (NumberFormatException e){
                log.error( "",e );
            }
        }
        new TimeServer().bind( port );
    }
}
