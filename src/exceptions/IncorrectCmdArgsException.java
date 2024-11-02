package exceptions;

/**
 * Exception is thrown when the incorrect command arguments are passed.
 */
public class IncorrectCmdArgsException extends Exception
{
    @Override
    public String toString()
    {
        return "Incorrect command arguments are passed.";
    }
}
