package xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import xyz.brassgoggledcoders.slimefusion.blocks.BlockTallGrassBase;

import javax.annotation.Nonnull;

public class BlockStakteroTallGrass extends BlockTallGrassBase {
    public BlockStakteroTallGrass() {
        super("staktero_tall_grass");
    }

    @Override
    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, GrassColor.PROPERTY);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(GrassColor.PROPERTY).ordinal();
    }

    @Override
    @Nonnull
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int metadata) {
        return this.getDefaultState().withProperty(GrassColor.PROPERTY, GrassColor.values()[metadata]);
    }
}
