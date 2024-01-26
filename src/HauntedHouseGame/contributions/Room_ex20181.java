package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ex20181 extends Room
{
    private final Item Cross = new Item("Cross");
    private final Item Flashlight = new Item("Flashlight");

    private boolean Visibility = false;
    private boolean Haunted = false;

    public Direction visit(Visitor visitor, Direction direction)
    {
        Direction leavingDirection = null;
        visitor.tell("You enter a creepy looking house.");
        visitor.tell("After walking through the entrance there are four coddidoors.");
        visitor.tell("pick a corridor to go down");
        char[] directionChoices = {'a','b','c','d'};
        char DirectionChoice =visitor.getChoice("a)North, b)South, c)West, d)East", directionChoices);
       

        if (DirectionChoice == 'a')
        {
            leavingDirection = Direction.TO_NORTH;
            visitor.tell("you found 7 gold!");
            visitor.giveGold(7);
            Random r1 = new Random();
            Visibility = r1.nextBoolean();
            Random r2 = new Random();
            Haunted = r2.nextBoolean();

            if (Visibility == false)
            {
                visitor.tell("The room is very dark");
                visitor.tell("You use your flashlight.");
            }
            if (Haunted == true)
            {
                visitor.tell("You see a ghost flying towards you");
                visitor.tell("You use your cross.");
                visitor.tell("The ghost has flown away");
            }
        }
        if (DirectionChoice == 'b')
        {
            leavingDirection = Direction.TO_SOUTH;
            visitor.tell("You lost 3 gold!");
            visitor.takeGold(3);
            Random r1 = new Random();
            Visibility = r1.nextBoolean();
            Random r2 = new Random();
            Haunted = r2.nextBoolean();
           
            if (Visibility == false)
            {
                visitor.tell("The room is very dark");
                visitor.tell("You use your flashlight.");
            }
            if (Haunted == true)
            {
                visitor.tell("You see a ghost flying towards you");
                visitor.tell("You use your cross.");
                visitor.tell("The ghost has flown away");
            }
        }

        if (DirectionChoice == 'c')
        {
            leavingDirection = Direction.TO_WEST;
            visitor.tell("You found 5 gold!");
            visitor.giveGold(5);
            Random r1 = new Random();
            Visibility = r1.nextBoolean();
            Random r2 = new Random();
            Haunted = r2.nextBoolean();
           
            if (Visibility == false)
            {
                visitor.tell("The room is very dark");
                visitor.tell("You use your flashlight.");
            }
            if (Haunted == true)
            {
                visitor.tell("You see a ghost flying towards you");
                visitor.tell("You use your cross.");
                visitor.tell("The ghost has flown away");
            }
        }
        if (DirectionChoice == 'd')
        {
            leavingDirection = Direction.TO_EAST;
            visitor.tell("You dropped 1 gold!");
            visitor.takeGold(1);
            Random r1 = new Random();
            Visibility = r1.nextBoolean();
            Random r2 = new Random();
            Haunted = r2.nextBoolean();
           
            if (Visibility == false)
            {
                visitor.tell("The room is very dark");
                visitor.tell("You use your flashlight.");
            }
            if (Haunted == true)
            {
                visitor.tell("You see a ghost flying towards you");
                visitor.tell("You use your cross.");
                visitor.tell("The ghost has flown away");
            }
        }
        return leavingDirection;
    }
}
