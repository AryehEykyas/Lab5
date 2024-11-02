package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;

/**
 * Class that describes the "print_ascending" command.
 */
public class PrintAscending extends Command
{
    private CollectionInteractor collectionInteractor;

    public PrintAscending(CollectionInteractor collectionInteractor, Console console)
    {
        super("print_ascending", "printing the elements of the collection in ascenging order", console);
        this.collectionInteractor = collectionInteractor;
    }

    /**
     * Method that sorts the elements of the collection in ascending order(sorted by their salaries).
     */
    public void command(String[] args)
    {
        try
        {
            if (args.length != 0)
            {
                throw new IncorrectCmdArgsException();
            }
            collectionInteractor.printAscending();
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}