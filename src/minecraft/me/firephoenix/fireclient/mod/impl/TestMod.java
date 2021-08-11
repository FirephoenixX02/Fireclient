package me.firephoenix.fireclient.mod.impl;

import me.firephoenix.fireclient.mod.Category;
import me.firephoenix.fireclient.mod.Mod;

public class TestMod extends Mod{

	public TestMod() {
		super("TestMod", "Test Desc", Category.MISC);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		System.out.println("THIS MOD IS NOW ENABLED");
	}
	

}
