package xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;
import java.util.Locale;

public enum DirtType implements IStringSerializable {
    DIRT, TILLED, GRASS, SNOWY;

    public static final PropertyEnum<DirtType> PROPERTY = PropertyEnum.create("dirt_type", DirtType.class);

    @Nonnull
    public String getName() {
        return this.name().toLowerCase(Locale.US);
    }
}
