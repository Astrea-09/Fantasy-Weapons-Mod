package org.noname.fantasy_weapons_mod.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.noname.fantasy_weapons_mod.entity.ModEntities;
import org.noname.fantasy_weapons_mod.item.ModItems;

public class DaggerProjectile extends AbstractArrow {

    public DaggerProjectile(EntityType<? extends AbstractArrow> entityType, Level level){
        super(entityType, level);
    }

    public DaggerProjectile(LivingEntity shooter, Level level) {
        super(ModEntities.DAGGER_PROJECTILE.get(), shooter, level, new ItemStack(ModItems.DAGGER.get()), null);
    }

    public DaggerProjectile(Level level, double x, double y, double z, ItemStack itemStack) {
        super(ModEntities.DAGGER_PROJECTILE.get(), x, y, z, level, itemStack, itemStack);
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return this.getWeaponItem();
    }
}
