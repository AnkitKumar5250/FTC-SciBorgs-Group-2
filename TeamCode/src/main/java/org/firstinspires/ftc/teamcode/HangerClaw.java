package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    public Servo baseY; // Joint 1
    public double baseSpeedY;
    //public Servo baseX; // Rotating bottom base
    //public double baseSpeedX;
    //public Servo elbow; // Joint 2
    //public double elbowSpeed;
    public Servo hand; // Top of claw ; Grabby part
    //public Servo handBottom; // Bottom of claw 
    public final double grab_limit; // the rotation of claw such that it grabs the hook on the lander

    public void Init(HardwareMap hardwareMap) {
        baseY = hardwareMap.get(Servo.class,"Claw Base X Servo");
        //baseX = hardwareMap.get(Servo.class,"Claw Base Y Servo");
        //elbow = hardwareMap.get(Servo.class,"Claw Elbow Servo");
        hand = hardwareMap.get(Servo.class,"Hand Servo");
        //handBottom = hardwareMap.get(Servo.class,"Hand Bottom Servo");
    }

    public void Update(Input input) {
        if (input.inputMode != "claw") {
            return;
        }

        baseY.setPosition(baseY.getPosition() - input.current.left_stick_x * baseSpeedY);
        //baseX.setPosition(baseX.getPosition() - input.current.left_stick_y * baseSpeedX);
        //elbow.setPosition(elbow.getPosition() - input.current.right_stick_y * elbowSpeed);

        if (input.current.x != input.previous.x) {
            if (input.current.x) {
                open();
                return;
            }
            close();
        }
        if (input.current.y != input.previous.y) {
            if (input.current.x) {
                close();
                return;
            }
            open();
        }
    }

    public void open() {
        // code for opening the claw
        hand.setposition(shape_limit);
    }
    public void retract() {
        // code for retracting the arm
    }
    public void close() {
        // code for closing the claw
        hand.setposition(0);
    }
}
