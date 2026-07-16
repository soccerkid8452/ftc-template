package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    //192.168.43.1
    public DcMotor left;
    public DcMotor up;
    public DcMotor down;
    public DcMotor right;
    public Servo claw; //left
    public Servo claw2; //right
    public double claw2Close = .53;
    public double claw2Open = .65;

    public double clawClose = .72;
    public double clawOpen = .6;

    public Hardware(HardwareMap hwMap) {
        left = hwMap.get(DcMotor.class, "lm");
        left.setDirection(DcMotorSimple.Direction.REVERSE);

        right = hwMap.get(DcMotor.class, "rm");

        up = hwMap.get(DcMotor.class, "up");

        claw = hwMap.get(Servo.class, "claw");
        claw2 = hwMap.get(Servo.class, "claw2");

        //down = hwMap.get(DcMotor.class, "down");

        up.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //down.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //up.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //down.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //down.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//servos

    }

    public void init() {
        openClaw();
    }

    public void openClaw() {
        claw.setPosition(clawOpen);
        claw2.setPosition(claw2Open);

    }

    public void closeClaw() {
        claw.setPosition(clawClose);
        claw2.setPosition(claw2Close);
    }


}
