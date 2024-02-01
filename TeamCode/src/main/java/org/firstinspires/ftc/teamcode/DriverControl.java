package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Driver Control",group = "OpMode")
public class DriverControl extends OpMode {
    // fields for the different components of the robot
    public Wheels wheels;
    public HangerClaw hangerClaw;
    public Input input1;

    @Override
    public void init() {
        wheels.Init(hardwareMap);
        hangerClaw.Init(hardwareMap);
    }

    @Override
    public void loop() {
        input1.Update(gamepad1);
        hangerClaw.Update(input1);
        wheels.Update(input1);
    }


}
