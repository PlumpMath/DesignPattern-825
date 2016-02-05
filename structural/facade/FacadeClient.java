package facade;

public class FacadeClient{

    public static void main(String[] args) {

        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawRectangle();
        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
    }
}

interface Shape{
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw(){
        System.out.println("Rectangle::draw()");
    }
}

class Circle implements Shape{

    @Override
    public void draw(){
        System.out.println("Circle::draw()");
    }
}

class Square implements Shape{

    @Override
    public void draw(){
        System.out.println("Square::draw()");
    }
}

class ShapeMaker{

    private Shape rectangle;
    private Shape circle;
    private Shape square;

    public ShapeMaker(){

        this.rectangle = new Rectangle();
        this.circle = new Circle();
        this.square = new Square();
    }

    public void drawRectangle(){
        this.rectangle.draw();
    }

    public void drawCircle(){
        this.circle.draw();
    }

    public void drawSquare(){
        this.square.draw();
    }
}
