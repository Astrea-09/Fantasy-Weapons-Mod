package org.noname.fantasy_weapons_mod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.noname.fantasy_weapons_mod.entity.ModEntities;
import org.noname.fantasy_weapons_mod.item.ModItems;

public class DaggerProjectile extends AbstractArrow {
    public DaggerProjectile(EntityType<? extends AbstractArrow> entityType, Level level){
        super(entityType, level);
    }
    public DaggerProjectile(LivingEntity shooter, Level level) {
        super(ModEntities.DAGGER_PROJECTILE.get(), shooter, level, new ItemStack(ModItems.DAGGER.get()), null);
    }
    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.DAGGER.get(), 1);
    }
    //
}
