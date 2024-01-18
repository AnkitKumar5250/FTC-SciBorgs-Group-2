package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Conveyor {
    public DcMotor motor;
    public double speed;

    public void Init(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class,"Conveyor Motor");
        motor.setDirection(DcMotor.Direction.FORWARD); // motor will move forward when setPower is positive
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // motor immediately stops when setPower == 0; Does not float/glide
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // the encoder position is set to zero and motor stops; must use another setMode option(RUN_WITHOUT_ENCODER, RUN_TO_POSITION, RUN_WITH_ENCODER) to start motor again
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
