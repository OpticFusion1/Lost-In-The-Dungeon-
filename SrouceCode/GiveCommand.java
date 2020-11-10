package SrouceCode;

/**
 *  PURPOSE:       this class allows the player to use the "give" Command
 *                  the back command allows the player to give an item in there inventory to a NPC in the World
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class GiveCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public GiveCommand()
    {
        super("give");
    }

    /**
     * try to give a item from the player to a npc in the world
     * otherwise print an error message and puts back the item into the player's inventory.
     * Returns always 'false'.
     */
    public boolean execute(Player player)
    {

        String strItem = this.getSecondWord();
        String strNpc = this.getThirdWord();

        if(strItem != null){
            WorldObject objItem = (WorldObject)player.getInventory().remove(strItem);
            if (objItem != null){
                if (strNpc != null){
                    NonPlayerCharacters objNpc = player.getCurrentRoom().getNpc();
                    if(objNpc != null || !objNpc.getName().equalsIgnoreCase(strNpc) ){
                        objNpc.giveItem(objItem);
                        System.out.println("You gave " + strNpc + " the item " + strItem);
                    }
                    else{
                        System.out.println("Give to who? that NPC is not in this room");
                        player.getInventory().add(objItem);
                    }
                }
                else{
                    System.out.println("Give to who? enter a NPC name.");
                    player.getInventory().add(objItem);
                }
            }
            else{
                System.out.println("Give what? that item is not here.");
            }
        }
        else{
          System.out.println("Give what? Enter a Item.");
        }

        return false;
    }
}
