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
import net.pixlblade.storange.blocks.SiliconInjector
import net.pixlblade.storange.items.HammerItem
import net.pixlblade.storange.blocks.SiliconShaper
import net.pixlblade.storange.items.StorangeItem
import net.pixlblade.storange.recipes.HammerRecipeSerializer

// Main object for initializing all items.
object Storange : ModInitializer {
    // ItemGroups
    val StorangeGroup: ItemGroup = FabricItemGroupBuilder.build(Identifier("storange", "general")) { ItemStack(Orange) }

    // Items
    val Orange = Item(FabricItemSettings().group(StorangeGroup).food(FoodComponent.Builder().hunger(4).build()))
    val Hammer = HammerItem(FabricItemSettings().group(StorangeGroup).maxDamage(100))
    val Storange = StorangeItem(FabricItemSettings().group(StorangeGroup))
    val IronPlate = ItemReg.make("iron_plate")
    val MiniSiliconWafer = ItemReg.make("mini_silicon_wafer")
    val Processor = ItemReg.make("processor")
    val ProcessorChip = ItemReg.make("processor_chip")
    val SiliconWafer = ItemReg.make("silicon_wafer")
    val Transistor = ItemReg.make("transistor")
    val SiliconPellet = ItemReg.make("silicon_pellet")

    // Blocks
    val MachineBlock = Block(FabricBlockSettings.of(Material.METAL).strength(5.0f))
    val SiliconShape = SiliconShaper(FabricBlockSettings.of(Material.METAL).strength(5.0f))
    val SiliconInjector = SiliconInjector(FabricBlockSettings.of(Material.METAL).strength(5.0f))

    override fun onInitialize() {
        // Items
        Registry.register(Registry.ITEM, ItemReg.makeID("orange"), Orange)
        Registry.register(Registry.ITEM, ItemReg.makeID("hammer"), Hammer)
        Registry.register(Registry.ITEM, ItemReg.makeID("storange"), this.Storange)
        ItemReg.register(IronPlate, MiniSiliconWafer, Processor, ProcessorChip, SiliconWafer, Transistor, SiliconPellet)

        // Blocks
        Registry.register(Registry.BLOCK, ItemReg.makeID("machine_block"), MachineBlock)
        Registry.register(Registry.BLOCK, ItemReg.makeID("silicon_shaper"), SiliconShape)
        Registry.register(Registry.BLOCK, ItemReg.makeID("silicon_injector"), SiliconInjector)

        // BlockItems
        Registry.register(Registry.ITEM, ItemReg.makeID("machine_block"), BlockItem(MachineBlock, FabricItemSettings().group(
            StorangeGroup)))
        Registry.register(Registry.ITEM, ItemReg.makeID("silicon_shaper"), BlockItem(
            SiliconShape, FabricItemSettings().group(StorangeGroup)))

        // Custom Recipes
        Registry.register(Registry.RECIPE_SERIALIZER, ItemReg.makeID("hammer_recipe"), HammerRecipeSerializer())
    }
}
