package SrouceCode;

import java.util.List;
import java.util.LinkedList;
/**
 *  PURPOSE:        this class is for any key object in the game world
 *                  it will follow the standards set by world object
 *                  any keys will extend this class example: 'basic key ', 'master key ', 'cell key '
 *                  keys are used to unlock locks
 *
 *
 * About:          a key holds a list of keys it can unlock
 *                 keys can sold and bought and have a weight to them
 *                  to use a key on a lock, insert it into a lock
 *
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public abstract class Key implements WorldObject
{

    private String name;
    private double weight;
    private int buyValue;
    private int sellValue;
    private List<Lock> locks;


    /**
     * constructor for Key class
     * Defaults value of name is "Unknown Key"
     *          value of weight is 0.5
     *          value of buyValue is 10
     *          value of sellValue is 5
     */
    public Key (){
        this("Unknown Key");
    }


    /**
     * constructor for Key class
     * @param name: is what the name of the Key is.
     * Defaults value of weight is 1.0
     *          value of buyValue is 10
     *          value of sellValue is 5
     */
    public Key(String name){
        this(name, 0.5);
    }


    /**
     * constructor for Key class
     * @param name: is the name of the Key
     * @param weight: is the weight of the Key.
     * Defaults value of buyValue will be 10
     *          Value of sellValue will be 5
     */
    public Key(String name, double weight){
        this(name, weight, 10, 5);
    }


    /**
     * Designated constructor for Key class
     * @param name: is the name of the Key
     * @param weight: is the weight of the Key.
     * @param buyValue: is how much the Key is to buy
     * @param sellValue: is how much the Key sells for
     */
    public Key(String name,double weight, int buyValue,int sellValue){
        this.name = name;
        this.weight = weight;
        this.buyValue = buyValue;
        this.sellValue = sellValue;
        this.locks = new LinkedList<Lock>();
    }


    /**
     * removes a lock from the list of locks the key can unlock
     * @param lock: the lock you want to remove from the list
     * @return boolean: if the locked was removed or not
     */
    public boolean removeLock(Lock lock){
        return locks.remove(lock);
    }

    /**
     * removes a lock from a door object
     * @param door: the door you want to removed the lock from 
     * @return Calls the remove lock method, passing the lock grabbed from the door
     */
    public boolean removeLock (Door door){
        return this.removeLock(door.getLock());
    }

    /**
     * this adds a lock to the list of locks the key can unlock
     * @param lock: the lock you want to add to the list
     */
    public void addLock(Lock lock){
        if( !locks.contains(lock)){
            locks.add(lock);
        }
    }
    
    /**
     * adds a lock to the key to unlock 
     * @param door: the door you want to add a unlock this key for 
     */
    public void addLock (Door door){
        this.addLock(door.getLock());
    }


    /**
     *
     * @return List: the list of locks this key can unlock
     */
    public List getLocks(){
        return this.locks;
    }


    /**
     *
     * @return Weight: is how much the key weighs
     */
    @Override
    public double getWeight(){
        return weight;
    }

    /**
     *
     * @return name: is the name of the key
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     *
     * @return value: is how much the key is worth
     */
    @Override
    public int getBuyValue(){
        return buyValue;
    }


    /**
     *
     * @return value: is how much the key is worth
     */
    @Override
    public int getSellValue(){
        return sellValue;
    }


    /**
     *
     * @return All fields of an key
     */
    @Override
    public String toString(){
        return "Name: " + this.getName() + ", " + this.description() + "\nWeight: " + this.getWeight() +
                " BuyValue: " + this.getBuyValue() + " SellValue:" + this.getSellValue();
    }

    
    /**
     * the method that is used by the use command
     * it will allow the player to "use" the key in room
     * it will go around each door in the room, and try to unlock it if it is locked
     *
     * @param room: the room you want to use this item in
     */
    public void use(Room room){

        List<Door> exits = room.getExit();
        boolean noUse = true;

        for (Door current : exits){
            if (current.getLock() != null && current.getLock().isLocked()){
                current.getLock().insert(this);
                if(current.getLock().isUnlocked()){
                    System.out.println("You unlocked " + current.getName());
                    noUse = false;
                }
            }
        }

        if(noUse){
            System.out.println("No door was unlocked.");
        }
    }


    /**
     *
     * @return a string that describes the item
     */
    @Override
    abstract public String description();


    /**
     *  will unlock a lock if this key is able to unlock it
     * @param lock: the lock you want to try the key on
     * @return boolean: if the lock was unlocked
     */
    abstract public boolean canUnlock(Lock lock);


}
