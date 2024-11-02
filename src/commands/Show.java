package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;

/**
 * Class that describes the "show" command.
 */
public class Show extends Command
{
    private CollectionInteractor collectionInteractor;

    public Show(CollectionInteractor collectionInteractor, Console console)
    {
        super("show", "printing out all the elements of the collection", console);
        this.collectionInteractor = collectionInteractor;
    }

    /**
     * printing out the concrete elements.
     */
    public void command(String[] args)
    {
        try
        {
            if (args.length != 0)
            {
                throw new IncorrectCmdArgsException();
            }
            collectionInteractor.printAllElements();
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}