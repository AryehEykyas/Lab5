package commands;

import classes.Worker;
import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;
import interactors.Validator;

/**
 * Class that describes the "filter_contains_name name" command.
 */
public class FilterContainsName extends Command
{
    private CollectionInteractor collectionInteractor;

    public FilterContainsName(CollectionInteractor collectionInteractor, Console console)
    {
        super("filter_contains_name", "printing out all the workers whose value of the name field contains the given substring", console);
        this.collectionInteractor = collectionInteractor;
    }

    /**
     * Method that prints out all the workers whose "name" field's contains the given substring.
     */
    public void command(String[] args)
    {
        try
        {
            String substr = "";
            if (args.length == 1 && !args[0].equals("null") && !Validator.isInteger(args[0]) && !Validator.isLong(args[0]) && !Validator.isDouble(args[0]) && !Validator.isFloat(args[0]))
            {
                substr = args[0];
            }
            else if (args.length == 1 && args[0].equals("null"))
            {
                substr = null;
            }
            else
            {
                throw new IncorrectCmdArgsException();
            }
            for (Worker w : collectionInteractor.getFilteredBySubName(substr))
            {
                console.print(w.toString());
            }
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}