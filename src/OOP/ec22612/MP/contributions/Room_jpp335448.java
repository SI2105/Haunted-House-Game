package OOP.ec22612.MP.contributions;

class Room_jpp335448 extends Room {
    public Direction visit(Visitor vis, Direction Dir) {
        vis.tell("Welcome to jpp335448, have fun!");
        vis.tell("Take some Gold!");
        vis.giveGold(4);
        return Direction.opposite(Dir);
    }
}
