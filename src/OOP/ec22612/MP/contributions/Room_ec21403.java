package OOP.ec22612.MP.contributions;

class Room_ec21403 extends Room {

    private boolean lightsOn;
    private boolean chestEmpty;

    public Direction visit(Visitor visitor, Direction arrives) {

        if (arrives == Direction.FROM_NORTH) {
            visitor.tell("You have arrived from the North.");
        } else if (arrives == Direction.FROM_EAST) {
            visitor.tell("You have arrived from the east.");
        } else if (arrives == Direction.FROM_SOUTH) {
            visitor.tell("You have arrived from the south.");
        } else if (arrives == Direction.FROM_WEST) {
            visitor.tell("You have arrived from the west.");
        }
        
        visitor.tell("You have entered ec21403's room. The Room is mysterious and there are a few items on the floor. There is a covered window and a latch to open it");

        if (lightsOn) {
            visitor.tell("The room is Brightly lit. You can see there is a chest, a window and a few ojects lying around");
        } else {
            visitor.tell("The room is dark. However due to your super vision you can see everything anyway");
        }

        if (chestEmpty) {
            visitor.tell("The chest is empty. No gold for you unfortunately");
        } else {
            visitor.tell("The chest contains 5 gold coins!");
        }

        char choice = visitor.getChoice("What would you like to do? (a) Turn on the light, (b) Pick up the jewel, (c) Open chest, (d) Open the window", new char[]{'a', 'b', 'c', 'd'});

        if (choice == 'a') {
            if (lightsOn) {
                visitor.tell("The light is already on.");
            } else {
                visitor.tell("You turned on the light.");
                lightsOn = true;
            }
        } else if (choice == 'b') {
            visitor.tell("You picked up a jewel from the floor.");
            visitor.giveItem(new Item("jewel"));
            
        } else if (choice == 'c') {
            if (chestEmpty) {
                visitor.tell("The chest is empty.");
                
            } else {
                if (visitor.hasIdenticalItem(new Item("key"))) {
                    visitor.tell("You used the key to open the chest.");
                    visitor.tell("You opened the chest and found 5 gold coins!");
                    visitor.giveGold(5);
                    chestEmpty = true;
                } else {
                    visitor.tell("You dont have the key to open this chest. It remains locked.");
                }
            }
            
        } else if (choice == 'd') {
            visitor.tell("You find a suspicious looking window in this room. You decide to open the window not knowing whats on the outside. A bird swoops in and takes 5 gold coins");
            visitor.takeGold(5);
            visitor.tell("However when You opened the window and can see the night lit sky!");
        }

        return Direction.opposite(arrives);

    }
}
