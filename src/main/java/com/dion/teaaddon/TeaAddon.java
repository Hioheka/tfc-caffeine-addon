package com.dion.teaaddon;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Crafting.AnvilRecipe;
import com.bioxx.tfc.api.Crafting.AnvilReq;
import com.bioxx.tfc.api.Enums.RuleEnum;
import com.dion.teaaddon.blocks.BlockTeaPlant;
import com.dion.teaaddon.items.ItemTeaLeaf;
import com.dion.teaaddon.items.ItemTeaSeed;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = TeaAddon.MODID, name = TeaAddon.MODNAME, version = TeaAddon.VERSION, dependencies = "required-after:terrafirmacraft")
public class TeaAddon {
    public static final String MODID = "teaaddon";
    public static final String MODNAME = "Tea Addon";
    public static final String VERSION = "1.0.0";

    // Items
    public static Item teaSeed;
    public static Item teaLeaf;

    // Blocks
    public static Block teaPlant;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Register blocks
        teaPlant = new BlockTeaPlant();
        GameRegistry.registerBlock(teaPlant, "TeaPlant");

        // Register items
        teaSeed = new ItemTeaSeed(teaPlant);
        GameRegistry.registerItem(teaSeed, "TeaSeed");

        teaLeaf = new ItemTeaLeaf();
        GameRegistry.registerItem(teaLeaf, "TeaLeaf");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // Additional initialization if needed
    }
}
