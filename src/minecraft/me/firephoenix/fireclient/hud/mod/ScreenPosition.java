package me.firephoenix.fireclient.hud.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ScreenPosition
{
    private static final Minecraft mc = Minecraft.getMinecraft();

    private double x, y;

    public ScreenPosition(double x, double y)
    {
        setRelative(x, y);
    }

    public ScreenPosition(int x, int y)
    {
        setAbsolute(x, y);
    }

    public static ScreenPosition fromRelativePosition(double x, double y)
    {
        return new ScreenPosition(x, y);
    }

    public static ScreenPosition fromAbsolutePosition(double x, double y)
    {
        return new ScreenPosition(x, y);
    }

    public int getAbsoluteX()
    {
        ScaledResolution res = new ScaledResolution(mc);
        return (int)(x * res.getScaledWidth());
    }

    public int getAbsoluteY()
    {
        ScaledResolution res = new ScaledResolution(mc);
        return (int)(y * res.getScaledHeight());
    }

    public double getRelativeX()
    {
        return x;
    }

    public double getRelativeY()
    {
        return y;
    }

    private void setAbsolute(int x2, int y2)
    {
        ScaledResolution res = new ScaledResolution(mc);
        this.x = (double) x / res.getScaledWidth();
        this.y = (double) y / res.getScaledHeight();
    }

    private void setRelative(double x2, double y2)
    {
        this.x = x;
        this.y = y;
    }
}
