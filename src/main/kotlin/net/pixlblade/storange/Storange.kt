package net.pixlblade.storange

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// For support join https://discord.gg/v6v4pMv

object Storange : ModInitializer {
    val Orange = Item(FabricItemSettings().group(ItemGroup.FOOD))
    val MachineBlock = Block(FabricBlockSettings.of(Material.METAL).strength(5.0f))
    override fun onInitialize() {
        // Items
        Registry.register(Registry.ITEM, Identifier("storange", "orange"), Orange)

        // Blocks
        Registry.register(Registry.BLOCK, Identifier("storange", "machine_block"), MachineBlock)

        // BlockItems
        Registry.register(Registry.ITEM, Identifier("storange", "machine_block"), BlockItem(MachineBlock, FabricItemSettings().group(
            ItemGroup.REDSTONE)))
    }
}
