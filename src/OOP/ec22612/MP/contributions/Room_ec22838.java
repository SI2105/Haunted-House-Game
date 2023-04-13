package OOP.ec22612.MP.contributions;

class Room_ec22838 extends Room
{
    //A4 V2
    
    //State of this room
    String lights = "on";
    String trunk = "full";
    
    //An item in the trunk that can be accepted by the visitor
    static final Item lamp = new Item("lamp");
    
    public Direction visit(Visitor visitor, Direction from)
    {
        if (from == Direction.FROM_NORTH) visitor.tell("You arrive from the north");
        if (from == Direction.FROM_EAST) visitor.tell("You arrive from the east");
        if (from == Direction.FROM_SOUTH) visitor.tell("You arrive from the south");
        if (from == Direction.FROM_WEST) visitor.tell("You arrive from the west");
        visitor.tell("Welcome to this room! (22838)");
        visitor.tell("The lights in here are currently " + lights);
        visitor.tell("The trunk is currently " + trunk);
        
        char choice = 'a';
        
        //Turn off the lights?
        visitor.tell("Do you want to turn the lights off?");
        choice = visitor.getChoice("a) Yes b) No", new char[]{'a','b'});
        if (choice == 'a')
        {
            lights = "off";
            visitor.tell("The lights are now " + lights);
        }
        
        //Empty the trunk?
        visitor.tell("Do you want to empty the trunk?");
        choice = visitor.getChoice("a) Yes b) No", new char[]{'a','b'});
        if (choice == 'a')
        {
            trunk = "empty";
            visitor.tell("The trunk is now " + trunk);
            visitor.tell("There was an item in the trunk: a lamp. You can take it if you please.");
            boolean accepted = visitor.giveItem(lamp);
            if (accepted) visitor.tell("You have gained a lamp");
        }
        else
        {
            visitor.tell("You chose not to empty the trunk. Commendable. Here's 5 gold pieces as a reward.");
            visitor.giveGold(5);
        }
        
        //Which direction to leave?
        visitor.tell("I'm going to let you choose the direction in which you leave: ");
        choice = visitor.getChoice("a) North b) East c) South d) West", new char[]{'a','b','c','d'});
        visitor.tell("Thank you for visiting this room. Farewell.");
        if (choice == 'a') return Direction.TO_NORTH;
        if (choice == 'b') return Direction.TO_EAST;
        if (choice == 'c') return Direction.TO_SOUTH;
        return Direction.TO_WEST;
    }
}
