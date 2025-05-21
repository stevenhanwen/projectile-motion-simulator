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

    public double maxHeight(){
        double maxHeight = (Math.pow(getVerticalVelocityComponent(), 2) / 9.81) - 
        (Math.pow(getVerticalVelocityComponent(), 2) / 9.81 / 2) + heightOfLauch; 

        return maxHeight; 
    }

    public void show() {
        SimpleDraw circle = new SimpleDraw(null); 
        circle.showAnimation(); 
    }

    public double getHorizontalVelocityComponent() {
        double radians = Math.toRadians(angleOfLaunch);
        double horizontalVelocity = initialVelocity * Math.cos(radians); 
        return horizontalVelocity; 
    }

    public double getVerticalVelocityComponent() {
        double radians = Math.toRadians(angleOfLaunch);
        double verticalVelocity = initialVelocity * Math.sin(radians); 
        return verticalVelocity; 
    }
}
