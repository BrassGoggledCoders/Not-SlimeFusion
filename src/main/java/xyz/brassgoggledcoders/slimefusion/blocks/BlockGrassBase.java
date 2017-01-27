package xyz.brassgoggledcoders.slimefusion.blocks;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks.DirtType;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockGrassBase extends BlockBase implements IGrowable {
    public final static PropertyEnum<DirtType> DIRT_TYPE = PropertyEnum.create("dirt_type", DirtType.class);

    public BlockGrassBase(String name) {
        super(Material.GLASS, name);
    }

    @Override
    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, DIRT_TYPE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (4 * state.getValue(DIRT_TYPE).ordinal());
    }

    @Override
    @Nonnull
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int metaData) {
        IBlockState blockState = getDefaultState();
        blockState = blockState.withProperty(DIRT_TYPE, DirtType.values()[metaData / 4]);
        return blockState;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if (!world.isRemote) {
            if (world.getLightFromNeighbors(pos.up()) < 4 && world.getBlockState(pos.up()).getLightOpacity(world, pos.up()) > 2) {
                world.setBlockState(pos, state.withProperty(DIRT_TYPE, DirtType.DIRT));
            } else {
                if (world.getLightFromNeighbors(pos.up()) >= 9) {
                    for (int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !world.isBlockLoaded(blockpos)) {
                            return;
                        }

                        IBlockState stateUP = world.getBlockState(blockpos.up());
                        IBlockState stateHere = world.getBlockState(blockpos);

                        if (stateHere.getBlock() == this && stateHere.getValue(DIRT_TYPE) == DirtType.DIRT &&
                                world.getLightFromNeighbors(blockpos.up()) >= 4 && stateUP.getLightOpacity(world, pos.up()) <= 2) {
                            world.setBlockState(blockpos, stateHere.withProperty(DIRT_TYPE, DirtType.GRASS));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean canGrow(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(@Nonnull World world, @Nonnull Random rand, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        return true;
    }

    @Override
    public void grow(@Nonnull World world, @Nonnull Random rand, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        BlockPos centerPos = pos.up();
        for (int i = 0; i < 128; ++i) {
            BlockPos plantPos = centerPos;
            int j = 0;

            while (true) {
                if (j >= i / 16) {
                    if (world.isAirBlock(plantPos)) {
                        placePlantAt(plantPos);
                    }

                    break;
                }

                plantPos = plantPos.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3)
                        / 2, rand.nextInt(3) - 1);

                if (isNotGrass(plantPos, world)) {
                    break;
                }

                ++j;
            }
        }
    }

    protected void placePlantAt(BlockPos pos) {

    }

    public boolean isNotGrass(BlockPos pos, World world) {
        boolean belowNotGrass = world.getBlockState(pos.down()).getBlock() != Blocks.GRASS;
        boolean isNormalCube = world.getBlockState(pos).isNormalCube();
        return belowNotGrass || isNormalCube;
    }
}
