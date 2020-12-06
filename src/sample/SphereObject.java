package sample;

import java.awt.*;

import static java.lang.Math.*;


public class SphereObject extends RotatingObject {



    public SphereObject() {
        super();
    }
    // colors: black, bordeau, darkgreen, darkblue, yellowgreen, purple, aqua, grey
    @Override
    public void init() {
//        this.nodes = new double[][] {{sin(45), cos(45), 0}, {sin(90), cos(90), 0}, {sin(135), cos(135), 0}, {sin(180), cos(180), 0},
//                {sin(225), cos(225), 0}, {sin(270), cos(270), 0}, {sin(315), cos(315), 0}, {sin(360), cos(360), 0}};
//        this.edges = new int[][] {{0, 45}, {0, 90}, {0, 135}, {0, 180}, {0, 225}, {0, 270}, {0, 315}, {0, 360}};

        this.nodes = new double[][] {{sin(90), cos(90), 0},{sin(180), cos(180), 0},
                {sin(270), cos(270), 0},{sin(360), cos(360), 0}};
        this.edges = new int[][] { {200, 90},{200, 180}, {200, 270}, {200, 360}};


    }

    @Override
    void rotateObject(double angleX, double angleY) {
        int widthCounter = 0;
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
            //edges[widthCounter][0] = (int)((edges[widthCounter][0]*sin(edges[widthCounter][1]))  )%200;
            widthCounter++;

        }
    }

    @Override
    void drawObject(Graphics2D g) {
        int radius = 100;



        int color = 0;


        g.translate(getWidth() / 2, getHeight() / 2);


        for (int[] width : edges) {
            int height = 2*radius;
            int x = 0 - (width[0]/2);
            int y = 0 - radius;

            g.setColor(new Color(colors[color][0], colors[color][1], colors[color][2]));
            g.drawOval(x  , y , width[0], height);

            width[0] = (int)((width[0]*abs(sin(width[1]))) +  (width[0]*abs(cos(width[1]))) )%200;
            System.out.println( x +" " + y + " " + height + " " + " " + width[0]);
            color++;

        }
    }



}
