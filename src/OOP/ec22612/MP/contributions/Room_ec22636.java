package OOP.ec22612.MP.contributions;

class Room_ec22636 extends Room {
    boolean locked = false;
    boolean wrongKey = false;
    static final Item keys = new Item("Key_ec22636");
    static final Item anItem = new Item("OOP Software Engineering - Bruegge Dutoit");

    public Direction visit(Visitor currentVisitor, Direction currentDirection) {
// Check if the visitor has entered the room before & either throw an error or enter n room
        currentVisitor.tell("You appear to be in a dark room with no idea of your surroundings");
        if (locked) {
            currentVisitor.tell("Not that way silly, you know you've been here. " + this.directionToString(currentDirection) + " it's locked now.");
        } else {
            currentVisitor.tell("You enter the room.. but the door slams shut behind you, click, click, locked.");
            locked = true;
        }
// Check if user has a key and allow them to unlock n door if y
        if (!wrongKey && currentVisitor.hasEqualItem(keys)) {
            currentVisitor.tell("Well.. you've got a key, what are you waiting for " + this.directionToString(currentDirection) + "?? ((y/n)??");
            char[] roomOptions = new char[]{'y', 'n'};
            char roomChosen = currentVisitor.getChoice("y/n", roomOptions);
            if (roomChosen == 'y') {
                currentVisitor.tell("You stick your bit in to " + this.directionToString(currentDirection) + ".");
                locked = false;
            } else {
                currentVisitor.tell("Okay, don't unlock it then.");
                currentVisitor.tell("Hmm, you might be a smart guy, that chest looks to have the same lock");
                char chestChoice = currentVisitor.getChoice("y/n", roomOptions);
                if (chestChoice == 'y') {
                    currentVisitor.tell("Open open open, you've only gone and opened it!");
                    currentVisitor.tell("Ten gold smackers, you've made it");
                    currentVisitor.giveGold(10);
                    this.wrongKey = true;
                }
            }
        }

// Search options in the room
        currentVisitor.tell("You can barely see a thing, but you can feel some books and a box of odds and sods.");
        char[] lootOptions = new char[]{'a', 'b'};
        char lootChoice = currentVisitor.getChoice("a/b", lootOptions);
        if (lootChoice == 'a') {
            currentVisitor.tell("You grab a book, you can't see a thing, go under that candle.. ahh a book on coding!");
            currentVisitor.giveItem(anItem);
        } else if (lootChoice == 'b') {
            currentVisitor.tell("Go on.. keep rummaging, that feels like a key? It is a key!");
            currentVisitor.giveItem(keys);
        } else {
            currentVisitor.tell("Alright, I didn't want anything either.. ^.0");
        }


// Escape options
        Direction forward = this.onwards(currentDirection);
        currentVisitor.tell("You see a door to the side," + this.directionToString(forward) + ",there's another," + this.directionToString(currentDirection) + ".");
        if (locked) {
            currentVisitor.tell("This door " + this.directionToString(currentDirection) + " is locked.");
        }

        char escape;
        lootOptions = new char[]{'a'};
        currentVisitor.tell("What way we going now?\na) " + this.directionToString(forward));
        if (!locked) {
            currentVisitor.tell("b) " + this.directionToString(currentDirection));
            lootOptions = new char[]{'a', 'b'};
            escape = currentVisitor.getChoice("a/b", lootOptions);
        } else {
            escape = currentVisitor.getChoice("a/a", lootOptions);
        }

        if (escape == 'b') {
            currentVisitor.tell("Quick hussle through," + this.directionToString(currentDirection) + ".");
            return Direction.opposite(currentDirection);
        } else {
            currentVisitor.tell("I guess we're going through " + this.directionToString(forward) + ".");
            return forward;
        }
    }

    private String directionToString(Direction d) {
        if (d == Direction.FROM_SOUTH) return "south";
        if (d == Direction.FROM_EAST) return "east";
        if (d == Direction.FROM_NORTH) return "north";
        if (d == Direction.FROM_WEST) return "west";
        return "undefined";
    }

    private Direction onwards(Direction d) {
        if (d == Direction.FROM_SOUTH) return Direction.TO_SOUTH;
        if (d == Direction.FROM_EAST) return Direction.TO_EAST;
        if (d == Direction.FROM_NORTH) return Direction.TO_NORTH;
        if (d == Direction.FROM_WEST) return Direction.TO_WEST;
        return Direction.UNDEFINED;
    }
}
