package commands;

import exceptions.IncorrectCmdArgsException;
import exceptions.IncorrectIdInputException;
import interactors.*;

/**
 * Class that describes the "execute_script file_name" command.
 */
public class ExecuteScript extends Command
{
    private String fileName;
    private CollectionInteractor collectionInteractor;
    private static int counter = 0, max = 5;

    public ExecuteScript(String fileName, CollectionInteractor collectionInteractor, Console console)
    {
        super("execute_script", "executes commands from a file", console);
        this.fileName = fileName;
        this.collectionInteractor = collectionInteractor;
    }

    public static void setMax(int max)
    {
        ExecuteScript.max = max;
    }

    /**
     * Checks that the arguments of the command are correct.
     */
    public void argsValidation(String[] args) throws IncorrectCmdArgsException
    {
        if (args.length != 1 || !Validator.isFile(args[0]))
        {
            throw new IncorrectCmdArgsException();
        }
    }

    /**
     * Executes the commands from a file.
     */
    public void command(String[] args)
    {
        try
        {
            argsValidation(args);
            String fileName = args[0];
            if (counter > max)
            {
                console.print("The max line depth was reached.");
                return;
            }
            console.print("Executing file consisting of the commands.");
            counter++;
            Console fileConsole = new FileConsoleInteractor(fileName);
            InputInteractor inputInteractor = new InputInteractor(fileConsole, collectionInteractor, fileName);
            inputInteractor.start();
            counter--;
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}