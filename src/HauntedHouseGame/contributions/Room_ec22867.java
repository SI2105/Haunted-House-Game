package HauntedHouseGame.contributions;

class Room_ec22867 extends Room {

     private boolean lightsOn;

     public Direction visit(Visitor visitor, Direction directionOfArrival) {

         visitor.tell("You have entered Sana's room.");

         if (lightsOn) {
             visitor.tell("The lights are on");
         } else {
             visitor.tell("The lights are off");
         }

         char choice = visitor.getChoice("What would you like to do? A) Turn on light, B) Turn off the light, C) Wear the shoe", new char[]{'A', 'B', 'C'});

         if (choice == 'A') {
             if (lightsOn) {
                 visitor.tell("The light is already on");
             } 
             
             else {
                 visitor.tell("You turned on the lights");
                 lightsOn = true;
             }
         } 
         
         else if (choice == 'B') {
             if (lightsOn) {
                 visitor.tell("You turned on the lights");
                 lightsOn = false;
             } 
             
             else {
                 visitor.tell("The light is already off");
             }
             
         } 
         
         else if (choice == 'C') {
             
             visitor.tell("You wore the shoe");
             
             if (visitor.hasIdenticalItem(new Item("shoe"))) {
                 visitor.tell("You have the matching pair and get 7 gold.");
                 visitor.giveGold(7);
             }
             
             else {
                 visitor.tell("You don't have the matching pair");
             }
         }
     

         return Direction.opposite(directionOfArrival);
     }

}
