package sample;

import java.awt.*;

import static java.lang.Math.*;


public class SphereObject extends RotatingObject {
    final int[][] edges2 = {{0, 1}, {1, 2}, {3, 2}, {4, 3}, {4, 5}, {5,0}, {0,3}, {1,4}, {2,5}};
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
    void drawObject(Graphics2D g) {
        System.out.println(asin((sin(90))));
        int color = 0;
        g.translate(getWidth() / 2, getHeight() / 2);

        int degree = 45;
        double x = sin(degree);
        int r = 100;

        for (int[] edge : edges) {
            double[] xy1 = nodes[edge[0]];
            double[] xy2 = nodes[edge[1]];

            switch(edge) {
                case edges2[0]:
                case edges2[1]:
                case edges2[2]:
                case edges2[3]:
                case edges2[4]:
                    g.drawArc((int) round(xy1[0] - r), (int) round(xy1[1] - r), r * 2, r * 2, 0, 180);
                    break;
                case edges2[5]:
                case edges2[6]:
                case edges2[7]:
                    break;
                default:
                    break;
            }

                    g.drawLine((int) round(xy1[0]), (int) round(xy1[1]),(int) round(xy2[0]), (int) round(xy2[1]));
            degree += 45;
        }

        for (double[] node : nodes) {
            //fill colors for testing
            g.setColor(new Color(colors[color][0], colors[color][1], colors[color][2]));
            g.fillOval((int) round(node[0]) - 4, (int) round(node[1]) - 4, 8, 8);
            color++;
        }
    }
}
