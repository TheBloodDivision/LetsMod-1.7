package com.TheBloodDivision.LetsMod;

import com.TheBloodDivision.LetsMod.init.LetsModBlocks;
import com.TheBloodDivision.LetsMod.init.LetsModItems;
import com.TheBloodDivision.LetsMod.init.LetsModTileEntity;
import com.TheBloodDivision.LetsMod.proxy.CommonProxy;
import com.TheBloodDivision.LetsMod.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class LetsMod {
    @Mod.Instance(Reference.MOD_ID)
    public static LetsMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS, modId = Reference.MOD_ID)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        LetsModBlocks.init();
        LetsModItems.init();
        LetsModTileEntity.init();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }
}
