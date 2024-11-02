package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;
import interactors.Validator;

/**
 * Class the describes the "remove_by_id id" command.
 */
public class RemoveById extends Command
{
    private CollectionInteractor collectionInteractor;

    public RemoveById(CollectionInteractor collectionInteractor, Console console)
    {
        super("remove_by_id", "remove an element from the collection by its id", console);
        this.collectionInteractor = collectionInteractor;
    }

    /**
     * Methor that removes an element from the collection by its id.
     */
    public void command(String[] args)
    {
        try
        {
            if (args.length != 1 || !Validator.isLong(args[0]))
            {
                throw new IncorrectCmdArgsException();
            }
            long id = Long.parseLong(args[0]);
            collectionInteractor.remove(id);
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}