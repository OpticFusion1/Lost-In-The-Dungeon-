package SrouceCode;

/**
 *  PURPOSE:        this class is the base for Doors in the game
 *                  This class follows the patterns set by WorldObjects
 *                  extend this class to classes of Doors that you want in the game
 *                  Example of classes to extend this would be: 'wooden door', 'metal door', etc
 *
 *
 * About:           A door links 2 rooms together
 *                  a door can be opended or closed
 *                  a door can also have a lock object tied to it
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */

public abstract class Door implements WorldObject{

    private String name;
    private double weight;
    private int buyValue;
    private int sellValue;
    private Lock lock;
    private Room room1;
    private Room room2;
    private boolean open;


    /**
     * constructor for Door class
     * Defaults value of name is "Unknown Door"
     *          value of room1  is null
     *          value of room2  is null
     *          value of open is true
     *          value of weight is 10.0
     *          value of buyValue is 0
     *          value of sellValue is 0
     *          value of lock will be null
     */
    public Door (){
        this(null, null);
    }


    /**
     * constructor for Door class
     * @param room1: is one side of the door.
     * @param room2: is the other side of the door.
     * Defaults value of name is "Unknown Door"
     *          value of open is true
     *          value of weight is 10.0
     *          value of buyValue is 0
     *          value of sellValue is 0
     *          value of lock will be null
     */
    public Door (Room room1, Room room2){
        this(room1, room2, true);
    }


    /**
     * constructor for Door class
     * @param room1: is one side of the door.
     * @param room2: is the other side of the door.
     * @param open: is if the door is open or not
     * Defaults value of weight is 10.00
     *          value of name will be "unknown door"
     *          value of buyValue will be 0
     *          Value of sellValue will be 0
     *          value of lock will be null
     */
    public Door(Room room1, Room room2, boolean open){
        this("Unknown Door", room1, room2, open );
    }


    /**
     * constructor for Door class
     * @param name: is the name of the Door
     * @param room1: is one side of the door.
     * @param room2: is the other side of the door.
     * @param open: is if the door is open or not
     * Defaults value of weight is 10.00
     *          value of buyValue will be 0
     *          Value of sellValue will be 0
     *          value of lock will be null
     */
    public Door(String name, Room room1, Room room2, boolean open){
        this(name, room1, room2, open, 10.0 );
    }


    /**
     * constructor for Door class
     * @param name: is the name of the Door
     * @param room1: is one side of the door.
     * @param room2: is the other side of the door.
     * @param open: is if the door is open or not
     * @param weight: is the weight of the Door.
     * Defaults value of buyValue will be 0
     *          Value of sellValue will be 0
     *          value of lock will be null
     */
    public Door(String name, Room room1, Room room2,boolean open, double weight){
        this(name, room1, room2, open, weight, 0, 0);
    }


    /**
     * Designated constructor for Door class
     * @param name: is the name of the item
     * @param room1: is one side of the door.
     * @param room2: is the other side of the door.
     * @param open: is if the door is open or not
     * @param weight: is the weight of the item.
     * @param buyValue: is how much the item is to buy
     * @param sellValue: is how much the item sells for
     * Defaults value of lock will null
     */
    public Door(String name,Room room1, Room room2, boolean open, double weight, int buyValue,int sellValue){
        this.name = name;
        this.room1 = room1;
        this.room2 = room2;
        this.open = open;
        this.weight = weight;
        this.buyValue = buyValue;
        this.sellValue = sellValue;
        this.lock = null;
    }


    /**
     * this method will get the room that is on the other side of the door
     * @param currentRoom: the room the player is currently standing in
     * @return Room: the other room this door connects too
     */
    public Room getOtherSide(Room currentRoom){
        Room otherSide;

        if(currentRoom == room1)
            otherSide = room2;
        else
            otherSide = room1;

        return otherSide;
    }


    /**
     *
     * @return if the door is open or not
     */
    public boolean isOpen(){
        return open;
    }


    /**
     *
     * @return if the door is closed or not
     */
    public boolean isClosed(){
        return !open;
    }


    /**
     * checks the door's lock to see if can be opened or not
     * @return if the door was opened
     */
    public boolean open(){
        if (lock != null){
            if(lock.mayOpen()){
                open = true;
            }
        }
        else{
            open = true;
        }

        return open;
    }


    /**
     * checks the door's lock to see if can be closed or not
     * @return if the door was closed
     */
    public boolean close(){
        if (lock != null){
            if(lock.mayClose()){
                open = false;
            }
        }
        else{
            open = false;
        }

        return !open;
    }


    /**
     * sets the lock object of this door
     * @param newLock: is the new lock to add to the door
     * @return the old lock that was on the door, null if none
     */
    public Lock setLock(Lock newLock){
        Lock oldLock = this.lock;

        this.lock = newLock;

        return oldLock;
    }

    /**
     * will lock the door if there is a lock tied to the door
     */
    public void lock(){
        if(this.lock != null){
            this.lock.lock();
        }
    }
      
    /**
     *
     * @return Weight: is how much the Door weighs
     */
    @Override
    public double getWeight(){
        return weight;
    }


    /**
     *
     * @return name: is the name of the Door
     */
    @Override
    public String getName(){
        return name;
    }


    /**
     *
     * @return value: is how much the Door is worth
     */
    @Override
    public int getBuyValue(){
        return buyValue;
    }


    /**
     *
     * @return value: is how much the Door is worth
     */
    @Override
    public int getSellValue(){
        return sellValue;
    }


    /**
     *
     * @return Lock: the look that is on the door
     */
    public Lock getLock(){
        return lock;
    }


    /**
     *
     * @return All fields of an door
     */
    @Override
    public String toString(){
        return "Name: " + this.getName() + ", " + this.description() + "\nWeight: " + this.getWeight() +
                " BuyValue: " + this.getBuyValue() + " SellValue:" + this.getSellValue();
    }


     /**
     *
     *
     * @return a string that describes the door
     */
    @Override
    abstract public String description();


    /**
     *  this method is for the use command. it is when the player trys to use an a Door object on a Room
     * @param room: the room in which the item is being used
     */
    @Override
    abstract public void use(Room room);


}
