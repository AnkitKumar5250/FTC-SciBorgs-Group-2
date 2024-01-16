package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Driver Control",group = "OpMode")
public class DriverControl extends OpMode {
    public Treads treads;
    public Conveyor conveyor;
    public Input input1;
    public Input input2;
    public Claw claw;

    @Override
    public void init() {
        treads.Init(hardwareMap);
        claw.Init(hardwareMap);
    }

    @Override
    public void loop() {
        input1.UpdateInput(gamepad1);
        input2.UpdateInput(gamepad2);
        treads.UpdatePower(input1);
        conveyor.UpdateConveyorPower(input1);
        claw.UpdateServo(input2);
    }


}
