package tfar.forgivingenchantingtable.mixin;

import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import tfar.forgivingenchantingtable.MixinHooks;

@Mixin(EnchantmentScreenHandler.class)
abstract class EnchantingTableContainerMixin {
	@Redirect(method = "*(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V",
	at = @At(value = "INVOKE",target = "Lnet/minecraft/world/World;isAir(Lnet/minecraft/util/math/BlockPos;)Z"))
	private boolean tweakBlocking(World world, BlockPos pos){
		return MixinHooks.canPass(world,pos);
	}
}
