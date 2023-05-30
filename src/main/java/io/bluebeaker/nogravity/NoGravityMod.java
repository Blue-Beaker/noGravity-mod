package io.bluebeaker.nogravity;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file

@Mod("nogravity")
public class NoGravityMod
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "nogravity";
    public NoGravityMod() {
        MinecraftForge.EVENT_BUS.register(this);
        ConfigRegistry.setupClient();
        ConfigRegistry.setupCommon();
    }
    // Apply NoGravity on entity spawn
    @SubscribeEvent
    public void onEntitySpawn(EntityJoinWorldEvent event){
        event.getEntity().setNoGravity(true);
    }
    // Apply NoGravity on entity spawn
    @SubscribeEvent
    public void onPlayerJoin(PlayerLoggedInEvent event){
        event.getPlayer().setNoGravity(true);
    }
    // Modify mining speed to negate 'not on ground' penalty
    @SubscribeEvent
    public void onMining(PlayerEvent.BreakSpeed event){
        if(ConfigRegistry.NegateMiningSpeedPenalty.get() && !event.getPlayer().isOnGround() && event.getPlayer().isNoGravity()){
            event.setNewSpeed(event.getNewSpeed()*5.0f);
        }
    }
    // Remove fall damage
    @SubscribeEvent
    public void onFall(LivingFallEvent event){
        if(event.getEntity().isNoGravity()){
            event.setCanceled(true);
        }
    }
}
