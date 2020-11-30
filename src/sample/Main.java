package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Set;
import java.util.TimerTask;

public class Main{
    static JButton Cube;
    static JButton Triangle;
    static JButton Sphere;
    static ButtonGroup buttons = new ButtonGroup();

    private static JPanel setupButtonPanel(int height, int width){
        JPanel jp = new JPanel(new GridLayout(3,1));
        //instantiate buttons
        Cube = new JButton("Cube");
        Triangle = new JButton("Triangle");
        Sphere = new JButton("Sphere");
        //add buttons to panel
        jp.add(Cube);
        jp.add(Triangle);
        jp.add(Sphere);
        // fit panel to frame
        jp.resize(height, width/5);
        //add buttons to group
        buttons.add(Cube);
        buttons.add(Triangle);
        buttons.add(Sphere);
        return jp;
    }

    private static void JButtonControllers(){
        // create actionlisteners
        ActionListener cubeAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetupRotatingObject(new CubeObject());
            }
        };
        ActionListener triangleAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SetupRotatingObject(new TriangleObject());
            }
        };
        ActionListener sphereAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SetupRotatingObject(new SphereObject());
            }
        };
        // bind actionlisteners to objects
        Cube.addActionListener(cubeAL);
        Triangle.addActionListener(triangleAL);
        Sphere.addActionListener(sphereAL);
    }


    private static void SetupRotatingObject(RotatingObject shape){
        // setup JFrame and run the RotatingObject
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Rotating Object");
        f.setResizable(false);
        f.add(shape.init(), BorderLayout.CENTER);
        f.add(setupButtonPanel(f.getHeight(), f.getWidth()), BorderLayout.WEST);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        // and close again after 5 seconds for test purposes
        new TimedExit(f);
    }


    public static void main(String[] args) {

        int rotatingObject;
        SwingUtilities.invokeLater(() -> {
            SetupRotatingObject(new CubeObject());
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

