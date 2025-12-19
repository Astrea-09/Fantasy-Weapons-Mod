package org.noname.fantasy_weapons_mod.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;
import java.util.function.Predicate;

public class ProximityDetection {

    /**
     * Gets nearby entities to entity
     *
     * @param entity The center entity
     * @param distance The distance to search
     * @param filter A predicate
     * @return A list of nearby Entities
     */
    public static List<Entity> nearbyEntities(Entity entity, double distance, Predicate<Entity> filter) {
        return entity.level().getEntitiesOfClass(Entity.class, entity.getBoundingBox().inflate(distance), filter);
    }

    /**
     * Gets nearby LivingEntities to entity
     *
     * @param entity The center entity
     * @param distance The distance to search
     * @param filter A predicate
     * @return A list of nearby LivingEntities
     */
    public static List<LivingEntity> nearbyLivingEntities(Entity entity, double distance, Predicate<LivingEntity> filter) {
        return entity.level().getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(distance), filter);
    }
}
