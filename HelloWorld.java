package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Hello World")
public class HelloWorld extends OpMode {
    int counter = 0
    for (counter >= 0; counter ++){
        telemetry.addData(counter, "counter")
    }


    @Override
    public void init() {
        telemetry.addData("Data", "Sriram");
    }

    @Override
    public void loop() {
        telemetry.addData("Data", "playing");
    }
}