import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static void main(String[] args) throws IOException {

      LogFile file = new LogFile();

        String name , type ;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What is the number of WI-FI Connections?");
        int maxConnections  = scanner.nextInt();
        Router router = new Router(maxConnections);
        
        System.out.println("What is the number of devices Clients want to connect?");
        int numDevices = scanner.nextInt();

        ArrayList<Device> clients = new ArrayList<>();
        for (int i = 0; i < numDevices; i++) {
            name = scanner.next() ;
            type = scanner.next();
            Device client = new Device(name , type , router);
            clients.add(client);
        }

        for (Device client : clients) {
            Thread thread = new Thread(client);
            thread.start();
        }
        /*
        4
        c1 mobile
        c2 tablet
        c3 Pc
        c4 laptop
         */
    }
}
