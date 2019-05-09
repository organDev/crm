package com.crm.netty.bootstrap.chapter3;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.netty.channelhandler.chapter3.TimeClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;


/**
 * @author maikec
 * @date 2019/5/7
 */
@Slf4j
public final class TimeClient {
    public static void main(String[] args) throws Exception{
        Integer port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf( args[0] );
            } catch (NumberFormatException e){
                log.error( "",e );
            }
        }
        new TimeClient().connect(port,"127.0.0.1");
    }

    private void connect(Integer port, String host) throws Exception{
        //配置客户端NIO线程组
        NioEventLoopGroup group = new NioEventLoopGroup(  );
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group( group )
                    .channel( NioSocketChannel.class )
                    .option( ChannelOption.TCP_NODELAY,true )
                    .handler( new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast( new TimeClientHandler() );
                        }
                    } );

            ChannelFuture future = bootstrap.connect( host,port ).sync();
            future.channel().closeFuture().sync();

        }finally {
            group.shutdownGracefully();
        }
    }
}
