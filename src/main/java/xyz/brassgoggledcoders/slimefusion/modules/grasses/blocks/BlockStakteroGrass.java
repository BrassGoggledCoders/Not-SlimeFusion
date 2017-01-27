package xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks;

import com.teamacronymcoders.base.blocks.IHasBlockStateMapper;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import xyz.brassgoggledcoders.slimefusion.blocks.BlockGrassBase;

import javax.annotation.Nonnull;

public class BlockStakteroGrass extends BlockGrassBase implements IHasBlockStateMapper, IGrowable {
    public BlockStakteroGrass() {
        super("staktero_grass");
    }

    @Override
    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, GrassColor.PROPERTY, DirtType.PROPERTY);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return super.getMetaFromState(state) + state.getValue(GrassColor.PROPERTY).ordinal();
    }

    @Override
    @Nonnull
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int metaData) {
        IBlockState blockState = super.getStateFromMeta(metaData);
        blockState = blockState.withProperty(GrassColor.PROPERTY, GrassColor.values()[metaData % 4]);
        return blockState;
    }

    @Override
    public String getVariant(IBlockState blockState) {
        String variantName;

        DirtType dirtType = blockState.getValue(DirtType.PROPERTY);
        switch (dirtType) {
            case GRASS:
                variantName = "grass_color=" + blockState.getValue(GrassColor.PROPERTY).getName();
                break;
            default:
                variantName = "dirt_type=" + dirtType.getName();
        }

        return variantName;
    }
}
