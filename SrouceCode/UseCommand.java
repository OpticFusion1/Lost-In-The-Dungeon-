package SrouceCode;

import java.util.LinkedList;
import java.util.List;


/**
 * Implementation of the 'use' user command.
 *
 * @author Peter N. Keres (2019)
 * @version 1.0 (April 2019)
 */
public class UseCommand extends Command
{
    /**
     * Constructor for objects of class use command
     */
    public UseCommand()
    {
        super("use");
    }

    /**
     * trys to use an object in the players inventory on a room in the world
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        

        List<WorldObject> objects = new LinkedList<WorldObject>();
        String item = this.getSecondWord();

        if(item != null){
           
            if (player.getInventory().contain(item)){
               
                do{
                    WorldObject object = (WorldObject)player.getInventory().remove(item);
                    object.use(player.getCurrentRoom());
                    objects.add(object);
                }while(player.getInventory().contain(item));
                
                while (!objects.isEmpty()){
                    player.getInventory().add(objects.remove(0));
                }
            }
            else{
                System.out.println("use what? that item is not in your inventory.");
            }

        }
        else{
          System.out.println("use what? Enter a Item.");
        }

        return false;
    }
}
