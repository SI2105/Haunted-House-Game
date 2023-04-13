package OOP.ec22612.MP.contributions;

class Room_bt21057 extends Room {
    static final Item sword = new Item("Sword");
    static final Item sock = new Item("Sock");
    static final Item gun = new Item("Gun");
    static final Item bullets = new Item("Bullets");
    static final Item helmet = new Item("Helmet");
    static final Item devilfruit = new Item("DevilFruit");
    static final Item shield = new Item("Shield");
  public Direction visit(Visitor visitor, Direction visitorDirection){
        char [] option1 = {'1', '2'};
        char [] option2 =  {'1', '2', '3', '4'};
      visitor.tell("Welcome, traveller!");
      visitor.tell("First i will ask if you want to be checked for what items you are carrying right now, if your lucky enough to be carrying and item we are looking for, we'll give you something to go with it ;)");        
      visitor.tell("Then, I will propose to you 4 choices");
      
      char choice1 = visitor.getChoice("Do you want to be checked? | 1 = yes | 2 = no", option1);
      
      if (choice1 == '1') {
          
        if (visitor.hasIdenticalItem(gun) == true ) {
      visitor.giveItem(bullets);
          visitor.tell("Have fun mate!");
      }
        else if (visitor.hasIdenticalItem(shield) == true ) {
      visitor.giveItem(helmet);
          visitor.tell("Now you are more protected!");
      }
        else {}
  }
        else {
    visitor.tell("Your loss.... ");
  }
        
      visitor.tell("Now, I will propose to you 4 choices");

        char choice2 = visitor.getChoice("Each value comes with a proposisition| 1) Take a sword from north but how much GOLD taken is unknown| 2) Take this sock from south for 1 GOLD| 3) Take this gun from west from for 2 GOLD 4) Take this devil fruit from east for 5 GOLD", option2);

        if (choice2 == '1') {
            visitor.takeGold(7);
            visitor.giveItem(sword);
            visitorDirection = Direction.TO_NORTH;
            visitor.tell("Creature: This can cut through anything, but takes 1 year of training before use");
        }

        else if (choice2 == '2') {
            visitor.takeGold(1);
            visitor.giveItem(sock);
            visitorDirection = Direction.TO_SOUTH;
            visitor.tell("Creature: Good choice, if you wear this sock your are immortal.");
        }

        else if (choice2 == '3') {
            visitor.takeGold(2);
            visitor.giveItem(gun);
            visitorDirection = Direction.TO_WEST;
            visitor.tell("Creature: Just a normal gun lol.");
        }

        else if (choice2 == '4') {
            visitor.takeGold(5);
            visitor.giveItem(devilfruit);
            visitorDirection = Direction.TO_EAST;
            visitor.tell("Creature: Eat this devil fruit and you will attain the Tremor-Tremor fruit powers.");
        }

        else {
            visitor.tell("BAKA");
            visitor.takeGold(10);
            visitorDirection = Direction.opposite(visitorDirection);
        }

        return visitorDirection;


    }

}
