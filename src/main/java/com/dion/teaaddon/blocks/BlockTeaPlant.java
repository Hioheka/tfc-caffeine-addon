package com.dion.teaaddon.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.bioxx.tfc.Blocks.BlockCropTFC;
import com.bioxx.tfc.Core.TFC_Climate;
import com.bioxx.tfc.Core.TFC_Time;
import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.Constant.Global;
import com.dion.teaaddon.TeaAddon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTeaPlant extends BlockCropTFC {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockTeaPlant() {
        super();
        this.setBlockName("TeaPlant");
        this.setBlockTextureName(TeaAddon.MODID + ":tea_plant");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister registerer) {
        icons = new IIcon[8];
        for (int i = 0; i < 8; i++) {
            icons[i] = registerer.registerIcon(TeaAddon.MODID + ":blocks/tea_plant_" + i);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta > 7) {
            meta = 7;
        }
        return icons[meta];
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (!world.isRemote) {
            int meta = world.getBlockMetadata(x, y, z);

            // Check if crop can grow
            if (meta < 7) {
                float temp = TFC_Climate.getHeightAdjustedTemp(world, x, y, z);
                float rainfall = TFC_Climate.getRainfall(world, x, y, z);

                // Climate requirements: temp 5-30°C, rainfall 200-500mm
                if (temp >= 5 && temp <= 30 && rainfall >= 200 && rainfall <= 500) {
                    // Grow the crop
                    if (rand.nextInt(20) == 0) {
                        world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
                    }
                }
            }
        }

        world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        if (metadata >= 7) {
            // Fully grown - drop tea leaves
            drops.add(new ItemStack(TeaAddon.teaLeaf, 1 + world.rand.nextInt(2)));

            // Chance to drop seeds
            if (world.rand.nextInt(3) == 0) {
                drops.add(new ItemStack(TeaAddon.teaSeed, 1));
            }
        } else {
            // Not fully grown - only drop seeds sometimes
            if (world.rand.nextInt(2) == 0) {
                drops.add(new ItemStack(TeaAddon.teaSeed, 1));
            }
        }

        return drops;
    }

    @Override
    public Item getItemDropped(int metadata, Random rand, int fortune) {
        return null; // We handle drops in getDrops
    }

    @Override
    public int tickRate(World world) {
        return 200; // Tick every 10 seconds
    }

    @Override
    public Item func_149866_i() {
        return TeaAddon.teaSeed;
    }

    @Override
    public Item func_149865_P() {
        return TeaAddon.teaLeaf;
    }
}
