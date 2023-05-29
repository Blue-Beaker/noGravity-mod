package io.bluebeaker.nogravity;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.loading.FMLPaths;

public class ConfigRegistry {
	private static final ForgeConfigSpec.Builder CFGC = new ForgeConfigSpec.Builder();
	private static ForgeConfigSpec CLIENT_CONFIG;
	public static ForgeConfigSpec.BooleanValue NoGravityParticle;
	static{
		initConfig();
	}
	private static void initConfig(){
		NoGravityParticle=CFGC.comment("No Gravity for Particles. Purely cosmetic.").define("no_gravity_particle", true);
		CLIENT_CONFIG = CFGC.build();
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
}
