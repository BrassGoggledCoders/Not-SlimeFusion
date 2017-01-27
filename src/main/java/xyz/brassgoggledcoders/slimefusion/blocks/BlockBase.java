package xyz.brassgoggledcoders.slimefusion.blocks;

import com.teamacronymcoders.base.IBaseMod;
import com.teamacronymcoders.base.IModAware;
import com.teamacronymcoders.base.blocks.IAmBlock;
import com.teamacronymcoders.base.blocks.IHasItemBlock;
import com.teamacronymcoders.base.client.models.IHasModel;
import com.teamacronymcoders.base.items.IHasSubItems;
import com.teamacronymcoders.base.items.ItemBlockGeneric;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;

public class BlockBase extends Block implements IHasItemBlock, IModAware, IHasSubItems, IAmBlock {
    private IBaseMod mod;
    private boolean creativeTabSet = false;
    private ItemBlock itemBlock;

    public BlockBase(Material mat) {
        super(mat);
        this.setHardness(1F);
    }

    public BlockBase(Material mat, String name) {
        this(mat);
        this.setUnlocalizedName(name);
    }

    @Override
    public void breakBlock(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        world.updateComparatorOutputLevel(pos, this);
        super.breakBlock(world, pos, state);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        this.updateState(world, pos, state);
        super.onBlockAdded(world, pos, state);
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighborPos) {
        this.updateState(world, pos, world.getBlockState(neighborPos));
        super.onNeighborChange(world, pos, neighborPos);
    }

    protected void updateState(IBlockAccess world, BlockPos pos, IBlockState state) {

    }

    @Override
    @Nonnull
    public Block setCreativeTab(@Nonnull CreativeTabs tab) {
        if (!creativeTabSet) {
            super.setCreativeTab(tab);
            this.creativeTabSet = true;
        }
        return this;
    }

    public void setItemBlock(ItemBlock itemBlock) {
        this.itemBlock = itemBlock;
    }

    @Override
    public ItemBlock getItemBlock() {
        return itemBlock == null ? new ItemBlock(this) : itemBlock;
    }

    @Override
    public IBaseMod getMod() {
        return mod;
    }

    @Override
    public void setMod(IBaseMod mod) {
        this.mod = mod;
    }

    @Override
    public List<ItemStack> getAllSubItems(List<ItemStack> itemStacks) {
        itemStacks.add(new ItemStack(this, 1));
        return itemStacks;
    }

    @Override
    public Block getBlock() {
        return this;
    }
}
