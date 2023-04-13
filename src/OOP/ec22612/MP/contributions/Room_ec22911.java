package OOP.ec22612.MP.contributions;

public class Room_ec22911 extends Room
{
    public Direction visit(Visitor v,Direction d)
    {
        char choice = 'K';

        v.tell("The room is very small and dirty, there is a very old small box on the table.");
        choice = v.getChoice("Do you want to open the box?(Y/N)",new char[]{'Y','N'});
        if (choice =='Y')
        {
            v.giveGold(9);
        }
        
        v.tell("Great choice! You gained 9 pieces of gold!");
        
        choice = v.getChoice("What direction would you like to go?(N/S/W/E)",new char[]{'N','W','E','S'});
        if (choice == 'N')
        {
            return Direction.TO_NORTH;
        }
        else if (choice =='W')
        {
            return Direction.TO_WEST;
        }
        else if (choice =='E')
        {
            return Direction.TO_EAST;
        }
        else if (choice =='S')
        {
            return Direction.TO_SOUTH;
        }

        return d;
    }
}
   
