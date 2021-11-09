package net.pixlblade.storange.recipes

import net.minecraft.inventory.CraftingInventory
import net.minecraft.item.ItemStack
import net.minecraft.recipe.ShapelessRecipe
import net.minecraft.util.collection.DefaultedList
import net.pixlblade.storange.items.HammerItem

class HammerRecipe(og: ShapelessRecipe) : ShapelessRecipe(og.id, og.group, og.output, og.ingredients) {
    override fun getRemainder(inventory: CraftingInventory?): DefaultedList<ItemStack> {
        val defaultedList = DefaultedList.ofSize(inventory!!.size(), ItemStack.EMPTY)
        for(i in 0..(defaultedList.size - 1)) {
            var stack = inventory.getStack(i)
            val item = stack.item
            if(item is HammerItem) {
                val newdamage = stack.damage + 1
                if(newdamage < stack.maxDamage) {
                    stack = stack.copy()
                    stack.damage = newdamage
                    defaultedList.set(i, stack)
                } else if(item.hasRecipeRemainder()) {
                    defaultedList.set(i, ItemStack(item.recipeRemainder))
                }
            }
        }
        return defaultedList
    }
}