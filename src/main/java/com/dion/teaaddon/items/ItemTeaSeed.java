package com.dion.teaaddon.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Enums.EnumFoodGroup;
import com.bioxx.tfc.api.Food;
import com.bioxx.tfc.api.Interfaces.IFood;
import com.dion.teaaddon.TeaAddon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTeaSeed extends ItemTerra implements IFood {
    private Block cropBlock;

    public ItemTeaSeed(Block crop) {
        super();
        this.cropBlock = crop;
        this.setUnlocalizedName("TeaSeed");
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setFolder("teaaddon/");
    }

    public Block getCropBlock() {
        return this.cropBlock;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registerer) {
        this.itemIcon = registerer.registerIcon(TeaAddon.MODID + ":items/tea_seeds");
    }

    @Override
    public int getFoodID() {
        return 0;
    }

    @Override
    public int getFoodMaxWeight(ItemStack food) {
        return 160;
    }

    @Override
    public boolean isEdible() {
        return false;
    }

    @Override
    public boolean isUsable() {
        return true;
    }

    @Override
    public EnumFoodGroup getFoodGroup() {
        return EnumFoodGroup.Grain;
    }
}
