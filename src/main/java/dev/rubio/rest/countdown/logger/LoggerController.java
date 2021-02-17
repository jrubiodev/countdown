package dev.rubio.rest.countdown.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
Class made to manage app log files.
Made by Javier Rubio.
 */

public class LoggerController {

    protected static final Logger logger = Logger.getLogger("COUNTDOWNLOG");

    public LoggerController() {
    }

    //Adds a new record to the log file
    public static void addLogEntry(Exception ex, String level, String message) {
        boolean append = true;
        FileHandler fileHandler = null;
        try {
            FileHandler handler = new FileHandler("logs/log%g.xml", append);
            logger.addHandler(handler);
            switch (level) {
                case "severe":
                    logger.log(Level.SEVERE, message, ex);
                    break;
                case "warning":
                    logger.log(Level.WARNING, message, ex);
                    break;
                case "info":
                    logger.log(Level.INFO, message, ex);
                    break;
                case "debug":
                    logger.log(Level.CONFIG, message, ex);
                    break;
            }
            handler.close();

        } catch (IOException | SecurityException ex1) {
            logger.log(Level.SEVERE, null, ex1);
        }
    }
}
