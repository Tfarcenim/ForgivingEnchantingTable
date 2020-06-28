package tfar.forgivingenchantingtable;

import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagContainer;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Optional;

public class BlockCachingTag extends Tag<Block> {

	public static final String MODID = "forgivingenchantingtable";
	public static final Tag<Block> unforgiving = new BlockCachingTag(new Identifier(MODID,"unforgiving"));
	public static final Tag<Block> forgiving = new BlockCachingTag(new Identifier(MODID,"forgiving"));


	private static int latestVersion;
	private static TagContainer<Block> container = new TagContainer<>(identifier -> Optional.empty(), "", false, "");
		private int version = -1;
		private Tag<Block> delegate;

		public BlockCachingTag(Identifier identifier) {
			super(identifier);
		}

		public boolean contains(Block block) {
			if (this.version != latestVersion) {
				this.delegate = container.getOrCreate(this.getId());
				this.version = latestVersion;
			}

			return this.delegate.contains(block);
		}

		public Collection<Block> values() {
			if (this.version != latestVersion) {
				this.delegate = container.getOrCreate(this.getId());
				this.version = latestVersion;
			}

			return this.delegate.values();
		}

		public Collection<Entry<Block>> entries() {
			if (this.version != latestVersion) {
				this.delegate = container.getOrCreate(this.getId());
				this.version = latestVersion;
			}

			return this.delegate.entries();
		}
	}
