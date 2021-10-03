package me.firephoenix.fireclient.util.config;

import java.io.File;
import java.io.IOException;

import me.firephoenix.fireclient.Fireclient;
import me.firephoenix.fireclient.hud.mod.HudMod;
import me.firephoenix.fireclient.util.config.*;

public class Config
{
    public File configFolder = new File("Fireclient");
    public File modsFolder = new File("Fireclient/mods");
    public File configFile = new File("Fireclient/mods/modconfiguration.json");

    public Configuration config, configToSave = ConfigurationAPI.newConfiguration(new File("Fireclient/mods/modconfiguration.json"));

    public void makeFolders()
    {
        if (!configFolder.exists())
        {
            configFolder.mkdirs();
        }

        if (!modsFolder.exists())
        {
            modsFolder.mkdirs();
        }

        if (!configFile.exists())
        {
            try
            {
                configToSave.save();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void saveModConfig()
    {
        if (!configFolder.exists())
        {
            configFolder.mkdirs();
        }

        if (!modsFolder.exists())
        {
            modsFolder.mkdirs();
        }

        System.out.println("Saving Mod Config");

        for (HudMod m : Fireclient.INSTANCE.hudManager.hudMods)
        {
            configToSave.set(m.name + "_x", m.getX());
            configToSave.set(m.name + "_y", m.getY());
            configToSave.set(m.name + "_enabled", m.isEnabled());
        }

        try
        {
            configToSave.save();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadModConfig()
    {
        System.out.println("Loading Mod Config");
        config = ConfigurationAPI.loadExistingConfiguration(new File("Fireclient/mods/modconfiguration.json"));
        System.out.println(config);
    }
}
