package HauntedHouseGame.contributions;

class Room_ec22959 extends Room {


    private boolean isDark = true; 
    private boolean hasTorch = true;
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
            visitor.tell("The room is dimly lit, you cannot see the contents of the room");
        } else {
            visitor.tell("The room is moderately lit, you can make out the contents of the room.");
        }

        if (hasTorch) {
            visitor.tell("You bring your torch forward. Your vision increases.");
        } else {
            visitor.tell("You are not carrying a torch. Your vision stays the same.");
        }

        char[] choices1 = {'A', 'B'};

        char choice1 = visitor.getChoice("A. Search the room\nB. Open drawer", choices1);

        switch (choice1) {
            case 'A':
                if (isDark & !hasTorch) {
                    visitor.tell("You try to search the room without a torch. Sadly, you stub your toe on the edge of a table. :(");
                } else {
                    visitor.tell("You search the room.");
                }

                visitor.tell("Afterwards, you open the drawer and find a torch & some gold.");
                visitor.giveGold(2);

                if (!visitor.hasIdenticalItem(torch)) {
                    visitor.giveItem(torch);
                    hasTorch = true;
                    isDark = false;
                }
                break;

            case 'B':
                visitor.tell("You open the drawer and find a torch & some gold.");
                visitor.giveGold(2);

                if (!visitor.hasIdenticalItem(torch)) {
                    visitor.giveItem(torch);
                    hasTorch = true;
                    isDark = false;
                }
                break;

            default:
                visitor.tell("You open the drawer and find a torch & some gold.");
                visitor.giveGold(2);

                if (!visitor.hasIdenticalItem(torch)) {
                    visitor.giveItem(torch);
                    hasTorch = true;
                    isDark = false;
                }
                break;
        }

        visitor.tell("With two more gold, you leave the room through a trapdoor hidden beneath a few boxes and enter a hallway split into 4 paths.");
        char[] directionToGo = {'A', 'B', 'C', 'D'};
        char choiceDirection = visitor.getChoice("A. Go North\nB. Go East\nC.Go South\nD.Go West", directionToGo);
        if (choiceDirection == 'A') {
            direction = Direction.TO_NORTH;
        } else if (choiceDirection == 'B') {
            direction = Direction.TO_EAST;
        } else if (choiceDirection == 'C') {
            direction = Direction.TO_SOUTH;
        } else {
            direction = Direction.TO_WEST;
        }

        return direction;
    }
}
