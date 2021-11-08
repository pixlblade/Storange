package net.pixlblade.storange

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.*
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// Main object for initializing all items.
object Storange : ModInitializer {
    // ItemGroups
    val StorangeGroup: ItemGroup = FabricItemGroupBuilder.build(Identifier("storange", "general")) { ItemStack(Orange) }

    // Items
    val Orange = Item(FabricItemSettings().group(StorangeGroup).food(FoodComponent.Builder().hunger(4).build()))
    val Hammer = ItemReg.make("hammer")
    val IronPlate = ItemReg.make("iron_plate")
    val MiniSiliconWafer = ItemReg.make("mini_silicon_wafer")
    val Processor = ItemReg.make("processor")
    val ProcessorChip = ItemReg.make("processor_chip")
    val SiliconWafer = ItemReg.make("silicon_wafer")
    val Transistor = ItemReg.make("transistor")

    // Blocks
    val MachineBlock = Block(FabricBlockSettings.of(Material.METAL).strength(5.0f))

    override fun onInitialize() {
        // Items
        Registry.register(Registry.ITEM, Identifier("storange", "orange"), Orange)
        ItemReg.register(Hammer, IronPlate, MiniSiliconWafer, Processor, ProcessorChip, SiliconWafer, Transistor)

        // Blocks
        Registry.register(Registry.BLOCK, Identifier("storange", "machine_block"), MachineBlock)

        // BlockItems
        Registry.register(Registry.ITEM, Identifier("storange", "machine_block"), BlockItem(MachineBlock, FabricItemSettings().group(
            StorangeGroup)))
    }
}
