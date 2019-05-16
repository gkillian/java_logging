package gaknet;

import java.io.IOException;
import java.io.InputStream;

import java.util.logging.Logger;
import java.util.logging.LogManager;

/**
 * App:  java.util.logging test
 *
 */
public class App 
{
    private static Logger LOGGER = null;

    static
    {
        InputStream stream = App.class.getClassLoader().getResourceAsStream("logging.properties");
        if(stream == null)
        {
            System.err.println("unable to open file: logging.properties");
            System.exit(1);
        }
        try
        {
            LogManager.getLogManager().readConfiguration(stream);
            LOGGER= Logger.getLogger(App.class.getName());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        System.out.println( "java util logging test" );

        System.out.println("-- main method starts --");
        LOGGER.info("in App");
        LOGGER.warning("a test warning");
    }
}
