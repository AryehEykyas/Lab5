package commands;

import classes.Worker;
import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;

/**
 * Class that describes "remove_greater {element} command".
 */
public class RemoveGreater extends InteractionWithWorker
{
    private CollectionInteractor collectionInteractor;
    private Worker worker;

    public RemoveGreater(CollectionInteractor collectionInteractor, Console console)
    {
        super("remove_greater", "remove all the workers that are greater than the given one", console);
        this.collectionInteractor = collectionInteractor;
    }

    public void setWorker(Worker worker)
    {
        this.worker = worker;
    }

    @Override
    public void getArgsValidation(String[] args) throws IncorrectCmdArgsException
    {
        if (args.length != 0)
        {
            throw new IncorrectCmdArgsException();
        }
    }

    /**
     * Methods that removes all the workers that are greater than the given one.
     */
    public void command(String[] args)
    {
        collectionInteractor.removeGreater(worker);
    }
}