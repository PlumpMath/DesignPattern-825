public class FactoryMethodDemo{

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}

//Shape interface
interface Shape {
   void draw();
}

//classes that implement Shape interface
class Rectangle implements Shape{

    @Override
    public void draw(){

        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Circle implements Shape{

    @Override
    public void draw(){
        System.out.println("Inside Circle::draw() method.");
    }
}

class Square implements Shape {

    @Override
    public void draw(){
        System.out.println("Inside Square::draw() method.");
    }
}

//Factory class
class ShapeFactory {
   //use getShape method to get object of type shape
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }
}
