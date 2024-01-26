package HauntedHouseGame.contributions;

class Room_ec2281 extends Room {
  static final Item Karambit = new Item("Karambit"); 
  
  public Direction visit(Visitor v, Direction d) {
    v.tell("Welcome");
    v.giveItem(Karambit);
    if (v.hasEqualItem(Karambit)) {
        v.takeGold(5);
    }
      return d;
  }
}
