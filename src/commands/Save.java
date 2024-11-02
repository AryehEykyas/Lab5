package commands;

import exceptions.IncorrectCmdArgsException;
import interactors.CollectionInteractor;
import interactors.Console;
import interactors.FileInteractor;
import interactors.JsonInteractor;

/**
 * Class that describes the "save" command.
 */
public class Save extends Command
{
    private String fileName;
    private CollectionInteractor collectionInteractor;

    public Save(String fileName, CollectionInteractor collectionInteractor, Console console)
    {
        super("save", "saving the collection into a file", console);
        this.fileName = fileName;
        this.collectionInteractor = collectionInteractor;
    }

    /**
     * Saving the collection into the file.
     */
    public void command(String[] args)
    {
        try
        {
            if (args.length != 0)
            {
                throw new IncorrectCmdArgsException();
            }
            FileInteractor.writeTextInFile(fileName, JsonInteractor.getStrJsonOfWorkerFromLinkedListWorker(collectionInteractor.getLinkedList()));
        }
        catch (IncorrectCmdArgsException e)
        {
            console.print(e.toString());
        }
    }
}