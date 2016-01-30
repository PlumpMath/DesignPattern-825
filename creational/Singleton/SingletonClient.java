public class SingletonClient{

    public static void main(String[] args) {

        SingleObject.getInstance().sayHello();
    }
}

class SingleObject{

    private static SingleObject instance = new SingleObject();

    private SingleObject(){}

    public static SingleObject getInstance(){
        return instance;
    }

    public void sayHello(){
        System.out.println("Hello from @Spino9330");
    }
}
