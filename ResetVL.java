package dev.aurora.module.impl.exploit;

import dev.aurora.event.impl.player.MotionEvent;
import dev.aurora.module.Category;
import dev.aurora.module.Module;

public final class ResetVL extends Module {

    private int jumps;

    public ResetVL() {
        super("ResetVL", Category.EXPLOIT, "Unflags you on servers");
    }

    @Override
    public void onMotionEvent(MotionEvent event) {
        mc.thePlayer.cameraYaw = mc.thePlayer.cameraPitch = 0.1F;
        if (mc.thePlayer.onGround) {
            if (jumps <= 25) {
                mc.thePlayer.motionY = 0.11;
                jumps++;
            }
        }
        if (jumps <= 25) {
            if (mc.thePlayer.posY - (int) mc.thePlayer.posY < 0.2) {
                mc.thePlayer.posY = (int) mc.thePlayer.posY;
            }
        } else {
            toggle();
        }
    }

    @Override
    public void onEnable() {
        jumps = 0;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        mc.timer.timerSpeed = 1;
        super.onDisable();
    }

}
