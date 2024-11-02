package interactors;

/**
 * File that is used for working with the reading/writing in a file.
 */
public class FileConsoleInteractor implements Console
{
    private String fileName;
    private String[] lines;
    private int index = 0;

    public FileConsoleInteractor(String fileName)
    {
        this.fileName = fileName;
        String text = FileInteractor.readTextFromFile(fileName);
        lines = text.split("\n");
    }

    public boolean hasNext()
    {
        return index < lines.length;
    }

    public String getNextStr()
    {
        return lines[index++].strip();
    }

    public void print(String data)
    {
        System.out.println(data);
    }
}