package the.flash.channelreadbiz;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import the.flash.protocol.Packet;
import the.flash.protocol.PacketCodeC;
import the.flash.protocol.request.LoginRequestPacket;
import the.flash.protocol.response.LoginResponsePacket;

import java.util.Date;

/**
 * @author yunfeng.lu
 * @create 2018/10/12.
 */
public class LoginRequestBiz implements ChannelRead {

    @Override
    public void doChannelRead(ChannelHandlerContext ctx, Packet packet) {
        System.out.println(new Date() + ": 收到客户端登录请求……");
        // 登录流程
        LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            System.out.println(new Date() + ": 登录成功!");
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }
        // 登录响应
        ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
        ctx.channel().writeAndFlush(responseByteBuf);

    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

}
