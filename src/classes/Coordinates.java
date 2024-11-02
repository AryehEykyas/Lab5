package classes;

/**
 * Class describing coordinates.
 */
public class Coordinates
{
    private int x; // Value of the field must be greater than -141.
    private Integer y; // The maximum value of the field: 555. The field can't be null.

    /**
     * Coordinates constructor.
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     */
    public Coordinates(int x, Integer y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x-coordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * @return y-coordinate.
     */
    public Integer getY()
    {
        return y;
    }

    /**
     * Checks that the coordinates satisfy the requirement.
     * @return true or false.
     */
    public boolean getValidation()
    {
        return (x > -141) && (y != null && y <= 555);
    }

    @Override
    public String toString()
    {
        return "Coordinates: x = " + x + ", y = " + y;
    }
}