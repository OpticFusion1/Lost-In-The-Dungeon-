package SrouceCode;

/**
 *  PURPOSE:        this class is the basic lock for any lock in the game
 *                  This class follows the lock interface
 *
 *
 * About:           this lock can be locked or unlocked
 *                  it will always let the object close even if locked
 *                  insert a key to unlock the lock
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */

public class BasicLock implements Lock
{

    private boolean locked;

     /**
     * Designated constructor for basic lock Class
     * Defaults locked: false
     */
    public BasicLock(){
        locked = false;
    }

    /**
     *
     * @return if the lock is locked
     */
    @Override
    public boolean isLocked() {
        return locked;
    }

    /**
     *
     * @return if the lock is unlocked
     */
    @Override
    public boolean isUnlocked() {
        return !locked;
    }

    /**
     * locks the lock
     */
    @Override
    public void lock() {
        locked = true;
    }

    /**
     * unlocks the lock
     */
    @Override
    public void unlock() {
        locked = false;
    }

    /**
     *
     * @return boolean: if allowed to open the object tied to this lock
     */
    @Override
    public boolean mayOpen() {
        return isUnlocked();
    }

    /**
     *
     * @return boolean: if allowed to close the object tied to this lock
     */
    @Override
    public boolean mayClose() {
        return true;
    }

    /**
     * this will unlock the lock if the key can unlock it
     * @param key: the key you want to use on this lock
     */
    @Override
    public void insert(Key key) {
        if(key.canUnlock(this)){
            this.unlock();
        }
    }

}
