package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;

public class Clear extends Command
{
    private CollectionInteractor collectionInteractor;

    public Clear(CollectionInteractor collectionInteractor, Console console)
    {
        super("clear", "clearing the whole collection", console);
        this.collectionInteractor = collectionInteractor;
    }

    /**
     * Clearing the collection.
     */
    public void command(String[] args)
    {
        try
        {
            if (args.length != 0)
            {
                throw new IncorrectCmdArgsException();
            }
            collectionInteractor.clear();
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}