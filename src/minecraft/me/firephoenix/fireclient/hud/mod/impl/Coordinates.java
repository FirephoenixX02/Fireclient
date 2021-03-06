package me.firephoenix.fireclient.hud.mod.impl;

import me.firephoenix.fireclient.hud.mod.HudMod;

public class Coordinates extends HudMod
{
    public Coordinates()
    {
        super("Cords", 140, 120);
    }

    @Override
    public void draw()
    {
        fr.drawString("X:" + " " + Math.round(mc.thePlayer.posX), getX(), getY(), -1);
        fr.drawString("Y:" + " " + Math.round(mc.thePlayer.posY), getX(), getY() + 10, -1);
        fr.drawString("Z:" + " " + Math.round(mc.thePlayer.posZ), getX(), getY() + 20, -1);
        //fr.drawString("XYZ:" + " " + Math.round(mc.thePlayer.posX) + " " + "/" + " " + Math.round(mc.thePlayer.posY) + " " + "/" + " " + Math.round(mc.thePlayer.posZ), getX(), getY() , -1);
        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("X:" + " " + Math.round(mc.thePlayer.posX), getX(), getY(), -1);
        fr.drawString("Y:" + " " + Math.round(mc.thePlayer.posY), getX(), getY() + 10, -1);
        fr.drawString("Z:" + " " + Math.round(mc.thePlayer.posZ), getX(), getY() + 20, -1);
        //fr.drawString("XYZ:" + " " + Math.round(mc.thePlayer.posX) + " " + "/" + " " + Math.round(mc.thePlayer.posY) + " " + "/" + " " + Math.round(mc.thePlayer.posZ), getX(), getY() , -1);
        super.renderDummy(mouseX, mouseY);
    }

    @Override
    public int getWidth()
    {
        return fr.getStringWidth("X:");
    }

    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
