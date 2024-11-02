package exceptions;

/**
 * Exception is thrown if there is no such an id in the collection.
 */
public class IncorrectIdInputException extends Exception
{
    @Override
    public String toString()
    {
        return "There is no such id in the collection.";
    }
}