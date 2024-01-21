package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Driver Control",group = "OpMode")
public class DriverControl extends OpMode {
    public Wheels wheels;
    public Input input1;

    @Override
    public void init() {
        wheels.Init(hardwareMap);
    }

    @Override
    public void loop() {
        input1.UpdateInput(gamepad1);
        wheels.UpdatePower(input1);
    }


}
