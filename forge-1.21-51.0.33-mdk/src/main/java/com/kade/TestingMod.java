package com.kade;

import com.kade.block.ModBlocks;
import com.kade.item.ModCreativeModeTabs;
import com.kade.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestingMod.MOD_ID)
public class TestingMod {
	// Define mod id in a common place for everything to reference
	public static final String MOD_ID = "testingmod"; // LOWERCASE ALL SPACES
	// Directly reference a slf4j logger
	public static final Logger LOGGER = LogUtils.getLogger();

	public TestingMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register the commonSetup method for modloading
		modEventBus.addListener(this::commonSetup);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		
		/*
		 * Registers custom:
		 * Creative mode tabs
		 * Items
		 * Blocks
		 */
		ModCreativeModeTabs.register(modEventBus); // Order doesn't matter anymore, but does in older versions potentially
		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);

		// Registers the items to a creative tab
		modEventBus.addListener(this::addCreative);

		// Register our mod's ForgeConfigSpec so that Forge can create and load the
		// config file for us
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {

	}

	/**
	 * Used to add items to the creative mode inventory
	 * 
	 * @param event Used to access different parts of the creative mode menu (like tabs)
	 */
	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		// Items to add to the Ingredients tab in creative
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ModItems.UNOBTAINIUM);
			event.accept(ModItems.RAW_UNOBTAINIUM);
		}
		
		// Items to add to the Building Blocks tab in creative
		if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			event.accept(ModBlocks.UNOBTAINIUM_BLOCK);
			event.accept(ModBlocks.RAW_UNOBTAINIUM_BLOCK);
		}
		
		// Items to add to the Natural Blocks tab
		if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			event.accept(ModBlocks.UNOBTAINIUM_ORE);
			event.accept(ModBlocks.UNOBTAINIUM_DEEPSLATE_ORE);
		}
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		// Do something when the server starts
		LOGGER.info("HELLO from server starting");
	}

	// You can use EventBusSubscriber to automatically register all static methods
	// in the class annotated with @SubscribeEvent
	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {

		}
	}
}
