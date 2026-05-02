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
	
	// Creates a register to keep track of all the new blocks
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			TestingMod.MOD_ID);
	
	// Set up block and its properties
	public static final RegistryObject<Block> UNOBTAINIUM_BLOCK = registerBlock("unobtainium_block", 
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(4f) // Mining level
					.requiresCorrectToolForDrops() // NEEDS A LOOT TABLE SO IT KNOWS WHAT TO DROP
					.sound(SoundType.METAL))); // Sounds it uses
	
	// Set up another block
	public static final RegistryObject<Block> RAW_UNOBTAINIUM_BLOCK = registerBlock("raw_unobtainium_block", 
			() -> new Block(BlockBehaviour.Properties.of()
					.strength(3f)
					.requiresCorrectToolForDrops() // NEEDS A LOOT TABLE SO IT KNOWS WHAT TO DROP
					.sound(SoundType.STONE)));
	
	
	/**
	 * Helper method used to register a new kind of block to the BLOCKS registry. Registers the block itself and the item
	 * associated with it.
	 * 
	 * @param <T> The type of block to register. Must be Block or a child of it.
	 * @param name The name identifier for the block to register
	 * @param block The Supplier lambda that defines what block to "get." This should define the block's properties. 
	 * @return Returns the RegistryObject for the given block
	 */
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> ret = BLOCKS.register(name, block);
		registerBlockItem(name, ret);
		return ret;
	}
	
	/**
	 * Helper method used to register a block's item form. Uses the ITEMS registry from ModItems to do so.
	 * 
	 * @param <T> The type of block to register. Must be Block or a child of it.
	 * @param name The name identifier for the block to register.
	 * @param block The block RegistryObject to base the item-to-register off of.
	 */
	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
	
	/**
	 * Registers the BLOCKS registry to the event bus telling Minecraft that these blocks exist.
	 * 
	 * @param eventBus
	 */
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
	
}
