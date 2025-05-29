package capstone.project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Oval implements Sprite {
    private int width;
    private int height;
    private Color color; 

    /**
     * Constructor for oval sprite
     * 
     * @param width
     * @param height
     * @param color
     */
    public Oval(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics surface, int x, int y) {
        // Draw the object

        // sets the color to color
        surface.setColor(color);
        surface.fillOval(x, y, width, height);

        // sets color to black for remaining methods to draw the outline
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
