package capstone.project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {

    ArrayList<Mover> movers = new ArrayList<>();
    BouncerOrStraightMover straightMovingSprite1;
    BouncerOrStraightMover straightMovingSprite2;
    BouncerOrStraightMover movingSprite1;
    BouncerOrStraightMover movingSprite2;

    /**
     * Initializes this class for drawing.
     * The JFrame is 1500 in width and 800 in height
     * We will draw shapes onto the JFrame with 1 meter = 30 pixels
     */
    public DrawGraphics() {
        Rectangle launchPlatform = new Rectangle(100, 50, Color.RED);
        straightMovingSprite1 = new BouncerOrStraightMover(0, 750, straightBox1, false);
        straightMovingSprite1.setMovementVector(0, 0);
        movers.add(straightMovingSprite1);

        // Oval straightOval1 = new Oval(50, 80, Color.BLUE);
        // straightMovingSprite2 = new BouncerOrStraightMover(10, 50, straightOval1,
        // false);
        // straightMovingSprite2.setMovementVector(3, 2);
        // movers.add(straightMovingSprite2);

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
