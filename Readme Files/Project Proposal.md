# Lost in the Dungeon! Proposal
>Group: Peter Keres\
>Class: object-oriented design\
>Assignment: final project proposal\
>Date: April 4, 2019



### Short Pitch:
Your lost in a dungeon unsure of your way out to the surface. You come across a tree who needs their apples back. The tress asks you to retrieve them, in return the tree will give you a key to a door so you can leave the dungeon.

### Basic features:
 - Adding rooms
    - Rooms will be added. Such as the room with the tree, room with the apples, and a room for the exit.
 - Rooms can hold items
    - As of this point, the only items the rooms will hold will be apples and possibly keys
 - Player can hold items
    - The play can hold items less then the total amount of weight a player can carry. 
    - Each item will have a weight associated with it
 - A way to win the game
    - The player wins by exiting the dungeon by any means. Most likely, this will be by retrieving the apples and getting a key that unlocks the door to the outside. 
 - Adding a “go back” command
    - This will allow the player to go back to the rooms they just came from. This command will hold the last 10 rooms the player was in. 
 - Adding new commands
    - The commands needed for the basic functionality are as follows
        - Pick up
            - Which will allow the player to pick up an item in a room and add it to their inventory
        - Open
            - Which will allow the player to open a door or chest
        - Use
            - Which will allow the player to use an item in their inventory on something in the world
        - Give
            - Which will allow the player to give an item in their inventory to something in the world. *
        - Drop
            - Which will allow the player to drop an item from their inventory into a room. 

### Scope of the game outside of the basic functionality:

Because I am a one-person group, I must implement five tasks from the sheet. The tasks will be as follows. 

 - Transporter room:
    - Player is taken to a new room that is not the exit of the current room
 - Limit on items
    - Adding a limit, the amount of one item a plyer can hold. Example only one key at a time. 
 - Doors and keys
    - Adding other doors to the game world and keys that unlock them. 
 - Items have a sell value
    - Each item will have some type of currency attached to the item
 - Trading room
    - A room where a player can buy/sell items 
 - This would also mean adding different types of items to the game world


### Functionality I would like to add if time allows:
 - Multiple ways to beat the game
    - Maybe the player finds an axe to take the key by force?
 - Solve a puzzle for a Dungeon exit?
    - A light story element to the game
 - An intro splash screen of a story introduction.
 - Add a light combat system
    - A simple system. Where the player can attack, use items, and run 
 - Add weapons / amour
    - These items will affect the stats of the % to hit and damage
- Add art
    - Will be ascii based.
    - Will be used at the splash scree, each room and fights
	



