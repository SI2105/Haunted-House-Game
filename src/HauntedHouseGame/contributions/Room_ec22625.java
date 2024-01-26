package HauntedHouseGame.contributions;

class Room_ec22625 extends Room {
  public Direction visit (Visitor visitor, Direction directionVistorArrivesFrom){
      char[] options = {1,2};
      int choice;
      visitor.tell("Free gold from ec22625");
      visitor.tell("Choose 1 or 2");
      choice = visitor.getChoice("Depending on what you choose you may gain 10 gold or 5 gold.", options);
    
      if(choice == 1){
        visitor.giveGold(10);
      }
      else if(choice == 2){
        visitor.giveGold(5);
      }

      return directionVistorArrivesFrom;
  }
}
