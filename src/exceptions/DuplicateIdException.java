package exceptions;

/**
 * Exception is thrown any time when used id is already in the collection.
 */
public class DuplicateIdException extends Exception
{
    @Override
    public String toString()
    {
        return "This id is already in the collection";
    }
}