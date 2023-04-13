package OOP.ec22612.MP.contributions;

// Changes made to A4 - 02/03/23 - re-submit
class Room_ec22741 extends Room
{
    char [] options = {'a', 'b'};
    Item lighter = new Item("Lighter");
    Item dagger = new Item("Dagger");

    public Direction visit(Visitor visitor, Direction d)
    {
        visitor.tell("You enter the building and find 2 doors - one to your left and another to your right");
        char [] leftOrRight = {'L', 'R'};
        char choice = visitor.getChoice("Do you enter the door to your left (L) or to your right (R)?", leftOrRight);
        if (choice == 'L')
        {
            visitor.tell("You open the door to your left, and discover some gold coins in a corner");
            visitor.tell("You pick up 8 gold coins");
            visitor.giveGold(8);
            visitor.tell("Suddenly, you hear something drop");
            char runOrInvestigate = visitor.getChoice("Do you run away (a) or go towards the direction of the noise (b)?", options);
            if (runOrInvestigate == 'a')
            {
                visitor.tell("You run away in fear and drop 3 gold coins in the process");
                visitor.takeGold(3);
                return Direction.TO_EAST;
            }
            else if (runOrInvestigate == 'b')
            {
                visitor.tell("You walk closer to the area where the sound belonged and find a lighter");
                if (visitor.giveItem(lighter))
                {
                    visitor.tell("You pick it up and put it in your pocket");

                }
                return Direction.TO_WEST;
            }

        }

        else if (choice == 'R')
        {
            visitor.tell("You enter the door to your right and enter a room that has a door to the left and a chest of drawers to the right");
            char doorOrSearch = visitor.getChoice("Do you open the door (a) or search the chest of drawers (b)?", options);
            if (doorOrSearch == 'a')
            {
                visitor.tell("You open the door and led to a room overrun by plants");
                return Direction.TO_NORTH;
            }

            else if (doorOrSearch == 'b')
            {
                visitor.tell("You start searching the chest of drawers");
                visitor.tell("You find 5 gold coins and put them in your pocket");
                visitor.giveGold(5);
                visitor.tell("You also find a dagger");
                if (visitor.giveItem(dagger))
                {
                    visitor.tell("You put that in your pocket too");
                }
                return Direction.TO_SOUTH;
            }

        }
        return d;
    }
}
