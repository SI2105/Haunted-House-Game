package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ec22563 extends Room {

    boolean visited = false;

    public Direction visit(Visitor v, Direction d)
    {
        if (!visited) {
            visited = true;
            v.tell("After stepping through the door you turn back to make sure it doesn't lock behind you.");
            v.tell("Instead, you find yourself staring at a blank wall.");
            v.tell("You shiver uneasily and swing yourself around to inspect the room and look for the exit.");
            v.tell("Incredibly, every few seconds the door appears to jump around");
            v.tell("As you track the door around the room, you take in the contents of the room");
            v.tell("The only object is a tattered wooden chest, on top of it is a yellowed and faded note");

            char[] choices = {'a', 'b', 'c'};

            char chosenChoice = v.getChoice("a) Read the note\nb) Try force open the chest\n c) Run for a door and try leave immediately\n (anything else to try leave)", choices);
            if (chosenChoice == 'a') {
                v.tell("The note says \"Just force it open, I tried to make a cool puzzle but the chest ended up getting stuck closed.");
                v.tell("I made the door jump around though, have fun! - I. Goole\"");
                forceOpenChest(v);
            }
            else if (chosenChoice == 'b') {
                forceOpenChest(v);
            }
            return exit(v);

        } else {
            v.tell("Looks like this is that room with the jumping door again!");
            return exit(v);
        }
        
    }

    public Direction exit(Visitor v) 
    {
        v.tell("You track the door as it bounces around the room, it seems to be following a pattern at an interval.");
        v.tell("Using some intuition, timing, and pattern recognition, you pounce on the door as soon as it changes position, hoisting yourself through");
        
        Random random = new Random();
        int random_int = random.nextInt(4);
        switch (random_int) {
            case 0:
                return Direction.TO_NORTH;
            case 1:
                return Direction.TO_EAST;
            case 2:
                return Direction.TO_SOUTH;
            case 3:
                return Direction.TO_WEST;
            default:
                return Direction.TO_NORTH;
        }
    }

    public void forceOpenChest(Visitor v) {
        v.tell("You kick open the chest forcefully, causing the old wood to groan in agony.");
        v.tell("Inside you find 7 gold pieces and a 20 sided dice. Next to the dice is another note: ");
        v.tell("\"This dice was supposed to be a part of the puzzle, since I failed, you can have it - I. Goole\"");
        v.giveItem(new Item("20 sided dice"));
        v.giveGold(7);
    }
}
