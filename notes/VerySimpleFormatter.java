import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

public class VerySimpleFormatter extends Formatter
{
    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

    @Override
    public String format(final LogRecord record)
    {
        return String.format(
                "%1$s %2$-7s %3$s\n",
                new SimpleDateFormat(PATTERN).format(
                    new Date(record.getMillis())),
                record.getLevel().getName(), formatMessage(record));
    }
}
