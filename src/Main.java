import classes.Worker;
import interactors.*;

import java.util.LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("File name must be entered within the command line.");
            System.exit(0);
        }
        String fileName = args[0];

        LinkedList<Worker> workerList = JsonInteractor.getLinkedListOfWorkerFromStrJson(FileInteractor.readTextFromFile(fileName));
        ConsoleInteractor consoleInteractor = new ConsoleInteractor();
        CollectionInteractor collectionInteractor = new CollectionInteractor(workerList);

        InputInteractor inputInteractor = new InputInteractor(consoleInteractor, collectionInteractor, fileName);
        inputInteractor.start();
    }
}