package the.flash.channelreadbiz;

import io.netty.channel.ChannelHandlerContext;
import the.flash.protocol.Packet;

/**
 * @author yunfeng.lu
 * @create 2018/10/12.
 */
public interface ChannelRead {

    void doChannelRead(ChannelHandlerContext ctx,Packet packet);
}
