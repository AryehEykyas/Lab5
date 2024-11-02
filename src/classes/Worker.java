package classes;

import java.time.LocalDate;

/**
 * Class describing workers.
 */
public class Worker implements Comparable<Worker>
{
    private long id; // Value of the field must be greater than 0, must be unique, must be generated automatically.
    private String name; // Value of the field can't be null, the string can't be empty.
    private Coordinates coordinates; // Value of the field can't be null.
    private LocalDate creationDate; // Value of the field can't be null, must be generated automatically.
    private Double salary; // Value of the field can't be null, must be greater than 0.
    private Position position; // Value of the field can't be null.
    private Status status; // Value of the field can be null.
    private Person person; // Value of the field can't be null.

    private static long workerId = 1; // static variable used to automatically generate id for each worker.

    /**
     * Worker's constructor.
     * @param name of a worker.
     * @param coordinates of a worker.
     * @param salary of a worker.
     * @param position of a worker.
     * @param status of a worker.
     * @param person that is associated with a worker.
     */
    public Worker(String name, Coordinates coordinates, Double salary, Position position, Status status, Person person)
    {
        this.id = workerId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.salary = salary;
        this.position = position;
        this.status = status;
        this.person = person;
    }

    /**
     * @return worker's id.
     */
    public long getId()
    {
        return id;
    }

    /**
     * @return worker's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return worker's coordinates.
     */
    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    /**
     * @return worker's creationDate;
     */
    public LocalDate getCreationDate()
    {
        return creationDate;
    }

    /**
     * @return worker's salary.
     */
    public Double getSalary()
    {
        return salary;
    }

    /**
     * @return worker's position.
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * @return worker's status..
     */
    public Status getStatus()
    {
        return status;
    }

    /**
     * @return worker's person.
     */
    public Person getPerson()
    {
        return person;
    }

    /**
     * Set new name to a worker.
     * @param name of a worker.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Set new coordinates to a worker.
     * @param coordinates of a worker.
     */
    public void setCoordinates(Coordinates coordinates)
    {
        this.coordinates = coordinates;
    }

    /**
     * Set new salary to a worker.
     * @param salary of a worker.
     */
    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    /**
     * Set new position to a worker.
     * @param position of worker.
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * Set new status to a worker.
     * @param status of w worker.
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /**
     * Set new person to a worker.
     * @param person of a worker.
     */
    public void setPerson(Person person)
    {
        this.person = person;
    }

    /**
     * Change the workerId variable.
     */
    public static void setWorkerId(long newId)
    {
        if (newId > workerId) workerId = newId;
    }

    /**
     * Checks that data in all the field is correct.
     * @return true or false.
     */
    public boolean getValidation()
    {
        if (id < 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null) return false;
        if (creationDate == null) return false;
        if (salary == null || salary < 0) return false;
        if (position == null) return false;
        if (person == null) return false;

        return coordinates.getValidation() && person.getValidation();
    }

    /**
     * Method tha changes the fields of the current worker by the others.
     *
     * @param worker the new worker.
     */
    public void update(Worker worker)
    {
        this.setName(worker.getName());
        this.setCoordinates(worker.getCoordinates());
        this.setSalary(worker.getSalary());
        this.setPosition(worker.getPosition());
        this.setStatus(worker.getStatus());
        this.setPerson(worker.getPerson());
    }

    /**
     * Method that returns a copy of the worker.
     * @return Worker copy of worker.
     */
    public Worker getCopy()
    {
        return this;
    }

    /**
     * Compare 2 workers by their salaries.
     * @param otherWorker the object to be compared.
     * @return int result. ( < 0, == 0, > 0)
     */
    @Override
    public int compareTo(Worker otherWorker)
    {
        if (this.getSalary() == null && otherWorker.getSalary() == null) return 0;
        if (this.getSalary() == null) return -1;
        if (otherWorker.getSalary() == null) return 1;

        double d = this.getSalary() - otherWorker.getSalary();
        if (d > 0) return 1;
        if (d == 0) return 0;
        return -1;
    }

    @Override
    public String toString()
    {
        return "Worker [id = " + id + ", name = " + name + ", coordinates = " + coordinates + ", creationDate = " +
                creationDate + ", salary = " + salary + ", position = " + position + ", status = " +
                status + ", person = " + person + "]";
    }
}