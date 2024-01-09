package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Driver Control",group = "OpMode")
public class DriverControl extends OpMode {
    public Treads treads;
    public Conveyor lowerConveyor;
    public Conveyor UpperConveyor;
    public Input input1;
    public Input input2;

    public Claw claw;

    @Override
    public void init() {
        treads.leftMotor = hardwareMap.get(DcMotor.class,"Left Motor");
        treads.rightMotor = hardwareMap.get(DcMotor.class,"Right Motor");
        lowerConveyor.motor = hardwareMap.get(DcMotor.class,"Lower Conveyor Motor");
        UpperConveyor.motor = hardwareMap.get(DcMotor.class,"Upper Conveyor Motor");
        claw.baseY = hardwareMap.get(Servo.class,"Claw Base X Servo");
        claw.baseX = hardwareMap.get(Servo.class,"Claw Base Y Servo");
        claw.elbow = hardwareMap.get(Servo.class,"Claw Elbow Servo");
    }

    @Override
    public void loop() {
        input1.UpdateInput(gamepad1);
        input2.UpdateInput(gamepad2);
        treads.UpdatePower(input1);
        lowerConveyor.UpdateConveyorPower(input1);
        UpperConveyor.UpdateConveyorPower(input1);
        claw.UpdateServo(input2);
    }


}
