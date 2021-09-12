package me.firephoenix.fireclient.mod;

import java.util.ArrayList;

import me.firephoenix.fireclient.hud.mod.impl.CustomEnchantGlint;
import me.firephoenix.fireclient.mod.impl.*;

public class ModManager
{
    public TestMod testMod;
    public ToggleSprint toggleSprint;

    public ArrayList<Mod> mods;

    public ModManager()
    {
        mods = new ArrayList<>();
        //Misc
        mods.add(testMod = new TestMod());
        mods.add(toggleSprint = new ToggleSprint());
    }
}
