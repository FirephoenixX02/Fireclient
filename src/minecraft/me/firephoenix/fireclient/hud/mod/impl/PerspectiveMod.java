package me.firephoenix.fireclient.hud.mod.impl;

import java.awt.event.KeyEvent;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import me.firephoenix.fireclient.event.EventTarget;
import me.firephoenix.fireclient.event.impl.EventUpdate;
import me.firephoenix.fireclient.hud.mod.HudMod;
import me.firephoenix.fireclient.mod.Category;
import me.firephoenix.fireclient.mod.Mod;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.potion.Potion;

public class PerspectiveMod extends HudMod
{
    private boolean returnOnRelease = true;
    private boolean perspectiveToggled = false;

    private float cameraYaw = 0F;
    private float cameraPitch = 0F;

    private int previousperspective = 0;

    public PerspectiveMod()
    {
        super("PerspectiveMod", 200, 100);
    }

    @EventTarget
    public void onUpdate(KeyEvent e, EventUpdate event)
    {
        if (this.isEnabled() && e.getKeyCode() == mc.gameSettings.PERSPECTIVE_MOD.getKeyCode())
        {
            perspectiveToggled = !perspectiveToggled;
            cameraYaw = mc.thePlayer.rotationYaw;
            cameraPitch = mc.thePlayer.rotationPitch;

            if (perspectiveToggled)
            {
                previousperspective = mc.gameSettings.thirdPersonView;
                mc.gameSettings.thirdPersonView = 1;
            }
            else
            {
                mc.gameSettings.thirdPersonView = previousperspective;
            }
        }
        else if (returnOnRelease)
        {
            perspectiveToggled = false;
            mc.gameSettings.thirdPersonView = previousperspective;
        }

        if (e.getKeyCode() == mc.gameSettings.PERSPECTIVE_MOD.getKeyCode())
        {
            perspectiveToggled = false;
        }
    }

    public float getCameraYaw()
    {
        return perspectiveToggled ? cameraYaw : mc.thePlayer.rotationYaw;
    }

    public float getCameraPitch()
    {
        return perspectiveToggled ? cameraPitch : mc.thePlayer.rotationPitch;
    }

    public boolean overrideMouse()
    {
        if (mc.inGameHasFocus && Display.isActive())
        {
            if (!perspectiveToggled)
            {
                return true;
            }

            mc.mouseHelper.mouseXYChange();
            float f1 = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
            float f2 = (f1 * 3 * 8.0F);
            float f3 = (float) mc.mouseHelper.deltaX * f2;
            float f4 = (float) mc.mouseHelper.deltaY * f2;
            cameraYaw += f3 * 0.15F;
            cameraPitch += f4 * 0.15F;

            if (cameraPitch > 90)
            {
                cameraPitch = 90;
            }

            if (cameraYaw < -90)
            {
                cameraYaw = -90;
            }
        }

        return false;
    }

    @Override
    public void draw()
    {
        fr.drawString("[Perspective Toggled]", getX(), getY(), -1);
        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("[Perspective Toggled]", getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }

    @Override
    public int getWidth()
    {
        return fr.getStringWidth("[Perspective Toggled]");
    }

    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }

    @EventTarget
    public void onUpdate(EventUpdate event)
    {
        if (this.isEnabled())
        {
        }
    }
}
