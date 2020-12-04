package sample;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import static java.lang.Math.*;


public class SphereObject extends RotatingObject {
    double angle;

    private int[][] edges2 = {{0, 1}, {1, 2}, {3, 2}, {4, 3}, {4, 5}, {5,0}, {0,3}, {1,4}, {2,5}};
    public SphereObject() {
        super();
    }
    // colors: black, bordeau, darkgreen, darkblue, yellowgreen, purple, aqua, grey
    @Override
    public RotatingObject init() {
        this.nodes = new double[][] { {sin(90), cos(90), 0}, {sin(135), cos(135), 0}, {sin(180), cos(180), 0},
                {sin(225), cos(225), 0}, {sin(270), cos(270), 0}, {sin(315), cos(315), 0}};

        this.edges = new int[][] {{0, 1}, {1, 2}, {3, 2}, {4, 3}, {4, 5}, {5,0}, {0,3}, {1,4}, {2,5}};

        return null;
    }

    @Override
    void rotateObject(double angleX, double angleY) {
        this.angle = angleX;
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
            //drawOval(graphic, (int)node[0], (int)node[1], 2*radius, angleX);
            //degree = (degree + 45)%360;

        }
    }

    @Override
    void drawObject(Graphics2D g) {
//        System.out.println(Math.toDegrees(atan((sin(90)))));
//        int color = 0;
//        g.translate(getWidth() / 2, getHeight() / 2);
//
//        int degree = 45;
//        double x = sin(degree);
//        int r = 100;
//
//        for (int[] edge : edges) {
//            double[] xy1 = nodes[edge[0]];
//            double[] xy2 = nodes[edge[1]];
//            //g.drawOval(0-r, 0-r, r*2, r*2);
//            //g.rotate(Math.toRadians(degree));
//
//            if (edge == edges[0] || edge == edges[1] || edge == edges[2] || edge == edges[3] || edge == edges[4]) {
//                //g.drawArc((int) round(xy1[0] - r), (int) round(xy1[1] - r), r * 2, r * 2, 0, 180);
//            } else {
//
//            }
//
//
//              //      g.drawLine((int) round(xy1[0]), (int) round(xy1[1]),(int) round(xy2[0]), (int) round(xy2[1]));
//            degree += 45;
//        }
//
//        for (double[] node : nodes) {
//            //fill colors for testing
//            g.setColor(new Color(colors[color][0], colors[color][1], colors[color][2]));
//            AffineTransform old = g.getTransform();
//            drawOval(g, (int) round(node[0]) - r, (int) round(node[1]), 2*radius, angle);
//            //g.rotate(5,5);
//            g.setTransform(old);
//            color++;
//        }
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        drawOval(g);
    }

    private void drawOval(Graphics2D g){
        int degree = 45;
        int radius = 100;
        int height = 2*radius;
        Graphics2D graphic;


        g.translate(getWidth() / 2, getHeight() / 2);


        for (double[] node : nodes) {
            double width = ((200 * cos(angle) - (200 * sin(angle))) + degree)%200;
            int x = (int)round(node[0] + radius);
            int y = (int)round(node[1] + radius);

            g.drawOval(x , 0, (int) width, height);
            System.out.println( x +" " + y + " " + height + " " + angle + " " + width);
            degree = (degree + 45)%360;
        }
    }
}
