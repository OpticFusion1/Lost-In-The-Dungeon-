package SrouceCode;

/**
 *  PURPOSE:      this class sets the standards for any non player character in the world
 *                any character that is not the player much extend this class
 *
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public interface NonPlayerCharacters
{
    /**
     *
     * @return name: the name of the NPC
     */
    public String getName();


    /**
     * allows to add an item into the inventory of the npc
     *
     * @param object: the object you want to add to the inventory of the npc
     */
    public void addItem(WorldObject object);


    /**
     * allows to add an item into the inventory of the npc
     *
     * @param object: the object you want to add to the inventory of the npc
     * @return the object that was removed
     */
    public WorldObject removeitem(WorldObject object);
    
    /**
     * 
     * @return what the NPC looks like 
     */
    public String getDescription();
    
    /**
     * sets the npc to being deiscovered
     */
    public void discovered();
    
    /**
     *
     * @return the status of the NPC if discovered
     */
    public boolean getDiscovered();
    
    /**
     * gives an item to a npc
     * @param object: the object you want to give the npc
     */
    public void giveItem(WorldObject object);
    
    /**
     * if an item is used on the npc
     * @param object: the item that is being used on them 
     */
    public void use(WorldObject object);


}
