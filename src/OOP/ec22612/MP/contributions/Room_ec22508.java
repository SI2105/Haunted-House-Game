package OOP.ec22612.MP.contributions;

import java.util.Random;

public class Room_ec22508 extends Room {

    Item torch = new Item("Torch");
    Item magnet = new Item("Magnet");

    boolean ghost = new Random().nextBoolean();
    boolean lights = new Random().nextBoolean();

    @Override
    public Direction visit(Visitor visitor, Direction direction){

	    visitor.tell("You pick up some gold entering the room...");
        visitor.giveGold(5);
        
        if(lights == false) {
		visitor.tell("The lights are off...");
            visitor.giveItem(torch);
	    	visitor.tell("You pick up a torch to light the way...");
        }
        
	if(ghost == true) {
		visitor.tell("A ghost spooked you...");
		visitor.tell("You run away!");
		visitor.tell("During your hasty exit, you picked up a magnet!");
		visitor.giveItem(magnet);
		direction = Direction.TO_SOUTH;
	} else {

        	direction = Direction.TO_NORTH;

        	if (visitor.hasIdenticalItem(torch) || visitor.hasEqualItem(torch)) {
			visitor.tell("You've already been here...");
            		visitor.takeGold(5);
            		direction = Direction.TO_EAST;
        	}
	}
        return direction;
    }
}
