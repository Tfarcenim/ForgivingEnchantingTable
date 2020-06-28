package tfar.forgivingenchantingtable.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.container.EnchantingTableContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import tfar.forgivingenchantingtable.BlockCachingTag;

@Mixin(EnchantingTableBlock.class)
abstract class EnchantingTableBlockMixin {
	@Redirect(method = "randomDisplayTick",
	at = @At(value = "INVOKE",target = "Lnet/minecraft/world/World;isAir(Lnet/minecraft/util/math/BlockPos;)Z"))
	private boolean test(World world, BlockPos pos){
		BlockState state = world.getBlockState(pos);
		return state.getCollisionShape(world,pos) != VoxelShapes.fullCube() && !state.matches(BlockCachingTag.unforgiving) || state.matches(BlockCachingTag.forgiving);
	}
}
