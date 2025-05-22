package capstone.project;

import java.lang.Math; 

public class PhysicalObject {
    double heightOfLauch; 
    double angleOfLaunch; 
    double initialVelocity; 

    public PhysicalObject(double heightOfLauch, double angleOfLaunch, double initialVelocity ) {
        this.heightOfLauch = heightOfLauch;
        this.angleOfLaunch = angleOfLaunch; 
        this.initialVelocity = initialVelocity; 
    }

    // method to find the max height of the object after the launch. 
    public double getMaxHeight(){

        if (angleOfLaunch <= 0) {
            return heightOfLauch; 
        }

        // gravity of Earth = 9.807 m/s^2
        double maxHeight = (Math.pow(getVerticalVelocityComponent(), 2) / 9.807) - 
        (Math.pow(getVerticalVelocityComponent(), 2) / 9.807 / 2) + heightOfLauch; 

        // rounding maxHeight to the thousandths place. 
        return Math.round(maxHeight * 1000.0) / 1000.0;
    }

    public double getTimeOfFlight() {

        double time; 
        time = (getVerticalVelocityComponent() + 
        Math.pow(Math.pow(getVerticalVelocityComponent(), 2) - 2 * 9.807 * heightOfLauch, 0.5)) / 2;

        return time; 
    }

    public double getHorizontalDistanceTravelled() {
        double horizontalDistance = 0; 

        if (angleOfLaunch == 90 || angleOfLaunch == -90) {
            return 0.0; 
        }

        if (heightOfLauch > 0) {

        }

        return horizontalDistance; 
    }


    
    // draw the object onto Java's JFrame
    public void show() {
        SimpleDraw circle = new SimpleDraw(null); 
        circle.showAnimation(); 
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
