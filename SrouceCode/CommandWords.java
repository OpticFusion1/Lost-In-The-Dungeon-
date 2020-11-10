package SrouceCode;

import java.util.HashMap;
/**
 * This class is the command words class of the "lost in a dungeon" application.
 * "lost in a dungeon" is a very simple, text based adventure game.
 *
 * This class holds a collection of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018) modified again by Peter N Keres (April 2019)
 * @version 2.1 (April 2019)
 */

public class CommandWords
{
    private HashMap<String, Command> commands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        Command command = new GoCommand();
        commands.put(command.getName(), command);
        command = new HelpCommand(this);
        commands.put(command.getName(), command);
        command = new QuitCommand();
        commands.put(command.getName(), command);
        command = new OpenCommand();
        commands.put(command.getName(), command);
        command = new GrabCommand();
        commands.put(command.getName(), command);
        command = new DropCommand();
        commands.put(command.getName(), command);
        command = new BackCommand();
        commands.put(command.getName(), command);
        command = new ViewCommand();
        commands.put(command.getName(), command);
        command = new UseCommand();
        commands.put(command.getName(), command);
        command = new GiveCommand();
        commands.put(command.getName(), command);
    }

    /**
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with this name.
     */
    public Command get(String word)
    {
        return commands.get(word);
    }

    /*
     * Print all valid commands to System.out.
     */
    public void showAll()
    {
        for(String commandName : commands.keySet())
        {
            System.out.print(commandName + "  ");
        }
        System.out.println();
    }
}
