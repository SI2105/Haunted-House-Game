package HauntedHouseGame.contributions;

class Room_ec22935 extends Room{
        static Item samurai = new Item ("samurai");
        static Item onion = new Item ("onion");
        static Item rifle = new Item ("rifle");
        static Item gas = new Item ("gas");
    public Direction visit (Visitor Visit , Direction direction)
    {
        char [] Choices = {'a','b','c','d'};

        Visit.tell("You arw about to enter the room of terror... *scary noise*. Be warned, this is not for the faint hearted");
        Visit.tell("Proceed if you dare...");

        if (direction == Direction.FROM_NORTH){
            Visit.tell("You have entered from the North side of the Mystery House");
        }
        else if (direction == Direction.FROM_EAST)
        {
            Visit.tell("You have entered from the East side of the Mystery House");
        }
        else if (direction == Direction.FROM_SOUTH)
        {
            Visit.tell("You have entered from the South side of the Mystery House");
        }
        else if (direction == Direction.FROM_WEST){
            Visit.tell("You have entered from the West side of the Mystery House");
        }
        
        char Choice = Visit.getChoice(("Pick an item of your choice to defeat the monster within! a) samurai b) onion c) rifle d) gas "), Choices);
        
        if (Choice == Choices[0]){
            Visit.tell ("You picked up the samurai and drive it into the side of the beast. Nice hit! Here's some gold");
            Visit.giveItem(samurai);
            Visit.giveGold(5);
            direction = Direction.FROM_NORTH;
        }
        
        else if (Choice == Choices[1]){
        Visit.tell("You picked up an onion and throw it at the monster. It cries and gets knocked out. Here's some gold");
        Visit.giveItem(onion);
        Visit.giveGold(5);
        direction = Direction.FROM_WEST;
        }
        
        else if (Choice == Choices [2])
        {
        Visit.tell("You pick up a rifle, but shock and horror, there are no bullets. Looks like gold isn't the only thing you're losing");
        Visit.giveItem(rifle);
        Visit.takeGold(5);
        direction = Direction.FROM_EAST;
        }
        
        else if (Choice == Choices[3])
        {
            Visit.tell("You have picked up a gas can. You spray the monster with gas. Nothing happens. THe gas is heading towards you. Oh dear... You lose gold");
            Visit.giveItem(gas);
            Visit.takeGold(5);
            direction = Direction.FROM_SOUTH;
        }
        return direction;

    }
}
