package loggingframework;

public class LogConfiguration {

    private LogLevel level;

    private OutputDestination destination;

    public LogConfiguration(LogLevel level, OutputDestination destination) {
        this.level = level;
        this.destination = destination;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public OutputDestination getDestination() {
        return destination;
    }

    public void setDestination(OutputDestination destination) {
        this.destination = destination;
    }
}
