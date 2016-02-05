package bridge;

public class BridgeClient{

    public static void main(String[] args) {

        Shape redCircle = new Circle(100,100,10,new RedCircle());
        Shape greenCircle = new Circle(100,100,10,new GreenCircle());

        redCircle.draw();
        greenCircle.draw(); 
    }
}

interface DrawApi{
    public void drawCircle(int radius,int x,int y);
}

class RedCircle implements DrawApi{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

class GreenCircle implements DrawApi{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

abstract class Shape{

    protected DrawApi drawApi;

    protected Shape(DrawApi drawApi){
        this.drawApi = drawApi;
    }

    public abstract void draw();
}

class Circle extends Shape{

    private int x,y,radius;

    public Circle(int radius, int x, int y, DrawApi drawApi){

        super(drawApi);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(){
        drawApi.drawCircle(radius,x,y);
    }
}
