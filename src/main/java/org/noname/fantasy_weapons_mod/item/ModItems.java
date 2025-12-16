package org.noname.fantasy_weapons_mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.noname.fantasy_weapons_mod.FantasyWeapons;
import org.noname.fantasy_weapons_mod.item.custom.Dagger;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FantasyWeapons.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static final DeferredItem<Item> DAGGER = ITEMS.register("dagger", () -> new Dagger(Tiers.IRON,
            new Item.Properties().attributes(Dagger.createAttributes(Tiers.IRON, -1.5))));
}
