package OOP.ec22612.MP.contributions;

public class Room_ec22442 extends Room {
    public Direction visit(Visitor v, Direction d) {
        
        Item MACGUFFIN = new Item("Key");
        char[] option = {'s', 'l'};
        char[] directionChoice = {'n', 'e', 's', 'w'};
        
        v.tell("There is a key on one of the four tables in the room.");
        v.tell("The key will either lead you to safety or to greater danger.");
        v.tell("Would you like to search for the key or leave and return to the previous room?");
        char optionChoice = v.getChoice("Enter 's' to search for the key or 'l' to leave.", option);
        
        if(optionChoice == 's') {
            v.tell("Which direction would you like to take?");
            char directionTaken = v.getChoice("Enter 'n' for north, 'e' for east, 's' for south 'w' for west", directionChoice);
            switch(directionTaken) {
                case 'n':
                    return Direction.TO_NORTH;
                case 'e':
                    return Direction.TO_EAST;
                case 's':
                    return Direction.TO_SOUTH;
                case 'w':
                    return Direction.TO_WEST;
            }
            
            boolean found = false;
            if(directionTaken == 'e') {
                found = true;
                v.tell("Well done, you have found the key!");
            }
            else if(directionTaken == 'n') {
                found = false;
                v.tell("No key here. But...");
                v.tell("...you have found some gold.");
                v.giveGold(5);
            }
            else {
                v.tell("No key here.");
            }
        }

        else {
            v.tell("No guts, no glory.");
            v.tell("Back to the previous room.");
        }
        return Direction.TO_SOUTH;
    }
}
