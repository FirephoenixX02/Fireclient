package me.firephoenix.fireclient.util.config;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class ConfigurationAPI {
    public static Configuration loadExistingConfiguration(File file) {
        JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(FileUtils.readFileToString(file, Charsets.UTF_8));
			//System.out.println("Loaded");
			//sSystem.out.println(jsonObject);
			} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new Configuration(file, jsonObject.toMap());
    }

    public static Configuration newConfiguration(File file) {
        return new Configuration(file);
    }
}