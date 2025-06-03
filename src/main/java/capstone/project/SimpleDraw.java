package capstone.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;

/** Displays a window and delegates drawing to DrawGraphics. */
public class SimpleDraw extends JPanel implements Runnable {
    private static final long serialVersionUID = -7469734580960165754L;
    private boolean animate = true;
    private final int FRAME_DELAY = 50; // 50 ms = 20 FPS
    public static final int WIDTH = 1500;
    public static final int HEIGHT = 800;
    private DrawGraphics draw;

    public SimpleDraw(DrawGraphics drawer) {
        this.draw = drawer;
    }

    /** Paint callback from Swing. Draw graphics using g. */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Enable anti-aliasing for better looking graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        draw.draw(g2);
    }

    /** Enables periodic repaint calls. */
    public synchronized void start() {
        animate = true;
    }

    /** Pauses animation. */
    public synchronized void stop() {
        animate = false;
    }

    private synchronized boolean animationEnabled() {
        return animate;
    }

    public void run() {
        while (true) {
            if (animationEnabled()) {
                repaint();
            }

            try {
                Thread.sleep(FRAME_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void showAnimation(PhysicalObject obj) {
        final SimpleDraw content = new SimpleDraw(new DrawGraphics(obj));

        JFrame frame = new JFrame("Graphics!");
        Color bgColor = Color.white;
        frame.getContentPane().setBackground(bgColor);
        content.setBackground(bgColor);
        // content.setSize(WIDTH, HEIGHT
        // content.setMinimumSize(new Dimension(WIDTH, HEIGHT);
        content.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // frame.setSize(WIDTH, HEIGHT);
        frame.setContentPane(content);
        frame.setResizable(false);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            public void windowDeiconified(WindowEvent e) {
                content.start();
            }

            public void windowIconified(WindowEvent e) {
                content.stop();
            }
        });

        // Create a label with text
        JLabel heightLabel = new JLabel(
                "Max Height: " + (double) Math.round(obj.getMaxHeight() * 100) / 100 + " meters");
        JLabel timeLabel = new JLabel(
                "Time of Flight: " + (double) Math.round(obj.getTimeOfFlight() * 100) / 100 + " seconds");
        JLabel finalVelocityLabel = new JLabel("Final speed is "
                + obj.getFinalSpeedRounded() + " m/s and " 
                + obj.getAngleOfFinalVelocityRounded() + " degrees from the X axis (ground)");
        JLabel launchPlatformLabel = new JLabel ("Launch Platform"); 

        // Increase the font of the text
        heightLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        finalVelocityLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        launchPlatformLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); 

        // Add the label to the frame
        frame.add(heightLabel);
        frame.add(timeLabel);
        frame.add(finalVelocityLabel); 
        frame.add(launchPlatformLabel); 

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout to null if you're positioning manually (optional)
        frame.setLayout(null);

        // If using null layout, set bounds for the label
        heightLabel.setBounds(700, 820 - (int) Math.round(obj.getMaxHeight() * 20), 500, 30);
        timeLabel.setBounds((int) Math.round(obj.getHorizontalDistanceTravelled() * 20), 700, 500, 30);
        finalVelocityLabel.setBounds((int) Math.round(obj.getHorizontalDistanceTravelled() * 20), 730, 800, 30); 
        launchPlatformLabel.setBounds(0, 730 - (int) Math.round(obj.heightOfLaunch) * 20, 500, 30);

        new Thread(content).start();

        frame.setVisible(true);
    }
}
