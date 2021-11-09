package net.pixlblade.storange

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// Object for easily registering items that have no special properties/are crafting items
// I coooould use a class for this but there's only gonna be one instance at init so what's the point lol
object ItemReg {
    private val ItemList = mutableListOf<String>()
    private val namespace = "storange"
    // Create an item instance and add the name to the itemlist
    fun make(name: String): Item {
        ItemList.add(name)
        return Item(FabricItemSettings().group(Storange.StorangeGroup))
    }
    // Register all items created using their names
    fun register(vararg items: Item) {
        var i = 0
        for(item in items) {
            Registry.register(Registry.ITEM, makeID(ItemList[i]), items[i])
            i++
        }
    }
    fun makeID(name: String): Identifier {
        return Identifier(namespace, name)
    }
}