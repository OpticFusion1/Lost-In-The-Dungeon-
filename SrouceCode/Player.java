package SrouceCode;

import java.util.Stack;

/**
 * This class represents players in the game. Each player has 
 * a current location
 * a inventory 
 * 
 * @author Michael Kolling modified by Rodrigo A. Obando (2018) modified again by Peter N keres (2019)
 * @version 1.0 (December 2002)
 */
public class Player
{
    private Room currentRoom;
    private Container inventory;
    private Stack<Room> prevRooms;


    /**
     * Constructor for objects of class Player
     */
    public Player(Room startingRoom)
    {
        currentRoom = startingRoom;
        inventory = new Inventory();
        prevRooms = new Stack<Room>();
        inventory.setLimit(new Ring(), 1);
        inventory.setLimit(new Gem(), 1);
    }

    /**
     * Return the current room for this player.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * Set the current room for this player.
     */
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }
    
    /**
     * adding a room to the list of prev room the palyer has been in 
     * @param room: the room in which the player was in 
     */
    public void addPrevRoom(Room room){
        if(room != null){
            prevRooms.push(room);
        }
        
    }
    
    /**
     * remvoes a room from the list of prev room the player was in 
     * @return a room the player was just in
     */
    public Room removePrevRoom(){
        Room lastRoom = null;
        if(!prevRooms.empty()){
            lastRoom = prevRooms.pop();
        }
        
        return lastRoom;
    }
    
    /**
     * 
     * @return the inventory of the player 
     */
    public Container getInventory(){
        return inventory;
    }
    
    
    
    
    /**
     * Try to walk in a given direction. If there is a door
     * this will change the player's location.
     */
    public void walk(Direction direction)
    {
        // Try to leave current room.
        Door door = currentRoom.getExit(direction);

        if (door == null)
            System.out.println("There is no exit in that direction!");
        else {
            if (door.isOpen()){
                this.addPrevRoom(currentRoom);
                setCurrentRoom(door.getOtherSide(currentRoom));
                System.out.println(currentRoom.getLongDescription());
                NotificationCenter.getInstance().postNotification(new Notification(currentRoom.getShortDescription(), this));
            }
            else{
                System.out.println("There is a door and its closed.");
            }
        }
        
    }
    
    
    /**
     * lets player open up a door in a given direction
     * @param directoin: where the door is located 
     */
    public void open(Direction directoin){
        
        if(currentRoom.getExit(directoin).open()){
            System.out.println("The door is open!");
        }
        else{
            System.out.println("The door seems to be locked.");
        }
    
    }
    
}
