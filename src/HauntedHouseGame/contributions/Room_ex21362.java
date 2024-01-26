package HauntedHouseGame.contributions;

class Room_ex21362 extends Room
 { 
     boolean lightsOn;
     boolean treasureEmpty;

     char choice; // to store the user's choice

     public Room_ex21362() 
     {
         this.lightsOn = false;
         this.treasureEmpty = false;
         // this.doorOpen = false; 
     }

     public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) 
     {
         visitor.tell("You have entered a room");
         if (lightsOn) 
         {
             visitor.tell("The lights are currently on. ");
         } 
         else 
         {
             visitor.tell("The light are currently off. ");
         }

         if (treasureEmpty) 
         {
             visitor.tell("The treasure box is empty!!");
         } 
         else
         {
             visitor.tell("Wow, the treasure box has items in it!! Wonder what they are. ");
         }

         choice = visitor.getChoice("What will your next step be? Choose from these options... \n"+ "L - Switch Light On/Off\n"+ "T - Treasure Box Empty/Not Empty\n"+ "X - Leave room\n", new char[] {'L', 'T', 'X'});

         switch (choice) 
         {
             case 'L':
                 lightsOn = !lightsOn; //will open lights is off OR clsoe lights if on 
                 if (lightsOn) 
                 {
                     visitor.tell("The lights will not be switched on");
                 } else {
                     visitor.tell("The lights are now off");
                 } 
                 break;                
             case 'T':
                 visitor.tell("You've chose to open the treasure box. How brave! ");
                 treasureEmpty = !treasureEmpty;
                 if (treasureEmpty) {
                     visitor.tell("What a shame, it is empty!");
                 } else {
                     visitor.tell("Interesting, you've earned 15 coins. Proceed ");
                 } 
                 break;                
             case 'X': //leave the current room 
                 visitor.tell("You can now leave the room.");
                 break;
         }        
         return Direction.opposite(directionVistorArrivesFrom);
     }

 }