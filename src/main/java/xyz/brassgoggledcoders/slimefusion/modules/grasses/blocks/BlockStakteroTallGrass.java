package xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import xyz.brassgoggledcoders.slimefusion.blocks.BlockBase;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class BlockStakteroTallGrass extends BlockBase implements IShearable {
    public BlockStakteroTallGrass() {
        super(Material.VINE, "staktero_tall_grass");
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

    @Override
    public boolean isReplaceable(IBlockAccess world, @Nonnull BlockPos pos) {
        return true;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockState(pos).getValue(GrassColor.PROPERTY).ordinal()));
        return ret;
    }
}
