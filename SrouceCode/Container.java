package SrouceCode;

/**
 *  PURPOSE:       This class is the foundation for any class that wants to hold Objects
 *                 Classes that would use this interface for example would be a 'inventory' class that holds items
 *                 this Class only forces basic functionality when holing objects. Like adding and removing an object.
 *
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 * @param <E>: The Class of objects you want this container to hold
 */
public interface Container<E> {

    /**
     *
     * @param object: the object you want to add to this Container
     * @return boolean: if object was able to be added or not 
     */
    public boolean add(E object);

    /**
     * 
     * @return the first object that is being held by the container 
     */
    public E remove();
     
    /**
     * @param  object:  the object you want to remove from this container
     * @return Object:  a copy of the object that was removed
     */
    public E remove(E object);


    /**
     * @param  object:  the object you want to remove from this container
     * @return Object:  a copy of the object that was removed
     */
    public E remove (String object);


    /**
     * @param object:   The object you want to see if this container holds
     * @return boolean: If a object was in the container or not
     */
    public boolean contain(E object);


    /**
     * @param  object:  the object you want to remove from this container
     * @return boolean:  if a object was in the container or not
     */
    public boolean contain(String object);


    /**
     * this method will set a limit for the amount of object's a container can hold
     *
     * @param object: what object you want a limit set on
     * @param limit: the number of the limit for the object
     */
    public void setLimit(E object, int limit);

    
    /**
     *
     * @return number: number of Objects in this container
     */
    public int count();


    /**
     * @param  object:  the object you want to know how many are in the container
     * @return int: the amount of that object in the container
     */
    public int count(E object);


    /**
     *
     * @return a name of all items held in this container
     */
    @Override
    public String toString();


}
