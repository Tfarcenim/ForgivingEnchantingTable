package tfar.forgivingenchantingtable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;

public class MixinHooks {

	public static final String MODID = "forgivingenchantingtable";

	public static Tag.Identified<Block> unforgiving;
	public static Tag.Identified<Block> forgiving;

	public static boolean canPass(World world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		return state.getCollisionShape(world,pos) != VoxelShapes.fullCube() && !unforgiving.contains(state.getBlock()) || forgiving.contains(state.getBlock());
	}
}
