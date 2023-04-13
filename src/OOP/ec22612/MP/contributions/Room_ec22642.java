package OOP.ec22612.MP.contributions;

class Room_ec22642 extends Room {
    boolean visited = false;
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        Direction directionVisitorLeavesTo = Direction.TO_NORTH;

        char input = visitor.getChoice("Where will you go? \n a)lake \n b)forest \n c)mountainous route \n d) hut", new char[]{'a', 'b', 'c', 'd'});
        switch (input) {
            case 'a':
                visitor.tell("The lake divines you with gold");
                visitor.giveGold(4);
                directionVisitorLeavesTo = Direction.TO_NORTH;
                break;

            case 'b':
                visitor.tell("You find a lantern rested on the largest tree");
                visitor.giveItem(new Item("Lantern"));
                directionVisitorLeavesTo = Direction.TO_EAST;
                break;

            case 'c':
                visitor.tell("You encounter bandits, they steal your gold off you");
                visitor.takeGold(4);
                directionVisitorLeavesTo = Direction.TO_SOUTH;
                break;

            case 'd':
                visitor.tell("Hut is abandoned and has gold inside");
                visitor.takeGold(2);
                directionVisitorLeavesTo = Direction.TO_WEST;
                break;

            default:
                visitor.tell("You dreadfully plunge into the abyss...");
                return directionVisitorLeavesTo; 
        }
        return directionVisitorLeavesTo;

    }
}