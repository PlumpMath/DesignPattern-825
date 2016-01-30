
public class AbstractFactoryClient{

    public static void main(String[] args) {
        AbstractFactory abstractFactory;
        Canvas canvas;
        Color color;

        abstractFactory = FactoryProducer.getFactory("canvas");
        abstractFactory.getCanvas("screen").createCanvas();
        abstractFactory.getCanvas("printer").createCanvas();

        abstractFactory = FactoryProducer.getFactory("color");
        abstractFactory.getColor("red").fill();
        abstractFactory.getColor("green").fill();
    }
}

interface Canvas {
   void createCanvas();
}

interface Color{
    void fill();
}

class ScreenCanvas implements Canvas{

    @Override
    public void createCanvas(){
        System.out.println("CreateCanvas()::ScreenCanvas");
    }
}

class PrinterCanvas implements Canvas{

    @Override
    public void createCanvas(){
        System.out.println("CreateCanvas()::PrinterCanvas");
    }
}

class Red implements Color{

    @Override
    public void fill(){
        System.out.println("Fill()::Red");
    }
}

class Green implements Color{

    @Override
    public void fill(){
        System.out.println("Fill()::Green");
    }
}

abstract class AbstractFactory {
   abstract Color getColor(String color);
   abstract Canvas getCanvas(String canvas) ;
}

class CanvasFactory extends AbstractFactory{

    @Override
    public Canvas getCanvas(String canvas){
        if(canvas == null)
            return null;

        if(canvas.equalsIgnoreCase("screen"))
            return new ScreenCanvas();

        else if(canvas.equalsIgnoreCase("printer"))
            return new PrinterCanvas();

        else
            return null;
    }

    @Override
    public Color getColor(String color){
        return null;
    }
}

class ColorFactory extends AbstractFactory{

    @Override
    public Color getColor(String color){

        if(color == null)
            return null;

        if(color.equalsIgnoreCase("red"))
            return new Red();
        else if(color.equalsIgnoreCase("green"))
            return new Green();

        else
            return null;
    }

    @Override
    public Canvas getCanvas(String canvas){
        return null;
    }
}

class FactoryProducer {

    public static AbstractFactory getFactory(String choice){

        if(choice.equalsIgnoreCase("canvas"))
            return new CanvasFactory();

        else if(choice.equalsIgnoreCase("color"))
            return new ColorFactory();

        return null;
    }
}
