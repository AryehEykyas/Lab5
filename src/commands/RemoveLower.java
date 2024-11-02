package commands;

import classes.Worker;
import exceptions.IncorrectIdInputException;
import interactors.CollectionInteractor;
import interactors.Console;

/**
 * Class that describes "remove_lower {element}" command.
 */
public class RemoveLower extends InteractionWithWorker
{
    private Worker worker;
    private CollectionInteractor collectionInteractor;

    public RemoveLower(CollectionInteractor collectionInteractor, Console console)
    {
        super("remove_lower", "removes all the workers that are lower than the given one", console);
        this.collectionInteractor = collectionInteractor;
    }

    public void setWorker(Worker worker)
    {
        this.worker = worker;
    }

    @Override
    public void getArgsValidation(String[] args) throws IncorrectIdInputException
    {
        if (args.length != 0)
        {
            throw new IncorrectIdInputException();
        }
    }

    /**
     * Method that removes all the workers that are lower than the given one.
     */
    public void command(String[] args)
    {
        collectionInteractor.removeLower(worker);
    }
}