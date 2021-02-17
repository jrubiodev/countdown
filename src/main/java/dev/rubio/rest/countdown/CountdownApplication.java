package dev.rubio.rest.countdown;

import dev.rubio.rest.countdown.logger.LoggerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
This program makes a countdown starting from the value of the argument passed.
Made by Javier Rubio.
 */

@SpringBootApplication
public class CountdownApplication {
    //CONSTANTS
    public static final long STARTTIME = System.currentTimeMillis();

    //Declared to make args accessible in other classes
    private static String[] savedArgs;

    static class CmdLineArgs {
        public static String[] getArgs() {
            return savedArgs;
        }
    }

    public static void main(String[] args) {
        LoggerController logger = new LoggerController();

        if (args.length == 0) {
            logger.addLogEntry(null, "severe", "Argument not provided. Closing the application.");
            System.exit(0);
        } else {
            try {
                Integer.parseInt(args[0]);
                savedArgs = args;
                logger.addLogEntry(null, "info", "Application started.");
            } catch (NumberFormatException ex) {
                logger.addLogEntry(ex, "severe", "Argument must be an Integer. Closing the application.");
                System.exit(0);
            } catch (Exception ex) {
                logger.addLogEntry(ex, "severe", "Impossible to start the application.");
            }
        }
        SpringApplication.run(CountdownApplication.class, args);

    }
}
