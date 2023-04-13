package OOP.ec22612.MP.contributions;

import java.util.ArrayList;
import java.util.List;

public class Room_ec22419 extends Room {
    private boolean isDark = false;
    private Item key = new Item("Key");
    private List<Item> items = new ArrayList<>();
    private int goldPieces = 10;
    private boolean hasSecret = false;
    private boolean isDoorLocked = false;

    @Override
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        // Implementation of the visit method for Room_more class.
        // Perform actions with the visitor and return the direction they leave towards.

        // Tell the visitor about the room and its state.
        visitor.tell("Welcome to Room_ec22419!");
        if (isDark) {
            visitor.tell("The room is dark.");
        } else {
            visitor.tell("The room is well-lit.");
        }

        // Ask the visitor to make a choice and tell them the consequences.
        char choice = visitor.getChoice("Do you want to pick up the key?", new char[] { 'Y', 'N' });
        if (choice == 'Y') {
            boolean accepted = visitor.giveItem(key);
            if (accepted) {
                visitor.tell("You picked up the key!");
                items.add(key);
            } else {
                visitor.tell("You couldn't pick up the key.");
            }
        } else {
            visitor.tell("You didn't pick up the key.");
        }

        // Check if the visitor has a particular item and tell them the result.
        if (visitor.hasIdenticalItem(key)) {
            visitor.tell("You already have the key.");
        }

        // Give or take gold depending on the visitor's choices.
        if (goldPieces > 0) {
            int goldToTake = 5;
            if (visitor.getChoice("Do you want to take some gold (Y,N)?", new char[] { 'Y', 'N' }) == 'Y') {
                int takenGold = visitor.takeGold(goldToTake);
                if (takenGold > 0) {
                    goldPieces -= takenGold;
                    visitor.tell("You took " + takenGold + " gold pieces.");
                    Item gold = new Item("Gold");
                    items.add(gold);
                } else {
                    visitor.tell("You don't have enough gold.");
                }
            } else {
                visitor.tell("You didn't take any gold.");
            }
        } else {
            visitor.tell("There is no more gold in this room.");
        }

        // Additional interactions with the visitor.
        if (hasSecret) {
            visitor.tell("You found a secret!");
        }

        char choice2 = visitor.getChoice("Do you want to search the room (Y,N)?", new char[] { 'Y', 'N' });
        if (choice2 == 'Y') {
            if (!(isDark)) {
                visitor.tell("It's too dark to see anything.");
            } else {
                if (!items.isEmpty()) {
                    visitor.tell("You found:");
                    for (Item item : items) {
                        visitor.tell(item.name);
                    }
                } else {
                    visitor.tell("There's nothing of interest here.");
                }
            }
        } else {
            visitor.tell("You decided not to search the room");
        }

        // Check if the visitor has a particular item and use it to unlock the door.
        if (visitor.hasIdenticalItem(key)) {
            char choice3 = visitor.getChoice("Do you want to use the key to unlock the door (Y,N)?", new char[] { 'Y', 'N' });
            if (choice3 == 'Y') {
                isDoorLocked = false;
                visitor.tell("You unlocked the door!");
            } else {
                visitor.tell("You decided not to use the key to unlock the door.");
            }
        }

        // Check if the door is unlocked and return the appropriate direction.
        if (isDoorLocked) {
            visitor.tell("The door is locked.");

        } else {
            visitor.tell("The door is opened.");

        }

        return Direction.opposite(directionVisitorArrivesFrom);
    }
}
