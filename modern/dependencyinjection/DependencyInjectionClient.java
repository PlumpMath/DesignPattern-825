package dependencyinjection;

public class DependencyInjectionClient{
    public static void main(String[] args) {

        MyApplication app;

        app = new MyApplication(new EmailServiceImpl());
        app.processMessages("Hi John", "johndoe@mail.com");

        app = new MyApplication(new SMSServiceImpl());
        app.processMessages("Hi John", "3466408077");
    }
}

interface MessageServiceInjector {

    public Consumer getConsumer();
}

interface MessageService {

    void sendMessage(String msg, String rec);
}

interface Consumer {

    void processMessages(String msg, String rec);
}

class EmailServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send email
        System.out.println("Email sent to "+rec+ " with Message="+msg);
    }

}

class SMSServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send SMS
        System.out.println("SMS sent to "+rec+ " with Message="+msg);
    }

}

class MyApplication {

    private MessageService service = null;

    public MyApplication(MessageService svc){
        this.service=svc;
    }

    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }
}

class MyDIApplication implements Consumer{

    private MessageService service;

    public MyDIApplication(MessageService svc){
        this.service=svc;
    }

    @Override
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }

}
