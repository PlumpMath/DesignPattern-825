package observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverClient{

    public static void main(String[] args) {

        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        System.out.println("\nFirst state change: 15");
        subject.setState(15);
        System.out.println("\nSecond state change: 10");
        subject.setState(10);
    }
}

class Subject{
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObserver(){

        for (Observer observer: observers) {
            observer.update();
        }
    }
}

abstract class Observer {
   protected Subject subject;
   public abstract void update();
}

class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState()));
    }
}

class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState()));
    }
}

class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println( "Hexa String: " + Integer.toHexString( subject.getState()));
    }
}
