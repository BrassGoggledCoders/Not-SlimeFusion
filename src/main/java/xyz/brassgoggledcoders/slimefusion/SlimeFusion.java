package xyz.brassgoggledcoders.slimefusion;

import com.teamacronymcoders.base.BaseModFoundation;
import com.teamacronymcoders.base.featuresystem.FeatureHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Locale;

import static xyz.brassgoggledcoders.slimefusion.SlimeFusion.*;

@Mod(modid = MOD_ID, name = MOD_NAME, version = VERSION, dependencies = DEPENDS)
public class SlimeFusion extends BaseModFoundation<SlimeFusion> {
    public static final String MOD_ID = "slimefusion";
    public static final String MOD_NAME = "SlimeFusion";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDS = "required-after:base@[0.0.0,);";

    @Instance(MOD_ID)
    public static SlimeFusion instance;

    public SlimeFusion() {
        super(MOD_ID, MOD_NAME, VERSION, CreativeTabs.MISC);
        FeatureHandler.requestFeature("MATERIALS", MOD_ID);
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
    public String getConfigFolderName() {
        return this.getID();
    }

    @Override
    public SlimeFusion getInstance() {
        return instance;
    }
}
