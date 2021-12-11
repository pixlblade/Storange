package net.pixlblade.storange.blocks

import net.minecraft.block.Block
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.ItemScatterer
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World

// Most of everything in this class is getting the silicon shaper to rotate.
class SiliconShaper(settings: Settings) : BlockWithEntity(settings) {
    // directional block stuff
    init {
        defaultState = this.stateManager.defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>?) {
        builder?.add(Properties.HORIZONTAL_FACING)
    }

    override fun getPlacementState(ctx: ItemPlacementContext?): BlockState? {
        return this.defaultState.with(Properties.HORIZONTAL_FACING, ctx?.playerFacing?.opposite)
    }

    // start of actual block entity stuff
    override fun createBlockEntity(pos: BlockPos?, state: BlockState?): BlockEntity? {
        return SiliconShaperEntity(pos!!, state!!)
    }

    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun onUse(
        state: BlockState?,
        world: World?,
        pos: BlockPos?,
        player: PlayerEntity?,
        hand: Hand?,
        hit: BlockHitResult?
    ): ActionResult {
        if(!world?.isClient!!) {
            val screenHandlerFactory = state.createScreenHandlerFactory(world, pos)
            player?.openHandledScreen(screenHandlerFactory)
        }
        return ActionResult.SUCCESS
    }

    override fun onStateReplaced(
        state: BlockState?,
        world: World?,
        pos: BlockPos?,
        newState: BlockState?,
        moved: Boolean
    ) {
        if(state.block != newState.block) {
            val blockEntity = world.getBlockEntity(pos)
            if(blockEntity is SiliconShaperEntity) {
                ItemScatterer.spawn(world, pos, blockEntity)
            }
            super.onStateReplaced(state, world, pos, newState, moved)
        }
    }
}