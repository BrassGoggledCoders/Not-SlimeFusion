package xyz.brassgoggledcoders.slimefusion;

import com.teamacronymcoders.base.BaseModFoundation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SlimeFusion.MOD_ID, name = SlimeFusion.MOD_NAME, version = SlimeFusion.VERSION)
public class SlimeFusion extends BaseModFoundation<SlimeFusion> {
    public static final String MOD_ID = "slimefusion";
    public static final String MOD_NAME = "SlimeFusion";
    public static final String VERSION = "@VERSION@";

    @Instance(MOD_ID)
    public static SlimeFusion instance;

    public SlimeFusion() {
        super(MOD_ID, MOD_NAME, VERSION, CreativeTabs.MISC);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public SlimeFusion getInstance() {
        return instance;
    }
}
