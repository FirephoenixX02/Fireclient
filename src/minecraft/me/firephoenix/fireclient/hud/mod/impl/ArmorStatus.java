package me.firephoenix.fireclient.hud.mod.impl;

import org.lwjgl.opengl.GL11;

import me.firephoenix.fireclient.hud.mod.HudMod;
import me.firephoenix.fireclient.hud.mod.ScreenPosition;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ArmorStatus extends HudMod
{
    public ArmorStatus()
    {
        super("ArmorStatus", 200, 150);
    }

    private ScreenPosition pos = ScreenPosition.fromRelativePosition(0.5, 0.5);
    private int width = Math.max(this.width, getX() + getWidth());
    private int height = Math.max(this.width, getX() + getHeight());

    @Override
    public int getWidth()
    {
        return 40;
    }

    @Override
    public int getHeight()
    {
        return 60;
    }

    public void draw()
    {
        for (int i = 0; i < mc.thePlayer.inventory.armorInventory.length; i++)
        {
            ItemStack itemStack = mc.thePlayer.inventory.armorInventory[i];
            renderItemStack(pos, i, itemStack);
        }

        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        renderItemStack(pos, 3, new ItemStack(Items.diamond_helmet));
        renderItemStack(pos, 2, new ItemStack(Items.diamond_chestplate));
        renderItemStack(pos, 1, new ItemStack(Items.diamond_leggings));
        renderItemStack(pos, 0, new ItemStack(Items.diamond_boots));
        super.renderDummy(mouseX, mouseY);
    }

    public void renderItemStack(ScreenPosition pos, int i, ItemStack is)
    {
        if (is == null)
        {
            return;
        }

        GL11.glPushMatrix();
        int yAdd = (-16 * i) + 48;

        if (is.getItem().isDamageable())
        {
            double damage = ((is.getMaxDamage() - is.getItemDamage()) / (double) is.getMaxDamage()) * 100;
            fr.drawString(String.format("%.2f%%", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, -1);
        }

        RenderHelper.enableGUIStandardItemLighting();
        mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
        GL11.glPopMatrix();
    }

    private void save(ScreenPosition pos)
    {
        this.pos = pos;
    }

    private ScreenPosition load(ScreenPosition pos)
    {
        return pos;
    }
}
