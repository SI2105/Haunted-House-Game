package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec221016 extends Room {
  
  public Direction visit(Visitor x, Direction dcamefrom) {
    
   
    x.tell("Welcome to my room!");
    x.tell("Unluckily youll get a random amount of gold taken from you and be sent the opposite way you came from =) ");
    
    Random num = new Random();
    int rnumgold = num.nextInt(10);
    
    while ((rnumgold >= 10) || (rnumgold <= 0)) {
      rnumgold = num.nextInt(10);
    }
    
    x.takeGold(rnumgold);
    x.tell("I took " + rnumgold + " from you haha");
    
    
    return dcamefrom.opposite(dcamefrom);
  }
}
