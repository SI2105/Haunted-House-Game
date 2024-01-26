package HauntedHouseGame.contributions;

class Room_ec22637 extends Room
{
    @Override
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom)
    {
        visitor.tell("You enter the lobby, there's a door to your right that goes east and door ahead of you that goes north");
        char[] directionList = { 'N', 'E', 'W'};
        char choice = visitor.getChoice("Head north or head east? [N/E/W]", directionList);
        if (choice == 'N')
        {
            visitor.tell("You head north.");
            return Direction.TO_NORTH;    
        } 
        else if (choice == 'E')
        {
            visitor.tell("You head east.");
            return Direction.TO_EAST;
        }
        else if (choice == 'W')
        {
            visitor.tell("You find a lever by the bedside. You flip it and revealed a west-side staircase under the bed. You head west.");
            return Direction.TO_WEST;
        }
        else
        {
            visitor.tell("You head back south, back the way you came.");
            return Direction.TO_SOUTH;
        }
    }
}