package OOP.ec22612.MP.contributions;

class Room_ec22909 extends Room {

    private boolean IsCandleOn = false; //ON or OFF
    private boolean Cold = true; //is it hot or cold
    private boolean ChestEmpty = false; //is the chest empty
    Item Lighter = new Item("Lighter");
    private int gold;


    public Direction visit(Visitor visitor, Direction direction) {

        if (direction == Direction.FROM_NORTH) {
            visitor.tell("You came from north direction.");
        } else if (direction == Direction.FROM_EAST) {
            visitor.tell("You came from east direction.");
        } else if (direction == Direction.FROM_SOUTH) {
            visitor.tell("You came from south direction");
        } else if (direction == Direction.FROM_WEST) {
            visitor.tell("You came from west direction.");
        }

        if (!IsCandleOn) {
            visitor.tell("the room is very dark and you can barely see");
        } else {
            visitor.tell("the room is very bright and you can see clearly");
        }

        if (Cold) {
            visitor.tell("it is very cold");
        } else {
            visitor.tell("it is not very cold");
        }

        char[] options = {'1', '2'};
        int choice = visitor.getChoice("1. explore the room\n2. open the chest", options);


        if (choice == '1') {
            if (!IsCandleOn) {

                visitor.tell("you explore the room and find a mirror and can feel some prensence nearby ");
                char[] options1 = {'1', '2'};
                int choice1 = visitor.getChoice("1.Look at the mirror \n2. open the chest", options1);

                if (choice1 == '1') {

                    visitor.tell("you look at the mirror can can barely see anything");
                    char[] options2 = {'1'};
                    int choice2 = visitor.getChoice("1. open the chest", options2);

                    if (choice2 == '1') {

                        visitor.tell("you find a lighter and some gold");
                        visitor.giveGold(3);

                        if (!visitor.hasIdenticalItem(Lighter)) {
                            visitor.giveItem(Lighter);
                            visitor.tell("you use the lighter on the candles and the room lights up");
                        }
                    }

                } else if (choice1 == '2') {
                    visitor.tell("you find a lighter and some gold");
                    visitor.giveGold(3);

                    if (!visitor.hasIdenticalItem(Lighter)) {
                        visitor.giveItem(Lighter);
                        visitor.tell("you use the lighter on the candles and the room lights up");
                    }
                }
            }
        } else if (choice == '2') {
            visitor.tell("you find a lighter and some gold");
            visitor.giveGold(3);

            if (!visitor.hasIdenticalItem(Lighter)) {
                visitor.giveItem(Lighter);
                visitor.tell("you use the lighter on the candles and the room lights up");
            }
        }


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
