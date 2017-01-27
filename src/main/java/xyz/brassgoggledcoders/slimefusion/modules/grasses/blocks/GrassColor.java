package xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;
import java.util.Locale;

public enum GrassColor implements IStringSerializable {
    GREEN, CYAN, BLUE, PURPLE;

    public static final PropertyEnum<GrassColor> PROPERTY = PropertyEnum.create("grass_color", GrassColor.class);

    @Nonnull
    public String getName() {
        return this.name().toLowerCase(Locale.US);
    }
}
