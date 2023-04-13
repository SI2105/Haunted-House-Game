package OOP.ec22612.MP.contributions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Room_ex21566 extends Room {

    private static final List<Item> items = new ArrayList<>(Arrays.asList(
            new Item("knife"),
            new Item("recipe book"),
            new Item("wallet"),
            new Item("gun"),
            new Item("key")
    ));
    
    private static boolean floorBroken = false;
    private static boolean chestDiscovered = false;

    @Override
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        visitor.tell("The room is a kitchen with old appliances, with unmaintained wood plank flooring.");

        char choices[] = {'a', 'b', 'c'};
        char choice = visitor.getChoice("What do you want to do a) Open fridge b) Move forward c) Open the drawer by the couch", choices);
        int goldTaken = 0;

        switch (choice) {
            case 'a':
                visitor.tell("You decided to open the fridge the fridge and, \n" +
                                            "grabbed a piece of cheese, suddenly 2 rats ambushed you.");
                int numOfGold = new Random().nextInt(10) + 1;
                goldTaken = visitor.takeGold(numOfGold);

                if (goldTaken == 0) visitor.tell("The rats did not rob you anything, because you got no pieces of gold on you.");
                else visitor.tell("The rats robbed you " + goldTaken + " pieces of gold.");

                break;
            case 'b':
                if (!floorBroken) {
                    visitor.tell("You stepped on old wood plank and it broke, you can see the crawl space (under house).");
                    floorBroken = true;
                    goldTaken = visitor.takeGold(10);

                    if (goldTaken == 0) visitor.tell("You did not lose gold when you felt, because you got no pieces of gold on you.");
                    else visitor.tell("You lost " + goldTaken + " pieces of gold when you felt.");
                } else {
                    if (!chestDiscovered) {
                        visitor.tell("You see a hole in the floor and go over it carefully, while doing so you see something sharp in the crawl space (under house).\n" +
                                     "You go down there and dig up the object, it is a chest");

                        if (visitor.hasEqualItem(new Item("key"))) {
                            visitor.tell("You have the key to open the chest and found 10 pieces of gold.");
                            visitor.giveGold(10);
                            chestDiscovered = true;
                        } else {
                            visitor.tell("You do not have the key to open it, you decide to hide it by burying it so that you can comeback later with the key.");
                        }
                    } else {
                        visitor.tell("You see a hole in the floor and go over it carefully, while doing so you see an open chest. You get annoyed.");
                    }
                }

                break;
            case 'c':
                Item item;
                if (items.size() != 0) {

                    item = items.get(new Random().nextInt(items.size()));

                    visitor.tell("You decided to open a drawer by the couch and found a " + item.name);
                    if (!visitor.hasEqualItem(item)) {
                        if (visitor.giveItem(item)) {
                            visitor.tell("You take it.");
                            items.remove(item);
                        }
                    } else {
                        visitor.tell("You already have it, so you leave it.");
                    }
                } else {
                    visitor.tell("You decided to open a drawer next to you, and found nothing.");
                }

        }

        char directions[] = {'a', 'b', 'c', 'd'};
        choice = visitor.getChoice("Which way would you like to leave by?\n" +
                                                   "a) North\n" +
                                                   "b) East\n" +
                                                   "c) South\n" +
                                                   "d) West", directions);

        switch (choice) {
            case 'a':
                visitor.tell("Leaving via North");
                return Direction.TO_NORTH;
            case 'b':
                visitor.tell("Leaving via East");
                return Direction.TO_EAST;
            case 'c':
                visitor.tell("Leaving via South");
                return Direction.TO_SOUTH;
            case 'd':
                visitor.tell("Leaving via West");
                return Direction.TO_WEST;
        }

        return null; // It will never reach here, since A4 states getChoice will return one of the provided choices.
    }
}
