package net.shadowfacts.tutorial.proxy;

import net.minecraft.item.Item;

public class CommonProxy {

    /* We’ll leave this method empty, because it’s in the common proxy so it can’t access any client-only code,
       but it still needs to be here because TutorialMod.proxy is of type CommonProxy so any client-only methods
       still need to have an empty stub in the CommonProxy. */
    public void registerItemRenderer(Item item, int meta, String id) {
    }
}
