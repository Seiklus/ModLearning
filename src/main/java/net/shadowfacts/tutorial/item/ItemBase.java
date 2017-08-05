package net.shadowfacts.tutorial.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.shadowfacts.tutorial.TutorialMod;

/*    Our ItemBase class will make it simpler to add basic items quickly.
      ItemBase primarily has a convenience constructor that sets both the unlocalized and the registry names. */
public class ItemBase extends Item{
        protected String name;

        public ItemBase(String name) {
            this.name = name;
            setUnlocalizedName(name);
            //The unlocalized name is used for translating the name of the item into the currently active language.
            setRegistryName(name);
            //The registry name is used when registering our item with Forge and should never, ever change.
        }

        public void registerItemModel() {
            TutorialMod.proxy.registerItemRenderer(this, 0, name);
        }

/*      The setCreativeTab method is an overridden version that returns ItemBase instead of Item
        so we can use it in our register method without casting, as you’ll see later. */
        @Override
        public ItemBase setCreativeTab(CreativeTabs tab) {
            super.setCreativeTab(tab);
            return this;

        }
    }

