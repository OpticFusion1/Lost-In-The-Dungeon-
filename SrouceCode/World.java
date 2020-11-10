package SrouceCode;

import java.util.Random;

/**
 *  this class is used to create a "world" within our "lost in a dungeon" application.
 * 
 *  this class is modeled after the singleton pattern.
 *  Meaning we will only have ONE instance of the world object
 *
 *  the main purpose of this class is to create the world the player will interact in.
 *  creating the rooms, linking the rooms, and populating the rooms
 *
 *
 * @author Peter Keres (2019)
 * @version 1.0 (April 2019)
 */
public class World {

    private static World INSTANCE;
    private Room startRoom;

    private World() {
        CreateWorld();
    }

    public static World getInstance() {

        if (INSTANCE == null){
            INSTANCE = new World();
        }

        return INSTANCE;
    }

    /**
     *  this class is used to get what room the player will start in
     * @return  the starting room of type Room
     */
    public Room getStartRoom(){
        return startRoom;
    }

    /**
     *   this method will create all the rooms and link them and set the starting room
     *
     */
    private void CreateWorld(){
    
        Room firstRoom = new Room ("The Starting Room");
        Room treeRoom = new Room ("The Tree Room");
            treeRoom.setNpc(new Tree(treeRoom));
        Room nWingRoom1 = new Room ("North Wing Room One");
            nWingRoom1.addItem(new Apple());
        Room nWingRoom2 = new Room ("North Wing Room Two");
            nWingRoom2.addItem(new Ring());
        Room exitRoom = new ExitRoom();
        
        Door door = this.makeWoodDoor(firstRoom, treeRoom, Direction.NORTH, Direction.SOUTH);
        door = this.makeWoodDoor(treeRoom, nWingRoom1, Direction.NORTH, Direction.SOUTH); 
        door = this.makeWoodDoor(nWingRoom1, nWingRoom2, Direction.NORTH, Direction.SOUTH);
            door.close();
        door = this.makeWoodDoor(nWingRoom2, exitRoom, Direction.EAST, Direction.WEST);
            door.close();
            door.setLock(new BasicLock());
            door.lock();
        
        
        Room eWingRoom1 = new Room ("East Wing Room One");
            eWingRoom1.addItem(new Gem());
        Room eWingRoom2 = new Room ("East Wing Room Two");
            eWingRoom2.addItem(new Cup());
            eWingRoom2.addItem(new Plate());
        Room eWingRoom3 = new Room ("East Wing Room Three");
            eWingRoom3.addItem(new Apple());
        
        door = this.makeWoodDoor(treeRoom, eWingRoom1, Direction.EAST, Direction.WEST);
        
        
        door = this.makeWoodDoor(eWingRoom1, eWingRoom2, Direction.EAST, Direction.WEST);
        
        
        door = this.makeWoodDoor(eWingRoom2, eWingRoom3, Direction.NORTH, Direction.SOUTH);
            door.close();
            door.setLock(new BasicLock());
            door.lock();
            Key key1 = new BasicKey();
            key1.addLock(door);
            nWingRoom1.addItem(key1);
        
        
        Room wWingRoom1 = new Room ("West Wing Room One");
             wWingRoom1.addItem(new Cup());
             wWingRoom1.addItem(new Plate());
        Room voidRoom = new Room ("Void Room");
            voidRoom.setNpc(new ShopKeeper(voidRoom));
        Room wWingRoom2 = new Room ("West Wing Room Two");
            wWingRoom2.addItem(new Gem());
        Room wWingRoom3 = new Room ("West Wing Room Three");
        Room wWingRoom4 = new Room ("West Wing Room Four");
            wWingRoom4.addItem(new Apple());
        Room tellRoom = new TransporterRoom ();
        
        door = this.makeWoodDoor(treeRoom, wWingRoom1, Direction.WEST, Direction.EAST);
        
        door = this.makeWoodDoor(wWingRoom1, voidRoom, Direction.NORTH, Direction.SOUTH);
            door.close();
        
        door = this.makeWoodDoor(wWingRoom1, wWingRoom2, Direction.WEST, Direction.EAST);
        
        door = this.makeWoodDoor(wWingRoom2, wWingRoom3, Direction.NORTH, Direction.SOUTH);
            door.close();
        
        door = this.makeWoodDoor(wWingRoom3, wWingRoom4, Direction.NORTH, Direction.SOUTH);
            door.close();
            door.setLock(new BasicLock());
            door.lock();
            Key key2 = new BasicKey();
            key2.addLock(door);
            eWingRoom3.addItem(key2);
        
        door = this.makeWoodDoor(wWingRoom2, tellRoom, Direction.SOUTH, Direction.NORTH);
            door.close();
      
            //list of rooms to be the room the tellporter takes the palyer too
        Room[] roomList = new Room[]{firstRoom, treeRoom, nWingRoom1, nWingRoom2,
                                        eWingRoom1, eWingRoom2,
                                        wWingRoom1, voidRoom, wWingRoom2, wWingRoom3};
        Random rand = new Random();
        int randRoom = rand.nextInt(roomList.length);
        NotificationCenter.getInstance().queueAddObserver("Transporter Room", roomList[randRoom], "transporter");
        NotificationCenter.getInstance().processQueue();
        
        
        
        
        




        startRoom = firstRoom;
    }
    
    
    /**
     * helper function that will connect 2 rooms and makes a door for us 
     * @param room1
     * @param room2
     * @param room1exit exit for room one going into room 2
     * @param room2exit exit for room 2 going into room 1
     * @return the door that connects the room 
     */
    private Door makeWoodDoor(Room room1, Room room2, Direction room1exit, Direction room2exit){
        Door door = new WoodDoor(room1, room2);
        
        room1.setExit(room1exit, door);
        
        room2.setExit(room2exit, door);
        
        return door;
    }
}
