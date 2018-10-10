package the.flash.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * SecondServerHandler.class
 *
 * @author yunfeng.lu
 * @date 2018/10/10
 */
public class SecondServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 客户端连上 触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes("客户端刚刚接入，这条消息从服务端发起到客户端".getBytes("UTF-8"));
        ctx.channel().writeAndFlush(buffer);

        System.out.println("channelActive " + ctx.channel().id());
    }

    /**
     * 客户端 断开触发
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive "+ ctx.channel().id());
    }

}
