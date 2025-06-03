package capstone.project;

import java.lang.Math;

public class PhysicalObject {
    double heightOfLaunch;
    double angleOfLaunch;
    double angleofLaunchRadians; 
    double initialVelocity;

    public PhysicalObject(double heightOfLauch, double angleOfLaunch, double initialVelocity) {
        this.heightOfLaunch = heightOfLauch;
        this.angleOfLaunch = angleOfLaunch;
        this.initialVelocity = initialVelocity;
        angleofLaunchRadians = Math.toRadians(angleOfLaunch); 
    }

    // method to find the max height of the object after the launch.
    public double getMaxHeight() {

        if (angleOfLaunch <= 0) {
            return heightOfLaunch;
        }

        // gravity of Earth = 9.807 m/s^2
        double maxHeight = (Math.pow(getVerticalVelocityComponent(), 2) / 9.81) -
                (Math.pow(getVerticalVelocityComponent(), 2) / 9.81 / 2) + heightOfLaunch;

        // rounding maxHeight to the thousandths place.
        return Math.round(maxHeight * 100.0) / 100.0;
    }

    public double getTimeOfFlight() {

        double time = 0;
        double verticalVelocitySquared = Math.pow(getVerticalVelocityComponent(), 2);

        // using quadratic formula to calculate time from the change in y formula
        time = (getVerticalVelocityComponent() +
                Math.pow(verticalVelocitySquared + (2 * 9.81 * heightOfLaunch), 0.5)) / 9.81;
        
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

    public double getFinalSpeedRounded() {
        // |v| = (vx + vy) ^ 1/2
        double speedSquared = getFinalVerticalVelocity() * getFinalVerticalVelocity() 
        + getHorizontalVelocityComponent() * getHorizontalVelocityComponent();  

        // rounding to the nearest hundreths
        // have to use 100.0 because if both operands are integers → Integer Division
        double speedBeforeRounding = Math.pow(speedSquared, 0.5); 
        return Math.round(speedBeforeRounding * 100) / 100.0; 
    }

    public double getFinalVerticalVelocity(){
        // vf = vi + at
        double vy = getVerticalVelocityComponent()  - 9.81 * getTimeOfFlight();
        return vy; 
    }

    public double getAngleOfFinalVelocityRounded() {
        // Computes the arctangent of y/x, but also considers the signs of x and y 
        // to determine the correct quadrant.

        double angle = Math.atan2(getFinalVerticalVelocity(), getHorizontalVelocityComponent()); 
        return Math.round(Math.toDegrees(angle) * 100) / 100.0; 
    }



    // Helper function to find the horizontal velocity component of V initial.
    public double getHorizontalVelocityComponent() {
        double horizontalVelocity = initialVelocity * Math.cos(angleofLaunchRadians);
        return horizontalVelocity;
    }

    // Helper function to find the vertical velocity component of V initial.
    public double getVerticalVelocityComponent() {
        double verticalVelocity = initialVelocity * Math.sin(angleofLaunchRadians);

        return verticalVelocity;
    }

    // draw the object onto Java's JFrame
    public void show() {
        SimpleDraw animation = new SimpleDraw(null);
        animation.showAnimation(this);
    }

    
}
