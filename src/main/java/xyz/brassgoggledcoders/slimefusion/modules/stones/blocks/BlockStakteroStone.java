package xyz.brassgoggledcoders.slimefusion.modules.stones.blocks;

import net.minecraft.block.material.Material;
import xyz.brassgoggledcoders.slimefusion.blocks.BlockEnumPropertyBase;

public class BlockStakteroStone extends BlockEnumPropertyBase<StoneType> {
    public BlockStakteroStone() {
        super(Material.ROCK,  "staktero_stone", StoneType.PROPERTY);
    }
}
