# Lost in the dungeon report
>Group: Peter Keres\
>Class: object-oriented design\
>Assignment: final project proposal\
>Date: April 4, 2019


- Name
     - “lost in the dungeon!”
- Short description
    - You find yourself lost in a dungeon unsure of how to leave. A tree tells you of a way out if you return the tree’s lost apples. Now you must find the apples or find a way out using another method. 
- User level description
    - The game allows you to go from room to room, picking up items. You can give items to characters in the world. You can drop items if you no longer want them. You can open and unlock doors you find in your path. Some items can be used on rooms.
- Implementation description
    - This application really revolves around three main interfaces (WorldObject, Command, Container) and the class ‘Room’. World Objects are any items or objects in the game world. Such as keys, doors, and apples. These objects can interact with each other and can be picked up by the player. The command interface allows the user to input actions they want to do in the game world. The container interface allows the players and characters of the world to hold/drop World Objects. Finally, the room class, allows all the WorldObjects and actions to take place in one central area. 
- Design patterns
    - Command pattern: this is used by the Abstracts class ‘command’ and it allows de-coupling between the parser and the objects in the world. Acting as a in-between the user’s input and the methods that are being called in the objects of the world. 
    - Achievement pattern: This is used by the notification center and other classes. It allows classes to commute with eat ocher but be staying loosely coupled.
    - Singleton pattern: this is used by the world class. It allows the class to only have one instance of itself and makes the class global to all other classes in the application.  
    - Delegation patter: this is used by the door/lock combination. The door’s functionally is changed by what lock is being held by the door. This allows us to change the lock in the future, therefore changing the functionally of the door but keeping the door class unchanged. 
- Special Features of the game
    - Multiple routs of finding a way out
    - Characters in the world
    - A room that teleports you to another room
- Known bugs
    - Some of the output to the screen can be unformatted at times
    - Dropping/ grabbing an identical item in the same room with a limit can cause the item to disappear from the room or print text to the screen saying you can not pick up the item even though you can and still do. Example of this is taking a gem in room eWingRoom1 and dropping it in wWingRoom2.
