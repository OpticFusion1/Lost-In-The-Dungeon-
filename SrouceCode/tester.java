package SrouceCode;

/**
 *  this is just a simpler tester class that will be used to help in the debugging of the
 *  "lost in a dungeon" application
 *
 *  most likely, Well be deleted on file version of the application.
 *
 * @author Peter N. Keres (2019)
 * @version 1.0 (April 2019)
 */


public class tester
{
   public static void main(String[] args)
   {
       Game newgame = new Game();

      // WorldObject testApple = new Apple();
       
       //System.out.println(testApple);
       

       newgame.play();

       /**

        Room room = new Room("basemnt");
        Plate plate = new Plate();
        Cup cup = new Cup();
        Cup cup2 = new Cup();
        MasterKey key = new MasterKey();


        room.getInventory().add(plate);
        room.getInventory().add(cup);
        room.getInventory().add(cup2);
        room.getInventory().add(key);

        System.out.println(room.getLongDescription());

        room.getInventory().remove("Cup");

        System.out.println(room.getLongDescription());

        */

   }

}
