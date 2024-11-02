package interactors;

import classes.*;
import commands.Command;
import exceptions.InputCompleteException;
import exceptions.NonExistentCommandException;
import exceptions.WorkerCompleteInputException;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

/**
 * Class that is used for processing the input.
 */
public class InputInteractor
{
    private Console console;
    private CollectionInteractor collectionInteractor;
    private String dataFileName; // file's name from which we read out and to which we write in data.

    private static final String completeExecution = "STOP"; // terminates the worker input

    public InputInteractor(Console console, CollectionInteractor collectionInteractor, String dataFileName)
    {
        this.console = console;
        this.collectionInteractor = collectionInteractor;
        this.dataFileName = dataFileName;
    }

    public Console getConsole()
    {
        return console;
    }

    public CollectionInteractor getCollectionInteractor()
    {
        return collectionInteractor;
    }

    /**
     * Method that receives an Integer value from the Standard input. (can't be null, but must be greater than -141)
     *
     * @param data like a description.
     * @param min minimal acceptable int value.
     * @param greater true - if greater, false - if equal or less than.
     * @param notNull - if not null, false - otherwise.
     * @return Integer value that was entered.
     */
    public Integer getInteger(String data, int min, boolean greater, boolean notNull) throws WorkerCompleteInputException, InputCompleteException
    {
        String s = "";
        Integer v;
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals("") && notNull)
                {
                    throw new NullPointerException();
                }
                if (s.equals("") && !notNull)
                {
                    return null;
                }
                if (Validator.isInteger(s))
                {
                    v = Integer.parseInt(s);
                    if (greater)
                    {
                        if (v > min) return v;
                    }
                    else
                    {
                        if (v <= min) return v;
                    }
                    console.print(data);
                }
            }
            catch (WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }
            catch (NullPointerException e)
            {
                console.print("Incorrect input Integer format.");
            }

            console.print(data);
        }

        throw new InputCompleteException();
    }

    /**
     * Method that receives an Integer value from the Standard input.
     *
     * @param data like a description.
     * @param flag true - if positive, false - otherwise.
     * @return Integer value.
     * @throws WorkerCompleteInputException
     * @throws InputCompleteException
     */
    public Integer getIntegerDepth(String data, boolean flag) throws WorkerCompleteInputException, InputCompleteException
    {
        String s = "";
        Integer v;
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (Validator.isInteger(s))
                {
                    v = Integer.parseInt(s);
                    if (v > 0 || (v <= 0 && !flag))
                    {
                        return v;
                    }
                }

                console.print(data);
            }
            catch(WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }
        }

        throw new InputCompleteException();
    }

    /**
     * Method that receives a Long value from the Standard input. (can't be null)
     *
     * @param data like a description.
     * @param flag - true if positive, false - otherwise.
     * @param notNull - true if not null, false - otherwise.
     * @return Long value that was entered.
     * @throws WorkerCompleteInputException
     * @throws InputCompleteException
     */
    public Long getLong(String data, boolean notNull, boolean flag) throws WorkerCompleteInputException, InputCompleteException
    {
        String s = "";
        Long v;
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals("") && notNull)
                {
                    throw new NullPointerException();
                }
                if (Validator.isLong(s))
                {
                    v = Long.parseLong(s);
                    if (v > 0 || (v <= 0 && !flag))
                    {
                        return v;
                    }
                }
                console.print(data);
            }
            catch (WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }
            catch (NullPointerException e)
            {
                console.print("Incorrect input Long format.");
            }
        }
        throw new InputCompleteException();
    }

    /**
     * Method that receives a Double value from the Standard input. (can't be null)
     *
     * @param data like a description.
     * @param flag true - if positive, false - otherwise.
     * @param notNull ture - if not null, false - otherwise.
     * @return Double value that was entered.
     * @throws WorkerCompleteInputException
     * @throws InputCompleteException
     */
    public Double getDouble(String data, boolean notNull, boolean flag) throws WorkerCompleteInputException, InputCompleteException
    {
        String s = "";
        Double v;
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals("") && notNull)
                {
                    throw new NullPointerException();
                }
                if (Validator.isDouble(s))
                {
                    v = Double.parseDouble(s);
                    if (v > 0 || (v <= 0 && !flag))
                    {
                        return v;
                    }
                }
                console.print(data);
            }
            catch (WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }
            catch (NullPointerException e)
            {
                console.print("Incorrect input Double format.");
            }
        }
        throw new InputCompleteException();
    }

    /**
     * Method the receives the position of the worker.
     */
    public Position getPosition() throws WorkerCompleteInputException, InputCompleteException
    {
        String data = "Enter the position of the worker. The field can't be null. The variants of Position are: ";
        for (Position el : Position.values())
        {
            data += el + " ";
        }

        String s = "";
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals(""))
                {
                    throw new InputCompleteException();
                }
                try
                {
                    return Position.valueOf(s);
                }
                catch (IllegalArgumentException e)
                {
                    console.print(e.getMessage());
                }
            }
            catch (WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }

            console.print(data);
        }

        throw new InputCompleteException();
    }

    /**
     * Method that receives the status of the worker.
     *
     * @return Status of the worker from the Standard input. (can be null)
     * @throws WorkerCompleteInputException
     * @throws InputCompleteException
     */
    public Status getStatus() throws WorkerCompleteInputException, InputCompleteException
    {
        String data = "Enter the status of the worker. The field can be null. The variants of status are: ";
        for (Status el : Status.values())
        {
            data += el + " ";
        }

        String s = "";
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals(""))
                {
                    return null;
                }
                try
                {
                    return Status.valueOf(s);
                }
                catch (IllegalArgumentException e)
                {
                    console.print(e.getMessage());
                }
            }
            catch (NullPointerException e)
            {
                console.print("Incorrect input Status format.");
            }
            console.print(data);
        }

        throw new InputCompleteException();
    }

    /**
     * Method that receives the color of eyes.
     *
     * @return Color of the worker's eyes.
     * @throws WorkerCompleteInputException
     * @throws InputCompleteException
     */
    public Color getEyesColor() throws WorkerCompleteInputException, InputCompleteException
    {
        String data = "Enter the color of the eyes or null. The variants are: ";
        for (Color cl : Color.values())
        {
            data += cl + " ";
        }

        String s = "";
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals(""))
                {
                    return null;
                }
                try
                {
                    return Color.valueOf(s);
                }
                catch (IllegalArgumentException e)
                {
                    console.print(e.getMessage());
                }
            }
            catch (NullPointerException e)
            {
                console.print("Incorrect input EyesColor format.");
            }
            console.print(data);
        }

        throw new InputCompleteException();
    }

    /**
     * Method that receives the color of hair.
     *
     * @return Color of the worker's hair.
     * @throws WorkerCompleteInputException
     * @throws InputCompleteException
     */
    public Color getHairColor() throws WorkerCompleteInputException, InputCompleteException
    {
        String data = "Enter the color of the hair. The field can't be null. The variants are: ";
        for (Color cl : Color.values())
        {
            data += cl + " ";
        }

        String s = "";
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s += console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals(""))
                {
                    throw new NullPointerException();
                }
                try
                {
                    return Color.valueOf(s);
                }
                catch (IllegalArgumentException e)
                {
                    console.print(e.getMessage());
                }
            }
            catch (WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }
            catch (NullPointerException e)
            {
                console.print("Incorrect input HairColor format.");
            }
            console.print(data);
        }

        throw new InputCompleteException();
    }

    /**
     * Method the receives the data of the LocalDateTime type from the Standard Input.
     *
     * @param data like a description.
     * @return LocalDateTime input date. (can't be null)
     */
    public LocalDateTime getDate(String data) throws WorkerCompleteInputException, InputCompleteException
    {
        String s = "";
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals(""))
                {
                    throw new NullPointerException();
                }
                try
                {
                    return LocalDateTime.parse(s);
                /*
                DateTimeFormatter formater = DateTimeFormater .ofPattern("yyyy-MM-dd HH:mm");
                return LocalDateTime.parse(s, formatter);

                 */
                }
                catch (IllegalArgumentException e)
                {
                    console.print(data);
                }
                catch (NullPointerException e)
                {
                    console.print(e.toString());
                }
                console.print(data);
            }
            catch (WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }
            catch (NumberFormatException e)
            {
                console.print("Incorrect input Date format.");
            }

            console.print(data);
        }

        throw new InputCompleteException();
    }

    /**
     * Method that receives a string consisting of not only blank spaces.
     *
     * @param data like a description.
     * @param min minimal acceptable length.
     * @param notNull true - can't be null, false - can.
     * @return @return Double entered number (can't be null)
     */
    public String getNotBlankString(String data, int min, boolean notNull) throws WorkerCompleteInputException, InputCompleteException
    {
        String s = "";
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (!notNull && s.equals(""))
                {
                    return null;
                }
                if (notNull && s.equals(""))
                {
                    throw new NullPointerException();
                }
                if (!s.isBlank() && s.length() >= min)
                {
                    return s;
                }

                console.print(data);
            }
            catch (WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }
            catch (NullPointerException e)
            {
                console.print("Incorrect input string format.");
            }

            console.print(data);
        }

        throw new InputCompleteException();
    }

    /**
     * Method that receives the X-coordinate of the Location from the input. (can't be null)
     *
     * @param data like a description.
     * @return Long X-coordinate of the position.
     * @throws WorkerCompleteInputException
     * @throws InputCompleteException
     */
    public Long getXLocation(String data) throws WorkerCompleteInputException, InputCompleteException
    {
        String s = "";
        Long v;
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals(""))
                {
                    throw new NullPointerException();
                }
                if (Validator.isLong(s))
                {
                    return Long.parseLong(s);
                }

                console.print(data);
            }
            catch (WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }
            catch (NullPointerException e)
            {
                console.print("Incorrect input XLocation format.");
            }

            console.print(data);
        }

        throw new InputCompleteException();
    }

    /**
     * Method that receives the Y-coordinate of the location from the input. (can't be null)
     */
    public Integer getYLocation(String data) throws WorkerCompleteInputException, InputCompleteException
    {
        String s = "";
        Integer v;
        console.print(data);
        while (console.hasNext())
        {
            try
            {
                s = console.getNextStr();
                if (s.equals(completeExecution))
                {
                    throw new WorkerCompleteInputException();
                }
                if (s.equals(""))
                {
                    throw new NullPointerException();
                }
                if (Validator.isInteger(s))
                {
                    return Integer.parseInt(s);
                }
                console.print(data);
            }
            catch (WorkerCompleteInputException e)
            {
                console.print(e.toString());
            }
            catch (NullPointerException e)
            {
                console.print("Incorrect input YLocation format.");
            }
            console.print(data);
        }

        throw new InputCompleteException();
    }

    /**
     * Method that receives data about worker from the Standard input.
     *
     * @return Worker with the input data.
     */
    public Worker getWorker()
    {
        try
        {
            String s = "";
            String name = getNotBlankString("Enter the name of a worker: ", 1, true);

            console.print("Enter the coordinates of a worker (X, Y).");

            Integer x = getInteger("Enter the X-coordinate(Integer value): ", -141, true, true);
            Integer y = getInteger("Enter the Y-coordinate(Integer value): ", 555, false, true);

            Coordinates coordinates = new Coordinates(x, y);

            Double salary = getDouble("Enter the salary of worker(Double value) and can't be null: ", true, true);

            Position position = getPosition();
            Status status = getStatus();

            LocalDateTime birthday = getDate("Enter the data of birth in the format 'yyyy-mm-ddThh:mm' and cant' be null: ");

            Color eyeColor = getEyesColor();
            Color hairColor = getHairColor();

            Long xLocation = getXLocation("Enter the X-coordinate of the location: ");
            Integer yLocation = getYLocation("Enter the Y-Coordinate of the location: ");
            String locationName = getNotBlankString("Enter the name of the location: ", 1, false);
            Location l = new Location(xLocation, yLocation, locationName);

            Person p = new Person(birthday, eyeColor, hairColor, l);

            return new Worker(name, coordinates, salary, position, status, p);
        }
        catch (WorkerCompleteInputException | InputCompleteException e)
        {
            return null;
        }
    }

    /**
     * Method that starts the interactive execution. (the main program)
     */
    public void start()
    {
        Command command;
        CommandInteractor commandInteractor = new CommandInteractor(this, dataFileName);
        while (console.hasNext())
        {
            String data = "Enter the command (help - to get the list of commands):";
            console.print(data);
            console.print("\n");
            try
            {
                commandInteractor.executeCommand(console.getNextStr());
            }
            catch (NonExistentCommandException e)
            {
                console.print(e.toString());
            }
            catch (NoSuchElementException e)
            {
                console.print("");
            }
            console.print("\n");
        }
    }
}