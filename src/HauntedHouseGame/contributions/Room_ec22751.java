package HauntedHouseGame.contributions;

class Room_ec22751 extends Room {
        static final Item potato = new Item ("potato");
        static final Item flesh = new Item ("flesh");
        static final Item milk = new Item ("milk");
        static final Item bazooka = new Item ("bazooka");
    public Direction visit (Visitor Visit , Direction direction)
    {
        char [] Choices = {'a','b','c','d'};

        Visit.tell("This is the Mystery House !!! boo. scared you didn't I");
        Visit.tell("Go ahead enter");

        if (direction == Direction.FROM_NORTH){
            Visit.tell("welcome to the North side of the Mystery House");
        }
        else if (direction == Direction.FROM_EAST)
        {
            Visit.tell("welcome to the East side of the Mystery House");
        }
        else if (direction == Direction.FROM_SOUTH)
        {
            Visit.tell("welcome to the south side of the Mystery House");
        }
        else if (direction == Direction.FROM_WEST){
            Visit.tell("Westside baby");
        }
        char Choice = Visit.getChoice(("Choose an item to defeat the demon within! a) potato b) flesh c) milk d) bazooka "), Choices);
        if (Choice == Choices[0]){
            Visit.tell ("You picked up the potato and threw it at the demons head causing him to pass out. You earned gold for that!");
            Visit.giveItem(potato);
            Visit.giveGold(5);
            direction = Direction.FROM_NORTH;
        }
        else if (Choice == Choices[1]){
        Visit.tell("You have chosen flesh and placed it in your pocket. The demon smells it and steals your gold.");
        Visit.giveItem(flesh);
        Visit.takeGold(5);
        direction = Direction.FROM_WEST;
        }
        else if (Choice == Choices [2])
        {
        Visit.tell("You drop the milk on the floor the demon comes running at you slips and hits his head. You get gold");
        Visit.giveItem(milk);
        Visit.giveGold(5);
        direction = Direction.FROM_EAST;
        }
        else if (Choice == Choices[3])
        {
            Visit.tell("wow you found a bazooka. You dont know how to use it so you blow yourself up. you lose gold");
            Visit.giveItem(bazooka);
            Visit.takeGold(5);
            direction = Direction.FROM_SOUTH;
        }
        return direction;

    }
}
