package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22621 extends Room {
    boolean lightState = true; //true if lights are on
    boolean ghostAngry = false; //true if ghost is angry
    Item iPhone = new Item("iPhone");
    Item rope = new Item("Rope");
    
    Random rs = new Random();    
    
    public Direction visit(Visitor visitor, Direction directionArrived) {
        Direction direction = directionArrived;
            
        if (directionArrived == Direction.FROM_NORTH) {
            visitor.tell("You entered from the North side of the building");
        } else if (directionArrived == Direction.FROM_EAST) {
            visitor.tell("You entered from the East side of the building");
        } else if (directionArrived == Direction.FROM_SOUTH) {
            visitor.tell("You entered from the South side of the building");
        } else if (directionArrived == Direction.FROM_WEST) {
            visitor.tell("You entered from the West side of the building");
        }
        
        int goldPieces = rs.nextInt(5);
        visitor.giveGold(goldPieces);
        visitor.tell("For entering Room_ec22621, you get " + goldPieces + " pieces of gold!");
        
        // describing the room 
        if(lightState){
            visitor.tell("Room_ec22621 has the lights on...");
        }
        else {
            visitor.tell("Room_ec22621 has the lights off...");
        }
        
        visitor.tell("There is a random chance of making the ghost angry... you have been warned!");
        //creating random chance of ghost being angry
        int diceRoll1 = rs.nextInt(5);
        int diceRoll2 = rs.nextInt(5);
        if (diceRoll1 == diceRoll2) {
            ghostAngry = true;
        }
        else {
            ghostAngry = false;
        }
        
        if (ghostAngry) {
            visitor.tell("The ghost in Room_ec22621 is angry!");
        }
        else {
            visitor.tell("The ghost in Room_ec22621 is not angry! He'll leave you alone... for now");
        }
        
        // visitor makes a choice
        char [] choices = {'1', '2'};
        char choiceMade = visitor.getChoice(("1. Take the rope lying on the table\n2. Search cabinet in hopes of something better"), choices);
        
        if (choiceMade == choices[0]) {
            if (visitor.giveItem(rope)){
                visitor.tell("You have taken the rope. You also find 3 pieces of gold next to it.");
                visitor.giveGold(3);
                
            }
            else {
                visitor.tell("You have not accepted the rope.");
            }
                             
        }
        else {
            visitor.tell("You open the cabinet and find an iPhone. If you take it, it will cost 3 gold");
            if (visitor.giveItem(iPhone)) {
                visitor.tell("You have taken the iPhone at the cost of 3 gold.");
                int goldTaken = visitor.takeGold(3);
            }
            else {
                visitor.tell("You have not accepted the iPhone.");
            }
        }
        
        char[] directionToGo = {'1', '2', '3', '4'};
        int choiceDirection = visitor.getChoice("1. Go North\n2. Go East\n3.Go South\n4.Go West", directionToGo);
        
        if (choiceDirection == directionToGo[0]) {
            direction = Direction.TO_NORTH;
        } else if (choiceDirection == directionToGo[1]) {
            direction = Direction.TO_EAST;
        } else if (choiceDirection == directionToGo[2]) {
            direction = Direction.TO_SOUTH;
        } else {
            direction = Direction.TO_WEST;
        }     
        
        return direction;
    }
}
