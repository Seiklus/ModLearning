package src.main.java.net.seiklus;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import src.main.java.net.seiklus.proxy.CommonProxy;

/* @Mod tells forge that this is a mod and should be treated as such.
 *
 *      modid sets the mods identification name in forge, usually as a STRING
 *
 *      name is the mods name in forge as a STRING
 *
 *      version is the mods version as a STRING (for starting, I am using 1.0.0 but can be whatever you want)
 *
 *      dependencies tells forge what mods this mod needs in order to run. forge will not launch the game otherwise.
 *      displays as a STRING
 *
 *      useMetadata determines whether forge should use the mcmod.info file instead to override the other settings
 *      displays as a BOOLEAN */
@Mod(
    modid = TarotCard.MODID,
    name = TarotCard.MODNAME,
    version = TarotCard.MODVERSION,
    dependencies = "required-after:Forge@[11.16.0.1865,)",
    useMetadata = true)

public class TarotCard {

// STRINGs to refer to the modid, name, and version in @Mod
    public static final String MODID = "tarot";
    public static final String MODNAME = "Tarot Cards";
    public static final String MODVERSION = "1.0.0";


    @SidedProxy(clientSide = "mcjty.modtut.proxy.ClientProxy", serverSide = "mcjty.modtut.proxy.ServerProxy")
    public static CommonProxy proxy;



    @Mod.Instance //This creates the mod instance by telling Forge it should run the ModTut class.
    public static TarotCard instance;
    //this sets up the logger
    public static Logger logger;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        if (Config.logAll == true) { //hook for allowing mod to log all information
             logger = event.getModLog();
        }
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }


}
