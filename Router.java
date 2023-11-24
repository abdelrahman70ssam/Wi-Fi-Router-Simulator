import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Router {
    private final int maxClients ;
    private Semaphore semaphore ;
    private ArrayList<Device> devices = new ArrayList<>();
    public Router(int maxClients) throws IOException {
        this.maxClients = maxClients;
        semaphore = new Semaphore(maxClients);
    }

    public void addConnection(Device client){
        semaphore.acquire(client);
        devices.add(client);
    }

    public void removeConnection(Device client){
        semaphore.release();
        devices.remove(client);
    }

}
