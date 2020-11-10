package SrouceCode;

/**
 *  PURPOSE:        this class allows to have Plate objects in the game world. 
 *                  It inherats from Item, so the Plate class does have a name field, buyValue, etc
 *                  
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class Plate extends Item
{
    /**
     * Designated constructor for Plate Class
     * Defaults Name: "Plate"
     *          weight: 2.5
     *          buyValue: 4
     *          sellValue: 1
     */
    public Plate(){
        super("Plate", 2.5, 4, 3);
    }
   
    
    /**
     *  
     * @return what an Plate looks like
     */
    @Override
    public String description() {
        return "The size Looks as though this might have been a dinner plate. Still useable even with the chip";
    }
    
    /**
     * using the item in a room
     * @param room: the room in which the item is being used in 
     */
    @Override
    public void use(Room room){
        System.out.println("This item has no use, If only you had a sandwich.");
    }
}
