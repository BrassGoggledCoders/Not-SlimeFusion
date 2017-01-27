package xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks;

import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;
import java.util.Locale;

public enum GrassColor implements IStringSerializable {
    GREEN, CYAN, BLUE, PURPLE;

    @Nonnull
    public String getName() {
        return this.name().toLowerCase(Locale.US);
    }
}
