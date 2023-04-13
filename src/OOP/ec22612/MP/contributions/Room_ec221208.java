package OOP.ec22612.MP.contributions;

import java.util.Random;

 class Room_ec221208 extends Room {
     
     static final Item Key = new Item ("Key");
    
     static boolean candle = true;

     public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
         //Random number
         Random random = new Random();
         int randInt = random.nextInt(10);

         char[] choices = { 'a', 'b', 'c' };
         
         char choice = '0';

        
         if (this.candle) {
             visitor.tell("You have entered a dark, abandoned room with a trunk, a chest and a single lit candle in the middle");
             choice = visitor.getChoice("You can (a) open the trunk, (b) open the chest or (c)blow out the candle", choices);
         }
         else{ 
             visitor.tell("You have entered a dark, abandoned room with a trunk, a chest and a single candle in the middle which has been blown out");
             choice = visitor.getChoice("You can (a) open the trunk, (b) open the chest or (c)relight the candle", choices);
         }
         if (choice == ('a')) {
             
             if (visitor.hasEqualItem(Key)) {
                 //If the user has already collecteed 
                 visitor.tell("You have already collected a key");
             } else {
                 
                 visitor.giveItem(Key);
             }
         //If user choses to open the chest
         } else if (choice == ('b')) {
             //Give the user a random number of gold
             visitor.giveGold(randInt);
             //If the candle is lit and the user choses to blow it out
         } else if (choice == ('c') && this.candle) {
             visitor.tell("The candle has been blown out");
             //Candle is now blown out 
             this.candle = false;
             //If the candle is not lit and the user choses to relight it
         } else if (choice == ('c') && !(this.candle)){
             visitor.tell("The candle has been relit");
             //Candle is now lit
             this.candle = true;
         } else{ //If the user enters an invalid option
             visitor.tell("Invalid option");
         }

         
         return Direction.opposite(directionVistorArrivesFrom);
     }
 }
