package com.kade.block;

import java.util.function.Supplier;

import com.kade.TestingMod;
import com.kade.item.ModItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			TestingMod.MOD_ID);
	// Set up block and its properties
	public static final RegistryObject<Block> UNOBTAINIUM_BLOCK = registerBlock("unobtainium_block", 
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(4f)
					.requiresCorrectToolForDrops() // NEEDS A LOOT TABLE SO IT KNOWS WHAT TO DROP
					.sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> RAW_UNOBTAINIUM_BLOCK = registerBlock("raw_unobtainium_block", 
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(3f)
					.requiresCorrectToolForDrops() // NEEDS A LOOT TABLE SO IT KNOWS WHAT TO DROP
					.sound(SoundType.STONE)));
	
	
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> ret = BLOCKS.register(name, block);
		registerBlockItem(name, ret);
		return ret;
	}
	
	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
	
}
