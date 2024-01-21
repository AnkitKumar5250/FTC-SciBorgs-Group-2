package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    public Servo baseY;
    public double baseSpeedY;
    public Servo baseX;
    public double baseSpeedX;
    public Servo elbow;
    public double elbowSpeed;
    public Servo handTop;
    public Servo handBottom;


    public void Init(HardwareMap hardwareMap) {
        baseY = hardwareMap.get(Servo.class,"Claw Base X Servo");
        baseX = hardwareMap.get(Servo.class,"Claw Base Y Servo");
        elbow = hardwareMap.get(Servo.class,"Claw Elbow Servo");
        handTop = hardwareMap.get(Servo.class,"Hand Top Servo");
        handBottom = hardwareMap.get(Servo.class,"Hand Bottom Servo");
    }

    public void UpdateServo(Input input) {
        if (input.inputMode != "claw") {
            return;
        }

        baseY.setPosition(baseY.getPosition() - input.current.left_stick_x * baseSpeedY);
        baseX.setPosition(baseX.getPosition() - input.current.left_stick_y * baseSpeedX);
        elbow.setPosition(elbow.getPosition() - input.current.right_stick_y * elbowSpeed);

        if (input.current.x != input.previous.x) {
            if (input.current.x) {
                handTop.setPosition(0.5);
                handBottom.setPosition(0.5);
                return;
            }
            handTop.setPosition(0);
            handBottom.setPosition(0);
        }
    }
}
