package org.noname.fantasy_weapons_mod.event;

import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import org.noname.fantasy_weapons_mod.FantasyWeapons;
import org.noname.fantasy_weapons_mod.item.ModItems;

@EventBusSubscriber(modid = FantasyWeapons.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void computeFovModifierEvent(ComputeFovModifierEvent event) {
        Item item = event.getPlayer().getUseItem().getItem();

        if(event.getPlayer().isUsingItem() && item == ModItems.LONGBOW.get()) {
            float fovModifier = 1f;
            int ticksUsingItem = event.getPlayer().getTicksUsingItem();

            float deltaTicks = (float)ticksUsingItem / 30f; // Charge time

            if(deltaTicks > 1f) {
                deltaTicks = 1f;
            } else {
                deltaTicks *= deltaTicks;
            }

            fovModifier *= 1f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }
    }
}
