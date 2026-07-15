package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name = "Worst Auto")
public class Auto extends LinearOpMode {
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
}