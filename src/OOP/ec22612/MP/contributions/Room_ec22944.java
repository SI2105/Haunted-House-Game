package OOP.ec22612.MP.contributions;

class Room_ec22944 extends Room
{
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom)
    {
        String context = "a) Look under my pillow, b) Play games on my computer, c) Ransack my room";
        char[] choices = {'a', 'b', 'c'};
        Item WisdomTooth = new Item("T Man's Wisdom Tooth");

        visitor.tell("Welcome to T Man's lair!. Have 3 gold on me!");
        visitor.giveGold(3);
        visitor.tell("What would you like to do?");


        if(visitor.getChoice(context, choices) == 'a')
        {
            visitor.tell("You found my wisdom tooth. Hope you find it useful later!");
            visitor.giveItem(WisdomTooth);
        }

        else if(visitor.getChoice(context, choices) == 'b')
        {
            visitor.tell("You wasted all your time playing The Sims 4. I hope you're proud of yourself.");
        }

        else if(visitor.getChoice(context, choices) == 'c')
        {
            visitor.tell("T Man walked in on you trying to steal his beloved possessions. You panicked and gave him your gold. Serves you right!");
            visitor.takeGold(10); //Punish the user for trying to rob the room
        }

        String exitDirections = "a) North, b) East, c) South, d) West";
        char[] exitChoices = {'a', 'b', 'c', 'd'};
        
        visitor.tell("Which way would you like to exit?");
        if(visitor.getChoice(exitDirections, exitChoices) == 'a')
        {
            return Direction.TO_NORTH;
        }

        else if(visitor.getChoice(exitDirections, exitChoices) == 'b')
        {
            return Direction.TO_EAST;
        }

        else if(visitor.getChoice(exitDirections, exitChoices) == 'c')
        {
            return Direction.TO_SOUTH;
        }

        else
        {
            return Direction.TO_WEST;
        }
    }
} 
