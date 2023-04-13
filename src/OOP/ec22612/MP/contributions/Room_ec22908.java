package OOP.ec22612.MP.contributions;

class Room_ec22908 extends Room {


    private boolean isDark = true; // true if the room is dark false if not
    private boolean noTorchAccess = true;
    private int gold;
    Item torch = new Item("torch");


    public Direction visit(Visitor visitor, Direction direction) {

        if (direction == Direction.FROM_NORTH) {
            visitor.tell("You entered the North side of the building");
        } else if (direction == Direction.FROM_EAST) {
            visitor.tell("You entered the East side of the building");
        } else if (direction == Direction.FROM_SOUTH) {
            visitor.tell("You entered the South side of the building");
        } else if (direction == Direction.FROM_WEST) {
            visitor.tell("You entered the West side of the building");
        }


        if (isDark) {
            visitor.tell("It is very dark you can barely see D: !");
        } else {
            visitor.tell("Not that dark in here...");
        }

        if (noTorchAccess) {
            visitor.tell("You have no torch access");
        } else {
            visitor.tell("You have torch access");
        }

        char[] choices = {'1', '2'};

        int choice = visitor.getChoice("1. Search the room\n2. open cabinet ", choices);

        if (choice == '1') {
            if (isDark & noTorchAccess) {
                visitor.tell("You stumble around in the dark and hit your leg. OUCH!");

                char[] choices1 = {'1'};
                int choice1 = visitor.getChoice("1. open the cabinet", choices1);

                if (choice1 == '1') {
                    visitor.tell("you opened the cabinet and found a torch and gold and use the torch");
                    visitor.giveGold(3);

                    if (!visitor.hasIdenticalItem(torch)) {
                        visitor.giveItem(torch);
                        noTorchAccess = false;
                        isDark = false;
                    }
                }
            }
        }

        if (choice == '2') {
            visitor.tell("you opened the cabinet and found a torch and gold and use the torch");
            visitor.giveGold(3);
            if (!visitor.hasIdenticalItem(torch)) {
                visitor.giveItem(torch);
                noTorchAccess = false;
            }
        }

        visitor.tell("You can now see around in the room and find a hidden hatch, you enter the hatch and find a hall way, you can go left, right, backwards or forwards");
        char[] directionToGo = {'1', '2', '3', '4'};
        int choiceDirection = visitor.getChoice("1. Go Left\n2. Go Right\n3.Go Forwards\n4.Go Backwards", directionToGo);
        if (choiceDirection == 1) {
            direction = Direction.TO_EAST;
        } else if (choiceDirection == 2) {
            direction = Direction.TO_WEST;
        } else if (choiceDirection == 3) {
            direction = Direction.TO_NORTH;
        } else {
            direction = Direction.TO_SOUTH;
        }


        return direction;
    }
}




