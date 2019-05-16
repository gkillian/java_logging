package gaknet;

import java.io.IOException;
import java.io.InputStream;

import java.util.Date;

import java.util.logging.ConsoleHandler;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * App3:  java.util.logging test
 *        programatically setting format
 *
 */
public class App3
{
    private static Logger LOGGER = null;

    static
    {
        Logger mainLogger = Logger.getLogger("gaknet");
        mainLogger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

            @Override
            public synchronized String format(LogRecord lr)
            {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        });
        mainLogger.addHandler(handler);
        LOGGER = Logger.getLogger(App3.class.getName());
    }

    public static void main( String[] args )
    {
        System.out.println( "java util logging test: programatically setting format");
        System.out.println("-- main method starts --");
        LOGGER.info("in App");
        LOGGER.warning("a test warning");
    }
}
