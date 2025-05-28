package capstone.project;

import java.lang.Math;

public class PhysicalObject {
    double heightOfLaunch;
    double angleOfLaunch;
    double initialVelocity;

    public PhysicalObject(double heightOfLauch, double angleOfLaunch, double initialVelocity) {
        this.heightOfLaunch = heightOfLauch;
        this.angleOfLaunch = angleOfLaunch;
        this.initialVelocity = initialVelocity;
    }

    // method to find the max height of the object after the launch.
    public double getMaxHeight() {

        if (angleOfLaunch <= 0) {
            return heightOfLaunch;
        }

        // gravity of Earth = 9.807 m/s^2
        double maxHeight = (Math.pow(getVerticalVelocityComponent(), 2) / 9.81) -
                (Math.pow(getVerticalVelocityComponent(), 2) / 9.81 / 2) + heightOfLaunch;

        System.out.println(Math.round(maxHeight * 100.0) / 100.0);

        // rounding maxHeight to the thousandths place.
        return Math.round(maxHeight * 100.0) / 100.0;
    }

    public double getTimeOfFlight() {

        double time = 0;
        double verticalVelocitySquared = Math.pow(getVerticalVelocityComponent(), 2);

        // using quadratic formula to calculate time from the change in y formula
        time = (getVerticalVelocityComponent() +
                Math.pow(verticalVelocitySquared + (2 * 9.81 * heightOfLaunch), 0.5)) / 9.81;
        System.out.println(time);
        

        return time; 
    }

    // this method returns the time of flight but rounded 
    // to the nearest hundreths. 
    public double getTimeOfFlightRounded(){
        return Math.round(getTimeOfFlight() * 100.0) / 100.0;
    }

    public double getHorizontalDistanceTravelled() {
        double horizontalDistance = 0;

        if (angleOfLaunch == 90 || angleOfLaunch == -90) {
            return horizontalDistance;
        }

        horizontalDistance = getTimeOfFlight() * getHorizontalVelocityComponent();

        return Math.round(horizontalDistance * 100.0) / 100.0;
    }

    // draw the object onto Java's JFrame
    public void show() {
        SimpleDraw circle = new SimpleDraw(null);
        circle.showAnimation(this);
    }

    // Helper function to find the horizontal velocity component of V initial.
    public double getHorizontalVelocityComponent() {
        double radians = Math.toRadians(angleOfLaunch);
        double horizontalVelocity = initialVelocity * Math.cos(radians);

        return horizontalVelocity;
    }

    // Helper function to find the vertical velocity component of V initial.
    public double getVerticalVelocityComponent() {
        double radians = Math.toRadians(angleOfLaunch);
        double verticalVelocity = initialVelocity * Math.sin(radians);

        return verticalVelocity;
    }
}
