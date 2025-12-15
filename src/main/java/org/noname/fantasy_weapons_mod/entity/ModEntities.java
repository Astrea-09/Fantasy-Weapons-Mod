package org.noname.fantasy_weapons_mod.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.noname.fantasy_weapons_mod.FantasyWeapons;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_REGISTER = DeferredRegister.create(
            BuiltInRegistries.ENTITY_TYPE, FantasyWeapons.MOD_ID);

    public static void register(IEventBus bus) {
        ENTITY_REGISTER.register(bus);
    }
}
