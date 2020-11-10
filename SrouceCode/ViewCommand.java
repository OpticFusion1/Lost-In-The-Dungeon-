package SrouceCode;

/**
 * Implementation of the 'view' user command.
 *
 * @author Peter N. Keres (2019)
 * @version 1.0 (April 2019)
 */
public class ViewCommand extends Command
{
   
     /**
     * Constructor for objects of class view  command
     */
    public ViewCommand()
    {
        super("view");
    }

    /**
     * tyrs to view some object in the world
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
      
        if (this.getSecondWord() != null){
            if(this.getSecondWord().equalsIgnoreCase("inventory")){
                System.out.println(player.getInventory());
            }
            else if(this.getSecondWord().equalsIgnoreCase("room")){
                System.out.println(player.getCurrentRoom().getLongDescription());
            }
            else{
                System.out.println("view what? that Object can not be viewed.");
            }
        }
        else{
          System.out.println("view what? Please enter a agrument.");
        }

        return false;
    }
}
