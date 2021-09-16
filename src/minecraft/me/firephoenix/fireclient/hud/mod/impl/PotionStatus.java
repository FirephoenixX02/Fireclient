package me.firephoenix.fireclient.hud.mod.impl;

import java.util.Collection;

import me.firephoenix.fireclient.Fireclient;
import me.firephoenix.fireclient.hud.mod.HudMod;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PotionStatus extends HudMod
{
    public PotionStatus()
    {
        super("PotionStatus", 100, 100);
    }

    @Override
    public void draw()
    {
    	int i = getX();
        int j = getY();
        Collection<PotionEffect> collection = mc.thePlayer.getActivePotionEffects();

        if (!collection.isEmpty()) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableLighting();
            int l = 33;

            if (collection.size() > 5) {
                l = 132 / (collection.size() - 1);
            }

            for (PotionEffect potioneffect : mc.thePlayer.getActivePotionEffects()) {
                Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(InventoryEffectRenderer.inventoryBackground);

                if (potion.hasStatusIcon()) {
                    int i1 = potion.getStatusIconIndex();
                    Fireclient.INSTANCE.mc.ingameGUI.drawTexturedModalRect(i + 6, j + 7, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
                }

                String s1 = I18n.format(potion.getName(), new Object[0]);

                if (potioneffect.getAmplifier() == 1) {
                    s1 = s1 + " " + I18n.format("enchantment.level.2", new Object[0]);
                } else if (potioneffect.getAmplifier() == 2) {
                    s1 = s1 + " " + I18n.format("enchantment.level.3", new Object[0]);
                } else if (potioneffect.getAmplifier() == 3) {
                    s1 = s1 + " " + I18n.format("enchantment.level.4", new Object[0]);
                }

                mc.fontRendererObj.drawStringWithShadow(s1, (float) (i + 10 + 18), (float) (j + 6), 16777215);
                String s = Potion.getDurationString(potioneffect);
                mc.fontRendererObj.drawStringWithShadow(s, (float) (i + 10 + 18), (float) (j + 6 + 10), 8355711);
                j += l;
            }
        }
        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("Potion Status", getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }

    @Override
    public int getWidth()
    {
        return fr.getStringWidth("[" + mc.getDebugFPS() + " FPS]");
    }

    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
