import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

public class Device implements Runnable{

    public String name , type ;
    private Router router ;
    private boolean loggedIN ;

    public Device(String name, String type , Router router ) throws IOException {
        this.name = name;
        this.type = type;
        this.router = router;
    }
    public void connect(){
        router.addConnection(this);
        LogFile.sharedFile.printf("( %s ) ( %s ) : connected \n" , this.name , this.type);

        loggedIN = true;
        LogFile.sharedFile.printf("( %s ) ( %s ) : login \n" , this.name , this.type);

    }


    public void performActivityOnline() throws InterruptedException {
        if(!loggedIN){
            LogFile.sharedFile.println("not logged in ");
            return;
        }
        LogFile.sharedFile.printf("( %s ) ( %s ) : performs online activity \n" , this.name , this.type);
        Thread.sleep((long) (Math.random() * 1000));
    }

    public void disconnect(){
        loggedIN = false;
        router.removeConnection(this);
        LogFile.sharedFile.printf("( %s ) ( %s ) : disconnected \n" , this.name , this.type);

    }


    @Override
    public void run() {
        connect();
        try {
            performActivityOnline();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        disconnect();
        LogFile.sharedFile.flush();
    }

}
