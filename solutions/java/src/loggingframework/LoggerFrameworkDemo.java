package loggingframework;

public class LoggerFrameworkDemo {

    public static void main(String[] args) {
        Logger log = Logger.getInstance();
        log.info("Starting to print logs");

        log.setLoggerConfig(new LogConfiguration(LogLevel.DEBUG, new FileDestination()));
        log.debug("Logger in debug mode");

        log.setLoggerConfig(new LogConfiguration(LogLevel.ERROR, new ConsoleDestination()));
        log.error("Printing an error log");

        log.setLoggerConfig(new LogConfiguration(LogLevel.FATAL, new ConsoleDestination()));
        log.fatal("Fatal error occured");
    }
}
