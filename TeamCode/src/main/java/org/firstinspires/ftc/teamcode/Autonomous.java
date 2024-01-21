package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Autonomous",group = "OpMode")
public class Autonomous extends OpMode {
    public Claw claw;
    public Wheels wheels;
    public double[] position = new double[3];
    public double[] rotation = new double[3];

    public void Unlatch() {
        claw.elbow.setPosition(0);
        claw.handBottom.setPosition(0);
        claw.handTop.setPosition(0);
    }




    @Override
    public void init() {
        claw.Init(hardwareMap);
        wheels.Init(hardwareMap);
    }

    @Override
    public void loop() {

    }
}
