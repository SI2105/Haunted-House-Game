package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22626 extends Room{

public Direction visit(Visitor myVisitor, Direction directionVisitorArrived){

    Item garlic = new Item("garlic");
    Item crucifix = new Item("crucifix");
    Item sunLight = new Item("sunLight");
    Item stake = new Item("stake");
    Item torch = new Item("torch");

    char[] Items = {'a', 'b', 'c', 'd', 'e'};
    int takeGold;
    

    

    
    
    myVisitor.tell("Welcome to Winchester Mystery House. The most famous, strange mansion to exist...");
    myVisitor.tell("You are in a tiny room with broken windows around you.");
    myVisitor.tell("Try using the objects found around the mansion to find your way out and survive the wrath of Dracula.");
    

    
    if (directionVisitorArrived == Direction.FROM_EAST){
        myVisitor.tell("You have arrived from the East side of the building.");
    }
    else if(directionVisitorArrived == Direction.FROM_NORTH){
        myVisitor.tell("You have arrived from the North side of the building.");
    }
    else if(directionVisitorArrived == Direction.FROM_SOUTH){
        myVisitor.tell("You have arrived from the South side of the building.");
    }
    else if(directionVisitorArrived == Direction.FROM_WEST){
        myVisitor.tell("You have arrived from the West side of the building.");
    } 

    char chooseItem = myVisitor.getChoice(("Chose an item to defeat the vampiric presence, determining which direction you go. a) garlic, b)crucifix, c)sunLight d)stake. "), Items);
    myVisitor.tell("If you stumble across a torch, you can chose what direction you want to exit. ");

    if(chooseItem == Items[0]){
        if(myVisitor.giveItem(garlic)){
            myVisitor.tell("You have used garlic to deter the supernatual threat. You will receive some gold for that");
        myVisitor.giveGold(2);
        directionVisitorArrived = Direction.FROM_EAST;

        }
        else{
            myVisitor.tell("You chose to not use the garlic. That would cost you 2 gold pieces.");
            takeGold = myVisitor.takeGold(2);
            directionVisitorArrived = Direction.FROM_WEST;
        }
        

    }
    else if(chooseItem == Items[1]){
        if(myVisitor.giveItem(crucifix)){
            myVisitor.tell("You have used a crucifix to deter the supernatual threat. You will receive some gold for that");
        myVisitor.giveGold(4);
        directionVisitorArrived = Direction.FROM_SOUTH;

        }
        else{
            myVisitor.tell("You chose not to use the crucifix. That costs you 3 gold pieces");
            takeGold = myVisitor.takeGold(3);
            directionVisitorArrived = Direction.FROM_NORTH;
        }
        
    }
    else if(chooseItem == Items[2]){
        if(myVisitor.giveItem(sunLight)){
            myVisitor.tell("You have chosen expose the Vampire to sunlight. This will give you time to escape and earn 3 gold pieces");
        myVisitor.giveGold(3);
        directionVisitorArrived = Direction.FROM_WEST;
        

        }
        else{
            myVisitor.tell("The vampire remains. This will cost you 3 gold pieces");
            takeGold = myVisitor.takeGold(3);
            directionVisitorArrived = Direction.FROM_NORTH;
        }
        

    }
    else if(chooseItem == Items[3]){
        if(myVisitor.giveItem(stake)){
            myVisitor.tell("You have chosen to stake the vampire. You will receive a 5 pieces of gold for killing Dracula");
        myVisitor.giveGold(5);
        directionVisitorArrived = Direction.FROM_SOUTH;

        }
        else{
            myVisitor.tell("You chose not to kill the supernatural threat. Scared huh? That would cost you 4 gold pieces.");
            takeGold = myVisitor.takeGold(4);
            directionVisitorArrived = Direction.FROM_WEST;
        }
        
    }
    else if(chooseItem == Items[4]){
        Random rs = new Random();
        if(myVisitor.giveItem(torch)){
            char[] Directions = {'N', 'E', 'S', 'W'};
            char choseDirections = myVisitor.getChoice(("Chose a direction."),Directions);
            if (choseDirections == Directions[0]){
                directionVisitorArrived = Direction.FROM_NORTH;
            }
            else if (choseDirections == Directions[1]){
                directionVisitorArrived = Direction.FROM_EAST;
            }
            else if (choseDirections == Directions[2]){
                directionVisitorArrived = Direction.FROM_SOUTH;
            }
            else if (choseDirections == Directions[3]){
                directionVisitorArrived = Direction.FROM_WEST;
            }
        }
        else{
            takeGold = myVisitor.takeGold(2);
            int randomDirections = rs.nextInt(3);
            
            if (randomDirections == 0){
                directionVisitorArrived = Direction.FROM_NORTH;
            }
            else if (randomDirections == 1){
                directionVisitorArrived = Direction.FROM_EAST;
            }
            else if (randomDirections == 2 ){
                directionVisitorArrived = Direction.FROM_SOUTH;
            }
            else if (randomDirections == 3){
                directionVisitorArrived = Direction.FROM_WEST;
            }

        }
        
    }
    
    
    return directionVisitorArrived.opposite(directionVisitorArrived);
}


}
