package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Autonomous",group = "OpMode")
public class Autonomous extends OpMode {
    // fields for the different components of the robot
    public Claw claw;
    public Wheels wheels;

    // variables that store the robots position and rotation on the field which can be used to calculate where it should go
    public double[] position = new double[3];
    public double[] rotation = new double[3];

    public void latch() {
        // Code for latching the robot at the before the match

        // idk if the robot can be latched manually or not so just in case we should probably have this function
    }

    public void Sample() {
        // Code for sampling the cube

        // I think we should position the robot in a position where it is parallel to any three samples, and move left and right
        // We should also have a tensorflow model capable of identifying when the cube is in front of us, and then proceed to punch it with the intake system(to avoid collateral damage which loses points)
        // I do not think we have the programming abilities to use AI navigation tools to drive directly to the cube(since tensorflow will not be accurate enough for determining the rotation of objects), so I think this is the best option
    }

    @Override
    public void init() {
        claw.Init(hardwareMap);
        wheels.Init(hardwareMap);

        claw.open();
    }

    @Override
    public void loop() {

    }
}
