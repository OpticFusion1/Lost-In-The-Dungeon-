package SrouceCode;

/**
 *  PURPOSE:        this class is for the base of any lock in the game
 *                  This class that is a lock will follow this interface
 *                  exapmles that will extend this are: 'basic lock', 'dead bolt', 'padlock'
 *
 * About:           should be able to know if the lock is locked or unlocked
 *                  able to lock or unlock the lock
 *                  ask if you are allowed to open or close the object that is attached to this lock
 *
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */

public interface Lock
{
    /**
     *
     * @return if the lock is locked
     */
    boolean isLocked();


    /**
     *
     * @return if the lock is unlocked
     */
    boolean isUnlocked();


    /**
     * locks the lock
     */
    void lock();


    /**
     * unlocks the lock
     */
    void unlock();


    /**
     *
     * @return if the object tied to this lock can be opened
     */
    boolean mayOpen();

    
    /**
     *
     * @return if the object tied to this lock can be closed
     */
    boolean mayClose();


    /**
     *  allows a key to try an unlock the lock
     *
     * @param key: the key you want to try to see if it will unlock the lock
     */
    void insert(Key key);

}
