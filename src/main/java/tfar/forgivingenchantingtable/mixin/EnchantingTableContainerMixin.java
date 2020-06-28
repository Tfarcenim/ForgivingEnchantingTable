package tfar.forgivingenchantingtable.mixin;

import net.minecraft.container.EnchantingTableContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantingTableContainer.class)
abstract class EnchantingTableContainerMixin {
	@Redirect(method = "method_17411(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V",
	at = @At(value = "INVOKE",target = "Lnet/minecraft/world/World;isAir(Lnet/minecraft/util/math/BlockPos;)Z"))
	private boolean tweakBlocking(World world, BlockPos pos){
		return world.getBlockState(pos).getCollisionShape(world,pos) != VoxelShapes.fullCube();
	}
}
