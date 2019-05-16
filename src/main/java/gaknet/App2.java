package gaknet;

import java.io.IOException;
import java.io.InputStream;

import java.util.logging.Logger;
import java.util.logging.LogManager;

/**
 * App2:  java.util.logging test
 *        Using system property
 *
 */
public class App2 
{
    private static Logger LOGGER = null;

    static
    {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                              "[%1$tF %1$tT] [%4$-7s] %5$s %n");
              LOGGER = Logger.getLogger(App2.class.getName());
    }

    public static void main( String[] args )
    {
        System.out.println( "java util logging test: Using system property" );

        System.out.println("-- main method starts --");
        LOGGER.info("in App2");
        LOGGER.warning("a test warning");
    }
}
