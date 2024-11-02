package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;

/**
 * Class that describes the "min_by_creation_date" command.
 */
public class MinByCreationDate extends Command
{
    private CollectionInteractor collectionInteractor;

    public MinByCreationDate(CollectionInteractor collectionInteractor, Console console)
    {
        super("min_by_creation_date", "printing any worker with the lowest value of the creationDate field", console);
        this.collectionInteractor = collectionInteractor;
    }

    /**
     * Method that prints the element with the lowest of the creationDate field.
     *
     * @param args of the command line.
     */
    public void command(String[] args)
    {
        try
        {
            if (args.length != 0)
            {
                throw new IncorrectCmdArgsException();
            }
            console.print(collectionInteractor.getMinByCreationDate().toString());
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}