package net.pixlblade.storange.items

import net.minecraft.item.Item

class StorangeItem(settings: Settings) : Item(settings) {
    val itemLimit: Int = 32000
    var itemsStored: Int = 0

}