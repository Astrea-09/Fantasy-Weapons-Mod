package org.noname.fantasy_weapons_mod.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.noname.fantasy_weapons_mod.FantasyWeapons;
import org.noname.fantasy_weapons_mod.entity.custom.DaggerProjectile;

import java.util.function.Supplier;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_REGISTER = DeferredRegister.create(
            BuiltInRegistries.ENTITY_TYPE, FantasyWeapons.MOD_ID);

    public static final Supplier<EntityType<DaggerProjectile>> DAGGER_PROJECTILE =
            ENTITY_REGISTER.register("dagger_projectile", () -> EntityType.Builder.<DaggerProjectile>of(DaggerProjectile::new, MobCategory.MISC)
                    .sized(1.0f, 1.0f).build("dagger_projectile"));
    public static void register(IEventBus bus) {
        ENTITY_REGISTER.register(bus);
    }
}
