package SrouceCode;

/**
 *  PURPOSE:       this class allows the player to use the "back" Command
 *                  the back command allows the player to go back x number of rooms
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class BackCommand extends Command
{

     /**
     * Constructor for objects of class GoCommand
     */
    public BackCommand()
    {
        super("back");
    }


    /**
     * this method will removed prev rooms stored by the player and set that rooms
     * to the palyer's current Room
     * @param player: the player that is using the command
     * @return booelan: always return false so game does not end
     */
    @Override
    public boolean execute(Player player)
    {
        if(this.getSecondWord() == null){
           Room oldRoom = player.removePrevRoom();
           if(oldRoom != null){
                player.setCurrentRoom(oldRoom);
                System.out.println(oldRoom.getLongDescription());
           }
           else{
               System.out.println("There is no room to go back too.");
           }
        }
        else{
          System.out.println("The back command does not require extra arugments.");
        }
        return false;
    }

    
}
