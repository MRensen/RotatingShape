package sample;

import javafx.scene.shape.Circle;

public class vertex {
    private int x;
    private int y;
    private int z;
    private Circle circle;

    public vertex(int x, int y, int z){
        x = x;
        y = y;
        z = z;
        circle = new Circle(this.x ,this.y, 5);
    }

    public Circle getCircle(){
        return circle;
    }

    public void move(int x, int y, int z){

    }

}
