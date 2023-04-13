package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ec22517 extends Room {
    private int goldInChest;
    private boolean lightsOn;
    private boolean keyTaken;
    private boolean chestOpen;
    private Item key;

    Room_ec22517() {
        goldInChest = 50;
        lightsOn = false;
        keyTaken = false;
        chestOpen = false;
        key = new Item("key");
    }

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        char choice = 'y';

        if (!lightsOn) {
            choice = visitor.getChoice("Turn the lights on?", new char[]{'y', 'n'});
            if (choice == 'y') {
                lightsOn = true;
            } else {
                visitor.tell("Since you can't see anything, you decide to leave.");
            }
        }

        if (lightsOn) {
            visitor.tell("The room is empty, except for a chest in the centre.");

            if (!keyTaken) {
                visitor.tell("There is also a key on the floor in front of you.");
                choice = visitor.getChoice("Pick up the key?", new char[]{'y', 'n'});

                if (choice == 'y') {
                    visitor.giveItem(key);
                }
            }

            if (!chestOpen) {
                choice = visitor.getChoice("Open the chest?", new char[]{'y', 'n'});
                if (choice == 'y') {
                    if (visitor.hasEqualItem(key)) {
                        visitor.tell("You used the key to open the chest.");
                        chestOpen = true;
                    } else {
                        visitor.tell("You don't have the key.");
                    }
                }
            } else {
                visitor.tell("The chest appears to already be open.");
            }

           
            if (chestOpen) {
                if (goldInChest == 0) {
                    visitor.tell("Looks like the chest is empty.");
                } else {
                    visitor.tell("You find " + goldInChest + " gold in the chest.");
                    if (goldInChest == 10) { // no need to offer a choice if only 10 left
                        choice = 'a';
                    } else {
                        choice = visitor.getChoice("You could either\na) Take 10 gold from the chest, leaving some for anyone else who may find it\nb) Try to take all of the gold", new char[]{'a', 'b'});
                    }

                    if (choice == 'a') {
                        visitor.tell("You take 10 gold.");
                        visitor.giveGold(10);

                        choice = visitor.getChoice("Close the chest?",  new char[]{'y', 'n'});

                        if (choice == 'y') {
                            chestOpen = false;
                        }
                    } else {
                        int goldToTake = randInt(1, 10); // visitor drops random amount of gold between 1 and 10

                        visitor.tell("As you are taking the gold, the walls of the room start to close in. As you run for the exit, you drop " + goldToTake + " gold.");
                        visitor.takeGold(goldToTake);
                    }
                }

            } else {
                visitor.tell("There's nothing else to do, so you leave the room.");
                visitor.getChoice("Leave the lights on?", new char[]{'y', 'n'});
                if (choice == 'n') {
                    lightsOn = false;
                }                
            }
        }
        
        return directionVistorArrivesFrom;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}