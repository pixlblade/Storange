package net.pixlblade.storange.recipes

import com.google.gson.JsonObject
import net.minecraft.network.PacketByteBuf
import net.minecraft.recipe.ShapelessRecipe
import net.minecraft.util.Identifier

class HammerRecipeSerializer : ShapelessRecipe.Serializer() {
    override fun read(identifier: Identifier?, jsonObject: JsonObject?): ShapelessRecipe {
        return HammerRecipe(super.read(identifier, jsonObject))
    }

    override fun read(identifier: Identifier?, packetByteBuf: PacketByteBuf?): ShapelessRecipe {
        return HammerRecipe(super.read(identifier, packetByteBuf))
    }
}