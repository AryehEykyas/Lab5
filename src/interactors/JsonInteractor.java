package interactors;

import classes.Worker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jsonInteractors.LocalDateInteractor;
import jsonInteractors.LocalDateTimeInteractor;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Class that is used for working with json-files.
 * Retrieving and writing data in them.
 */
public class JsonInteractor
{
    private static Gson g = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateInteractor()).registerTypeAdapter(
            LocalDateTime.class, new LocalDateTimeInteractor()).setPrettyPrinting().create();

    private static Console console;

    /**
     * Method that returns a LinkedList generated from a static array.
     *
     * @param workers a static array.
     * @return LinkedList<Workers> LinkedList.
     */
    public static LinkedList<Worker> getLinkedList(Worker[] workers)
    {
        LinkedList<Worker> list = new LinkedList<>();
        for (Worker w : workers)
        {
            list.add(w);
        }

        return list;
    }

    public static String getStrJsonOfWorkerFromLinkedListWorker(LinkedList<Worker> workers)
    {
        try
        {
            String json = g.toJson(workers);
            return json;
        }
        catch (Exception e)
        {
            console.print(e.toString());
            return "Parsing was failed.";
        }
    }

    /**
     * Method that returns a LinkedList of workers from a json-String.
     *
     * @param json String value.
     * @return LinkedList<Worker> LinkedList.
     */
    public static LinkedList<Worker> getLinkedListOfWorkerFromStrJson(String json)
    {
        try
        {
            LinkedList<Worker> workers = new LinkedList<>();
            if (!json.isEmpty())
            {
                Type type = new TypeToken<LinkedList<Worker>>(){}.getType();
                workers = g.fromJson(json, type);
            }

            return workers;
        }
        catch(Exception e)
        {
            console.print("Json-file in not correct -> the process was failed.");
            return new LinkedList<>();
        }
    }
}