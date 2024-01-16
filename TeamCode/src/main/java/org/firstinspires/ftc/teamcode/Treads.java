package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Treads {
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    public double speed;

    public void Init(HardwareMap hardwareMap) {
        leftMotor = hardwareMap.get(DcMotor.class,"Left Motor");
        rightMotor = hardwareMap.get(DcMotor.class,"Right Motor");
    }
    public void UpdatePower(Input input) {
        if (input.inputMode != "Drive") {
            return;
        }
        if (input.current.right_stick_y != 0 && input.current.left_stick_x != 0) {
            return;
        }

        double lp = input.current.right_stick_y * speed + input.current.left_stick_x * speed;
        double rp = input.current.right_stick_y * speed - input.current.left_stick_x * speed;

        if (lp > 1.0) {
            lp = 1.0;
        }
        if (rp > 1.0) {
            rp = 1.0;
        }

        leftMotor.setPower(lp);
        rightMotor.setPower(rp);
    }
}
