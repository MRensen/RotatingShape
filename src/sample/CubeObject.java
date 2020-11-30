package sample;

public class CubeObject extends RotatingObject {

    public CubeObject(){
        super();
    }

    @Override
    public RotatingObject init() {
        this.nodes = new double[][] {{-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1},
                {1, -1, -1}, {1, -1, 1}, {1, 1, -1}, {1, 1, 1}};

        this.edges = new int[][] {{0, 1}, {1, 3}, {3, 2}, {2, 0}, {4, 5}, {5, 7}, {7, 6},
                {6, 4}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
        return this;
    }
}
