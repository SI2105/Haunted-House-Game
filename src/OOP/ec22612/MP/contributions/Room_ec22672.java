package OOP.ec22612.MP.contributions;

import java.util.Random;
class Room_ec22672 extends Room {

    @Override
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        visitor.tell("There are 2 doors on your left and on your right. One towards north the other towards south");
        char[] northAndSouthChoices = { 'N', 'S' };
        char choice = visitor.getChoice("Go north, or go south? [N/S]", northAndSouthChoices);
        if (choice == 'N') {
            return Direction.TO_NORTH;    
        } else if (choice == 'S') {
            return Direction.TO_SOUTH;
        }

        visitor.tell("Invalid door chosen. You choose to flip a coin instead.");
        Random random = new Random();
        boolean goingNorth = random.nextBoolean();
        if(goingNorth){
            visitor.tell("The coin landed on head. You are going north.");
            return Direction.TO_NORTH;    
        }else{
            visitor.tell("The coin landed on tails. You are going south.");
            return Direction.TO_SOUTH;
        }
    }

}
