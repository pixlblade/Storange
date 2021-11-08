package net.pixlblade.storange

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// Object for easily registering items
object ItemReg {
    private val ItemList = mutableListOf<String>()
    private val namespace = "storange"
    fun make(name: String): Item {
        ItemList.add(name)
        return Item(FabricItemSettings().group(Storange.StorangeGroup))
    }
    fun register(vararg items: Item) {
        var i = 0
        for(item in items) {
            Registry.register(Registry.ITEM, Identifier(namespace, ItemList[i]), items[i])
            i++
        }
    }
}