package HauntedHouseGame.contributions;

class Room_ec22726 extends Room {

    private boolean lightsOn = false;
    private boolean trunkEmpty = false;
    private boolean poltergeistFriendly = true;

    
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        visitor.tell("You have entered the room from " + directionVisitorArrivesFrom);
        if (lightsOn) {
            visitor.tell("The room is well-lit.");
        } else {
            visitor.tell("The room is dark.");
        }
        if (trunkEmpty) {
            visitor.tell("The trunk is empty.");
        } else {
            visitor.tell("There is a closed trunk in the corner of the room.");
        }

        if (poltergeistFriendly) {
            visitor.tell("A friendly poltergeist is floating around the room.");
        } else {
            visitor.tell("An angry poltergeist is throwing objects around the room.");
        }

        char choice = visitor.getChoice("What would you like to do?\n" +
                "a. Turn on the lights\n" +
                "b. Open the trunk\n" +
                "c. Talk to the poltergeist\n" +
                "d. Leave the room", new char[]{'a', 'b', 'c', 'd'});

        if (choice == 'a') {
            lightsOn = true;
            visitor.tell("You turn on the lights. The room is now well-lit.");
        } else if (choice == 'b') {
            if (trunkEmpty) {
                visitor.tell("The trunk is empty.");
            } else {
                visitor.tell("You open the trunk and find a golden key.");
                Item key = new Item("golden key");
                boolean accepted = visitor.giveItem(key);
                if (accepted) {
                    trunkEmpty = true;
                }
            }
        } else if (choice == 'c') {
            if (poltergeistFriendly) {
                visitor.tell("You talk to the friendly poltergeist, but it doesn't say anything back.");
            } else {
                visitor.tell("You try to talk to the angry poltergeist, but it just throws a book at you.");
                int goldTaken = visitor.takeGold(5);
                visitor.tell("The poltergeist takes " + goldTaken + " pieces of your gold.");
            }
        } else {
            visitor.tell("You leave the room and return to the previous room.");
            return Direction.opposite(directionVisitorArrivesFrom);
        }

        if (visitor.hasIdenticalItem(new Item("golden key"))) {
            visitor.tell("You already have the golden key.");
        } else if (visitor.hasEqualItem(new Item("golden key"))) {
            visitor.tell("You already have a key, but it's not the golden one.");
        } else {
            visitor.tell("You notice a golden key on the ground and pick it up.");
            boolean accepted = visitor.giveItem(new Item("golden key"));
            if (!accepted) {
                visitor.tell("You cannot carry any more items.");
            }
        }

        if (poltergeistFriendly) {
            visitor.tell("The friendly poltergeist waves goodbye as you leave the room.");
        } else {
            visitor.tell("The angry poltergeist throws a vase at you as you leave the room.");
        }

        return Direction.opposite(directionVisitorArrivesFrom);
    }
}
