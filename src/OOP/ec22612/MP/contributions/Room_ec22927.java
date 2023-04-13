package OOP.ec22612.MP.contributions;

class Room_ec22927 extends Room {
    
    public Direction visit(Visitor visitor, Direction d){
        
        Item wateringCan = new Item("watering can");
        Item cat = new Item("cat");
        Direction direction = Direction.TO_NORTH;
        
        //Greet and gift the user, check whether they already have the item watering can 
        //
        if (visitor.hasIdenticalItem(wateringCan)){
            visitor.giveGold(3);
            visitor.tell("Welcome to this room! You have been gifted three pieces of gold!");
            visitor.tell("Looks like you already have a watering can.");
  
        }
            else{
        visitor.giveItem(wateringCan);
        visitor.giveGold(3);
        visitor.tell("Welcome to this room! You have been gifted three pieces of gold and a watering can.");
            }
            
        char [] possibleChoices = {'a', 'b', 'c', 'd'};
        
        //User is given two options and could be tricked; it's not clear that there is a wrong option
        //
        char choice = visitor.getChoice("Would you like to a) water the plants or b) water the cat?", possibleChoices);
        
        //Different outcome based on the user's choice: a is the good option and b is the bad option
        //
        if(choice=='a'){
            visitor.tell("Good choice. Your plants are grateful.");
            visitor.giveItem(cat);
            visitor.tell("You have been given the cat as a reward for your efforts. He is your companion now.");
            
            //user can decide on any direction to leave//
            char direction_choice = visitor.getChoice("Which way would you like to leave? a) North, b) East, c) South, d) West or e) back the way you came?", possibleChoices);
            
            if(direction_choice == 'a'){
                direction = Direction.TO_NORTH;
            }
            else if(direction_choice=='b'){
                direction = Direction.TO_EAST;
            }
            else if(direction_choice == 'c'){
                direction = Direction.TO_SOUTH;
            }
            else if(direction_choice=='d'){
                direction=Direction.TO_WEST;
            }
            else if (direction_choice == 'e'){
                direction=Direction.opposite(d);
            }
            else //any input not in the possibleChoices array//
            {
                visitor.tell("South you go!");
                direction = Direction.TO_SOUTH;
            }
             
            
        }
            else if(choice=='b'){
                visitor.tell("You have made a bad choice. The cat is not grateful.");
                visitor.takeGold(3);
                visitor.tell("Your gold has been taken back.");
                visitor.tell("Because of your bad decision you will not be given the choice of which direction to leave. You will be leaving south to hell.");
                
                direction = Direction.TO_SOUTH;
            }
            
        else //anything other than a or b//
        {
            visitor.tell("You have not chosen correctly. Please leave."); 
            direction = Direction.TO_SOUTH;
        }
            
        return direction;
        
    }
}
        
