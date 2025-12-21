package org.noname.fantasy_weapons_mod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Longbow extends BowItem {

    public Longbow(Properties settings) {
        super(settings);
    }

    @Override
    public void releaseUsing(@NotNull ItemStack itemStack, @NotNull Level level,
                             @NotNull LivingEntity livingEntity, int time) {
        if (livingEntity instanceof Player player) {
            ItemStack itemstack = player.getProjectile(itemStack);

            if (!itemstack.isEmpty()) {
                int i = this.getUseDuration(itemStack, livingEntity) - time;
                i = net.neoforged.neoforge.event.EventHooks.onArrowLoose(itemStack, level, player, i, !itemstack.isEmpty());

                if (i < 0) return;

                float f = getPowerForTime(i);

                if(!((double)f < 0.1)) {
                    List<ItemStack> list = draw(itemStack, itemstack, player);

                    if (level instanceof ServerLevel serverlevel && !list.isEmpty()) {
                        this.shoot(serverlevel, player, player.getUsedItemHand(), itemStack, list, f * 3.0f, 1.0f, f == 1.0f, null);
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0f, 1.0f /
                                    (level.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    protected void shoot(@NotNull ServerLevel level, @NotNull LivingEntity shooter, @NotNull InteractionHand hand, @NotNull ItemStack weapon,
                         @NotNull List<ItemStack> projectileItems,
                         float velocity, float inaccuracy, boolean isCrit, @Nullable LivingEntity target) {
        super.shoot(level, shooter, hand, weapon, projectileItems, velocity * 1.2f, inaccuracy / 2, isCrit, target);
    }

    public static float getPowerForTime(int charge) {
        float power = (float)charge / 30.0f; // Charge time

        power = (power * power + power * 2.0f) / 3.0f;
        if (power > 1.0f) {
            power = 1.0f;
        }

        return power;
    }
}
