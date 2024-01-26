package HauntedHouseGame.contributions;

class Room_ec22717 extends Room {
    public Direction visit(Visitor visitor, Direction directionFrom) {
        boolean hasInspectedShelf = false;
        boolean hasOpenedBox = false;
        boolean lightOn = true;
        
        // Tells you where you came from.
        if(directionFrom == Direction.FROM_NORTH) {
            visitor.tell("You arive from the northen entrance.");
        }else if(directionFrom == Direction.FROM_EAST) {
            visitor.tell("You arive from the eastern entrance.");
        }else if(directionFrom == Direction.FROM_SOUTH) {
            visitor.tell("You arive from the southern entrance.");
        }else if(directionFrom == Direction.FROM_WEST) {
            visitor.tell("You arive from the western entrance.");
        }
        
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor, directionFrom);
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor, directionFrom);
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor, directionFrom);
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor, directionFrom);
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor, directionFrom);
        visitor.tell("You feel like you've been here too long. It's time to explore other rooms.");
        return Leave(visitor, lightOn);
    }
    
    Direction ChooseAction(boolean hasInspectedShelf, boolean hasOpenedBox, boolean lightOn, Visitor visitor, Direction directionFrom) {
        Item key = new Item("Key");
        
        // Shows current condition of room.
        if(lightOn == true) {
            visitor.tell("You are at a well-lit, wooden room. A large wooden shelf sits in the corner of the room. A door can be seen on each wall.");
        }else if(lightOn == false) {
            visitor.tell("You are in a dark room. Light bleeds through the underside of the doors on each wall.");
        }

        // Asks what you would like to do.
        visitor.tell("What would you like to do?");

        char[] twoOptions = {'a', 'b'};
        char[] threeOptions = {'a', 'b', 'c'};
        char[] fourOptions = {'a', 'b', 'c', 'd'};
        
        // Gives options you can do.
        if(hasInspectedShelf == false && lightOn == true) {
            char choice = visitor.getChoice("a)Inspect shelf b)Turn off lights c)Leave room", threeOptions);
            if(choice == 'a') {
                if(hasOpenedBox == false) {
                    visitor.tell("You approach the shelf. A small, white box with golden engravings sits to one side.");
                }else if(hasOpenedBox == true) {
                    visitor.tell("You approach the shelf. An opened, small, white box with golden engravings sits to one side.");
                }
                hasInspectedShelf = true;
            }else if(choice == 'b'){
                visitor.tell("You flip a switch on the wall. The room is now dark.");
                lightOn = false;
            }else if(choice == 'c'){
                return Leave(visitor, lightOn);
            }
        }else if(hasInspectedShelf == true && lightOn == true) {
            char choice = visitor.getChoice("a)Inspect shelf b)Open box c)Turn off lights d)Leave room", fourOptions);
            if(choice == 'a') {
                if(hasOpenedBox == false) {
                    visitor.tell("You approach the shelf. A small, white box with golden engravings sits to one side.");
                }else if(hasOpenedBox == true) {
                    visitor.tell("You approach the shelf. An opened, small, white box with golden engravings sits to one side.");
                }
            }else if(choice == 'b') {
                if(visitor.hasEqualItem(key)) {
                    visitor.tell("You try to use your key to open the box... It works!");
                    visitor.tell("You take 5 gold.");
                    visitor.giveGold(5);
                    hasOpenedBox = true;
                }else if(!visitor.hasEqualItem(key)) {
                    visitor.tell("You try to open the box... It needs a key.");
                }
            }else if(choice == 'c') {
                visitor.tell("You flip a switch on the wall. The room is now dark.");
                lightOn = false;
            }else if(choice == 'd') {
                return Leave(visitor, lightOn);
            }
        }else if(lightOn == false) {
            char choice = visitor.getChoice("a)Turn on lights b)Leave room", twoOptions);
            if(choice == 'a') {
                visitor.tell("You carefully make your way to the switch on the wall. Flipping the switch, the lights turn on.");
                lightOn = true;
            }else if(choice == 'b'){
                return Leave(visitor, lightOn);
            }
        }
        return Leave(visitor, lightOn);
    }
    
    Direction Leave(Visitor visitor, boolean lightOn) {
        char[] fourOptions = {'a', 'b', 'c', 'd'};
        
        visitor.tell("In which direction would you like to leave?");
        char choice = visitor.getChoice("a)North b)East c)South d)West", fourOptions);
        if(lightOn == false) {
            visitor.tell("You stumble in the dark toward the door.");
        }
        if(choice == 'a') {
            visitor.tell("You take the nothern exit.");
            return Direction.TO_NORTH;
        }else if(choice == 'b') {
            visitor.tell("You take the eastern exit.");
            return Direction.TO_EAST;
        }else if(choice == 'c') {
            visitor.tell("You take the southern exit.");
            return Direction.TO_SOUTH;
        }else if(choice == 'd') {
            visitor.tell("You take the western exit.");
            return Direction.TO_WEST;
        }
        return null;
    }
}
