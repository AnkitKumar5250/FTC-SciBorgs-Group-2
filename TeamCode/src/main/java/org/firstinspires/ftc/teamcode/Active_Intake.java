package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LinearSlide {
  public DcMotor slideLeft;
  public DcMotor slideRight;
  
  public void Init(HardwareMap hardwareMap) {
    // initialize left and right motors on the linear slide
    slideLeft = hardwareMap.get(DcMotor.class, "Linear Slide Left DcMotor"); 
    slideRight = hardwareMap.get(DcMotor.class, "Linear Slide Right DcMotor");

    // sets instructions for left linear slide motor
    slideLeft.setDirection(DcMotor.Direction.FORWARD); // motor will move forward when setPower is positive
    slideLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // motor immediately stops when setPower == 0; Does not float/glide
    slideLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // the encoder position is set to zero and motor stops; must use another setMode option(RUN_WITHOUT_ENCODER, RUN_TO_POSITION, RUN_WITH_ENCODER) to start motor again

    // sets instructions for right linear slide motor
    slideRight.setDirection(DcMotor.Direction.FORWARD); // motor will move forward when setPower is positive
    slideRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // motor immediately stops when setPower == 0; Does not float/glide
    slideRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // the encoder position is set to zero and motor stops; must use another setMode option(RUN_WITHOUT_ENCODER, RUN_TO_POSITION, RUN_WITH_ENCODER) to start motor again
    }
  }
