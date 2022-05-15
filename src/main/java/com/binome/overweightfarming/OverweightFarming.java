package com.binome.overweightfarming;

import com.binome.overweightfarming.events.MiscEvents;
import com.binome.overweightfarming.events.MobEvents;
import com.binome.overweightfarming.init.OFBlocks;
import com.binome.overweightfarming.init.OFItems;
import com.binome.overweightfarming.init.OFParticleTypes;
import com.binome.overweightfarming.init.OFVanillaIntegration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(OverweightFarming.MODID)
public class OverweightFarming {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "overweight_farming";

    public OverweightFarming() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        OFBlocks.BLOCKS.register(modEventBus);
        OFItems.ITEMS.register(modEventBus);
        OFParticleTypes.PARTICLE_TYPES.register(modEventBus);

        IEventBus eventBus = MinecraftForge.EVENT_BUS;
        eventBus.register(this);
        eventBus.register(new MobEvents());
        eventBus.register(new MiscEvents());
    }

    private void setup(final FMLCommonSetupEvent event) {
        OFVanillaIntegration.init();
    }

}
