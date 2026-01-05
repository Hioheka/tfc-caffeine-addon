package com.dion.teaaddon.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Enums.EnumFoodGroup;
import com.bioxx.tfc.api.Food;
import com.bioxx.tfc.api.Interfaces.IFood;
import com.dion.teaaddon.TeaAddon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTeaLeaf extends ItemTerra implements IFood {

    public ItemTeaLeaf() {
        super();
        this.setUnlocalizedName("TeaLeaf");
        this.setCreativeTab(CreativeTabs.tabFood);
        this.setFolder("teaaddon/");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registerer) {
        this.itemIcon = registerer.registerIcon(TeaAddon.MODID + ":items/tea_leaves");
    }

    @Override
    public int getFoodID() {
        return 1;
    }

    @Override
    public int getFoodMaxWeight(ItemStack food) {
        return 160;
    }

    @Override
    public boolean isEdible() {
        return true;
    }

    @Override
    public boolean isUsable() {
        return true;
    }

    @Override
    public EnumFoodGroup getFoodGroup() {
        return EnumFoodGroup.Vegetable;
    }
}
