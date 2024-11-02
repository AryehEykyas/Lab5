package classes;

import java.time.LocalDateTime;

/**
 * Class describing people.
 */
public class Person
{
    private java.time.LocalDateTime birthday; // Value of the field can't be null.
    private Color eyeColor; // Value of the field can be null.
    private Color hairColor; // Value of the field can't be null.
    private Location location; // Value of the field can't be null.

    /**
     * Person's constructor.
     * @param birthday of a person.
     * @param eyeColor of a person.
     * @param hairColor of a person.
     * @param location of a person.
     */
    public Person(LocalDateTime birthday, Color eyeColor, Color hairColor, Location location)
    {
        this.birthday = birthday;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.location = location;
    }

    /**
     * Checks that the fields satisfy the appropriate requirements.
     * @return true or false.
     */
    public boolean getValidation()
    {
        if (birthday == null) return false;
        if (hairColor == null) return false;
        if (location == null) return false;

        return true;
    }

    @Override
    public String toString()
    {
        return "Person: birthday = '" + birthday + "', eyeColor = '" + eyeColor + "', hairColor = '" +
                hairColor + "', location = '" + location + "'";
    }
}