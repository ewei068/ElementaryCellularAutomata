import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;


public class Drawing extends Canvas {
    public int rule;
    /*public static void main(String[] args) {

        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Drawing();
        canvas.setSize(400, 800);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

    }

     */
    public void paint(Graphics g) {
        //Rectangle bb = new Rectangle(100, 100, 200, 200);
        //mickey(g, bb);
        int[] start = new int[199];
        start[99] = 1;
        CA _ca = new CA(rule, start);

        int x = 0;
        while (_ca.y < 1000) {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            _ca.display(g);
        }
    }
}
