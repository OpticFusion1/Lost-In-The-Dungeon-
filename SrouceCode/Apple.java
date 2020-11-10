package SrouceCode;

/**
 *  PURPOSE:        this class allows to have Apple objects in the game world.
 *                  It inherats from Item, so the Apple class does have a name field, buyValue, etc
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class Apple extends Item{

    /**
     * Designated constructor for Apple Class
     * Defaults Name: "Apple"
     *          weight: 1.5
     *          buyValue: 10
     *          sellValue: 2
     */
    public Apple(){
        super("Apple", 1.5, 10, 2);
    }


    /**
     *  
     * @return what an apple looks like
     */
    @Override
    public String description() {
        return "A fresh crisp red apple.";
    }


    /**
     *  this method is for the use command. it is when the player trys to use an Apple object on a Room
     * @param room: the room in which the item is being used
     */
    @Override
    public void use(Room room){
        System.out.println("This item has no use, Its does look fresh and keeps the doctors away.");
    }

}
