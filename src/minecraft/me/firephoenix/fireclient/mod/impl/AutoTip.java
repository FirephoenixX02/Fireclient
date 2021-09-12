package me.firephoenix.fireclient.mod.impl;

import net.minecraft.client.Minecraft;

public class AutoTip
{
    private Minecraft mc = Minecraft.getMinecraft();
    private static final String MESSAGE = "/tip all";

    public void onEntityJoinWorld()
    {
        if (mc.thePlayer != null)
        {
        }
    }

    public void onServerJoin()
    {
        if ((mc.getCurrentServerData().serverIP.contains("hypixel.net")))
        {
            Minecraft.getMinecraft().thePlayer.sendChatMessage(MESSAGE);
        }
    }
}