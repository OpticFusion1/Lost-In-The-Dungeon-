package SrouceCode;

/**
 *  PURPOSE:      this class if for shopkeeprs in the game
 *                  the shopkeeper is a black void that players van give items and the void might drop items in return 
 *                
 *
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class ShopKeeper implements NonPlayerCharacters
{
    
    private String name;
    private Container<WorldObject> inventory;
    private boolean[] rewards;
    private boolean Discovered;
    private Room currentRoom;
    private int totalWorth;
    
    
    /**
     * making a shopkeeper
     * @param room: the room in which the shopkeeper is set too
     * defaluts values are Name: "Void"
     *                      inventory: new inventory
     *                      rewards: holds 3 true rewards
     *                      discoverd: false
     *                      totalWorth: 0
     */
    public ShopKeeper(Room room){
        name = "void";
        inventory = new Inventory();
        rewards = new boolean[] {true, true, true};
        Discovered = false;
        currentRoom = room;
        totalWorth = 0;
 
    }
     
    /**
     * 
     * @return the name of the shopkeeper
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @param object the item you want to add to the inveotry of the shopkeeper 
     */
    @Override
    public void addItem(WorldObject object) {
        inventory.add(object);
    }

    /**
     * 
     * @param object: the object to remove from the shopkeeper invenotry 
     * @return the ojbect that was remvoed
     */
    @Override
    public WorldObject removeitem(WorldObject object) {
        return inventory.remove(object);
    }

    /**
     * 
     * @return what the shopkeeper looks like 
     */
    @Override
    public String getDescription() {
        String description;
        
        if(this.getDiscovered() == false){
            description = this.firstDiscovered();
            this.discovered();
        }
        else{
            description = this.normalDiscovered();
        }
        
        return description;
    }
    
    /**
     * 
     * @return What shoppkeepr looks like on first meeting 
     */
    private String firstDiscovered(){
        return "You see infront of you a small black void floating in the air";

    }
    
    /**
     * 
     * @return what shopkeeper looks like on anymeeting after first 
     */
    private String normalDiscovered(){
        return "The hold is in the same place you left it. Maybe you could interact with it?";
    }

    /**
     *  the shopkeepr has been discovered
     */
    @Override
    public void discovered() {
        Discovered = true;
    }

    /**
     * 
     * @return if the shopkeeper has been discored  
     */
    @Override
    public boolean getDiscovered() {
        return Discovered;
    }

    /**
     * if the shopkeepr has be given an item 
     * @param object: the ojbject given to the shopkeepr
     */
    @Override
    public void giveItem(WorldObject object) {
       
        if (object != null){
            totalWorth = totalWorth + object.getSellValue();
            inventory.add(object);  
            System.out.println("You throw the " + object.getName() + " into the void and it is sucked away into the darkness.");
        }
       
        this.dropItem();
    }
    
    /**
     * what rewoard the shopkeepr drops
     */
    private void dropItem(){
       
        if ( totalWorth > 10 && rewards[0]){
             currentRoom.getInventory().add(new Apple());
             rewards[0] = false;
             System.out.println("out of the black void drops an Apple!");
        }
        if( totalWorth > 15 && rewards[1]){
           currentRoom.getInventory().add(new Axe());
             rewards[1] = false;
             System.out.println("out of the black void drops an rusty old Axe.");
        }
        else if( totalWorth > 20 && rewards[2]){
            currentRoom.getInventory().add(new MasterKey());
             rewards[2] = false;
             System.out.println("out of the black void drops a very strange looking key.");
        }
        
    }
    
    /**
     * 
     * @return what shopp keeper looks like 
     */
    @Override
    public String toString(){
        return this.getDescription();
    }

    /**
     * if a plyer uses an object on shop keeper
     * @param object: the object being used on the shopkeeper 
     */
    @Override
    public void use(WorldObject object) {
        
        System.out.println("you try to use the " + object.getName() + " on the void with no effect.");
        this.giveItem(object);
    }
    
        
}
