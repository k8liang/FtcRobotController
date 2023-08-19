package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor fLeft = hardwareMap.dcMotor.get("fLeft");
        DcMotor fRight = hardwareMap.dcMotor.get("fRight");
        DcMotor bLeft = hardwareMap.dcMotor.get("bLeft");
        DcMotor bRight = hardwareMap.dcMotor.get("bRight");

        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        fLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        fRight.setDirection(DcMotorSimple.Direction.FORWARD);
        bLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        bRight.setDirection(DcMotorSimple.Direction.FORWARD);

        fLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        int ticks = fLeft.getCurrentPosition();
        double ticksPerInch = (537.7/1.4) / 11.87373601322835;

        while (opModeIsActive()) {

            telemetry.addLine(String.valueOf(ticks));
            telemetry.addLine(String.valueOf(ticksPerInch));
            telemetry.update();

            if (ticks < (ticksPerInch*12)) {
                fLeft.setPower(0.25);
                fRight.setPower(0.25);
                bLeft.setPower(0.25);
                bRight.setPower(0.25);
            } else if (ticks >= (ticksPerInch*12)){
                fLeft.setPower(0);
                fRight.setPower(0);
                bLeft.setPower(0);
                bRight.setPower(0);
            }

            ticks = fLeft.getCurrentPosition();

        }

    }
}
