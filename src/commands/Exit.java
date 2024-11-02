package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.Console;

/**
 * Class the describes the "exit" command.
 */
public class Exit extends Command
{
    public Exit(Console console)
    {
        super("exit", "terminates the program execution", console);
    }

    /**
     * Method that exits from the program.
     */
    public void command(String[] args)
    {
        try
        {
            if (args.length != 0)
            {
                throw new IncorrectCmdArgsException();
            }
            System.exit(0);
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}