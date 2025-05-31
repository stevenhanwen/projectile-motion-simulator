package capstone.project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.lang.Math;

public class DrawGraphics {

    ArrayList<Mover> movers = new ArrayList<>();
    ProjectileMover spriteOfLaunchPlatform;
    ProjectileMover spriteOfProjectileBall;
    ProjectileMover spriteOfMaxHeightLine;

    /**
     * Initializes this class for drawing.
     * The JFrame is 1500 in width and 800 in height
     * We will draw shapes onto the JFrame with 1 meter = 20 pixels
     */
    public DrawGraphics(PhysicalObject projectile) {

        // the width of the platform will always stay 100 pixels
        // the height will depend on the height of the launch
        // have to round to nearest int, because pixels are in integers
        Rectangle launchPlatform = new Rectangle(100, (int) Math.round(projectile.heightOfLaunch * 20), Color.RED);
        spriteOfLaunchPlatform = new ProjectileMover(0, 800 - (int) Math.round(projectile.heightOfLaunch * 20),
                launchPlatform, false, projectile);
        // spriteOfLaunchPlatform.setMovementVector(0, 0);
        movers.add(spriteOfLaunchPlatform);

        // centering the projectile to the center of the launch platform
        Oval projectileBall = new Oval(35, 35, Color.BLUE);
        spriteOfProjectileBall = new ProjectileMover(35, 765 - (int) Math.round(projectile.heightOfLaunch * 20),
                projectileBall, true, projectile);
        // spriteOfProjectileBall.setMovementVector(0, 0);
        movers.add(spriteOfProjectileBall);

        Rectangle maxHeightLine = new Rectangle(1500, 1, Color.BLACK);
        spriteOfMaxHeightLine = new ProjectileMover(0, 785 - (int) Math.round(projectile.getMaxHeight() * 20),
                maxHeightLine,
                false, projectile);
        movers.add(spriteOfMaxHeightLine);

        // Rectangle box1 = new Rectangle(15, 20, Color.MAGENTA);
        // movingSprite1 = new BouncerOrStraightMover(50, 170, box1, true);
        // movingSprite1.setMovementVector(2, 1);
        // movers.add(movingSprite1);

        // Oval oval1 = new Oval(40, 80, Color.YELLOW);
        // movingSprite2 = new BouncerOrStraightMover(10, 20, oval1, true);
        // movingSprite2.setMovementVector(3, 2);
        // movers.add(movingSprite2);

    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {

        for (Mover mover : movers) {
            mover.draw(surface);
        }

    }
}
