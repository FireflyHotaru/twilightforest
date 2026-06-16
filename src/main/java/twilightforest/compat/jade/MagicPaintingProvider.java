package twilightforest.compat.jade;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.JadeIds;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;
import twilightforest.entity.MagicPainting;
import twilightforest.entity.MagicPaintingVariant;

public enum MagicPaintingProvider implements IEntityComponentProvider {
	INSTANCE;

	@Override
	public void appendTooltip(ITooltip tooltip, EntityAccessor accessor, IPluginConfig config) {
		MagicPainting magicPainting = (MagicPainting) accessor.getEntity();
		var variantHolder = magicPainting.getVariant();
		MagicPaintingVariant variant = variantHolder.value();
		ResourceKey<MagicPaintingVariant> variantKey = variantHolder.unwrapKey().orElse(null);
		if (variantKey == null) return;
		ResourceLocation id = variantKey.location();
		tooltip.add(IThemeHelper.get().warning(Component.translatable(id.toLanguageKey("magic_painting", "title"))));
		tooltip.add(variant.author());
	}

	@Override
	public ResourceLocation getUid() {
		return JadeIds.MC_PAINTING;
	}
}