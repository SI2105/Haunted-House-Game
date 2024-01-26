package HauntedHouseGame.contributions;

class Room_ec22708 extends Room{
    
        Item flashlight = new Item("flashlight");
        Item helmet = new Item("helmet");
        Item bottleOfWater = new Item("bottle of water");
        Item bat = new Item("bat");
        boolean lightsOn = false;

    public Direction visit(Visitor visitor, Direction directionFrom){
            
    char choice;
        visitor.tell("You enter the house and find the lights to be on. You see four doors, each heading either north, south ,east or west.");

        choice = visitor.getChoice("Do you want to head north, south, east or west?", new char[]{'n','s','e','w'});
        
        if(choice == 'n'){
        visitor.tell("You head through the north door but cannot find the light switch. Thankfully you find a flashlight that happens to work. Using the flashlight, you also spot some gold and take it for yourself");
            directionFrom = Direction.TO_NORTH;
            visitor.giveItem(flashlight);
            visitor.giveGold(3);
        }
        
        else if(choice == 's'){
        visitor.tell("You head through the south door but cannot find the light switch. You do find a bag, and inside it you find a small helmet that you decide to put on and some gold you decide to take.");
            directionFrom = Direction.TO_SOUTH;
            visitor.giveItem(helmet);
            visitor.giveGold(3);
        }
        
        else if(choice == 'w'){
        visitor.tell("You head through the west door and find the light switch. You turn on the lights to find a bottle of water, but feel a breeze of wind and notice some gold has been taken from you.");
            directionFrom = Direction.TO_WEST;
            lightsOn = true;
            visitor.giveItem(bottleOfWater);
            visitor.takeGold(3);
        }
        
        else if(choice == 'e'){
            visitor.tell("You head through the east door and find the light switch. You turn on the lights to find a bat to defend yourself with but feel something in your pockets. You notice that some gold has been taken from you");
            directionFrom = Direction.TO_EAST;
            lightsOn = true;
            visitor.giveItem(bat);
            visitor.takeGold(3);
        }
        
            visitor.tell("You head back from the way you came, as you now feel uneasy in this house");
        if(visitor.hasIdenticalItem(flashlight)){
        visitor.tell("You use the flashlight to easily navigate your way out of the house, and spot some more gold on your way out");
        visitor.giveGold(3);
        }
        
        else if(visitor.hasIdenticalItem(helmet)){
        visitor.tell("You struggle to find your way out of the house because of the dark, as well as the helmet imparing your vision, and end up dropping a piece of gold before finally getting out of the house");
        visitor.takeGold(1);
        }
        
        else if(visitor.hasIdenticalItem(bottleOfWater)){
        visitor.tell("You drink some water to quench your thirst before making your way out of the house. You don't spot anything significant on your way out");
        }
        
        else if(visitor.hasIdenticalItem(bat)){
        visitor.tell("While heading out, you hear a noise and swing your bat. You only hit and break a vase, which contained some gold in it. You quickly leave the house in fear, but with more gold");
        visitor.giveGold(10);
        }
    
    return Direction.opposite(directionFrom);
    }
   
}
