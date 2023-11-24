import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogFile {
    public static PrintWriter sharedFile ;

    public LogFile() throws IOException {
        sharedFile = new PrintWriter(new FileWriter("logs.txt", true));
    }


}
