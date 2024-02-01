package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Sensor {
    ColorSensor sensor; // actual sensor devices
    double cube_threshold = 0.5; // basically the sensitivity of the sensor to the color yellow
    double ball_threshold = 0.5; // basically the sensitivity of the sensor to the color white

    public void init(HardwareMap hardwareMap) {
        sensor = hardwareMap.get(ColorSensor.class,"Color Sensor"); // initializing class
    }
    public String getColor() {
        // takes the average of the color values of red and green(red + green = yellow) and if its over the threshold specified, then return yellow
        if ((double) (sensor.red() + sensor.green()) / 2  > cube_threshold * 510) {
            return "Yellow";
        }
        // takes the average of the color values of red,blue and green(red + green + blue = white) and if its over the threshold specified, then return white
        if ((double) (sensor.red() + sensor.green() + sensor.blue()) / 3 > ball_threshold * 765) {
            return "White";
        }
        return "None";
    }

}
