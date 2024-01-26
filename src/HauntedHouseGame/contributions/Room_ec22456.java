package HauntedHouseGame.contributions;

class Room_ec22456 extends Room {

    private int visited;

    private Direction leaveRoom (Visitor visitor, Direction visitingDirection) {
        char visitorChoice = visitor.getChoice("Would you like to leave from the door to the North (a), " +
                "West (b), East (c) or South (d).", new char[]{'a', 'b', 'c', 'd'});

        if (visitorChoice == 'a') { return Direction.TO_NORTH; }
        if (visitorChoice == 'b') { return Direction.TO_WEST; }
        if (visitorChoice == 'c') { return Direction.TO_EAST; }
        if (visitorChoice == 'd') { return Direction.TO_SOUTH; }

        return Direction.opposite(visitingDirection);
    }

    public Direction visit(Visitor visitor, Direction visitingDirection) {

        if (visited == 1) {
            visitor.tell("Entering the room again, you see the same bookshelves lining the walls, making the same intersection, " +
                    "with the pedestal in the middle still being retracted. \n" +
                    "There is no sign that room will trap you again or that the pedestal will rise again.");
            return leaveRoom(visitor, visitingDirection);
        }

        visited = 1;

        visitor.tell("When you enter the room, you can see that bookshelves lining the walls form an intersection;\n in the middle" +
                " there is a big lever on pedestal. \nAs you step towards the center, metal bars enclose on all the doorways leading out of the room." +
                " \nOnce everything is closed down, you notice a glowing red button behind one of the bookshelves at the door to the north.");
        char visitorChoice = visitor.getChoice("You can press pull the lever (a) or press the red button (b)", new char[]{'a', 'b'});

        if (visitorChoice == 'a') {
            visitor.tell("Once you pull the lever, the pedestal the lever was sat on starts to retract into the ground and is replaced" +
                    " by a chest lowering from the ceiling by a rope. \nYou also notice that " +
                    "the bars on the doors slowly rise and free your way out of the room and the red button has lost it's glow. The chest has a small padlock with a 4 number combination.");
            visitorChoice = visitor.getChoice("You can leave the room (a), or attempt to unlock the padlock (b).", new char[]{'a', 'b'});

            if (visitorChoice == 'a') {
                return leaveRoom(visitor, visitingDirection);
            }

            if (visitorChoice == 'b') {
                visitorChoice = visitor.getChoice("You know a couple possible combinations that it could be :\n " +
                        "The birth year of Sarah Winchester 1839(a),\n the year Sarah Winchester died 1922(b) \nor " +
                        " The year an earthquake damaged the house severely 1906(c).", new char[]{'a', 'b', 'c'});

                if (visitorChoice == 'a') {
                    visitor.tell("Once you put the combination into the padlock, it unlocks easily and drops to the floor.");
                    visitorChoice = visitor.getChoice("Do you want to open the chest(a), or the leave the room (b)?", new char[]{'a', 'b'});

                    if (visitorChoice == 'a') {
                        visitor.tell("Opening the chest reveals 7 gold coins that were hidden inside.");
                        visitor.giveGold(7);

                        visitor.tell("You feel that you have seen all that this room has to offer.");
                        return leaveRoom(visitor, visitingDirection);
                    }

                    if (visitorChoice == 'b') {
                        visitor.tell("As you step away from the pedestal, the chest quickly retracts back into the ceiling. \n" +
                                "You feel that you missed out on something.");
                        return leaveRoom(visitor, visitingDirection);
                    }
                }

                if (visitorChoice == 'b') {
                    visitor.tell("After putting in the combination into the lock you attempt to tug on it and realise that it is firmly locked. \n" +
                            "The chest quickly retracts back into the ceiling. You feel that you missed out on something.");
                    return leaveRoom(visitor, visitingDirection);
                }

                if (visitorChoice == 'c') {
                    visitor.tell("After putting in the combination into the lock you attempt to tug on it and realise that it is firmly locked. \n" +
                            "The chest quickly retracts back into the ceiling. You feel that you missed out on something.");
                    return leaveRoom(visitor, visitingDirection);
                }
            }

            if (visitorChoice == 'b') {
                visitor.tell("As you step away from the pedestal, the chest quickly retracts back into the ceiling. \n" +
                        "You feel that you missed out on something.");
                return leaveRoom(visitor, visitingDirection);
            }
        }

        if (visitorChoice == 'b') {
            visitor.tell("Walking over to the red button and pressing it, released the metal bars from the doors. \n" +
                    "You are now free to leave the room. \n" +
                    "The pedestal in the middle of the room retracts back into the ground. You feel that you missed out on something.");
            return leaveRoom(visitor, visitingDirection);
        }

        return Direction.opposite(visitingDirection);
    }
}
