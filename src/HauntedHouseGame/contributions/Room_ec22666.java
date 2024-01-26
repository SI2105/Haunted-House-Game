package HauntedHouseGame.contributions;

class Room_ec22666 extends Room
{

    private boolean lightson = false;
    static boolean visited = false;


    public Direction visit(Visitor visitor,Direction directionVistorArrivesFrom)
    {
        if(directionVistorArrivesFrom == Direction.FROM_NORTH){
            visitor.tell("You have entered from the north door.");
        }
        else if (directionVistorArrivesFrom == Direction.FROM_EAST){
            visitor.tell("You have entered from the east door.");
        }
        else if (directionVistorArrivesFrom == Direction.FROM_SOUTH){
            visitor.tell("You have entered from the south door.");
        }
        else if (directionVistorArrivesFrom == Direction.FROM_WEST){
            visitor.tell("You have entered from the west door.");
        }

        if(!lightson)
        {
            char lights = visitor.getChoice("The lights are currently off, would you like to turn them on?, (y/n)", new char[]{'y','n'});
            if (lights == 'y')
            {
                visitor.tell("The lights are now on and you have found a 10 gold coins on the floor!");
                visitor.giveGold(10);
            }
            else if(lights == 'n')
            {
                visitor.tell("You have fallen over and found a torch on the floor, lucky you");
            }

        }
        else if(lightson == true)
        {
            visitor.tell("Someone has already been here it seems since the lights are on");
        }
        visitor.tell("Your in a room with 4 chests at every side of the room, one is blue, one is orange, one is pink and one is green which one do you open?");
        char choice = visitor.getChoice("What do you want to do, a)Open the blue one b)Open the orange one c) open the pink one d) open the green one", new char[]{'a', 'b', 'c', 'd'});

            if (choice == 'a')
            {
                visitor.tell("You have opened the blue chest which contains a diamond sword");
                visitor.giveItem(new Item("Diamond sword"));
            }
            else if (choice == 'b')
            {
                visitor.tell("You have opened the orange chest which contains Gold, worth roughly 5 gold coins");
                visitor.giveGold(5);
            }
            else if (choice == 'c')
            {
                visitor.tell("You have opened the pink chest which contains a bomb, the room blows up and you lose all your money, and a leg");
                visitor.takeGold(10);
            }
            else if (choice == 'd')
            {
                visitor.tell("You have opened the green chest which contains a snake, you get bit and might die soon, but lose no gold!");
            }
            else
            {
                visitor.tell("Now you lost 5 gold, hope your happy");
                visitor.takeGold(5);
            }


        return Direction.opposite(directionVistorArrivesFrom);
    }
}
