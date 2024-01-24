package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

public class Input {
    public Gamepad previous;
    public Gamepad current;
    public String inputMode;

    public void Update(Gamepad gamepad) {
        previous = current;
        current = gamepad;
    }
}
