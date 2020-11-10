package SrouceCode;

/**
 *  PURPOSE:      this class if for tree in the game
 *                 the tree is the charater the the player meets who tells him what to do and how to get out
 *                  the tree alos drops the master key that lets the player out of the dungon 
 *                
 *
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class Tree implements NonPlayerCharacters
{
    private String name;
    private Container<WorldObject> inventory;
    private boolean Discovered;
    private Room currentRoom;

    
    /**
     * making a tree
     * @param room: the room in which the tree is set too
     * defaluts values are Name: "Tree"
     *                      inventory: new inventor
     *                      discoverd: false
     *                      totalWorth: 0
     */
    public Tree(Room room){
        name = "Tree";
        inventory = new Inventory();
        Discovered = false;
        currentRoom = room;
    }

       /**
     * 
     * @return the name of the Tree
     */
    @Override
    public String getName() {
        return this.name;
    }

     /**
     * 
     * @param object the item you want to add to the inveotry of the Tree 
     */
    @Override
    public void addItem(WorldObject object) {
        inventory.add(object);
    }

        /**
     * 
     * @param object: the object to remove from the Tree invenotry 
     * @return the ojbect that was remvoed
     */
    @Override
    public WorldObject removeitem(WorldObject object) {
        return inventory.remove(object);
    }

    /**
     * 
     * @return what the Tree looks like 
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
     * @return What Tree looks like on first meeting 
     */
    private String firstDiscovered(){
        return "You see infront of you a large white tree.\n It speaks to you and "
                + "says\" Bring me 3 of my lost apples and i will give you a key that lets you leave this place.";
    }

     /**
     * 
     * @return what Tree looks like on anymeeting after first 
     */
    private String normalDiscovered(){
        return "\"Still looking for the apples are we? or do you like it here now.\"-speaks the tree";
    }

     /**
     *  the Tree has been discovered
     */
    @Override
    public void discovered() {
        Discovered = true;
    }

        /**
     * 
     * @return if the Tree has been discored  
     */
    @Override
    public boolean getDiscovered() {
        return Discovered;
    }
    
    /**
     * if the Tree has be given an item 
     * @param object: the ojbject given to the Tree
     */
    @Override
    public void giveItem(WorldObject object) {
        Apple apple = new Apple();

        if (object != null){
            this.addItem(object);

            if (inventory.count(apple) == 3){
                this.dropKey();
                System.out.println("\"Thank you so much for bring back my apples. Take this and never be trapped again.\"\n"
                + "(a key falls from the tree's branches on to the ground.)");
            }
            else if(inventory.count(apple) > 3){
                System.out.println("Thank you for the extra apples, but i have nothing else to give you.");
            }
            else{
                System.out.println("Thank you for this gift");
            }
        }


    }

   /**
     * what rewoard the Tree drops
     */
    private void dropKey(){
        currentRoom.getInventory().add(new MasterKey());
    }

     /**
     * 
     * @return what Tree keeper looks like 
     */
    @Override
    public String toString(){
        return this.getDescription();
    }


    /**
     * if a plyer uses an object on Tree
     * @param object: the object being used on the Tree 
     */
    @Override
    public void use(WorldObject object) {
        
        if (object.getClass().getName().equalsIgnoreCase("Axe")){
            System.out.println("NOOOOOOOOOOO, HOW COULD YOU DO THIS TO MEEEEEE");
            this.dropKey();
            System.out.println("(a key falls from the tree's branches on to the ground.)");
            this.currentRoom.removeNpc();
        }
    }

    
}
