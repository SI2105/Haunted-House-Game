package OOP.ec22612.MP.contributions;

class Room_ec22436 extends Room {
    public Direction visit (Visitor v , Direction direction)
    {
        Item potato = new Item ("potato");
        Item flesh = new Item ("flesh");
        Item milk = new Item ("milk");
        Item bazooka = new Item ("bazooka");
        char [] Choices = {'a','b','c','d'};

        v.tell("Welcome to the Mystery House! Are you brave enough to enter?");
        v.tell("Go ahead enter");

        if (direction == Direction.FROM_NORTH){
            v.tell("Welcome to the North side of the Mystery House");
        }
        else if (direction == Direction.FROM_EAST)
        {
            v.tell("Welcome to the East side of the Mystery House");
        }
        else if (direction == Direction.FROM_SOUTH)
        {
           v.tell("Welcome to the south side of the Mystery House");
        }
        else if (direction == Direction.FROM_WEST){
            v.tell("Westside baby");
        }
        char Choice = v.getChoice(("Choose an item to defeat the demon within! a) potato b) flesh c) milk d) bazooka "), Choices);
        if (Choice == Choices[0]){
            v.tell ("You picked up the potato and threw it at the demons head causing him to pass out. You earned gold for that!");
            v.giveGold(5);
            direction = Direction.FROM_NORTH;
        }
        else if (Choice == Choices[1]){
        v.tell("You have chosen flesh and placed it in your pocket. The demon smells it and steals your gold.");
        v.takeGold(5);
        direction = Direction.FROM_WEST;
        }
        else if (Choice == Choices [2])
        {
        v.tell("You drop the milk on the floor the demon comes running at you slips and hits his head. You get gold");
        v.giveGold(5);
        direction = Direction.FROM_EAST;
        }
        else if (Choice == Choices[3])
        {
            v.tell("wow you found a bazooka. You dont know how to use it so you blow yourself up. you lose gold");
            v.takeGold(5);
            direction = Direction.FROM_SOUTH;
        }
        return direction.opposite(direction);

    }
}
