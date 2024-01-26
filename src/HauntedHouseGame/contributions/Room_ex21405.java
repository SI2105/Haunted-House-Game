package HauntedHouseGame.contributions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Room_ex21405 extends Room {

    private final static List<Item> items = Arrays.asList(
            new Item("sword"),
            new Item("map"),
            new Item("money"),
            new Item("cannon")
    );

    
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        visitor.tell("The room is empty with only a large box in the middle.");

        char choices[] = {'a', 'b', 'c'};
        char choice = visitor.getChoice("What do you want to do a)open the box b) see if you can find anything else c) move on", choices);
        int goldTaken = 0;

        switch (choice) {
            case 'a':
                visitor.tell("You decided to open the box, in the box, \n" +
                                            "grabbed the book in the box, suddenly the light falls from the ceiling.");
                int numOfGold = new Random().nextInt(10) + 1;
                goldTaken = visitor.takeGold(numOfGold);

                if (goldTaken == 0) visitor.tell("The ceiling just missed and you still remain with zero gold.");
                else visitor.tell("The light falls on you, and now you have " + goldTaken + " pieces of gold.");

                break;
            case 'b':
                visitor.tell("You looked around the room and the floor collasped in the corner!");
                goldTaken = visitor.takeGold(10);

                if (goldTaken == 0) visitor.tell("You did not lose gold when you fell through, because you got no pieces of gold on you.");
                else visitor.tell("You lost" + goldTaken + " pieces of gold when you fell.");

                break;
            case 'c':
                Item item;
                if (items.size() != 0) {

                    item = items.get(new Random().nextInt(items.size()));

                    visitor.tell("You decided to move forward and in the next room you found a" + item.name);
                    if (!visitor.hasEqualItem(item)) {
                        visitor.tell("You take it.");
                        items.remove(item);
                    } else {
                        visitor.tell("You already have it, so you leave it.");
                    }
                } else {
                    visitor.tell("You decided to move on and found nothing.");
                }

        }

        char directions[] = {'a', 'b', 'c', 'd'};
        choice = visitor.getChoice("Which way would you like to leave by?\n" + "a) North\n" +"b) East\n" +"b) South\n" +"b) West", directions);

        switch (choice) {
            case 'a':
                visitor.tell("Moving North...");
                return Direction.TO_NORTH;
            case 'b':
                visitor.tell("Moving East...");
                return Direction.TO_EAST;
            case 'c':
                visitor.tell("Moving South...");
                return Direction.TO_SOUTH;
            case 'd':
                visitor.tell("Moving West...");
                return Direction.TO_WEST;
        }

        return null;
    }
}
