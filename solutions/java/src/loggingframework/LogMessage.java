package loggingframework;

public class LogMessage {
    private final long timestamp;
    private final LogLevel level;
    private final String message;

    public LogMessage(LogLevel level, String message) {
        this.level = level;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "timestamp='" + timestamp + '\'' +
                ", level=" + level +
                ", message='" + message + '\'' +
                '}';
    }
}
