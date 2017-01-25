package xyz.brassgoggledcoders.slimefusion;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = SlimeFusion.MOD_ID,
        name = SlimeFusion.MOD_NAME,
        version = SlimeFusion.VERSION
)
public class SlimeFusion {

    public static final String MOD_ID = "slimefusion";
    public static final String MOD_NAME = "SlimeFusion";
    public static final String VERSION = "1.0.0-SNAPSHOT";

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
