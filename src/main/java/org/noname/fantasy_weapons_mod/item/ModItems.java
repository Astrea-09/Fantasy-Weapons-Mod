package org.noname.fantasy_weapons_mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.noname.fantasy_weapons_mod.FantasyWeapons;
import org.noname.fantasy_weapons_mod.item.custom.*;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FantasyWeapons.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    //daggers
    public static final DeferredItem<Item> IRON_DAGGER = ITEMS.register("iron_dagger", () -> new Dagger(Tiers.IRON,
            new Item.Properties().attributes(Dagger.createAttributes(Tiers.IRON, -1.5))));

    public static final DeferredItem<Item> GOLD_DAGGER = ITEMS.register("gold_dagger", () -> new Dagger(Tiers.GOLD,
            new Item.Properties().attributes(Dagger.createAttributes(Tiers.GOLD, -1.5))));

    public static final DeferredItem<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger", () -> new Dagger(Tiers.DIAMOND,
            new Item.Properties().attributes(Dagger.createAttributes(Tiers.DIAMOND, -1.5))));

    public static final DeferredItem<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger", () -> new Dagger(Tiers.NETHERITE,
            new Item.Properties().attributes(Dagger.createAttributes(Tiers.NETHERITE, -1.5))));

    //double-sided axes
    public static final DeferredItem<Item> IRON_DOUBLE_SIDED_AXE = ITEMS.register("iron_double_sided_axe", () -> new DoubleSidedAxe(Tiers.IRON,
            new Item.Properties().attributes(DoubleSidedAxe.createAttributes(Tiers.IRON, -3.5))));

    public static final DeferredItem<Item> GOLD_DOUBLE_SIDED_AXE = ITEMS.register("gold_double_sided_axe", () -> new DoubleSidedAxe(Tiers.GOLD,
            new Item.Properties().attributes(DoubleSidedAxe.createAttributes(Tiers.GOLD, -3.5))));

    public static final DeferredItem<Item> DIAMOND_DOUBLE_SIDED_AXE = ITEMS.register("diamond_double_sided_axe", () -> new DoubleSidedAxe(Tiers.DIAMOND,
            new Item.Properties().attributes(DoubleSidedAxe.createAttributes(Tiers.DIAMOND, -3.5))));

    public static final DeferredItem<Item> NETHERITE_DOUBLE_SIDED_AXE = ITEMS.register("netherite_double_sided_axe", () -> new DoubleSidedAxe(Tiers.NETHERITE,
            new Item.Properties().attributes(DoubleSidedAxe.createAttributes(Tiers.NETHERITE, -3.5))));

    //greatswords
    public static final DeferredItem<Item> IRON_GREATSWORD = ITEMS.register("iron_greatsword", () -> new Greatsword(Tiers.IRON,
            new Item.Properties().attributes(Greatsword.createAttributes(Tiers.IRON, -3.25))));

    public static final DeferredItem<Item> GOLD_GREATSWORD = ITEMS.register("gold_greatsword", () -> new Greatsword(Tiers.GOLD,
            new Item.Properties().attributes(Greatsword.createAttributes(Tiers.GOLD, -3.25))));

    public static final DeferredItem<Item> DIAMOND_GREATSWORD = ITEMS.register("diamond_greatsword", () -> new Greatsword(Tiers.DIAMOND,
            new Item.Properties().attributes(Greatsword.createAttributes(Tiers.DIAMOND, -3.25))));

    public static final DeferredItem<Item> NETHERITE_GREATSWORD = ITEMS.register("netherite_greatsword", () -> new Greatsword(Tiers.NETHERITE,
            new Item.Properties().attributes(Greatsword.createAttributes(Tiers.NETHERITE, -3.25))));

    //halberds
    public static final DeferredItem<Item> IRON_HALBERD = ITEMS.register("iron_halberd", () -> new Halberd(Tiers.IRON,
            new Item.Properties().attributes(Halberd.createAttributes(Tiers.IRON, -2.0))));

    public static final DeferredItem<Item> GOLD_HALBERD = ITEMS.register("gold_halberd", () -> new Halberd(Tiers.GOLD,
            new Item.Properties().attributes(Halberd.createAttributes(Tiers.GOLD, -2.0))));

    public static final DeferredItem<Item> DIAMOND_HALBERD = ITEMS.register("diamond_halberd", () -> new Halberd(Tiers.DIAMOND,
            new Item.Properties().attributes(Halberd.createAttributes(Tiers.DIAMOND, -2.0))));

    public static final DeferredItem<Item> NETHERITE_HALBERD = ITEMS.register("netherite_halberd", () -> new Halberd(Tiers.NETHERITE,
            new Item.Properties().attributes(Halberd.createAttributes(Tiers.NETHERITE, -2.0))));

    //sledgehammer
    public static final DeferredItem<Item> SLEDGEHAMMER = ITEMS.register("sledgehammer", () -> new Sledgehammer(Tiers.IRON,
            new Item.Properties().attributes(Sledgehammer.createAttributes(Tiers.IRON, -3.5))));

    //longbow
    public static final DeferredItem<Item> LONGBOW = ITEMS.register("longbow", () -> new Longbow(new Item.Properties()));

    //magic staff
    public static final DeferredItem<Item> MAGIC_STAFF = ITEMS.register("magic staff", () -> new MagicStaff(/*new Item.Properties()*/));
}

