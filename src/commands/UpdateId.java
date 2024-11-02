package commands;

import classes.Worker;
import exceptions.IncorrectCmdArgsException;
import exceptions.IncorrectIdInputException;
import interactors.CollectionInteractor;
import interactors.Console;
import interactors.Validator;

/**
 * Class that describes the "updateId {element}" command.
 */
public class UpdateId extends InteractionWithWorker
{
    private Worker worker;
    private CollectionInteractor collectionInteractor;

    public UpdateId(CollectionInteractor collectionInteractor, Console console)
    {
        super("updateId", "updating the current worker by id of the given worker", console);
        this.collectionInteractor = collectionInteractor;
    }

    public void setWorker(Worker worker)
    {
        this.worker = worker;
    }

    @Override
    public void getArgsValidation(String[] args) throws IncorrectCmdArgsException, IncorrectIdInputException
    {
        if (args.length != 1 || !Validator.isLong(args[0]))
        {
            throw new IncorrectCmdArgsException();
        }
        long id = Long.parseLong(args[0]);
        if (collectionInteractor.existsId(id))
        {
           throw new IncorrectIdInputException();
        }
    }

    /**
     * Update the current worker by the id of the given one.
     * @param args of the command line.
     */
    public void command(String[] args)
    {
        long id = Long.parseLong(args[0]);
        collectionInteractor.update(id, worker);
    }
}