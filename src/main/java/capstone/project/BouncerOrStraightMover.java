package capstone.project;

import java.awt.Graphics;

public class BouncerOrStraightMover implements Mover {
    private int x;
    private int y;
    private int xDirection;
    private int yDirection;
    private Sprite sprite;
    private boolean isBouncer = false;

    /**
     * Create a BouncerOrStraightMover that positions sprite at (startX, startY).
     */
    public BouncerOrStraightMover(int startX, int startY, Sprite sprite, boolean isBouncer) {
        x = startX;
        y = startY;
        this.sprite = sprite;
        this.isBouncer = isBouncer;
    }

    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }

    /** Draws the sprite at its current position on to surface. */
    @Override
    public void draw(Graphics surface) {
        // Draw the sprite
        sprite.draw(surface, x, y);

        // Move the object each time we draw it
        x += xDirection;
        y += yDirection;

        // checks if the sprite created is a bouncer or straight mover
        // if not a bouncer, won't bounce off the walls
        if (isBouncer == true) {
            // If we have hit the edge and are moving in the wrong direction, reverse
            // direction
            // We check the direction because if a box is placed near the wall, we would get
            // "stuck"
            // rather than moving in the right direction
            if ((x <= 0 && xDirection < 0) ||
                    (x + sprite.getWidth() >= SimpleDraw.WIDTH && xDirection > 0)) {
                xDirection = -xDirection;
            }
            if ((y <= 0 && yDirection < 0) ||
                    (y + sprite.getHeight() >= SimpleDraw.HEIGHT && yDirection > 0)) {
                yDirection = -yDirection;
            }
        }
    }
}
