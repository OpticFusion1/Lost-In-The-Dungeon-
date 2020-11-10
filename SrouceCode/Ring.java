package SrouceCode;

/**
 *  PURPOSE:        this class allows to have Ring objects in the game world. 
 *                  It inherats from Item, so the Ring class does have a name field, buyValue, etc
 *                  
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class Ring extends Item
{
    /**
     * Designated constructor for Plate Class
     * Defaults Name: "Ring"
     *          weight: 1.5
     *          buyValue: 20
     *          sellValue: 10
     */
    public Ring(){
        super("Ring", 1.5, 20, 10);
    }
   
    
    /**
     *  
     * @return what an Plate looks like
     */
    @Override
    public String description() {
        return "Looks like a wedding right, covered in dust.";
    }
    
    /**
     * when you use this item in a room
     * @param room: the room in which the items was used in 
     */
    @Override
    public void use(Room room){
        System.out.println("You try to wear it, but its not your size.");
    }
    
    
}
