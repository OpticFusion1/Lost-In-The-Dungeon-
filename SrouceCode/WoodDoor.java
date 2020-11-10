package SrouceCode;

/**
 *  PURPOSE:        this class is for any basic woodend door in the game
 *                  This class follows the patterns set by the Door object
 *                  woodedn door will the basic door used
 * 
 * About:           A door links 2 rooms together
 *                  a door can be opended or closed
 *                  a door can also have a lock object tied to it
 *                  
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */

public class WoodDoor extends Door
{
    
    /**
     * constructor for WoodDoor class
     * @param: room1: one of the rooms the door is tied too
     * @param: room2: the other room the door is tied too 
     * Defaults value of name is "Wooden Door"
     *          value of open is true
     *          value of weight is 10.0
     *          value of buyValue is 0
     *          value of sellValue is 0
     *          value of lock will be null
     */
    public WoodDoor(Room room1, Room room2){
        super("Wooden Door", room1, room2, true);
    }
    
    
    
     /**
     *  
     * @return what an Wooden door looks like
     */
    @Override
    public String description() {
        return "Large Wooden door";
    }
    
    /**
     * if the player trys to use the door on a room 
     * @param room: in whic the tiem is being used in 
     */
    @Override
    public void use(Room room){
        System.out.print("This item has no use, Why are you even carrying this?");
    }
}
