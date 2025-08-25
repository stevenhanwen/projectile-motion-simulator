package capstone.project;

import java.awt.Graphics;

public class ProjectileMover implements Mover {
    private int x;
    private int y;
    private int startY; 
    private Sprite sprite;
    private boolean isMoving = false;
    private PhysicalObject motionParameters;

    // time step per frame (arbitrary)
    private final double timeIncrement = 0.05;
    private double time = 0;

    /**
     * Create a BouncerOrProjectileMover that positions sprite at (startX, startY).
     */
    public ProjectileMover(int startX, int startY, Sprite sprite, boolean isMoving, PhysicalObject projec) {
        x = startX;
        y = startY;
        this.startY = startY; 
        this.sprite = sprite;
        this.isMoving = isMoving;
        this.motionParameters = projec;
    }


    /** Draws the sprite at its current position on to surface. */
    @Override
    public void draw(Graphics surface) {
        // Draw the sprite
        sprite.draw(surface, x, y);

        if (isMoving == false) {
            return;
        }

        // Update time
        time += timeIncrement;
        final int lastXBeforeGround = x;

        // Update positions using projectile motion equations
        // multiple by 20 to convert meters into pixels on the screen

        x = (int) Math.round(x + motionParameters.getHorizontalVelocityComponent() * 20 * timeIncrement);
        // y = (int) Math.round (y - (motionParameters.getVerticalVelocityComponent() *
        // timeIncrement * 20 - 0.5 * 9.81 * timeIncrement * time * 20));

        // Assuming initialY is set when the ball is first launched
        double vy = motionParameters.getVerticalVelocityComponent();
        double displacement = vy * time - 0.5 * 9.81 * time * time; // meters
        // System.out.println("the current displacement is: " + displacement + "and vy is: " + vy); 

        y = (int) Math.round(startY - displacement * 20);

        // Stop the motion if the object hits the "ground"
        if (y + sprite.getHeight() >= SimpleDraw.HEIGHT) {
            y = 765;
            x = lastXBeforeGround;
        }

        // Move the object each time we draw it (this is for linear)
        // x += xDirection;
        // y += yDirection;

    }
}
