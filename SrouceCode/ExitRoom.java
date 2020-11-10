package SrouceCode;

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
 * @author  Peter N. Keres (2019)
 * @version 1.1 (April 2019)
 */

public class ExitRoom extends Room
{
    
    /**
     * Creates an Exit room with the defaults values of 
     *      description: "Exit Room"
     *      NPC: null
     */
    public ExitRoom() {
        this("Exit Room", null);
    }
    
    
    /**
     * Creates an  Exit room with the values of 
     * @param description: what the room looks like/ called
     * @param npc: a non player character in the room 
     */
     public ExitRoom(String description, NonPlayerCharacters npc)
    {
       super(description, npc);
    }
    
     
     /**
      * 
      * @return What the room looks like
      */
    @Override
     public String getLongDescription()
    {      
        return "the door opens, the shinshine hits your face. you have escaped.";
    }
     
     

}
