package interactors;

import java.io.File;

public class FileAccessInteractor
{
    public static void checkAccess(String fileName)
    {
        File file = new File(fileName);
        if (!file.exists())
        {
            System.out.println("File does not exist");
            System.exit(0);
        }
        else if (!file.canRead())
        {
            System.out.println("File is not readable");
            System.exit(0);
        }
    }
}