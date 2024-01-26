package HauntedHouseGame.contributions;

class Room_ec22570 extends Room {
  public Direction visit(Visitor visitor, Direction origin) {
    visitor.tell("Hello, welcome to Room_ec22570");
    visitor.tell("You came from " + origin);
    visitor.tell("Please leave my room, I shall give you 10 gold in return");
    visitor.giveGold(10);
    return Direction.opposite(origin);
  }
}
