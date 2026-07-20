package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Test Each Motor")
public class TestClass extends LinearOpMode {

    public void runOpMode(){
        Hardware robot =new Hardware(hardwareMap);
        waitForStart();
        robot.left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (opModeIsActive()){
            if (gamepad1.a){
                robot.left.setPower(0.5);
            } else if (gamepad1.x){
                robot.left.setPower(-0.5);
            } else {
                robot.left.setPower(0);
            }
            if (gamepad1.dpad_up){
                robot.right.setPower(0.5);
            } else if (gamepad1.dpad_down){
                robot.right.setPower(-0.5);
            } else {
                robot.right.setPower(0);
            }
            telemetry.addData("Left Motor", robot.left.getCurrentPosition());
            telemetry.addData("Right Motor", robot.right.getCurrentPosition());
            telemetry.update();
        }
    }
}
