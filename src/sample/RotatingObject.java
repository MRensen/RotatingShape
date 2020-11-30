package sample;
import java.awt.*;
import java.awt.event.ActionEvent;
import static java.lang.Math.*;
import javax.swing.*;
import java.util.Date;
import java.util.TimerTask;

public abstract class RotatingObject extends JPanel {
    // colors for testing: black, bordeau, darkgreen, darkblue, yellowgreen, purple, aqua, grey
    int[][] colors = {{0,0,0}, {100,0,0}, {0,100,0}, {0,0,100}, {100,100,0},{100,0,100},{0,100,100},{100,100,100}};
    double[][] nodes;

    int[][] edges;

    public abstract RotatingObject init();

    public RotatingObject() {
        init();
        setPreferredSize(new Dimension(640, 640));
        setBackground(Color.white);

        scale(100);
        if(nodes != null && edges != null) {
            rotateObject(PI / 90, atan(sqrt(2)));

            new Timer(17, (ActionEvent e) -> {
                rotateObject(Math.PI / 180, 0);
                repaint();
            }).start();
        } else {
            System.out.println("nodes and edges not initiated");
        }
    }


    private void scale(double s) {
        for (double[] node : nodes) {
            node[0] *= s;
            node[1] *= s;
            node[2] *= s;
        }
    }

    private void rotateObject(double angleX, double angleY) {
        double sinX = sin(angleX);
        double cosX = cos(angleX);

        double sinY = sin(angleY);
        double cosY = cos(angleY);

        for (double[] node : nodes) {
            double x = node[0];
            double y = node[1];
            double z = node[2];

            node[0] = x * cosX - z * sinX;
            node[2] = z * cosX + x * sinX;

            z = node[2];

            node[1] = y * cosY - z * sinY;
            node[2] = z * cosY + y * sinY;
        }
    }

    void drawObject(Graphics2D g) {
        int color = 0;
        g.translate(getWidth() / 2, getHeight() / 2);

        for (int[] edge : edges) {
            double[] xy1 = nodes[edge[0]];
            double[] xy2 = nodes[edge[1]];
            g.drawLine((int) round(xy1[0]), (int) round(xy1[1]),
                    (int) round(xy2[0]), (int) round(xy2[1]));
        }

        for (double[] node : nodes) {
            //fill colors for testing
            g.setColor(new Color(colors[color][0], colors[color][1], colors[color][2]));
            g.fillOval((int) round(node[0]) - 4, (int) round(node[1]) - 4, 8, 8);
            color++;
        }
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        drawObject(g);
    }


}