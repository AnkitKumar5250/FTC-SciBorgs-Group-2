package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Wheels {
    // creating fields for the four motors
    public DcMotor bottomLeftMotor;
    public DcMotor bottomRightMotor;
    public DcMotor topLeftMotor;
    public DcMotor topRightMotor;

    // public variables used for setting the speed of turning,strafing and moving forward/backwards
    public double straightSpeed = 1;
    public double turnSpeed = 1;
    public double strafeSpeed = 1;

    public void Init(HardwareMap hardwareMap) {
        // Fetching the physical motors and assigning them to the fields
        bottomLeftMotor = hardwareMap.get(DcMotor.class,"Bottom Left Motor");
        bottomRightMotor = hardwareMap.get(DcMotor.class,"Bottom Right Motor");
        topLeftMotor = hardwareMap.get(DcMotor.class,"Top Left Motor");
        topRightMotor = hardwareMap.get(DcMotor.class,"Top Right Motor");

        // Makes it so the motors brake when the power is set to zero
        bottomLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        topLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        topRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // In the case that a motor is put in the wrong orientation(since there is no way to tell), its direction can be changed via code
        bottomLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        bottomRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        topLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        topRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    public void UpdatePower(Input input) {
        // Since there are many systems in place and only one controller
        // It would be beneficial to have different modes for operating different mechanisms(which the driver can switch through)
        if (input.inputMode != "Drive") {
            return;
        }

        // left stick will be used to turn the robot in place
        // right stick will move the robot in the direction of the joystick
        double strafe = input.current.right_stick_x * strafeSpeed;
        double turn = input.current.left_stick_x * turnSpeed;
        double straight = -input.current.right_stick_y * straightSpeed;

        // in order to prevent the values from exceeding 1 or -1 they will be expressed as a ratio instead of a raw value
        // this allows guarantees that values will always be accurate relative to each other
        double denominator = Math.max(Math.abs(straight) + Math.abs(strafe) + Math.abs(turn), 1);

        bottomLeftMotor.setPower((straight - strafe + turn) / denominator);
        bottomRightMotor.setPower((straight + strafe + turn) / denominator);
        topLeftMotor.setPower((straight + strafe - turn) / denominator);
        topRightMotor.setPower((straight - strafe - turn) / denominator);
    }
}
