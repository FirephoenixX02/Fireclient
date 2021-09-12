package me.firephoenix.fireclient.hud.mod.impl;

import java.awt.Color;

import me.firephoenix.fireclient.hud.mod.HudMod;

public class CustomEnchantGlint extends HudMod
{
    public CustomEnchantGlint()
    {
        super("Custom Enchant Glint", 100, 100);
    }

    private Color DEFAULT_COLOR = new Color(128, 64, 204);

    private Color glintColor = new Color(255, 0, 0);

    public Color getColor()
    {
        return glintColor;
    }
}
