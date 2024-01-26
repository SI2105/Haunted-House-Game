package HauntedHouseGame.contributions;

import java.util.Random;
class Room_ec22414 extends Room {
     public Direction visit(Visitor visitor, Direction direction){

         Random random = new Random();
         Item PS5Controller  = new Item("PS5 Controller");
         boolean LightsOn = true;

         visitor.tell("Hi, and welcome to this room!");
         visitor.tell("In this room you will have the opportunity to receive up to 10 pieces of gold.");
         char[] places = {'k','g','l'};
         visitor.tell("You may search one of three places: The kitchen, the gaming room or the living room .");
         char choice = visitor.getChoice("Enter 'k' to search the kitchen, 'g' to search the gaming room or 'l' to search the living room.", places);

         if (choice == 'k')
         {
             visitor.tell("Congratulations! In one of the cupboards, you find a treasure chest.");
             int gold = random.nextInt(10) + 1;
             visitor.tell("In the treasure chest you find " + gold + " pieces of gold.");
             visitor.giveGold(gold);
         }
         else if (choice == 'g')
         {
             visitor.tell("You have chosen the gaming room. You search and search however u do not find any pieces of gold.");
             visitor.tell("As a consolation prize,however, you receive a PS5 controller.");
             visitor.giveItem(PS5Controller);
        }
         else
         {
             visitor.tell("As you begin to search the living room, you trip over the sofa and lose some gold. Nevertheless you still manage to find 5 pieces of gold.");
             visitor.giveGold(5);
             int gold_taken = random.nextInt(10);
             visitor.takeGold(gold_taken);
         }



          // Visitor chooses which direction he / she wants to go

         char [] directions = {'n','e','s','w'};
         choice = visitor.getChoice("In which direction do you wish to go, choose 'n' for north, 'e' for east, 's' for south or 'w' for west.",directions);

         if (choice == 'n')
         {
             LightsOn = false;
             return Direction.TO_NORTH;
         }
         else if (choice == 'e')
         {
             LightsOn = false;
             return Direction.TO_EAST;
         }
         else if (choice == 's')
         {
             LightsOn = false;
             return Direction.TO_SOUTH;
         }
         else
         {
             LightsOn = false;
             return Direction.TO_WEST;
         }
     }
 }
