package HauntedHouseGame.contributions;

public class Room_ec22520 extends Room
{
    boolean chest = false;
    public Direction visit(Visitor v,Direction DirectionFrom)
    {
        char choice = 'K';

        if(!chest)
        { 
            v.tell("The room is very dusty and has a large chest in the centre");
            choice = v.getChoice("Do you want to open the chest?(Y/N)",new char[]{'Y','N'});
            if (choice =='Y')
            {
                v.giveGold(5);
                chest = true;
            }
            else if(choice =='N')
            {
                v.tell("You have been cursed! Five gold is taken from you.");
                v.takeGold(5);
            }
        }
        else
        {
            v.tell("The chest in this room has already been opened!");
        }
       

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
       
        return DirectionFrom;
    }
}
