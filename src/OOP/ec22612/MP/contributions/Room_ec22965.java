package OOP.ec22612.MP.contributions;

class Room_ec22965 extends Room{
  public Direction visit( Visitor guest, Direction ArrivalDirection){
    Item lamp = new Item("lamp");
    guest.tell("welcome to my room, have fun!");
    guest.tell("let's play a game! I will ask you some questions, get the answer right i'll give you gold, get it wrong you give me gold");
    
    char [] UserChoices1 = {'a','b','c'};
    
    guest.tell("In reply to an inquiry about the animals on his farm, the farmer says: “I only ever keep sheep, goats, and horses. In fact, at the moment they are all sheep bar three, all goats bar four, and all horses bar five.” How many does he have of each animal?");
    char question1 = guest.getChoice("a)3 sheep, 2 goats, and 1 horse b) 4 sheep, 2 goats, and 1 horse c)3 sheep, 2 goats, and 2 horse", UserChoices1);
    
    if (question1== 'a'){
      guest.tell("WELL DONE here's 100 gold");
      guest.giveGold(100);
    }
    else{
      guest.tell("wrong!! give me 100");
      guest.takeGold(100);
    }
    
    guest.tell("that was fun lets play again but this time, if you win i'll give you a special item");
    char [] UserChoices2 = {'a','b','c'};
    guest.tell("what english football club got the most points in a prem season");
    char question2 = guest.getChoice("a) man city b) liverpool c) united", UserChoices2);
    
    if (question2== 'a'){
      guest.tell("WELL DONE here's a lamp");
      guest.giveItem(lamp);
    }
    else{
      guest.tell("wrong, sorry");
    }
    
    return Direction.opposite(ArrivalDirection);
  }
}
