package SrouceCode;

/**
 *  PURPOSE:        this class allows to have Axe objects in the game world.
 *                  It inherats from Item, so the Axe class does have a name field, buyValue, etc
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class Axe extends Item
{
   
    /**
     * Designated constructor for Plate Class
     * Defaults Name: "Axe"
     *          weight: 5
     *          buyValue: 10
     *          sellValue: 5
     */
    public Axe(){
        super("Axe", 5, 10, 5);
    }
   
    
    /**
     *  
     * @return what an Axe looks like
     */
    @Override
    public String description() {
        return "An rusty old axe, I wonder if there is a tree in need of chopping";
    }
    
    /**
     *  this method is for the use command. it is when the player trys to use an Axe object on a Room
     * @param room: the room in which the item is being used
     */
    @Override
    public void use(Room room){
        
        // if there is a tree in the room, pass it the axe and let tree handled what it does when a axe is used on it 
        if (room.getNpc().getClass().getName().equalsIgnoreCase("Tree")){
            room.getNpc().use(this);
        }
        else{
            System.out.println("This item has no use, maybe keep it for when you find that speical someone.");
        }
       
    }
    
}
