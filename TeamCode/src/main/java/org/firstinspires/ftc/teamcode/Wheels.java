package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Wheels {
    public DcMotor bottomleftMotor;
    public DcMotor bottomrightMotor;
    public DcMotor topleftMotor;
    public DcMotor toprightMotor;

    public double speed;

    public void Init(HardwareMap hardwareMap) {
        bottomleftMotor = hardwareMap.get(DcMotor.class,"Bottom Left Motor");
        bottomrightMotor = hardwareMap.get(DcMotor.class,"Bottom Right Motor");
        topleftMotor = hardwareMap.get(DcMotor.class,"Top Left Motor");
        toprightMotor = hardwareMap.get(DcMotor.class,"Top Right Motor");
    }
    public void UpdatePower(Input input) {
        if (input.inputMode != "Drive") {
            return;
        }
    }
}
