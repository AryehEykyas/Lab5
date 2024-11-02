package interactors;

import classes.Worker;
import exceptions.DuplicateIdException;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Class that is used for working with the collection.
 */
public class CollectionInteractor
{
    private Console console = new ConsoleInteractor();
    private LinkedList<Worker> workers;
    private TreeMap<Long, Worker> workerMap = new TreeMap<Long, Worker>();
    private LocalDateTime creationDate;

    /**
     * CollectionInteractor constructor.
     */
    public CollectionInteractor()
    {
        creationDate = LocalDateTime.now();
        workers = new LinkedList<>();
    }

    public CollectionInteractor(LinkedList<Worker> workers)
    {
        this();
        setWorkers(workers);
    }

    public void setWorkers(LinkedList<Worker> workers)
    {
        clear();
        long idCounter = 0;

        for (Worker worker : workers)
        {
            if (worker != null && worker.getValidation() && !existsId(worker.getId()))
            {
                try
                {
                    add(worker);
                    idCounter = Math.max(idCounter, worker.getId());
                }
                catch (DuplicateIdException e) {};
            }
        }
        Worker.setWorkerId(idCounter + 1);
    }

    /**
     * Checks the correctness of the collection.
     * That all the workers are correct and each id differs.
     */
    public boolean getValidation()
    {
        for (Worker worker : workers)
        {
            if (!worker.getValidation() || workerMap.get(worker.getId()) != worker)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks whether the collection is empty.
     *
     * @return boolean true - if is empty, false - otherwise.
     */
    public boolean isEmpty()
    {
        return workers.isEmpty();
    }

    /**
     * Prints out the information about the collection.
     */
    public void printInfo()
    {
        console.print("Data type: " + workers.getClass().getName());
        console.print("Date of initialization: " + creationDate);
        console.print("The number of elements: " + workers.size());
    }

    /**
     * Prints out all the elements of the collection.
     */
    public void printAllElements()
    {
        if (workers.isEmpty())
        {
            console.print("There are no elements in the collection");
            return;
        }

        console.print("The number of elements: " + workers.size());
        int counter = 0;
        for (Worker worker : workers)
        {
            System.out.print(worker);
            if (counter != workers.size())
            {
                console.print(", ");
            }
            counter++;
        }
        console.print(".");
    }

    /**
     * Prints out the elements in ascending order.
     */
    public void printAscending()
    {
        LinkedList<Worker> aWorkers = new LinkedList<>(workers);
        Collections.sort(aWorkers);

        for (Worker worker : aWorkers)
        {
            console.print(worker.toString());
        }
    }

    /**
     * Adds a worker in the collection.
     *
     * @param worker the added worker.
     * @throws DuplicateIdException exception if the worker with the same id already exists.
     */
    public void add(Worker worker) throws DuplicateIdException
    {
        if (existsId(worker.getId()))
        {
            throw new DuplicateIdException();
        }

        workerMap.put(worker.getId(), worker);
        workers.add(worker);
    }

    /**
     * Checks does the collection contains the given id.
     *
     * @param id that is provided.
     * @return boolean true - if yes, false - otherwise.
     */
    public boolean existsId(long id)
    {
        return workerMap.containsKey(id);
    }

    /**
     * Method that updates the current worker whose id is equal to the given one
     *
     * @param id of the current worker.
     * @param worker the given one.
     */
    public void update(long id, Worker worker)
    {
        if (!workers.contains(worker))
        {
            console.print("There is no such worker in the collection");
            return;
        }

        Worker w = workerMap.get(id);
        w.update(worker);
    }

    /**
     * Method that drops the worker from the collection.
     *
     * @param id of the worker.
     */
    public void remove(long id)
    {
        if (!workerMap.containsKey(id))
        {
            console.print("There is no such worker with such id.");
            return;
        }

        Worker worker = workerMap.get(id);
        workerMap.remove(id);
        workers.remove(worker);
    }

    /**
     * Method that drops all the workers who have their salaries lower than the given one.
     *
     * @param worker the given worker.
     */
    public void removeLower(Worker worker)
    {
        LinkedList<Worker> aWorkers = new LinkedList<>(workers);
        for (Worker w : aWorkers)
        {
            // Comparison is lead by their salaries;
            if (w.compareTo(worker) < 0)
            {
                workers.remove(w);
                workerMap.remove(w.getId());
            }
        }
    }

    /**
     * Method that drops all the workers who have their salaries greater than the given one.
     *
     * @param worker the given worker.
     */
    public void removeGreater(Worker worker)
    {
        LinkedList<Worker> aWorkers = new LinkedList<>(workers);
        for (Worker w : aWorkers)
        {
            // Comparison is lead by their salaries.
            if (w.compareTo(worker) > 0)
            {
                workers.remove(w);
                workerMap.remove(w.getId());
            }
        }
    }

    /**
     * Method that returns any element of the collection which has the lowest value of the creationDate field.
     *
     * @return Worker with the lowest creationDate value.
     */
    public Worker getMinByCreationDate()
    {
        LinkedList<Worker> aWorkers = new LinkedList<>(workers);
        Worker min = aWorkers.getFirst();
        for (int i = 1; i < aWorkers.size(); i++)
        {
            if (min.getCreationDate().compareTo(aWorkers.get(i).getCreationDate()) > 0)
            {
                min = aWorkers.get(i);
            }
        }

        return min;
    }

    /**
     * Clearing the collection.
     */
    public void clear()
    {
        workers.clear();
        workerMap.clear();
    }

    /**
     * Return the first element in the collection.
     *
     * @return Worker the first element.
     */
    public Worker getHead()
    {
        return workers.getFirst();
    }

    /**
     * Method that return the current LinkedList of workers.
     *
     * @return LinkedList<Worker> of workers.
     */
    public LinkedList<Worker> getLinkedList()
    {
        return workers;
    }

    /**
     * Method that returns the current LinkedList of workers.
     *
     * @return LinkedList<Worker> of workers.
     */
    public LinkedList<Worker> getCopy()
    {
        LinkedList<Worker> copy = new LinkedList<>();
        for (Worker worker : workers)
        {
            copy.add(worker);
        }

        return copy;
    }

    /**
     * Method that returns a filtered array the contains the workers whose name field contains the given substring.
     *
     * @param name the given substring.
     * @return LinkedList<Worker> of workers that satisfy the requirement.
     */
    public LinkedList<Worker> getFilteredBySubName(String name)
    {
        LinkedList<Worker> filtered = new LinkedList<>();
        for (Worker worker : workers)
        {
            if (worker.getName().contains(name))
            {
                filtered.add(worker);
            }
        }

        return filtered;
    }
}