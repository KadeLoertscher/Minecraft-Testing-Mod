package com.kade.item;

import com.kade.TestingMod;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	
	// This register is how we keep track of all the new items in this mod
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			TestingMod.MOD_ID);
	
	// This adds a new item called "unobtainium" to the items register with default properties
	public static final RegistryObject<Item> UNOBTAINIUM = ITEMS.register("unobtainium",
			() -> new Item(new Item.Properties()));
	
	// Adds another new item to the register
	public static final RegistryObject<Item> RAW_UNOBTAINIUM = ITEMS.register("raw_unobtainium",
			() -> new Item(new Item.Properties()));
	
	
	/**
	 * This registers the item registry to the event bus (basically telling minecraft that this exists)
	 * 
	 * @param eventBus
	 */
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
