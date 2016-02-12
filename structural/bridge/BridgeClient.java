package bridge;

public class BridgeClient{

    public static void main(String[] args) {

        Shape redCircle = new Circle(100,100,10,new RedCircle());
        Shape greenCircle = new Circle(100,100,10,new GreenCircle());

        Shape redSquare = new Square(10,new GreenCircle());

        redCircle.draw();
        greenCircle.draw();

        redSquare.draw();
    }
}

//Implementazione

interface DrawApi{
    public void drawShape(int radius,int x,int y);
    public void drawShape(int l);
}

class RedCircle implements DrawApi{

    @Override
    public void drawShape(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }

    @Override
    public void drawShape(int l){
        return;
    }
}

class GreenCircle implements DrawApi{

    @Override
    public void drawShape(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }

    @Override
    public void drawShape(int l){
        System.out.println("Drawing Square[ color: green, lato: "+l+"]");
    }
}

//Astrazione

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
        drawApi.drawShape(radius,x,y);
    }
}

class Square extends Shape{

    private int l;

    public Square(int l,DrawApi drawApi){
        super(drawApi);
        this.l = l;
    }

    @Override
    public void draw(){
        drawApi.drawShape(l);
    }
}
