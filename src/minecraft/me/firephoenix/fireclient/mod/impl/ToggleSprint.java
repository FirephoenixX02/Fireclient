package me.firephoenix.fireclient.mod.impl;

import me.firephoenix.fireclient.event.EventTarget;
import me.firephoenix.fireclient.event.impl.EventUpdate;
import me.firephoenix.fireclient.mod.Category;
import me.firephoenix.fireclient.mod.Mod;
import net.minecraft.potion.Potion;

public class ToggleSprint extends Mod{

	public ToggleSprint() {
		super("ToggleSprint", "Toggles Sprint", Category.MISC);
	}
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if(this.isEnabled() && mc.thePlayer.onGround 
				&& !mc.thePlayer.isBlocking() 
				&& !mc.thePlayer.isSneaking() 
				&& (mc.thePlayer.motionZ != 0) 
				&& !mc.thePlayer.isCollidedHorizontally
				&& !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
				&& !mc.thePlayer.isPotionActive(Potion.confusion)
				) {
			mc.thePlayer.setSprinting(true);
		}
		
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		
		mc.thePlayer.setSprinting(false);
	}

}
