package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    //192.168..43.1
    public DcMotor left;
    public DcMotor up;
    public DcMotor down;
    public DcMotor right;
    public Servo claw;

    public double clawClose = .3;
    public double clawOpen = .3;

    public Hardware(HardwareMap hwMap) {
        left = hwMap.get(DcMotor.class, "lm");
        right = hwMap.get(DcMotor.class, "rm");

        up = hwMap.get(DcMotor.class, "up");
         down = hwMap.get(DcMotor.class, "down");

        up.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        down.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        up.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        down.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        down.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//servos
        claw = hwMap.get(Servo.class, "claw");
    }

    public void init() {
        openClaw();
    }

    public void openClaw() {
        claw.setPosition(clawOpen);
    }

    public void closeClaw() {
        claw.setPosition(clawClose);
    }


}
