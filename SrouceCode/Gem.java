package SrouceCode;

/**
 *  PURPOSE:        this class allows to have Gem objects in the game world.
 *                  It inherats from Item, so the Gem class does have a name field, buyValue, etc
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class Gem extends Item
{
   /**
     * Designated constructor for Plate Class
     * Defaults Name: "Gem"
     *          weight: 2.5
     *          buyValue: 8
     *          sellValue: 5
     */
    public Gem(){
        super("Gem", 2.5, 8, 5);
    }
   
    
    /**
     *  
     * @return what an Gem looks like
     */
    @Override
    public String description() {
        return "Is a green emerald, cut into a square. You can almost see your reflection in it.";
    }
    
    /**
     *  this method is for the use command. it is when the player trys to use an Gem object on a Room
     * @param room: the room in which the item is being used
     */
    @Override
    public void use(Room room){
        System.out.println("This item has no use, maybe keep it for when you find that speical someone.");
    }
    
    
}
