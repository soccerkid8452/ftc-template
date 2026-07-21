package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "REDAuto")
public class AutoRED extends LinearOpMode {

    public double ticsPerInch = (537.7)/(Math.PI * 3.78);
//    public double ticsPerDegree = 0;
public Hardware robot;

//when you press innit
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Hardware(hardwareMap);
        robot.init();
        waitForStart();
        moveForward(.1,75);

        while (opModeIsActive() & (robot.left.isBusy()|| robot.right.isBusy())){
            telemetry.addData("Current Inches", robot.left.getCurrentPosition()/ ticsPerInch);
            telemetry.addData("Current Inches r", robot.right.getCurrentPosition()/ ticsPerInch);
            telemetry.addData("Target", robot.left.getTargetPosition());
            telemetry.addData("Target r", robot.right.getTargetPosition());
            telemetry.update();
        }
        turnLeft(.1, -180);
        while (opModeIsActive() & (robot.left.isBusy()|| robot.right.isBusy())) {
            telemetry.addData("Current Inches", robot.left.getCurrentPosition() / ticsPerInch);
            telemetry.addData("Current Inches r", robot.right.getCurrentPosition() / ticsPerInch);
            telemetry.addData("Target", robot.left.getTargetPosition());
            telemetry.addData("Target r", robot.right.getTargetPosition());
            telemetry.update();
        }
        moveForward(0.5, -25);
        while (opModeIsActive() & (robot.left.isBusy()|| robot.right.isBusy())) {
            telemetry.addData("Current Inches", robot.left.getCurrentPosition() / ticsPerInch);
            telemetry.addData("Current Inches r", robot.right.getCurrentPosition() / ticsPerInch);
            telemetry.addData("Target", robot.left.getTargetPosition());
            telemetry.addData("Target r", robot.right.getTargetPosition());
            telemetry.update();
        }
////
//        robot.left.setPower(.6);
//        robot.right.setPower(.6);
//        sleep(1000); //waiting 1 second
//
//        robot.left.setPower(0);
//        robot.right.setPower(0);
//
//        robot.openClaw();
//
//        //turn
//        turnleft(.6, 500);
//        sleep(500);
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

//    public void foward(double power, long duration) {
//        robot.left.setPower(power);
//        robot.right.setPower(power);
//        sleep(duration);
//    }
     public void moveForward(double power, double inches){
         robot.left.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);
         robot.right.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);

         int ticks = (int) (inches * ticsPerInch);

         robot.left.setTargetPosition(ticks);
         robot.right.setTargetPosition(ticks);

         robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
         robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

         robot.left.setPower(power);
         robot.right.setPower(power);
     }

    public void turnLeft(double power, double degrees){
        double ticks = ( 537.7*17.5*degrees)/(360*3.78);
        robot.left.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);

//        int ticks = (int) (inches * ticsPerDegree);


        robot.left.setTargetPosition((int)ticks);
        robot.left.setTargetPosition((int)-ticks);


        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }

//    public void rightEncoder(double power, double inches){
//        robot.left.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);
//        robot.right.setMode(DcMotor.RunMode. STOP_AND_RESET_ENCODER);
//
//        int ticks = (int) (inches * ticsPerDegree);
//
//        robot.left.setTargetPosition(-ticks);
//        robot.left.setTargetPosition(ticks);
//
//        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        robot.left.setPower(power);
//        robot.right.setPower(power);
//    }

}