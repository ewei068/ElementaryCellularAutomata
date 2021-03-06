import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class GUI {
    public static void main(String args[]) {
        //Creating the Frame
        JFrame frame = new JFrame("Elementary Cellular Automata Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);


        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Rule (0 to 255):");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        send.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) {
                                       String s1=tf.getText();
                                       //String s2=tf2.getText();
                                       int rule=Integer.parseInt(s1);
                                       newDrawing(rule);
                                   }
                               });
        // JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        // panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        //frame.getContentPane().add(BorderLayout.NORTH, mb);
        //frame.getContentPane().add(BorderLayout.CENTER, ta);
        /*Canvas canvas = new Drawing();
        canvas.setSize(400, 800);
        frame.add(canvas);
        frame.pack();

         */
        frame.setVisible(true);
    }

    static void newDrawing(int rule) {
        JFrame frame2 = new JFrame("Rule " + rule);
        Drawing canvas = new Drawing();
        canvas.setSize(400, 800);
        canvas.rule = rule;

        frame2.add(canvas);
        frame2.pack();
        frame2.setVisible(true);


    }
}
