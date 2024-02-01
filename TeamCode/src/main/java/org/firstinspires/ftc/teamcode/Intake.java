package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
  public DcMotor slide; // motor to move rigging
  //public DcMotor slideRight;
  public Servo claw; // grabbing the game pieces
  public Servo claw_limit; // rotation limit such that the claw is able to grab the game pieces
  
  public void Init(HardwareMap hardwareMap) {
    // initialize motor on the linear slide
    slide = hardwareMap.get(DcMotor.class, "Linear Slide DcMotor"); 
    //slideRight = hardwareMap.get(DcMotor.class, "Linear Slide Right DcMotor");
    claw = hardwareMap.get(Servo.class, "Linear Slide Claw Servo");

    // sets instructions for linear slide motor
    slide.setDirection(DcMotor.Direction.FORWARD); // motor will move forward when setPower is positive
    slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // motor immediately stops when setPower == 0; Does not float/glide
    slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // the encoder position is set to zero and motor stops; must use another setMode option(RUN_WITHOUT_ENCODER, RUN_TO_POSITION, RUN_WITH_ENCODER) to start motor again

    // sets instructions for right linear slide motor
    //slideRight.setDirection(DcMotor.Direction.FORWARD); // motor will move forward when setPower is positive
    //slideRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // motor immediately stops when setPower == 0; Does not float/glide
    //slideRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // the encoder position is set to zero and motor stops; must use another setMode option(RUN_WITHOUT_ENCODER, RUN_TO_POSITION, RUN_WITH_ENCODER) to start motor again
    }

    public void Update(Input input) {
        if (input.inputMode != "claw") {
            return;
        }
        if (input.current.x != input.previous.x) {
            if (input.current.x) {
                this.open();
                return;
            }
            this.close();
        }
        if (input.current.y != input.previous.y) {
            if (input.current.x) {
                this.close();
                return;
            }
            this.open();
        }

    }
    public void open() {
        // code for opening the claw
        claw.setPosition(0.5);
    }
    public void retract() {
        // code for retracting the slide
    }
    public void close() {
        // code for closing the claw
        claw.setPosition(0);
    }
}
