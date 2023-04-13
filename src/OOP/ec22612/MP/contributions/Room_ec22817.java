package OOP.ec22612.MP.contributions;

class Room_ec22817 extends Room
{

  //Definiting the state of the room


  public static final boolean lightsOn = true;

  public static final Item SPEAR = new Item("Inverted Spear Of Heaven");

  public static final boolean steal = true;



  public Direction visit (Visitor visitor, Direction directionVisitorArrivesFrom)
  {

    visitor.tell("----------------------------------------------------------------");
    visitor.tell("Welcome to the A4 Mansion");
    visitor.tell("Your objective is to find and acquire a powerful weapon");
    visitor.tell("You are currently in the mansion's hall");
    visitor.tell("There are 3 chests in this current hall: silver, bronze and obsidian");
    visitor.tell("----------------------------------------------------------------");
    visitor.tell("\tWhat would you like to do now?");

    char[] decision = {'a','b','c'};

    char visitor_decision = visitor.getChoice("\t(a) Open silver chest  (b) Open bronze chest  (c) Open obsidian chest (d) Leave the room",decision);

    switch (visitor_decision)
    {
      case 'a':

        visitor.tell("There were no weapons found in the silver chest. However, there were 3 gold coins found in the chest");
        visitor.giveGold(3);

        break;

      case 'b':

        visitor.tell("You have opened the bronze chest...");
        visitor.tell("However it was cursed! The bronze chest contained the vortex impendium that steals valuable items from you!");
        visitor.takeGold(6);

        break;

      case 'c':

        visitor.tell("You have opened the obsidian chest...");
        visitor.tell("Acquiring something from the chest comes at a price...");
        visitor.tell("Your gold shall be taken!");
        visitor.takeGold(3);
        visitor.tell("In return you shall receive the powerful Inverted Spear Of Heaven!");
        visitor.giveItem(SPEAR);

        break;

        case 'd':

          visitor.tell("With hopefully a newly acquired powerful weapon, you will head north to where a battle awaits you...");

          return Direction.TO_NORTH;

    }

    return null; //if the visitor does not leave the room

  }



}
