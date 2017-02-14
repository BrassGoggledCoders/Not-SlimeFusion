package xyz.brassgoggledcoders.slimefusion.modules.metals;

import com.teamacronymcoders.base.materialsystem.MaterialPart;
import com.teamacronymcoders.base.materialsystem.MaterialsSystem;
import com.teamacronymcoders.base.materialsystem.materials.Material;
import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Locale;

import static xyz.brassgoggledcoders.slimefusion.SlimeFusion.MOD_ID;

@Module(MOD_ID)
public class ModuleMetals extends ModuleBase {
    @Override
    public String getName() {
        return "Metals";
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        String[] materialNames = new String[] {"Asimium", "Chrysium", "Copper", "Rose Brass", "Silver", "Steel"};
        String[] partNames = new String[] {"bolt", "gear", "ingot", "nugget", "plate"};
        for (String materialName : materialNames) {
            Material material = new Material(materialName);
            material.registerPartsFor(partNames);

            for (String partName : partNames) {
                ResourceLocation resourceLocation = new ResourceLocation(materialName, partName);
                MaterialPart materialPart = MaterialsSystem.MATERIAL_PARTS.getValue(resourceLocation);
                materialPart.setColorize(false);
                materialPart.setTextureLocation(new ResourceLocation(MOD_ID, partName + "_" +
                        materialName.toLowerCase(Locale.US).replace(" ", "")));

            }
        }
    }
}
