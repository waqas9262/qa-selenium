package core;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerManager {

    private static final Logger logger = Logger.getLogger("FrameworkLogger");

    static {
        try {
            // Build absolute path to log file
            String logPath = System.getProperty("user.dir") + "/logs/framework.log";

            FileHandler fileHandler = new FileHandler(logPath, true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);

        } catch (Exception e) {
            throw new RuntimeException("Could not set up logging", e);
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}