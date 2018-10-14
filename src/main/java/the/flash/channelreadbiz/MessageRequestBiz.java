package the.flash.channelreadbiz;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import the.flash.protocol.Packet;
import the.flash.protocol.PacketCodeC;
import the.flash.protocol.request.MessageRequestPacket;
import the.flash.protocol.response.MessageResponsePacket;

import java.util.Date;

/**
 * @author yunfeng.lu
 * @create 2018/10/12.
 */
public class MessageRequestBiz implements ChannelRead {
    @Override
    public void doChannelRead(ChannelHandlerContext ctx, Packet packet) {
        // 客户端发来消息
        MessageRequestPacket messageRequestPacket = ((MessageRequestPacket) packet);

        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());
        messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
        ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), messageResponsePacket);
        ctx.channel().writeAndFlush(responseByteBuf);
    }
}
