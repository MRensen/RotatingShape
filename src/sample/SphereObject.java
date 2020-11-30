package sample;

import java.awt.*;

import static java.lang.Math.round;

public class SphereObject extends RotatingObject {
    public SphereObject() {
        super();
    }

    @Override
    public RotatingObject init() {
        this.nodes = new double[][] {{-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1},
                {1, -1, -1}, {1, -1, 1}, {1, 1, -1}, {1, 1, 1}};

        this.edges = new int[][] {{0, 1}, {1, 3}, {3, 2}, {2, 0}, {4, 5}, {5, 7}, {7, 6},
                {6, 4}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
        return null;
    }

    @Override
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
}
