package xyz.brassgoggledcoders.slimefusion.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class BlockEnumPropertyBase<E extends Enum<E> & IStringSerializable> extends BlockBase {
    private PropertyEnum<E> property;
    private E[] enumValues;

    public BlockEnumPropertyBase(Material mat, String name, PropertyEnum<E> property) {
        super(mat, name);
        this.property = property;
        this.enumValues = property.getValueClass().getEnumConstants();
    }

    @Override
    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, this.property);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(this.property).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int metadata) {
        return this.getDefaultState().withProperty(this.property, this.enumValues[metadata]);
    }
}
