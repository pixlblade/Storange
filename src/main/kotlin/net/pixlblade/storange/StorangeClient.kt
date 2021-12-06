package net.pixlblade.storange

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.client.model.FabricModelPredicateProviderRegistry
import net.minecraft.util.Identifier
import net.pixlblade.storange.items.StorangeItem

object StorangeClient : ClientModInitializer {
    override fun onInitializeClient() {
        FabricModelPredicateProviderRegistry.register(Storange.Storange, Identifier("stored")) {itemStack, clientWorld, livingEntity, gamig ->
            val itst = itemStack.item
            return@register if(itst is StorangeItem) (itst.itemsStored.toFloat() / itst.itemLimit.toFloat()) else 0.0f
        }
    }
}