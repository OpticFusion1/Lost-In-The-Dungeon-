package SrouceCode;

/**
 *  PURPOSE:        this class lays the foundation/blueprint for any item in the game. 
 *                  Use this interafce when neededing to make a type of items the game would hold
 *                  example of this would be Gems or Weapons
 *                  
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public interface WorldObject
{
     /**
     * 
     * @return name: is the name of the item
     */
    public String getName();
    
    /**
     * 
     * @return Weight: is how much the item weighs
     */
    public double getWeight();
    
    /**
     * 
     * @return value: is how much it is to buy this item
     */
    public int getBuyValue();
    
     /**
     * 
     * @return value: is how much the item will sell for 
     */
    public int getSellValue();
    
    
    /**
     *  this method should return a string of what the item looks like
     *  
     *  @return description: is what the item looks like
     */
    public String description();
    
    /**
     * if the world object is to be used by the player
     * @param room 
     */
    public void use(Room room);
    
}
