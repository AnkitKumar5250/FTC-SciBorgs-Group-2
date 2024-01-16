package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.Vector;

@TeleOp(name = "Autonomous",group = "OpMode")
public class Autonomous extends OpMode {
    public Claw claw;
    public Treads treads;
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
        treads.Init(hardwareMap);
    }

    @Override
    public void loop() {

    }
}
