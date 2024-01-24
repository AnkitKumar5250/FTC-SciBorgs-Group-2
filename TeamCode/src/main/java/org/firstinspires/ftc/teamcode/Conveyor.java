package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Conveyor {
    // creating a field for the motor
    public DcMotor motor;

    // creating an adjustable speed variable
    public double speed;

    public void Init(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class,"Conveyor Motor");
        motor.setDirection(DcMotor.Direction.FORWARD); // motor will move forward when setPower is positive
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // motor immediately stops when setPower == 0; Does not float/glide
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // the encoder position is set to zero and motor stops; must use another setMode option(RUN_WITHOUT_ENCODER, RUN_TO_POSITION, RUN_WITH_ENCODER) to start motor again
    }
    public void Update(Input input) {
        // Since there are many systems in place and only one controller
        // It would be beneficial to have different modes for operating different mechanisms(which the driver can switch through)
        if (input.inputMode != "Conveyor") {
            return;
        }

        // has two modes, an on mode and an off mode
        // only changes state when the input has changed
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
