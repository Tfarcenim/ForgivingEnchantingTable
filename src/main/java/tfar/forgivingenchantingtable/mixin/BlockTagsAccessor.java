package tfar.forgivingenchantingtable.mixin;

import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import tfar.forgivingenchantingtable.MixinHooks;

import static tfar.forgivingenchantingtable.MixinHooks.MODID;

@Mixin(BlockTags.class)
abstract class BlockTagsAccessor {

	@Shadow
	private static Tag.Identified<Block> register(String id){
		throw new IllegalStateException();
	}
static {
	MixinHooks.forgiving = register(MODID+":forgiving");
	MixinHooks.unforgiving = register(MODID+":unforgiving");
}

}
