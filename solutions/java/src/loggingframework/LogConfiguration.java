package loggingframework;

public class LogConfiguration {

    private final LogLevel level;

    private final OutputDestination destination;

    public LogConfiguration(LogLevel level, OutputDestination destination) {
        this.level = level;
        this.destination = destination;
    }

    public LogLevel getLevel() {
        return level;
    }

    public OutputDestination getDestination() {
        return destination;
    }
}
