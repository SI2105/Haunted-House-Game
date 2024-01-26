package HauntedHouseGame.contributions;

class Room_ec22875 extends Room {
    public Direction visit (Visitor visitor, Direction Dir){
        visitor.tell ("Welcome to Room EC22875, enjoy!");
        visitor.tell ("Have some gold!");
        visitor.giveGold(4);
        return Direction.opposite (Dir);
    }
}
