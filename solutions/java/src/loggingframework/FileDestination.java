package loggingframework;

import java.io.FileWriter;
import java.io.IOException;

public class FileDestination implements  OutputDestination{

    private final FileWriter writer;

    public FileDestination() {
        try{
            this.writer = new FileWriter("app.log");
        } catch (IOException e) {
            throw new RuntimeException("Unable to create file because "+ e.getMessage());
        }

    }


    @Override
    public void addLog(LogMessage message) {
        try{
            this.writer.write(message.toString()+"\n");
            this.writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to file because "+e.getMessage());
        }
    }
}
