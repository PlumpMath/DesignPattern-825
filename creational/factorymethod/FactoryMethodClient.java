package factorymethod;

public class FactoryMethodClient{

    public static void main(String[] args) {

        CanvasFactory canvasFactory = new CanvasFactory();
        Canvas canvas;

        canvas = canvasFactory.getCanvas("screen");
        canvas.createCanvas();

        canvas = canvasFactory.getCanvas("printer");
        canvas.createCanvas();
    }
}

interface Canvas {
   void createCanvas();
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

class CanvasFactory{

    public Canvas getCanvas(String canvas){

        if(canvas == null)
            return null;

        if(canvas.equalsIgnoreCase("printer"))
            return new PrinterCanvas();

        else if(canvas.equalsIgnoreCase("screen"))
            return new ScreenCanvas();

        else
            return null;
    }
}
