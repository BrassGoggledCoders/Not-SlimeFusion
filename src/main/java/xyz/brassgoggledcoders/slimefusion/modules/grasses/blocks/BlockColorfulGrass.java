package xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks;

import com.teamacronymcoders.base.blocks.IHasBlockStateMapper;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.slimefusion.blocks.BlockBase;
import xyz.brassgoggledcoders.slimefusion.blocks.BlockGrassBase;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockColorfulGrass extends BlockGrassBase implements IHasBlockStateMapper, IGrowable {
    public final static PropertyEnum<GrassColor> GRASS_COLOR = PropertyEnum.create("grass_color", GrassColor.class);

    public BlockColorfulGrass() {
        super("staktero_grass");
    }

    @Override
    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, GRASS_COLOR, DIRT_TYPE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return super.getMetaFromState(state) + state.getValue(GRASS_COLOR).ordinal();
    }

    @Override
    @Nonnull
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int metaData) {
        IBlockState blockState = super.getStateFromMeta(metaData);
        blockState = blockState.withProperty(GRASS_COLOR, GrassColor.values()[metaData % 4]);
        return blockState;
    }

    @Override
    public String getVariant(IBlockState blockState) {
        String variantName;

        DirtType dirtType = blockState.getValue(DIRT_TYPE);
        switch(dirtType) {
            case GRASS:
                variantName = "grass_color=" + blockState.getValue(GRASS_COLOR).getName();
                break;
            default:
                variantName = "dirt_type=" + dirtType.getName();
        }

        return variantName;
    }
}
