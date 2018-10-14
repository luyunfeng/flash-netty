package the.flash.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import the.flash.protocol.Packet;
import the.flash.protocol.PacketCodeC;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) {
        System.out.println("编码");
        PacketCodeC.INSTANCE.encode(out, packet);
    }
}
