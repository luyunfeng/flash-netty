package the.flash.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import the.flash.channelreadbiz.ChannelRead;
import the.flash.channelreadbiz.LoginRequestBiz;
import the.flash.channelreadbiz.MessageRequestBiz;
import the.flash.protocol.Packet;
import the.flash.protocol.PacketCodeC;
import the.flash.protocol.request.LoginRequestPacket;
import the.flash.protocol.request.MessageRequestPacket;
import the.flash.protocol.response.LoginResponsePacket;
import the.flash.protocol.response.MessageResponsePacket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static the.flash.protocol.command.Command.*;

/**
 * @author chao.yu
 * chao.yu@dianping.com
 * @date 2018/08/04 06:21.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    private static Map<Byte, Class<? extends ChannelRead>> packetTypeMap;

    static {
        packetTypeMap = new ConcurrentHashMap<>();
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestBiz.class);
        packetTypeMap.put(MESSAGE_REQUEST, MessageRequestBiz.class);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf requestByteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);
        packetTypeMap.forEach((type, className) -> {
            if (type.equals(packet.getCommand())) {
                try {
                    className.newInstance().doChannelRead(ctx, packet);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
