package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.Console;

/**
 * Class that describes the "help" command,
 */
public class Help extends Command
{
    private Command[] commands;

    public Help(Command[] commands, Console console)
    {
        super("help", "printing out information about all the commands", console);
        this.commands = commands;
    }

    /**
     * A brief description of each command.
     */
    @Override
    public void command(String[] args)
    {
        try
        {
            if (args.length != 0)
            {
                throw new IncorrectCmdArgsException();
            }
            for (Command cmd: commands)
            {
                console.print(cmd.toString());
            }
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}