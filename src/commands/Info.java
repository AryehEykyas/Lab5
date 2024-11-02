package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;

/**
 * Class that describes the "info" command.
 */
public class Info extends Command
{
    private CollectionInteractor collectionInterface;

    public Info(CollectionInteractor collectionInterface, Console console)
    {
        super("info", "printing out information about the collection", console);
        this.collectionInterface = collectionInterface;
    }

    /**
     * printing out the whole information.
     */
    public void command(String[] args)
    {
        try
        {
            if (args.length == 0)
            {
                throw new IncorrectCmdArgsException();
            }
            collectionInterface.printInfo();
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}