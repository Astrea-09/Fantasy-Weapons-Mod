package org.noname.fantasy_weapons_mod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.noname.fantasy_weapons_mod.FantasyWeapons;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FantasyWeapons.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static DeferredItem<Item> registerItem(String internalName) {
        return ITEMS.register(internalName, ()-> new Item(new Item.Properties()));
    }
}
