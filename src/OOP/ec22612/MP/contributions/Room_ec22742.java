package OOP.ec22612.MP.contributions;

class Room_ec22742 extends Room {

  private boolean phoneCharged;
  private boolean cameraEquipped;
  private int poltergeistMood; 
  private int gold;

 public Room_ec22742() {
     this.phoneCharged = false;
     this.cameraEquipped = false;
     this.poltergeistMood = 0;
     this.gold = 0;
 }
  

  public Direction visit(Visitor visitor, Direction directionOfArrival) {

      visitor.tell("You are now within the house. You must take great precaution, as it is said this place is haunted, and the only way to befriend this ghastly presence is to gift it something.");

      if (phoneCharged) {
          visitor.tell("Ok, good, your phone is charged. You are now equipped to survive this dangerous adeventure, and have the resources to escape if needed.");
      } else {
          visitor.tell("So tell me now, why the hell did you not charge your phone? You're putting yourself at risk here, by advancing with this journey.");
      }

      char choice = visitor.getChoice("What would you like to do? A) Continue Walking, B) Charge your phone, ", new char[]{'A', 'B'});

      if (choice == 'A') {
          if (phoneCharged) {
              visitor.tell("Your phone is already charged, well done. You may now advance.");
          } 

          else {
              visitor.tell("So you're sure you want to advance without charging it? Alright, but just know that you have been warned.");
              phoneCharged = false;
          }
      } 

      else if (choice == 'B') {
          if (phoneCharged) {
              visitor.tell("No need, your phone seems to be on full charge! Well done traveller, you have taken great precaution. ");
              phoneCharged = true;
          } 

          else {
              visitor.tell("*20* minutes later* well done traveller, that was the right choice, your phone is now fully charged.");
          }

      } 

    char choice2 = visitor.getChoice("Now that you are advancing forward, it's time to ensure you have the right resources to capture this ghatsly creature on camera. What would you like to do? A) Equip Camera, B) Keep it inside the bag ", new char[]{'A', 'B'});
     
     if (choice2 == 'A') {
          if (cameraEquipped) {
              visitor.tell("Ah, so you're quick on your feet. Your camera is already equipped. Well done, you are now prepared to fave the ghost of this mansion.");
          } 

          else {
              visitor.tell("Good choice young traveller, equipping the camera is the wises move in this scenario.");
              cameraEquipped = true;
          }
      } 

        else if (choice2 == 'B') {
          if (cameraEquipped) {
              visitor.tell("Ah, so you're quick on your feet. Your camera is already equipped. Well done, you are now prepared to fave the ghost of this mansion.");
              cameraEquipped = true;
          } 

          else {
              visitor.tell("Mmm, so you choose to keep the camera hidden for now. Okay. Might be smart not to scare off the ghost, but I think it would be better to equip it. However, it is your choice young traveller.");
          }

      }
      
      visitor.tell("You are now approaching the room where the ghastly figure resides. Your choices up until now will decide your fate. I wish you best of luck young traveler. And I hope this encounter does indeed go to plan.");

      if(phoneCharged)
      {
        visitor.tell("Well done for taking precaution, the ghost's powers weaken when it knows that you are prepared, you can take some of it's gold.");

       visitor.takeGold(5);
      }
      else{
        visitor.tell("You see, I told you it would have been a benefit to have charged your phone, now the ghost sees that you're completely alone.");
      }

      if(cameraEquipped)
      {
        visitor.tell("Nows your chance to snap a picture of the ghost! .... well done, it's immobile for a bit, go grab some of it's gold.");
        visitor.takeGold(5);
      }
      else{
        visitor.tell("And once again I was right, if you have your camera equipped, you would have been able to immobilize the ghost for a second and go for the gold.");
      }
    
        visitor.tell("Now tell me, how angry does the poltergeist seem on a scale of 1-10?");

        if(poltergeistMood<=0){
          visitor.tell("That's surprising, perhaps it has matured and grown to be kinder over the years. Strange, anyways you can now go.");
        }
        else if(poltergeistMood>0 && poltergeistMood<6)
        {
          visitor.tell("It's clearly a bit upset at you, so i'd be very cautious if I was you, and slowly back out of the room.");
        }
        else if(poltergeistMood>=6 && poltergeistMood<=10)
        {
          visitor.tell("Oh, it's angry, if I were you, I'd start running, and I wouldn't look back.");
        }

        if(gold==10)
        {
          visitor.tell("Well, done! You have taken it's gold and won the game!");
        }
        else if(gold==5)
        {
          visitor.tell("You have stolen a part of it's treasure, os we can call this one a draw.");
        }
        else if(gold<5)
        {
          visitor.tell("Unfortunately, you didn't manage to steal any gold, because you didn't prepare well enough. You'll get it next time.");
        }

    
        


      return Direction.opposite(directionOfArrival);
  }

}
class House_ec22742 extends House {
     private Room room1;
     private Room room2;
     private Room room3;

     House_ec22742() {
         room1 = new Room_ec22743(); // North
         room2 = new Room_ec22741(); // East  
         room3 = new Room_ec22740(); // West  
     }

     public Direction visit(Visitor v, Direction direction) {
         v.tell("You are now ready to lave the house, pick which room you're going to! ");
         char[] options = {'N', 'S', 'W', 'E'};
         v.tell("Now choose! But choose wisely, because if you don't you might get lost!"); 
         v.tell("Choose to go forward (north), right (east), left (west) or (south)"); 
         v.tell("Choose wisely"); 
         v.tell(" One of the options is (N).");
         v.tell(" Or you could do(W).");
         v.tell(" MMM how about (E).");
         v.tell(" Or you could do(S)");
         char choice = v.getChoice("Chhose now!", options);

         while (choice != 'S') {
             if (choice == 'N') {
                 v.tell("Welcome to the front room!");
                 direction = room1.visit(v, direction);
             }
             if (choice == 'E') {
                 v.tell("Welcome to the one of the wine cellars, not sure if this is the right way though.");
                 direction = room2.visit(v, direction);
             }
             if (choice == 'W') {
                 v.tell("Welcome to the storage room. Don't know if this is the one!");
                 direction = room3.visit(v, direction);
             }
             else {
                 choice = v.getChoice("Dont cheat", options);
             }
             choice = v.getChoice("next Room!", options);
         }
         return direction;
     }
 }
