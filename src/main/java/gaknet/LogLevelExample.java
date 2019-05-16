package gaknet;

import java.lang.reflect.Field;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;

public class LogLevelExample
{
    private static Logger log = Logger.getLogger(LogLevelExample.class.getName());

    static
    {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                        "[%1$tF %1$tT %1$tL] [%4$-7s] %5$s %n");
    }

    public static void main(String[] args) throws Exception
    {
        setLevel(Level.ALL);
        Set<Level> levels = getAllLevels();
        int i = 1;
        for (Level level : levels)
        {
            log.log(level, level.getName() + " - " + (i++));
        }
    }

    public static void setLevel(Level targetLevel)
    {
        Logger root = Logger.getLogger("");
        root.setLevel(targetLevel);
        for (Handler handler : root.getHandlers())
        {
            handler.setLevel(targetLevel);
        }
        System.out.println("level set: " + targetLevel.getName());
    }

    public static Set<Level> getAllLevels() throws IllegalAccessException
    {
        Class<Level> levelClass = Level.class;

        Set<Level> allLevels = new TreeSet<>(
                Comparator.comparingInt(Level::intValue));

        for (Field field : levelClass.getDeclaredFields())
        {
            if (field.getType() == Level.class)
            {
                allLevels.add((Level) field.get(null));
            }
        }
        return allLevels;
    }
}
