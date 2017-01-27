package xyz.brassgoggledcoders.slimefusion.modules.grasses;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registry.BlockRegistry;
import com.teamacronymcoders.base.registry.config.ConfigRegistry;
import xyz.brassgoggledcoders.slimefusion.modules.grasses.blocks.BlockStakteroGrass;

import static xyz.brassgoggledcoders.slimefusion.SlimeFusion.MOD_ID;

@Module(MOD_ID)
public class ModuleGrasses extends ModuleBase {
    @Override
    public String getName() {
        return "Grasses";
    }

    @Override
    public void registerBlocks(ConfigRegistry configRegistry, BlockRegistry blockRegistry) {
        blockRegistry.register(new BlockStakteroGrass());
    }
}
