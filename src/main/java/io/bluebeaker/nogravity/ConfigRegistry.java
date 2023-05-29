package io.bluebeaker.nogravity;

import java.util.ArrayList;
import java.util.List;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.loading.FMLPaths;

public class ConfigRegistry {
	private static final ForgeConfigSpec.Builder CFGC = new ForgeConfigSpec.Builder();
	private static ForgeConfigSpec CLIENT_CONFIG;

	private static final ForgeConfigSpec.Builder CFG = new ForgeConfigSpec.Builder();
	private static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec.BooleanValue NoGravityParticle;
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

		DespawnStuckArrows=CFG.comment("Despawn arrow projectiles stuck in air for 1min.").define("despawn_stuck_arrows", true);
		CleanProjectilesInterval=CFG.comment("Interval to clean other projectiles stuck in air.").defineInRange("clean_projectiles_interval",1200,0,2147483647);
		ProjectilesToClean=CFG.comment("ID of other projectile types to be cleaned.").define("projectiles_to_clean",DefaultProjectilesToClean);
		COMMON_CONFIG = CFG.build();
	}
	public static void setupClient() {
		final CommentedFileConfig configData = CommentedFileConfig.builder(FMLPaths.CONFIGDIR.get().resolve(NoGravityMod.MODID + "-client.toml"))
			.sync()
			.autosave()
			.writingMode(WritingMode.REPLACE)
			.build();
		configData.load();
		CLIENT_CONFIG.setConfig(configData);
	}
	public static void setupCommon() {
		final CommentedFileConfig configData = CommentedFileConfig.builder(FMLPaths.CONFIGDIR.get().resolve(NoGravityMod.MODID + "-common.toml"))
			.sync()
			.autosave()
			.writingMode(WritingMode.REPLACE)
			.build();
		configData.load();
		COMMON_CONFIG.setConfig(configData);

	}
}
