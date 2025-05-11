package loggingframework;

public class ConsoleDestination implements OutputDestination{

    public ConsoleDestination() {
    }

    @Override
    public void addLog(LogMessage message) {
        System.out.println(message.toString());
    }
}
