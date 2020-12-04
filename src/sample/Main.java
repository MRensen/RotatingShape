package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.TimerTask;

public class Main{
    static JButton CubeButton;
    static JButton TriangleButton;
    static JButton SphereButton;
    static RotatingObject Shape;
    static JFrame f;

    static ButtonGroup buttons = new ButtonGroup();

    private static JPanel setupButtonPanel(int height, int width){
        JPanel jp = new JPanel(new GridLayout(3,1));
        //instantiate buttons
        CubeButton = new JButton("CubeButton");
        TriangleButton = new JButton("TriangleButton");
        SphereButton = new JButton("SphereButton");
        JButtonControllers();
        //add buttons to panel
        jp.add(CubeButton);
        jp.add(TriangleButton);
        jp.add(SphereButton);
        // fit panel to frame
        jp.resize(height, width/5);
        //add buttons to group
        buttons.add(CubeButton);
        buttons.add(TriangleButton);
        buttons.add(SphereButton);
        return jp;
    }

    private static void JButtonControllers(){
        // create actionlisteners
        ActionListener cubeAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swapObject(new CubeObject());
            }
        };
        ActionListener triangleAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swapObject(new TriangleObject());
            }
        };
        ActionListener sphereAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swapObject(new SphereObject());
            }
        };
        // bind actionlisteners to objects
        CubeButton.addActionListener(cubeAL);
        TriangleButton.addActionListener(triangleAL);
        SphereButton.addActionListener(sphereAL);
    }


    private static void SetupRotatingObject(RotatingObject shape){
        // setup JFrame and run the RotatingObject
        Shape = shape;
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Rotating Object");
        f.setResizable(false);
        f.add(Shape, BorderLayout.CENTER);
        f.add(setupButtonPanel(f.getHeight(), f.getWidth()), BorderLayout.WEST);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        // and close again after 5 seconds for test purposes
       // new TimedExit(f);
    }

    private static void swapObject(RotatingObject shape){
        f.remove(Shape);
        Shape = shape;
        f.add(Shape, BorderLayout.CENTER);
        f.invalidate();
        f.revalidate();
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SetupRotatingObject(new SphereObject());
        });
    }
}

class TimedExit {
    JFrame f;
    java.util.Timer timer = new java.util.Timer();
    TimerTask exitApp = new TimerTask() {
        public void run() {
            System.exit(0);
        }
    };

    public TimedExit(JFrame f) {
        this.f = f;
        timer.schedule(exitApp, new Date(System.currentTimeMillis()+5*1000));
    }

}

