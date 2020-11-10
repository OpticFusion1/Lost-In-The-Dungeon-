package SrouceCode;

/**
 *  PURPOSE:        this class allows to have Cup objects in the game world.
 *                  It inherats from Item, so the Cup class does have a name field, buyValue, etc
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class Cup extends Item
{
    /**
     * Designated constructor for Cup Class
     * Defaults Name: "Cup"
     *          weight: 1.0
     *          buyValue: 3
     *          sellValue: 1   
     */
    public Cup(){
        super("Cup", 1.0, 3, 1);
    }


    /**
     *
     * @return what an Cup looks like
     */
    @Override
    public String description() {
        return "So thick with dust its hard to see the bottom of the cup.";
    }


    /**
     *  this method is for the use command. it is when the player trys to use an Cup object on a Room
     * @param room: the room in which the item is being used
     */
    @Override
    public void use(Room room){
        System.out.println("This item has no use, Its not tea time yet!");
    }
}
