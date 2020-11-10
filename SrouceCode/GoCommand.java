package SrouceCode;

/**
 * Implementation of the 'go' user command.
 *
 * @author Michael Kolling modified by Rodrigo A. Obando (2018), modified again by Peter N. Keres (2019)
 * @version 1.1 (April 2019)
 */
public class GoCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public GoCommand()
    {
        super("go");
    }

    /**
     * Try to go to one direction. If there is an exit
     * trys to open the door
     * otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
      
        String directionU = this.getSecondWord();

        if(directionU != null){
          directionU = directionU.toUpperCase();

          try{
              Room oldRoom = player.getCurrentRoom();
              Direction direction = Direction.valueOf(directionU);
              player.walk(direction);
          }
          catch(IllegalArgumentException e){
              // if the second word is not in the list of directoins
              System.out.println("Go where? Invalid direction");
          }

        }
        else{
          System.out.println("go to where? Enter a direction.");
        }

        return false;
    }
}
