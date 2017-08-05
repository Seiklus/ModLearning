package net.shadowfacts.tutorial;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.shadowfacts.tutorial.item.ModItems;
import net.shadowfacts.tutorial.proxy.CommonProxy;


@Mod (modid = TutorialMod.modId, name = TutorialMod.name, version = TutorialMod.version)
public class TutorialMod {

    public static final String modId = "tutorial";
    public static final String name = "My first mod";
    public static final String version = "1.0";

    @Mod.Instance(modId)
    public static TutorialMod instance;

    @Mod.EventHandler //preinit
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println(name + " is Loading");
    }

    @Mod.EventHandler //init
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler //postinit
    public void postInit(FMLPostInitializationEvent event) {

    }

    @SidedProxy(serverSide = "net.shadowfacts.tutorial.proxy.CommonProxy", clientSide = "net.shadowfacts.tutorial.proxy.ClientProxy")
    public static CommonProxy proxy;

    /*The event bus is Forge’s system for allowing mods to register (or subscribe) handler methods to be run
      when specific events happen. Forge provides numerous events for all sorts of things in the game, however
      the ones we’re currently concerned with are the registry events.
      (Registries are Forge’s method of keeping track of all the objects of various types in the game,
      both vanilla Minecraft and modded ones.)
      */
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
        }
        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
        }
    }
}
