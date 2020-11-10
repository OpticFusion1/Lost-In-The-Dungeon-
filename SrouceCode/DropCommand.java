package SrouceCode;

/**
 *  PURPOSE:       this class allows the player to use the "drop" Command
 *                  the drop command allows the player to drop a item in there inventory in the room
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class DropCommand extends Command
{
    /**
     * Constructor for objects of class DropCommand
     */
    public DropCommand()
    {
        super("drop");
    }

    /**
     * Try to drop one item in the player's inventory into a room
     * otherwise print an error message. Returns always 'false'.
     * @param player: the player who uses this command
     * @return boolean: always false so the game does not end
     */
    @Override
    public boolean execute(Player player)
    {
        String item = this.getSecondWord();

        if(item != null){
            WorldObject object = (WorldObject)player.getInventory().remove(item);
            if (object != null){
                player.getCurrentRoom().getInventory().add(object);
                System.out.println("You dropped " + item + " in the room.");
            }
            else{
                System.out.println("drop what? that item is not here.");
            }
        }
        else{
          System.out.println("drop what? Enter a Item.");
        }

        return false;
    }
}
