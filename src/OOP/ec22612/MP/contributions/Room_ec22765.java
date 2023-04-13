package OOP.ec22612.MP.contributions;

public class Room_ec22765 extends Room {
    private boolean lightsOn;
    private boolean trunkEmpty;
    private int goldAmount;
    boolean hasShotgun;
    boolean hasAxe;
    boolean hasTorch;
    boolean hasKey;

    Item shotgun = new Item("shotgun");
    Item axe = new Item("axe");
    Item torch = new Item("torch");
    Item key = new Item("key");

    public Room_ec22765() {
        lightsOn = false;
        trunkEmpty = false;
        goldAmount = 5;
        hasShotgun = false;
        hasAxe = false;
        hasTorch = false;
        hasKey = false;
    }


    public Direction visit(Visitor visitor, Direction direction) {
        visitor.tell("You are in Room ec22765.");
        visitor.tell("You start off looking in a trunk in which you found 5 pieces of gold");
        visitor.giveGold(5); 

        if (direction == Direction.FROM_NORTH) {
            visitor.tell("You just came from the north.");
        } else if (direction == Direction.FROM_EAST) {
            visitor.tell("You just came from the east.");
        } else if (direction == Direction.FROM_SOUTH) {
            visitor.tell("You just came from the south.");
        } else if (direction == Direction.FROM_WEST) {
            visitor.tell("You just came from the west.");
        }
        else if (direction == null) {
            visitor.tell("I don't know how you get here.");
        }

        if (lightsOn) {
            visitor.tell("The lights are on.");
        } else {
            visitor.tell("The lights are off.");
        }

        if (trunkEmpty) {
            visitor.tell("The trunk is empty.");
        } else {
            visitor.tell("The trunk is not empty.");
        }

        char[] choices = { 'a', 'b', 'c' };
        int choiceIndex = visitor.getChoice("What do you want to do?", choices);
        char choice = choices[choiceIndex];

        if (choice == 'a') {
            if (!lightsOn) {
                visitor.tell("You turn on the lights.");
                lightsOn = true;
                visitor.tell("You notice a thief with a gun who saw you take gold and followed you to your room.");
                visitor.takeGold(3); 
                visitor.tell("The thief took the gold and jumped out of the window. I wonder if he made it out alive.");
            } else {
                visitor.tell("The lights are already on.");
            }
        } else if (choice == 'b') {
            if (!trunkEmpty) {
                char[] pickItem = {'d', 'e', 'f', 'g'};
                int itemIndex = visitor.getChoice("You took 3 gold bars, there are 4 items and you can only pick one choose wisely.", pickItem);
                char cItem = pickItem[itemIndex];

                if (cItem == 'd') {
                    visitor.giveItem(shotgun);
                    visitor.tell("You have decided to pick a shotgun, you only have 1 round");
                    hasShotgun = true;
                }
                if (cItem == 'e') {
                    visitor.giveItem(axe);
                    visitor.tell("You have decided to pick the axe, now you can destroy locked doors and kill threats");
                    hasAxe = true;
                }
                if (cItem == 'f') {
                    visitor.giveItem(torch);
                    visitor.tell("You have decided to pick a torch,now you can navigate without the lights on");
                    hasTorch = true;
                }
                if (cItem == 'g') {
                    visitor.giveItem(key);
                    visitor.tell("You have decided to pick the key, you can now open locked doors");
                    hasKey = true;
                }
                
                visitor.giveGold(3);
                trunkEmpty = false;
            } else {
                visitor.tell("You open the trunk but it's empty.");
            }
        } else if (choice == 'c') {
            if (goldAmount > 0) {
                int amount = visitor.takeGold(Math.min(goldAmount, 10));
                goldAmount = goldAmount - amount;
                visitor.tell("You take " + amount + " gold pieces from a shiny gold chest.");
                visitor.giveGold(amount);
            } else {
                visitor.tell("There is no gold in the room.");
            }
        }

        if (goldAmount > 0) {
            visitor.tell("There are " + goldAmount + " gold pieces in the room.");
        } else {
            visitor.tell("There is no gold in the room.");
        }

        visitor.tell("You decide that you now want to exit the room");
        if (hasShotgun) {
            visitor.tell("You shoot down the lock, since you are out of ammo you decide to throw away the shotgun and continue travelling the house for more gold");
            hasShotgun = false;
            visitor.tell("You might think you have won the game, but you are vulnerable to threats, be careful");
        }
        else if (hasAxe) {
            visitor.tell("You break the door with the axe and leave the room looking for more gold.");
        }
        else if (hasTorch) {
            visitor.tell("You had the stupid idea to burn down the door, why would you do that, you now burn to death and die. The only losing outcome, you remain stuck in the room for eternity");
            hasTorch = false;
            goldAmount = 0;
        }
        else if (hasKey) {
            visitor.tell("You open the door with the key, you eventually realise that this key can open anything in the house so you open all the chests and leave the house rich. You truly won");
            goldAmount = 10;
        }

        visitor.tell("You have now left the room, only to enter a much bigger room, the doors behind you are magically locked, you now have a choice of 4 doors to go through");
    char cDirection = visitor.getChoice("Which way would you like to go?" + " a) north" +" b) east" +" c) south" +" d) west", new char[]{'a', 'b', 'c', 'd'});
        if (cDirection == 'a'){
            visitor.tell("You go to the north room");
            return Direction.FROM_NORTH;}
        else if (cDirection == 'b'){
            visitor.tell("You go to the east room");
            return Direction.FROM_EAST;}
        else if (cDirection == 'c'){
            visitor.tell("You go to the south room");
            return Direction.FROM_SOUTH;}
        else if (cDirection == 'd'){
            visitor.tell("You go to the west room");
            return Direction.FROM_WEST;}
    
            return direction;
        
    }
}
