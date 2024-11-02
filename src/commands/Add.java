package commands;

import classes.Worker;
import exceptions.DuplicateIdException;
import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;

/**
 * Class that describes the "add element" command.
 */
public class Add extends InteractionWithWorker
{
    private Worker worker;
    private CollectionInteractor collectionInteractor;

    public Add(CollectionInteractor collectionInteractor, Console console)
    {
        super("add", "adding a new worker to a collection", console);
        this.collectionInteractor = collectionInteractor;
    }

    public void setWorker(Worker worker)
    {
        this.worker = worker;
    }

    /**
     * Checks that the command args satisfy the requirements.
     * @param args of a command (if existed).
     * @throws IncorrectCmdArgsException exception is thrown.
     */
    public void getArgsValidation(String[] args) throws IncorrectCmdArgsException
    {
        if (args.length != 0)
        {
            throw new IncorrectCmdArgsException();
        }
    }

    /**
     * Adding a new worker to the collection.
     */
    public void command(String[] args)
    {
        try
        {
            collectionInteractor.add(worker);
        }
        catch (DuplicateIdException e)
        {
            console.print(e.toString());
        }
    }
}