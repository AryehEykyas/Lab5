package interactors;

import java.util.Scanner;

/**
 * Class that is used for working with tha standard I/O.
 */
public class ConsoleInteractor implements Console
{
    private Scanner sc = new Scanner(System.in);

    public boolean hasNext()
    {
        return true;
    }

    public String getNextStr()
    {
        return sc.nextLine().strip();
    }

    public void print(String data)
    {
        System.out.println(data);
    }
}