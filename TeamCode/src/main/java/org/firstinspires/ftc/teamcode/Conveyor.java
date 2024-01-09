package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Conveyor {
    public DcMotor motor;

    public double speed;

    public void UpdateConveyorPower(Input input) {
        if (input.current.x != input.previous.x) {
            if (input.current.x) {
                motor.setPower(speed);
            }
            if (!input.current.x) {
                motor.setPower(0);
            }
        }
    }
}
