package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Worst Auto")
public class Auto extends LinearOpMode {

    public double ticsPerInch = 0;
    public double ticsPerDegree = 0;
public Hardware robot;

//when you press innit
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Hardware(hardwareMap);
        robot.init();
        waitForStart();

        robot.left.setPower(.6);
        robot.right.setPower(.6);
        sleep(1000); //waiting 1 second

        robot.left.setPower(0);
        robot.right.setPower(0);

        robot.openClaw();

        //turn
        turnleft(.6, 500);
        sleep(500);
    }

    public void turnleft(double power, long duration){
        robot.left.setPower(-power);
        robot.right.setPower(power);
        sleep(duration);
    }

    public void turnright(double power, long duration){
        robot.left.setPower(power);
        robot.right.setPower(-power);
        sleep(duration);
    }

    public void foward(double power, long duration) {
        robot.left.setPower(power);
        robot.right.setPower(power);
        sleep(duration);
    }
     public void fowardEncoder(double power, double inches){
         robot.left.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);
         robot.right.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);

         int ticks = (int) (inches = ticsPerInch);

         robot.left.setTargetPosition(ticks);
         robot.left.setTargetPosition(ticks);

         robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
         robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

         robot.left.setPower(power);
         robot.right.setPower(power);
     }

    public void leftEncoder(double power, double inches){
        robot.left.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches = ticsPerDegree);

        robot.left.setTargetPosition(ticks);
        robot.left.setTargetPosition(-ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }

    public void rightEncoder(double power, double inches){
        robot.left.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches = ticsPerDegree);

        robot.left.setTargetPosition(-ticks);
        robot.left.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }

}