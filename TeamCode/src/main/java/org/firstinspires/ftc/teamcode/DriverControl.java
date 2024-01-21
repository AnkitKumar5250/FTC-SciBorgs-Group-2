package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Driver Control",group = "OpMode")
public class DriverControl extends OpMode {
    public Wheels wheels;
    public Conveyor conveyor;
    public Input input1;
    public Input input2;
    public Claw claw;

    @Override
    public void init() {
        wheels.Init(hardwareMap);
        claw.Init(hardwareMap);
    }

    @Override
    public void loop() {
        input1.UpdateInput(gamepad1);
        input2.UpdateInput(gamepad2);
        wheels.UpdatePower(input1);
        conveyor.UpdateConveyorPower(input1);
        claw.UpdateServo(input2);
    }


}
