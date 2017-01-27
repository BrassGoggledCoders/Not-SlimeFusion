package xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks;

import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;
import java.util.Locale;

public enum DirtType implements IStringSerializable {
    DIRT, TILLED, GRASS, SNOWY;

    @Nonnull
    public String getName() {
        return this.name().toLowerCase(Locale.US);
    }
}
