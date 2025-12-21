package org.noname.fantasy_weapons_mod.item.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.noname.fantasy_weapons_mod.item.ModItems;

public class ModItemProperties {

    public static void addCustomItemProperties() {
        addBowProperties(ModItems.LONGBOW.get());
    }

    private static void addBowProperties(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"),
                (itemStack, level, livingEntity, i) -> {
                    if(livingEntity == null) {
                        return 0.0f;
                    } else {
                        return livingEntity.getUseItem() != itemStack ? 0.0f : (float)(itemStack.getUseDuration(livingEntity)
                                - livingEntity.getUseItemRemainingTicks()) / 30.0f; // Charge time
                    }
                });

        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pulling"),
                (itemStack, level, livingEntity, i) -> livingEntity != null
                        && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0f : 0.0f);
    }
}
