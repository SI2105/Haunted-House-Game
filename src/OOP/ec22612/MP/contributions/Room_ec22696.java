package OOP.ec22612.MP.contributions;

//reuplaod
class Room_ec22696 extends Room {
    public Direction visit(Visitor visitor, Direction direction) {
        Direction[] outgoings = getDirections(direction);
        Direction directionToTake = outgoings[0];
        visitor.tell("This room seems to have been a library, once - now, though, the books are in piles on the floor whike the shelves host only spider webs.");
        visitor.tell("You see a strange, cylindrical box on a desk in the corner, a large tome set on a pedestal, and an old-fashioned gramophone on a table in the centre of the room.");
        char[] options = new char[3];
        options[0] = 'A';
        options[1] = 'B';
        options[2] = 'C';
        char choice = visitor.getChoice("Would you like to investigate a) the box, b) the book or c) the gramophone?", options);
        if (choice=='A') {
            visitor.tell("The box is black, with silver clasps.");
            char[] boxOptions = new char[2];
            boxOptions[0] = 'A';
            boxOptions[1] = 'B';
            char bookChoice = visitor.getChoice("Would you like to a) open the top, or b) pull open a side drawer?", boxOptions);
            if (bookChoice=='B'){
                visitor.tell("In this side drawer, you find some gold.");
                visitor.giveGold(2);
            } else {
                visitor.tell("A withered hand reaches out, and you lose some gold.");
                visitor.takeGold(4);
            }
            directionToTake = outgoings[0];
        } else if (choice=='B') {
            visitor.tell("The book lies open on a page filled with incomprehensible symbols.");
            char[] bookOptions = new char[2];
            bookOptions[0] = 'A';
            bookOptions[1] = 'B';
            char bookChoice = visitor.getChoice("Wouls you like to turn the page a) forward, or b) backward?", bookOptions);
            if (bookChoice=='A'){
                visitor.tell("Hidden beneath the pages, you find some gold.");
                visitor.giveGold(3);
            } else {
                visitor.tell("The script written on this page turns out to be an ancient curse - you lose some gold.");
                visitor.takeGold(3);
            }
            directionToTake = outgoings[1];
        } else if (choice=='C'){
            visitor.tell("The gramophone is a dull bronze and faded brown.");
            char[] phoneOptions = new char[2];
            phoneOptions[0] = 'A';
            phoneOptions[1] = 'B';
            char bookChoice = visitor.getChoice("Would you like to a) turn the handle, or b) check the records?", phoneOptions);
            if (bookChoice=='A'){
                visitor.tell("As you turn the handle, you find some gold behind the player.");
                visitor.giveGold(4);
            } else {
                visitor.tell("A shadow sneaks out the dusty pile, taking your gold as it goes.");
                visitor.takeGold(2);
            }
            directionToTake = outgoings[2];
        }
        return directionToTake;
    }
    
    Direction[] getDirections(Direction incoming) {
        Direction[] outgoings = new Direction[3];
        if (incoming.equals(Direction.FROM_SOUTH)){
            outgoings[0] = Direction.TO_WEST;
            outgoings[1] = Direction.TO_NORTH;
            outgoings[2] = Direction.TO_EAST;
        } else if (incoming.equals(Direction.FROM_WEST)){
            outgoings[0] = Direction.TO_NORTH;
            outgoings[1] = Direction.TO_EAST;
            outgoings[2] = Direction.TO_SOUTH;
        } else if (incoming.equals(Direction.FROM_NORTH)){
            outgoings[0] = Direction.TO_EAST;
            outgoings[1] = Direction.TO_SOUTH;
            outgoings[2] = Direction.TO_WEST;
        } else if (incoming.equals(Direction.FROM_EAST)){
            outgoings[0] = Direction.TO_SOUTH;
            outgoings[1] = Direction.TO_WEST;
            outgoings[2] = Direction.TO_NORTH;
        }
        return outgoings;
    }
}

