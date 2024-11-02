package commands;

import interactors.Console;

/**
 * Abstract Command class.
 */
public abstract class Command
{
    private String name, description;
    protected Console console;

    public Command(String name, String description, Console console)
    {
        this.name = name;
        this.description = description;
        this.console = console;
    }

    public String getName()
    {
        return name;
    }

    /**
     * Printing the corresponding information out.
     */
    public abstract void command(String[] args);

    @Override
    public String toString()
    {
        return this.name + " : " + this.description;
    }
}