package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Conveyor {
    public DcMotor motor;
    public double speed;

    public void Init(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class,"Conveyor Motor");
        motor.setDirection(DcMotor.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); 
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void UpdateConveyorPower(Input input) {
        if (input.inputMode != "Conveyor") {
            return;
        }
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
