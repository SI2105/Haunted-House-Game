package HauntedHouseGame.contributions;

class Room_ec22513 extends Room{
  
  public Direction visit(Visitor visitor, Direction direction){
    visitor.tell("welcome to my room");
    visitor.tell("take this gold");

    visitor.giveGold(5);

    return Direction.opposite(direction);
  }
}
