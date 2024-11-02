package classes;

/**
 * Class describing a location.
 */
public class Location
{
    private long x;
    private Integer y; // Field can't be null.
    private String name; // Field can't be null.

    /**
     * Location's constructor
     * @param x is the location's x-coordinate
     * @param y is the location's y-coordinate
     * @param name is the location's name.
     */
    public Location(long x, Integer y, String name)
    {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * @return long x-coordinate.
     */
    public long getX()
    {
        return x;
    }

    /**
     * @return Integer y-coordinate.
     */
    public Integer getY()
    {
        return y;
    }

    /**
     * @return String name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Checks that the y-coordinate satisfies the requirement.
     * @return true or false.
     */
    public boolean getValidation()
    {
        return y != null;
    }

    @Override
    public String toString()
    {
        return "Location: x = " + x + ", y = " + y + ", with name = " + name;
    }
}