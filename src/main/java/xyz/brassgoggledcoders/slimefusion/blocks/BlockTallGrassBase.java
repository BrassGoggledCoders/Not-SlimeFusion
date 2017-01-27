package xyz.brassgoggledcoders.slimefusion.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks.GrassColor;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class BlockTallGrassBase extends BlockBase implements IShearable{
    public BlockTallGrassBase(String name) {
        super(Material.VINE, name);
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
        ret.add(new ItemStack(this, 1, getMetaFromState(world.getBlockState(pos))));
        return ret;
    }
}
