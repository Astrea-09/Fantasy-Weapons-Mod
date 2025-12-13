package org.noname.fantasy_weapons_mod.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.noname.fantasy_weapons_mod.FantasyWeapons;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FantasyWeapons.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
