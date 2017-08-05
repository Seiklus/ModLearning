package net.shadowfacts.tutorial.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.shadowfacts.tutorial.TutorialMod;


public class ClientProxy extends CommonProxy {

/* This method calls ModelLoader.setCustomModelResourceLocation which will tell Minecraft which item model to use for our item. */
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(TutorialMod.modId + ":" + id, "inventory"));
    }


}
