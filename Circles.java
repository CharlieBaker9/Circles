import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * class which makes circles of random size and color everytime step is called
 *
 * @author Charlie Baker, Dartmouth Spring 2021
 */
public class Circles extends DrawingGUI{
    protected static final int width=800, height=600;
    private int delay=100;
    protected ArrayList<Point> coordinatesOfCircle = new ArrayList<>();
    protected ArrayList<Integer> radiusOfCircle = new ArrayList<>();
    protected ArrayList<Color> colorOfCircle = new ArrayList<>();

    public Circles() {
        super("circles", width, height);
        setTimerDelay(delay);
        startTimer();
        for (int i = 0; i < 50; i++) {
            Point point = new Point((int) (Math.random() * width), (int) (Math.random() * height));
            coordinatesOfCircle.add(point);
            radiusOfCircle.add((int) ((Math.random() * 80) + 20));
            Random color = new Random();
            Color randomColor = new Color(color.nextFloat(), color.nextFloat(), color.nextFloat());
            colorOfCircle.add(randomColor);
        }
    }
    @Override
    public void handleMousePress(int x, int y) {
        int radius = (int) ((Math.random() * 80) + 20);
        radiusOfCircle.add(radius);
        Random color = new Random();
        Color randomColor = new Color(color.nextFloat(), color.nextFloat(), color.nextFloat());
        colorOfCircle.add(randomColor);
        Point point = new Point((int) x - (radius/2), (int) y - (radius/2) );
        coordinatesOfCircle.add(point);
        repaint();
    }
    @Override
    public void draw(Graphics g) {
        for (int i=0; i < coordinatesOfCircle.size(); i++) {
            g.setColor(colorOfCircle.get(i));
            g.fillOval((int) coordinatesOfCircle.get(i).getX(), (int) coordinatesOfCircle.get(i).getY(), radiusOfCircle.get(i), radiusOfCircle.get(i));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { new Circles(); }
        });
    }
}
