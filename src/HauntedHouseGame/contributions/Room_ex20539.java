package HauntedHouseGame.contributions;

// Room_ex20539 class extends Room
class Room_ex20539 extends Room {

    // Define a final Item "Dragon Balls"
    public final Item dragonballs = new Item("Dragon Balls");

    // Define a static boolean "looted"
    public static boolean looted = false;

    // Define a final boolean "lightsOn"
    public final boolean lightsOn = true;

    // Override the visit method of Room class
    
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {

        // Display a message to the visitor about the room and the boxes
        visitor.tell("This room has two boxes, one red and one blue, however you can only open one of them");

        // Define an array of char for the visitor's first choice
        char[] firstChoices = {'a', 'b', 'c'};

        // Get the visitor's choice with a message using getChoice method
        char visitorChoice = visitor.getChoice("Do you want to a) Open red box b) Open blue box c) Leave", firstChoices);

        // Switch statement to handle the visitor's choice
        switch (visitorChoice) {
            // Case 'a' for opening the red box
            case 'a':
                // Display a message to the visitor about what was found in the red box
                visitor.tell("There were no dragon balls in the red box but a wizard gave you a single piece of gold");

                // Give the visitor 1 piece of gold
                visitor.giveGold(1);

                // If the visitor already has the dragonballs or has an identical one, display a message
                if (visitor.hasEqualItem(dragonballs) || visitor.hasIdenticalItem(dragonballs)) {
                    visitor.tell("Nice you got the one piece.... of gold");
                } else {
                    // Otherwise, give the visitor the dragonballs
                    visitor.giveItem(dragonballs);
                }
                break;

            // Case 'b' for opening the blue box
            case 'b':
                // Display a message to the visitor about what happened when they opened the blue box
                visitor.tell("You open the blue box and a group of big black clothed men attack you, g check you and take all of your gold.");

                // Take 10 gold from the visitor
                visitor.takeGold(10);
                break;

            // Case 'c' for leaving the room
            case 'c':
                // Define an array of char for the visitor's leaving direction
                char[] directionChoices = {'a', 'b', 'c', 'd'};

                // Get the visitor's leaving direction with a message using getChoice method
                char leaving = visitor.getChoice("Leave via a) North b) East c) South d) West", directionChoices);

                // Switch statement to handle the visitor's leaving direction
                switch (leaving) {
                    case 'a':
                        return Direction.TO_NORTH;
                    case 'b':
                        return Direction.TO_EAST;
                    case 'c':
                        return Direction.TO_SOUTH;
                    case 'd':
                        return Direction.TO_WEST;
                }
        }

        // Return null if the visitor doesn't leave the room
        return null;
    }

}
