package OOP.ec22612.MP.contributions;

class Room_ec22749 extends Room{

    private Item Flashlight = new Item("Flashlight");
    private Item Axe = new Item("Axe");
    private Direction direction;
 
    public Direction visit(Visitor visitor, Direction direction)
    {
      //Inform the user about the room they just entered
      visitor.tell("You have just entered an old and rusted long-left-alone wrecked ship in a deserted island.");
      char option = visitor.getChoice(" a) Scan the surroundings and the walls inside of the ship.\n b) Go straight to the treasure kinda looking box .\n c) Examine the floors carefully.", new char[] {'a', 'b', 'c'});
 
          //if the player choose option 'a'
          if (option == 'a') {
              //Give the visitor the flashlight to look through the whole ship much easier
                  visitor.giveItem(Flashlight);
 
                  visitor.tell("You shine your flashlight around the ship to figure out when, where and what kind of ship was it before it wrecked and is left behind.");
                  visitor.tell("There are lot of stuffs being left behind such as compasses, telescopes, ledgers and a lot more of essential stuffs that are covered with dust as well.");
                  visitor.tell("You walked towards the table and saw a book");
                  char OpenBook = visitor.getChoice("Open the book or not? (y/n)", new char[] {'y', 'n'});
 
                      if (OpenBook == 'y') {
                          visitor.tell("You get to know that the ship belonged to Captain Edward! This ship is from the 80s!");
                          visitor.tell("Suddenly, you saw a small door right beside the table");
                          char OpenDoor = visitor.getChoice("Open the door? (y/n)", new char[] {'y', 'n'});
 
                          if(OpenDoor == 'y') {
                              visitor.tell("You shouldn't have open the door! ");
                              visitor.tell("The floor sinks downwards due to the weak wood floor as it has been left for so long.");
                              visitor.tell("Now, you're stuck and the only way out is by finding the way out by yourself");
                              direction = Direction.TO_NORTH;
                              return direction;
                          } 
                      }
          }
 
        //if the player choose option 'b'
          else if (option == 'b') {
 
              visitor.tell("You walk straight to the treasure box");
              char BreakBox = visitor.getChoice("Break the Box? (y/n)", new char[] {'y', 'n'});
 
                  if(BreakBox == 'y') {
                      visitor.giveItem(Axe);
 
                      visitor.tell("Use all your might to break the box and see what's inside");
                      visitor.tell("You found few golds left inside the treasure box");
                      visitor.giveGold(5);
                      visitor.tell("Get out of here before any weird monster came out since you take the gold being left there");
                      direction = Direction.TO_WEST;
                  }
                  else
                  {
                      direction = direction;
                  }
              
              return direction;
          }
 
        //if the player choose option 'c'
          else if (option == 'c') {
 
               //The player walks to look at the painting but can't do anything with it.
               visitor.tell("You walk slowly while looking downwards.");
               visitor.tell("You're disgusts by all the insects and there's also worms between the woods' crack.");
               visitor.tell("You notice the faint glint of a gold coin on the frame.");
               visitor.tell("You almost vomit out of being so disgusted by the floors condition and run out via the closest door.");
               direction = Direction.TO_EAST;
               return direction;
              
           }
 
          visitor.tell("You are satisfied with your adventure in the old stinky ship for the day and go out via the main door(South Door).");
          direction = Direction.TO_SOUTH;
          return direction;
    }
}
