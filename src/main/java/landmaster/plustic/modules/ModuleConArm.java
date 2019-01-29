package landmaster.plustic.modules;

import java.util.*;

import c4.conarm.lib.materials.*;
import landmaster.plustic.*;
import landmaster.plustic.config.*;
import landmaster.plustic.traits.*;
import landmaster.plustic.traits.armor.*;
import net.minecraftforge.fml.common.Loader;
import slimeknights.tconstruct.library.*;

import static c4.conarm.common.armor.traits.ArmorTraits.*;

public class ModuleConArm implements IModule {
	@Override
	public void init() {
		if (Config.constructsArmory && Loader.isModLoaded("conarm")) {
			Optional.ofNullable(PlusTiC.materials.get("emerald")).ifPresent(mat -> {
				ArmorMaterials.addArmorTrait(mat, GoodFridayAgreement.goodfridayagreement);
				ArmorMaterials.addArmorTrait(mat, Terrafirma.terrafirma.get(0));
				TinkerRegistry.addMaterialStats(mat,
						new CoreMaterialStats(18, 20),
						new PlatesMaterialStats(1, 9, 2.2f),
						new TrimMaterialStats(13.5f));
			});
			Optional.ofNullable(PlusTiC.materials.get("alumite")).ifPresent(mat -> {
				ArmorMaterials.addArmorTrait(mat, CamDaiBay.camdaibay, ArmorMaterialType.CORE);
				ArmorMaterials.addArmorTrait(mat, DunansTransport.dunanstransport);
				TinkerRegistry.addMaterialStats(mat,
						new CoreMaterialStats(14, 20),
						new PlatesMaterialStats(1, 7, 2.2f),
						new TrimMaterialStats(10f));
			});
			Optional.ofNullable(PlusTiC.materials.get("nickel")).ifPresent(mat -> {
				ArmorMaterials.addArmorTrait(mat, NickOfTime.nickOfTime, magnetic);
				TinkerRegistry.addMaterialStats(mat,
						new CoreMaterialStats(13, 16.5f),
						new PlatesMaterialStats(1, -0.1f, 1),
						new TrimMaterialStats(4.25f));
			});
		}
	}
}
