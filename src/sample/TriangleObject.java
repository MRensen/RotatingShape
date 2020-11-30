package sample;

public class TriangleObject extends RotatingObject {

    public TriangleObject(){
        super();
    }
    // colors: black, bordeau, darkgreen, darkblue, yellowgreen, purple, aqua, grey
    @Override
    public RotatingObject init() {
        this.nodes = new double[][] {{-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1},
                {1, 0, 0}};

        this.edges = new int[][] {{0, 1}, {1, 3}, {3, 2}, {2, 0}, {4, 0}, {4, 1},
                {2, 4}, {3, 4}};
        return this;
    }
}
