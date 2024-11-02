package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;

/**
 * Class that describes the "head" commend.
 */
public class Head extends Command
{
    private CollectionInteractor collectionInteractor;

    public Head(CollectionInteractor collectionInteractor, Console console)
    {
        super("head", "returns the first element of the collection", console);
        this.collectionInteractor = collectionInteractor;
    }

    /**
     * Method that returns the first element.
     */
    public void command(String[] args)
    {
        try
        {
            if (args.length != 0)
            {
                throw new IncorrectCmdArgsException();
            }
            if (collectionInteractor.isEmpty())
            {
                console.print("Collection is empty");
            }
            else
            {
                console.print(collectionInteractor.getHead().toString());
            }
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}