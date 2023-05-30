package io.bluebeaker.nogravity;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigRegistry {
	private static final ForgeConfigSpec.Builder CFGC = new ForgeConfigSpec.Builder();
	public static ForgeConfigSpec CLIENT_CONFIG;

	private static final ForgeConfigSpec.Builder CFG = new ForgeConfigSpec.Builder();
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec.BooleanValue NoGravityParticle;

	public static ForgeConfigSpec.BooleanValue NegateMiningSpeedPenalty;
	public static ForgeConfigSpec.BooleanValue NoFallingBlocks;
	public static ForgeConfigSpec.BooleanValue DespawnStuckArrows;
	public static ForgeConfigSpec.IntValue CleanProjectilesInterval;
	public static ForgeConfigSpec.ConfigValue<List<? extends String>> ProjectilesToClean;
	private static ArrayList<String> DefaultProjectilesToClean = new ArrayList<String>();
	static{
		initConfig();
	}
	private static void initConfig(){
		DefaultProjectilesToClean.add("minecraft:snowball");
		DefaultProjectilesToClean.add("minecraft:egg");
		DefaultProjectilesToClean.add("minecraft:experience_bottle");
		DefaultProjectilesToClean.add("minecraft:potion");
		DefaultProjectilesToClean.add("minecraft:llama_spit");
		DefaultProjectilesToClean.add("minecraft:trident");
		DefaultProjectilesToClean.add("minecraft:shulker_bullet");

		NoGravityParticle=CFGC.comment("No Gravity for Particles. Purely cosmetic.").define("no_gravity_particle", true);
		CLIENT_CONFIG = CFGC.build();

		NegateMiningSpeedPenalty=CFG.comment("Negate mining speed penalty when in mid-air.").define("negate_mining_speed_penalty", true);
		NoFallingBlocks=CFG.comment("Prevent 'Gravity' blocks from falling.").define("no_falling_blocks", true);
		DespawnStuckArrows=CFG.comment("Despawn arrow projectiles stuck in air for 1min.").define("despawn_stuck_arrows", true);
		CleanProjectilesInterval=CFG.comment("Interval to clean other projectiles stuck in air. Interval unimplemented yet, projectiles will be cleaned just when its motion is near zero.").defineInRange("clean_projectiles_interval",1200,0,2147483647);
		ProjectilesToClean=CFG.comment("ID of other projectile types to be cleaned.").define("projectiles_to_clean",DefaultProjectilesToClean);
		COMMON_CONFIG = CFG.build();
	}
}
