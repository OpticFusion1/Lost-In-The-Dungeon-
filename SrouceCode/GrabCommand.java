package SrouceCode;

/**
 * Implementation of the 'grab' user command.
 *
 * @author Peter N. Keres (2019)
 * @version 1.0 (April 2019)
 */
public class GrabCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public GrabCommand()
    {
        super("grab");
    }

    /**
     * trys to grab an item in the room and add it to the player inventory
     * otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {

        String item = this.getSecondWord();

        if(item != null){
            WorldObject object = (WorldObject)player.getCurrentRoom().getInventory().remove(item);
            if (object != null){
                if(player.getInventory().add(object)){
                    System.out.println("You added " + item + " to your inventory.");
                }
                else{
                    player.getCurrentRoom().getInventory().add(object);
                }
            }
            else{
                System.out.println("grab what? that item is not here.");
            }
        }
        else{
          System.out.println("grab what? Enter a Item.");
        }

        return false;
    }
}
