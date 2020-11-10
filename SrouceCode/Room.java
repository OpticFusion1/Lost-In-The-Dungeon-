package SrouceCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is the main class of the "lost in a dungeon" application.
 * "lost in a dungeon" is a very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  For each existing exit, the room
 * stores a door which holds a referecnce to the neighboring room.
 *
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018), modified again by Peter N. Keres (2019)
 * @version 1.1 (April 2019)
 */

class Room
{
    private String description;
    private HashMap<Direction, Door> exits;        // stores exits of this room.
    private Container inventory;
    private NonPlayerCharacters npc;
    
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court
     * yard".
     */
    public Room(String description)
    {
        this(description, null);
    }
    
     /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court
     * yard".
     */
    public Room(String description, NonPlayerCharacters npc)
    {
        this.description = description;
        exits = new HashMap<Direction, Door>();
        inventory = new Inventory();
        this.npc = npc;
    }

    /**
     * Define an exit from this room.
     */
    public void setExit(Direction direction, Door door)
    {
        exits.put(direction, door);
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of this room, in the form:
     *     You are in the kitchen.
     *     Exits: north west
     */
    public String getLongDescription()
    {

        String string = new String();
        
        string = string + "You are " + description;
        string = string + ".\n" + getExitString();
        if (getInventory().count() > 0){
            string = string + ".\n You see the following items.\n" + getInventory();
        }
        if (getNpc() != null){
            string = string + "\n" + npc;
        }
        
        return string;

    }

 
    /**
     * 
     * @return the inventory of the room 
     */
    public Container getInventory(){
        return inventory;
    }
    
    
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        for(Direction exitName : exits.keySet())
        {
            returnString += " " + exitName;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Door getExit(Direction direction) 
    {
        return exits.get(direction);
    }
    
    
    /**
     * 
     * @return list of doors the room is ited too  
     */
    public List<Door> getExit(){
        
        List<Door> exits = new LinkedList<Door>();
        
        for (Map.Entry<Direction, Door> current : this.exits.entrySet()){
            exits.add(current.getValue());
        }
        
        
        return exits;
    }
    
    /**
     * 
     * @return the npc of the room 
     */
    public NonPlayerCharacters getNpc(){
        return this.npc;
    }
    
    /**
     * sets the npc of the room
     * @param npc: the npc you want to be in the room 
     */
    public void setNpc(NonPlayerCharacters npc){
        this.npc = npc;
    }
   
    /**
     * removes the room of the npc 
     */
    public void removeNpc(){
        this.npc = null;
    }
    
    /**
     * if this room was picked as the trasnporter room 
     * @param n 
     */
    public void transporter(Notification n){
        
        System.out.println(this.getShortDescription());
        ((Player)n.getObject()).setCurrentRoom(this);
    }
    
    /**
     * adding an itme to the inventory/ floor of the room
     * @param item: the item you wan to add to the room 
     */
    public void addItem(WorldObject item){
        inventory.add(item);
    }
    

}
