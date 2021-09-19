package me.firephoenix.fireclient.hud.mod.impl;

import me.firephoenix.fireclient.hud.mod.HudMod;

public class Direction extends HudMod
{
    public Direction()
    {
        super("Direction", 100, 100);
    }

    @Override
    public void draw()
    {
        fr.drawString("Direction:" + " " + mc.thePlayer.getHorizontalFacing(), getX(), getY(), -1);
        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("Direction:" + "West", getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }

    @Override
    public int getWidth()
    {
        return fr.getStringWidth("Direction:" + "West");
    }

    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
