package exceptions;

/**
 * Exception is thrown when a non-existent command is called.
 */
public class NonExistentCommandException extends Exception
{
    @Override
    public String toString()
    {
        return "Non-Existent command is being called.";
    }
}