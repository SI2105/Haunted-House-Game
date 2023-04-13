package OOP.ec22612.MP.contributions;// Program where user can enter ec22557 Mystery House. Thee user's entrance and exit direction is known.
// You can have a play around with some items with the aim to get gold coins.

class Room_ec22557 extends Room 
{
        // My Items
        static final Item MIRROR = new Item ("Mirror");
        static final Item REMOTE = new Item ("Remote");
        static final Item DAGGER = new Item ("Dagger");
        static final Item DOLL = new Item ("Doll");
        public boolean ChestDrawers = false;
        public boolean MirrorLights = false;
        
    public Direction visit(Visitor visitor, Direction direction)
    {
        char[] options = {'a','b','c','d'};

        visitor.tell("Welcome to the Mystery House");
        
        // User's entrance direction
        if (direction == Direction.FROM_NORTH)
        {
            visitor.tell("You are standing in the North of the Mystery House");
        }
        else if (direction == Direction.FROM_EAST)
        {
            visitor.tell("You are standing in the East of the Mystery House");
        }
        else if (direction == Direction.FROM_SOUTH)
        {
            visitor.tell("You are standing in the South of the Mystery House");
        }
        else if (direction == Direction.FROM_WEST)
        {
            visitor.tell("You are standing in the West of the Mystery House");
        }
        
        // provide user with choices on which item they want to play with
        char Choice = visitor.getChoice("What do you want to go towards? a) Mirror b) Remote c) Drawers d) Doll ", options);
        
        // If user selects mirror
        if (Choice == 'a')
        {
            MirrorLights = true;
            visitor.tell("You decided to look at yourself in the mirror.");
            visitor.tell("As you approach the mirror, its sensor lights turn on.");
            visitor.tell("You look at the mirror to see... 'Run if you want to live!' written in red ink");
            visitor.tell("On your way out, you see 5 pieces of gold. You take them.");
            visitor.giveGold(5);
           
            direction = Direction.FROM_NORTH; // exit direction
        }
        // If user selects remote
        if (Choice == 'b')
        {
            visitor.tell("You see the TV remote in front of you and switch the tv on.");
            visitor.tell("The tv turns on and displays the message 'Leave! You don't belong here.'");
            visitor.tell("Then the tv turns on and off on its own displaying the same message.");
            visitor.tell("You shouldn't have come here. As you run for your life, a distant shadow snatches 5 gold coins from your purse");
            visitor.takeGold(5);
          
            direction = Direction.FROM_WEST;
        }
        // If user selects dagger
        if (Choice == 'c')
        {
            visitor.tell("You see something shiny in the chest of drawers in front of you.");
            visitor.tell("You open the top drawer to find a dagger.");
            visitor.tell("You hear weird whistling sounds, someone might be approaching.");
            visitor.tell("You should keep a weapon for your safety.");

            if(visitor.hasIdenticalItem(DAGGER))
            {
                visitor.tell("Great you already have a weapon");
                ChestDrawers = false;
            }
            else 
            {
               visitor.tell("It'd be good to take the dagger.");
               ChestDrawers = true;
            }

            visitor.tell("As you turn around, 5 gold coins drop out of your purse");
            visitor.takeGold(5);
            direction = Direction.FROM_EAST;
        }
        // if user selects doll
        if (Choice == 'd')
        {
            visitor.tell("Wow, you are brave enough to play will the doll.");
            visitor.tell("The doll is on a cupboard, you will need a stool to reach it.");

            Item STOOL = new Item("Stool");

            if (visitor.hasEqualItem(STOOL))
            {
                  visitor.tell("Great, you have got a stool else I would get one for you.");
            }
            else
            {
                  visitor.giveItem(STOOL);
            }

            visitor.tell("As you take the doll in your hands, you find 5 gold coins as sequins in her dress.");
            visitor.giveGold(5);
            direction = Direction.FROM_SOUTH;
        }
        return direction.opposite(direction);

    }
}
