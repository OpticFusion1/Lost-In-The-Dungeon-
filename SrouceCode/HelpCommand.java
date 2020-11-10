package SrouceCode;

/**
 * Implementation of the 'help' user command.
 *
 * @author Michael Kolling modified by Rodrigo A. Obando (2018), modified again by Peter N keres (2019)
 * @version 1.1 (April 2019)
 */
public class HelpCommand extends Command
{
    private CommandWords commandWords;

    /**
     * Constructor for objects of class HelpCommand
     */
    public HelpCommand(CommandWords words)
    {
        super("help");
        commandWords = words;
    }

    /**
     * Print out some help information. Here we print some stupid,
     * cryptic message and a list of the command words.
     * Returns always false.
     */
    public boolean execute(Player player)
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around the dungeon looking for a way out.");
        System.out.println();
        System.out.println("Your command words are:");
        commandWords.showAll();
        return false;
    }
}
