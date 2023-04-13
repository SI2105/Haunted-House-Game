package OOP.ec22612.MP.contributions;

public class Room_ec22519 extends Room
{
    boolean chest_open = false;
    public Direction visit(Visitor visitor, Direction incomingDirection) 
    {
        if(!chest_open)
        {
            visitor.tell("The room is very dusty and has a large chest in the centre");
            char choice = visitor.getChoice("Do you want to open the chest?(Y/N)",new char[]{'Y' ,'y' ,'N', 'n'});

            if(choice == 'Y' || choice == 'y')
            {
                visitor.tell("A goblin pops out at soon as you open the chests and steals gold from you and runs off into the dark! :(");
                visitor.takeGold(5);
                visitor.tell("As the goblin scurries off he drops an katana.");
                visitor.giveItem(Room_ec22772.katana);
            }
            else if(choice == 'N' || choice == 'n')
            {
                visitor.tell("You decide to ignore the chest and go to another room");
            }

            chest_open = true;
        }
        else if(chest_open)
        {
            visitor.tell("The room is very dusty and has a large chest in the centre but it has already been opened");
            if(!visitor.hasIdenticalItem(Room_ec22772.katana))
            {
                visitor.tell("There is a katana lying on the floor.");
                visitor.giveItem(Room_ec22772.katana);
            }
        }

        char exitDir = visitor.getChoice("Which direction do you wish to go? (n/s/e/w)", new char[]{'n','s','e','w'});

        if(exitDir == 'n')
        {
            return Direction.TO_NORTH;
        }
        else if(exitDir == 's')
        {
            return Direction.TO_SOUTH;
        }
        else if(exitDir == 'e')
        {
            return Direction.TO_EAST;
        }
        else if(exitDir == 'w')
        {
            return Direction.TO_WEST;
        }

        return(incomingDirection);
    }
}
