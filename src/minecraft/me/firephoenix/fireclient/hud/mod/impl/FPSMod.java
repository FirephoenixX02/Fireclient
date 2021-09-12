package me.firephoenix.fireclient.hud.mod.impl;

import me.firephoenix.fireclient.hud.mod.HudMod;

public class FPSMod extends HudMod
{
    public FPSMod()
    {
        super("FPS", 100, 100);
    }

    @Override
    public void draw()
    {
        fr.drawString(mc.getDebugFPS() + " FPS", getX(), getY(), -1);
        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString(mc.getDebugFPS() + " FPS", getX(), getY(), -1);
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
