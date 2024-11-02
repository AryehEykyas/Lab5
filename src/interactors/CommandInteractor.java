package interactors;

import classes.Worker;
import commands.Command;
import commands.*;
import exceptions.*;

import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * Class that is used for manipulating the commands.
 */
public class CommandInteractor
{
    private Console console;
    private CollectionInteractor collectionInteractor;
    private InputInteractor inputInteractor;
    private String dataFileName;
    private TreeMap<String, Command> commands = new TreeMap<>();

    public CommandInteractor(InputInteractor inputInteractor, String dataFileName)
    {
        this.inputInteractor = inputInteractor;
        this.collectionInteractor = inputInteractor.getCollectionInteractor();
        this.dataFileName = dataFileName;
        console = inputInteractor.getConsole();
        Command[] commands1 = {new Help(null, console), new Info(collectionInteractor, console),
        new Show(collectionInteractor, console), new Add(collectionInteractor, console), new UpdateId(collectionInteractor, console), new RemoveById(collectionInteractor, console), new Clear(collectionInteractor, console), new Save(dataFileName, collectionInteractor, console),
        new ExecuteScript(dataFileName, collectionInteractor, console), new Exit(console),
        new Head(collectionInteractor, console), new RemoveGreater(collectionInteractor, console),
        new RemoveLower(collectionInteractor, console), new MinByCreationDate(collectionInteractor, console),
        new FilterContainsName(collectionInteractor, console), new PrintAscending(collectionInteractor, console)};

        Command help = new Help(commands1, console);

        for (Command command : commands1)
        {
            if (command instanceof Help) commands.put(command.getName(), help);
            else commands.put(command.getName(), command);
        }
    }

    /**
     * Method that executes a command by its string description.
     *
     * @param description is an input string.
     * @throws NonExistentCommandException is thrown when there is no such command.
     */
    public void executeCommand(String description) throws NonExistentCommandException
    {
        String[] sCommands = description.split("\\s+");
        description = sCommands[0];
        String[] args = new String[sCommands.length - 1];
        for (int i = 1; i < sCommands.length; i++)
        {
            args[i - 1] = sCommands[i];
        }

        if (!commands.containsKey(description))
        {
            throw new NonExistentCommandException();
        }

        Command cmd = commands.get(description);
        if (cmd instanceof InteractionWithWorker)
        {
            try
            {
                ((InteractionWithWorker) cmd).getArgsValidation(args);
            }
            catch (IncorrectCmdArgsException | IncorrectIdInputException e)
            {
                console.print(e.toString());
                return;
            }

            Worker worker = inputInteractor.getWorker();
            if (worker == null) return;
            ((InteractionWithWorker) cmd).setWorker(worker);
        }
        if (cmd instanceof ExecuteScript)
        {
            try
            {
                ((ExecuteScript) cmd).argsValidation(args);
                if (console instanceof ConsoleInteractor)
                {
                    int maxDepth = inputInteractor.getIntegerDepth("Enter the number of line iterations", true);
                    ExecuteScript.setMax(maxDepth);
                }
            }
            catch (WorkerCompleteInputException | InputCompleteException e)
            {
                console.print(e.toString());
            }
            catch (IncorrectCmdArgsException e)
            {
                throw new RuntimeException(e);
            }
        }
        cmd.command(args);
    }
}