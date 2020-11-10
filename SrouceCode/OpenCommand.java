package SrouceCode;

/**
 * Implementation of the 'Open' user command.
 *
 * @author Peter N. Keres (2019)
 * @version 1.0 (April 2019)
 */
public class OpenCommand extends Command
{
    /**
     * Constructor for objects of class openCommand
     */
    public OpenCommand()
    {
        super("open");
    }

    /**
     * Try to open something in a direction. If there is something to open, will try to open that object
     * otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
       
        String directionU = this.getSecondWord();

        if(directionU != null){
          directionU = directionU.toUpperCase();

          try{
          Direction direction = Direction.valueOf(directionU);
          player.open(direction);
          }
          catch(IllegalArgumentException e){
              // if there is no second word, we don't know where to go...
              System.out.println("Open where? Invalid direction");
          }

        }
        else{
          System.out.println("Open What? Enter a direction.");
        }

        return false;
    }
}
