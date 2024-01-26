package HauntedHouseGame.contributions;

class Room_ec22677 extends Room {
    public Direction visit(Visitor vis, Direction dir){
        Item luckyCharm = new Item("Lucky Charm");
        vis.tell("Pay 10 gold to enter");
        vis.takeGold(10);
        vis.tell("Thank you, have this lucky charm!");
        vis.giveItem(luckyCharm);
        return Direction.opposite(dir);
    }
}
