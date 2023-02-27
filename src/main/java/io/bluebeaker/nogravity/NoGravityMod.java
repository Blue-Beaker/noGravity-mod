package io.bluebeaker.nogravity;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file

@Mod(modid = NoGravityMod.MODID, name = NoGravityMod.NAME, version = NoGravityMod.VERSION)
public class NoGravityMod
{
    public static final String MODID = "nogravity";
    public static final String NAME = "No Gravity";
    public static final String VERSION = "1.1";

    private static Logger logger;

    public NoGravityMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
