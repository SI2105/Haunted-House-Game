package OOP.ec22612.MP.contributions;

class Room_ec22558 extends Room {
    
    //Use for later
    boolean MonsterMood = true;

    
    public Direction visit (Visitor Visit , Direction direction)
    {
        Item watch = new Item ("watch");
     
        Item toothpick = new Item ("toothpick");
      
        Item water = new Item ("water");
      
        Item grenade = new Item ("grenade");
      
        char [] Choices = {'a','b','c','d'};

        Visit.tell("Welcome to the msytery house");
        Visit.tell("Go ahead enter");

        if (direction == Direction.FROM_NORTH){
            Visit.tell("welcome to the North side of mystery house");
        }
        else if (direction == Direction.FROM_EAST)
        {
            Visit.tell("welcome to the East side of mystery house. East side is the best");
        }
        else if (direction == Direction.FROM_SOUTH)
        {
            Visit.tell("welcome to the south side of mystery house");
        }
        else if (direction == Direction.FROM_WEST){
            Visit.tell("Welcome to the west side of mystery house. West side is da best");
        }
        
        
        
        char Choice = Visit.getChoice(("Choose an item to defeat the demon within! a) watch b) toothpick c) water d) bazooka "), Choices);
        if (Choice == Choices[0]){
            Visit.tell ("You picked up the watch and wear it. The monster thinks u look totally rad dude and leaves you. You earned gold for that!");
            Visit.giveGold(5);
            direction = Direction.FROM_NORTH;
        }
        else if (Choice == Choices[1]){
        Visit.tell("You have chosen toothpick. you scare the monster of with the toothpick somehow. The monster dropped gold running away");
        Visit.giveGold(5);
        direction = Direction.FROM_WEST;
        }
        else if (Choice == Choices [2])
        {
        Visit.tell("You offer the monster water. He takes the water and your gold. You lost gold");
        Visit.takeGold(5);
        direction = Direction.FROM_EAST;
        }
        else if (Choice == Choices[3])
        {
            Visit.tell("You found a grenade!?. you accidentaly set it off on yourself. you lose gold");
            Visit.takeGold(5);
            direction = Direction.FROM_SOUTH;
        }
        return direction.opposite(direction);

    }
}
