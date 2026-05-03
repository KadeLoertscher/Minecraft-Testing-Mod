package com.kade.item;

import com.kade.TestingMod;
import com.kade.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ItemStack;


public class ModCreativeModeTabs {
	
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestingMod.MOD_ID);
	
	public static final RegistryObject<CreativeModeTab> UNOBTAINIUM_ITEMS_TAB = CREATIVE_MODE_TABS.register("unobtainium_items_tab",
			() -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(ModItems.UNOBTAINIUM.get()))
			.title(Component.translatable("creativetab.testingmod.unobtainium_items"))
			.displayItems((itemDisplayParamters, output) -> {
				output.accept(ModItems.UNOBTAINIUM.get());
				output.accept(ModItems.RAW_UNOBTAINIUM.get());
			})
			.build());
	
	public static final RegistryObject<CreativeModeTab> UNOBTAINIUM_BLOCKS_TAB = CREATIVE_MODE_TABS.register("unobtainium_blocks_tab",
			() -> CreativeModeTab.builder()
			.withTabsBefore(UNOBTAINIUM_ITEMS_TAB.getId())
			.icon(() -> new ItemStack(ModBlocks.UNOBTAINIUM_BLOCK.get()))
			.title(Component.translatable("creativetab.testingmod.unobtainium_blocks"))
			.displayItems((itemDisplayParamters, output) -> {
				output.accept(ModBlocks.UNOBTAINIUM_BLOCK.get());
				output.accept(ModBlocks.RAW_UNOBTAINIUM_BLOCK.get());
				output.accept(ModBlocks.UNOBTAINIUM_ORE.get());
				output.accept(ModBlocks.UNOBTAINIUM_DEEPSLATE_ORE.get());
			})
			.build());
	
	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
	
}
