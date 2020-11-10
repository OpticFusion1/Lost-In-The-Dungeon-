package SrouceCode;

import java.util.List;
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
public class TransporterRoom extends Room
{
   
    /**
     * Creates an Exit room with the defaults values of 
     *      description: "Transporter Room"
     *      NPC: null
     */ 
    public TransporterRoom() {
        this("Transporter Room", null);
    }
    
    /**
     * Creates an  Exit room with the values of 
     * @param description: what the room looks like/ called
     * @param npc: a non player character in the room 
     */
     public TransporterRoom(String description, NonPlayerCharacters npc)
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
        this.lockAllDoors();
        return "As you enter the room, there is an opening in the floor that starts to suck you in.\nEverything goes dark and you awake in a new room of the dungeon.";
    }
    
    
     /**
      * locks all doors going to this room so can not be entered in by player again 
      * NOTE: if player uses master key, this door will open 
      */
    private void lockAllDoors(){
        
        
        List<Door> doors = this.getExit();
        
        for (Door door : doors){
            door.close();
            door.setLock(new BasicLock());
            door.getLock().lock();

        }
    }
    
    /**
     * if this rooms was selected to be the transpoerter room 
     * it will try to find anohter room tied to it that is not a trasnpoerter room 
     * @param the notification that was used to call this method
     */
    public void transporter(Notification n){
        
        List<Door> doors = this.getExit();
        
        for (Door door : doors){
            if (!door.getOtherSide(this).getClass().getName().equalsIgnoreCase("TransporterRoom")){
                door.getOtherSide(this).transporter(n);
            }
        } 
   
        
    }
}
