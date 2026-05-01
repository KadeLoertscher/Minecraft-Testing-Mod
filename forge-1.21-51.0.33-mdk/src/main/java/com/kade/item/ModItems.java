package com.kade.item;

import com.kade.TestingMod;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			TestingMod.MOD_ID);
	
	public static final RegistryObject<Item> UNOBTAINIUM = ITEMS.register("unobtainium",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> RAW_UNOBTAINIUM = ITEMS.register("raw_unobtainium",
			() -> new Item(new Item.Properties()));
	
	
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
