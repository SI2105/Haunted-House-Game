package OOP.ec22612.MP.contributions;

class Room_ec221012 extends Room {

    private boolean lightsOn;
    private boolean trunkEmpty;

    @Override
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {

        visitor.tell("You have entered Jamie's room.");

        if (directionVisitorArrivesFrom == Direction.FROM_WEST) {
            visitor.tell("You have arrived from the west.");
        } else if (directionVisitorArrivesFrom == Direction.FROM_EAST) {
            visitor.tell("You have arrived from the east.");
        } else if (directionVisitorArrivesFrom == Direction.FROM_NORTH) {
            visitor.tell("You have arrived from the north.");
        } else if (directionVisitorArrivesFrom == Direction.FROM_SOUTH) {
            visitor.tell("You have arrived from the south.");
        }

        if (lightsOn) {
            visitor.tell("The lights are on.");
        } else {
            visitor.tell("The lights are off.");
        }

        if (trunkEmpty) {
            visitor.tell("The chest is empty.");
        } else {
            visitor.tell("The chest is not empty.");
        }

        char choice = visitor.getChoice("What would you like to do? (B)low out candles, (L)ight candles, (O)pen chest, (C)lose chest", new char[]{'B', 'L', 'O', 'C'});

        if (choice == 'B') {
            if (lightsOn) {
                visitor.tell("You blew out the candles.");
                lightsOn = false;
            } else {
                visitor.tell("There are no candles to blow out.");
            }
        } else if (choice == 'L') {
            if (lightsOn) {
                visitor.tell("The candles are already lit.");
            } else {
                visitor.tell("You lit the candles.");
                lightsOn = true;
            }
        } else if (choice == 'O') {
            if (trunkEmpty) {
                visitor.tell("The chest is already empty.");
            } else {
                if (visitor.hasIdenticalItem(new Item("key"))) {
                    visitor.tell("You used the key to open the chest.");
                    visitor.giveGold(5);
                    trunkEmpty = true;
                } else {
                    visitor.tell("The chest is locked.");
                }
            }
        } else if (choice == 'C') {
            if (trunkEmpty) {
                visitor.tell("The chest is already closed.");
            } else {
                visitor.tell("You closed the chest.");
            }
        }

        return Direction.opposite(directionVisitorArrivesFrom);

    }
}
