package dev.rubio.rest.countdown;

import dev.rubio.rest.countdown.logger.LoggerController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
Controller class for the countdown resource.
Made by Javier Rubio.
 */
@RestController
public class CountdownController {
    //GET countdown resource
    @RequestMapping(method = RequestMethod.GET, path = "/countdown", produces = "application/json")
    public long countdown() {
        LoggerController logger = new LoggerController();
        try {
            String[] args = CountdownApplication.CmdLineArgs.getArgs();
            if (System.currentTimeMillis() > (CountdownApplication.STARTTIME + (Integer.parseInt(args[0]) * 1000))) {
                return 0;
            } else {
                logger.addLogEntry(null, "info", "GET countdown resource has been accessed.");
                return Integer.parseInt(args[0]) - ((System.currentTimeMillis() - CountdownApplication.STARTTIME) / 1000);
            }
        } catch (Exception ex) {
            logger.addLogEntry(ex, "severe", "Error processing the request");
            return 0;
        }

    }
}
