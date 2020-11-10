package SrouceCode;

/**
 *  This class is the main class of the "lost in a dungeon" application.
 *  "lost in a dungeon" is a very simple, text based adventure game.
 *
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 *
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.
 *
 *  this world room layout is basied on the V 1.0 of the dungeon
 *
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018), modified again by Peter N keres (2019)
 * @version 1.2 (April 2019)
 */

class Game
{
    private Parser parser;
    private Player player;
    private boolean victory;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        player = new Player(World.getInstance().getStartRoom());
        parser = new Parser();
        victory = false;
        NotificationCenter.getInstance().queueAddObserver("Exit Room", this, "victory");
        NotificationCenter.getInstance().processQueue();
    }


    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        
        while(! finished) {
            Command command = parser.getCommand();
            if(command == null) {
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(player);
                if (victory == true){
                    finished = true;
                }
            }
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }


    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("You found your self lost in a dungeon!");
        System.out.println("The lost in a dungeon is a new, incredibly boring adventure game.");
        System.out.println("You have to find your way out!");
        System.out.println("\nType 'help' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }
    
    /**
     *  if the player hits a victory condition
     * @param n the notificatoin that is tied to a vicotry condition.
     */
    public void victory(Notification n){
        
        this.victory = true;
    }
}
