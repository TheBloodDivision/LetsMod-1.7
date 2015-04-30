package com.TheBloodDivision.LetsMod.network;

import com.TheBloodDivision.LetsMod.LetsMod;
import com.TheBloodDivision.LetsMod.reference.Reference;
import com.TheBloodDivision.LetsMod.tileentity.LetsModTileEntity;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;

@Sharable
public class DescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket>{
    public static final String CHANNEL = Reference.MOD_ID + "Description";

    static {
        NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescriptionHandler());
    }

    public static void init(){
        //not actually doing anything here, apart from loading the class. If the channel registry goes in here, Netty will throw a duplicate
        //channel error.
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception{
        ByteBuf buf = msg.payload();
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        TileEntity te = LetsMod.proxy.getClientPlayer().worldObj.getTileEntity(x, y, z);
        if(te instanceof LetsModTileEntity) {
            ((LetsModTileEntity)te).readFromPacket(buf);
        }
    }

}
