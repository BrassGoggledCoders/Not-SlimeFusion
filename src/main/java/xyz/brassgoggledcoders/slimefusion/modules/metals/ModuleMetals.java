package xyz.brassgoggledcoders.slimefusion.modules.metals;

import com.teamacronymcoders.base.materialsystem.MaterialsSystem;
import com.teamacronymcoders.base.materialsystem.materials.Material;
import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import java.awt.*;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static xyz.brassgoggledcoders.slimefusion.SlimeFusion.MOD_ID;

@Module(MOD_ID)
public class ModuleMetals extends ModuleBase {
    @Override
    public String getName() {
        return "Metals";
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        Material materialSilver = new Material("Silver", Color.GRAY, false);
        materialSilver.registerPartsFor("bolt", "gear", "ingot", "nugget", "plate");

        Material materialAsimium = new Material("Asimium", Color.BLUE, false);
        materialAsimium.registerPartsFor("bolt", "gear", "ingot", "nugget", "plate");

        MaterialsSystem.MATERIAL_PARTS.getValue(new ResourceLocation("asimium", "bolt"))
                .setTextureLocation(new ResourceLocation("slimefusion", "bolt_asimium"));

    }
}
