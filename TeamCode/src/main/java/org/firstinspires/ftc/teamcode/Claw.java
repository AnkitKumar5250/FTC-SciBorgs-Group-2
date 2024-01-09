package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    public Servo baseY;
    public double baseSpeedY;
    public Servo baseX;
    public double baseSpeedX;
    public Servo elbow;
    public double elbowSpeed;

    public void UpdateServo(Input input) {
        baseY.setPosition(baseY.getPosition() - input.current.left_stick_x * baseSpeedY);
        baseX.setPosition(baseX.getPosition() - input.current.left_stick_y * baseSpeedX);
        elbow.setPosition(elbow.getPosition() - input.current.right_stick_y * elbowSpeed);
    }
}
