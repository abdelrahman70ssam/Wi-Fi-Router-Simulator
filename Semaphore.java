import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Semaphore {
    protected int value ;
    private PrintWriter printWriter ;

    protected Semaphore() throws IOException { value = 0 ; }
    protected Semaphore(int initial) throws IOException { value = initial ; }
    public synchronized void acquire(Device client ) {
        value--;
        if (value < 0) {
            try {
                LogFile.sharedFile.printf("( %s ) ( %s ) : arrived and waiting \n", client.name, client.type);
                wait();
            } catch (InterruptedException e) {

            }
        }
        else{
            LogFile.sharedFile.printf("( %s ) ( %s ) : arrived \n", client.name, client.type);
        }
    }
    public synchronized void release() {
        value++ ;
        if (value <= 0) {
            notify();
        }
    }
}
