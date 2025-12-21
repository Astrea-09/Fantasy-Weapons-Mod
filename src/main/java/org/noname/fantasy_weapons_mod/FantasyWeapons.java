package org.noname.fantasy_weapons_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.noname.fantasy_weapons_mod.entity.ModEntities;
import org.noname.fantasy_weapons_mod.item.ModItems;
import org.noname.fantasy_weapons_mod.item.util.ModItemProperties;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(FantasyWeapons.MOD_ID)
public class FantasyWeapons {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "fantasy_weapons_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public FantasyWeapons(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (FantasyWeapons) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            //daggers
            event.accept(ModItems.IRON_DAGGER);
            event.accept(ModItems.GOLD_DAGGER);
            event.accept(ModItems.DIAMOND_DAGGER);
            event.accept(ModItems.NETHERITE_DAGGER);
            //double-sided axes
            event.accept(ModItems.IRON_DOUBLE_SIDED_AXE);
            event.accept(ModItems.GOLD_DOUBLE_SIDED_AXE);
            event.accept(ModItems.DIAMOND_DOUBLE_SIDED_AXE);
            event.accept(ModItems.NETHERITE_DOUBLE_SIDED_AXE);
            //greatswords
            event.accept(ModItems.IRON_GREATSWORD);
            event.accept(ModItems.GOLD_GREATSWORD);
            event.accept(ModItems.DIAMOND_GREATSWORD);
            event.accept(ModItems.NETHERITE_GREATSWORD);
            //halberds
            event.accept(ModItems.IRON_HALBERD);
            event.accept(ModItems.GOLD_HALBERD);
            event.accept(ModItems.DIAMOND_HALBERD);
            event.accept(ModItems.NETHERITE_HALBERD);
            //sledgehammer
            event.accept(ModItems.SLEDGEHAMMER);
            //longbow
            event.accept(ModItems.LONGBOW);
            //magic staff
            //event.accept(ModItems.MAGIC_STAFF);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();
        }
    }
}
