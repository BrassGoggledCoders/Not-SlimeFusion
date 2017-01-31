package xyz.brassgoggledcoders.slimefusion.modules.stones.blocks;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;
import java.util.Locale;

public enum StoneType implements IStringSerializable {
    STONE, COBBLESTONE;

    public static final PropertyEnum<StoneType> PROPERTY = PropertyEnum.create("stone_type", StoneType.class);

    @Override
    @Nonnull
    public String getName() {
        return this.name().toLowerCase(Locale.US);
    }
}
