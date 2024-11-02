package commands;

import classes.Worker;
import exceptions.IncorrectCmdArgsException;
import exceptions.IncorrectIdInputException;
import interactors.Console;

/**
 * Abstract class InteractionWithWorker that is used to retrieve new workers,
 * to process and update the collection of workers under the variety of the requirements.
 */
public abstract class InteractionWithWorker extends Command
{
    protected InteractionWithWorker(String name, String description, Console console)
    {
        super(name, description, console);
    }

    public abstract void setWorker(Worker worker);

    /**
     * Method that checks the correctness of the arguments. If they're incorrect, the method will throw exceptions.
     */
    public abstract void getArgsValidation(String[] args) throws IncorrectCmdArgsException, IncorrectIdInputException;
}