package loggingframework;

public class Logger {

    private static Logger logger;

    private LogConfiguration logConfig;


    private Logger(){
        // creates default configuration
        logConfig = new LogConfiguration(LogLevel.INFO, new ConsoleDestination());
    }

    public static Logger getInstance(){
        if(logger==null){
            logger = new Logger();
            return logger;
        }
        return logger;
    }

    public void setLoggerConfig(LogConfiguration config){
        this.logConfig = config;
    }

    public void log(LogLevel level, String message){
        if(level.ordinal()>=logConfig.getLevel().ordinal()){
            LogMessage logMessage = new LogMessage(level, message);
            logConfig.getDestination().addLog(logMessage);
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }



}
