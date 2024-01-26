package HauntedHouseGame.contributions;

import java.util.Random;
// Assignment 4 Version 2
// ec221088.
// 3/3/2023
abstract class Room_ec221088 extends Room implements Visitor, Visitable{
    Item newItem = new Item("Key");
    int NumberofGold = 7; 
    String roomDescription = "There's an old wooden chest with rusted hinges in one corner, its lid slightly ajar, as if something has been recently removed.\n" +
        " Across from it is a dusty bookshelf, filled with leather-bound tomes and old scrolls, their titles written in a language you don't recognize.\n" + 
        " In the center of the room is a large, circular table, made of an unknown dark wood and etched with intricate designs.\n" + 
        "Upon the table sits a crystal orb, reflecting the flickering candlelight and casting rainbows across the walls.";
    
    
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
        visitor.tell("Hello, do you want to enter the room?");
        char userchoice = visitor.getChoice("Please choose a to come in, b to leave", new char [] {'a','b'});
        if(userchoice == 'a') {
            visitor.tell("You are in room ec221088.");
        }
        else {
            visitor.tell("See you next time! Good Luck with the rest of your Journey!");
            return Direction.opposite(directionVistorArrivesFrom);
        }
        int NumberofGold = visitor.takeGold(3); 
        boolean light = true; 
        
        visitor.tell("Welcome Explorer!");
        visitor.tell("You are in the room ec221088! arriving from "+ directionVistorArrivesFrom);
      
        if (light == true){
            visitor.tell("The light is on");
            visitor.tell(roomDescription);
            light = false; 
        }
        else if (light == false){
            visitor.tell("the light is off");
             visitor.tell(roomDescription);
             light = true;
        }
        visitor.tell("You move towards the wooden chest, on it you see a lock with 1-9 numbers in it, and a hand written letter.\n" + 
    " Letter says: Test your luck, pick a number between 1-8, inside it is the key to leave this room and 5 Gold coins.\n" + 
     " If You Pick the wrong number, you have to give 5 Gold coins to get the key to exit this room. You have no choice but to continue!");
        
        int number=randomNum(8); 
        char[] choices = {'1','2','3','4','5','6','7','8'};
        char choicesResp=visitor.getChoice("You must pick the correct cup select from 1-8", choices);
        int choiceConv=Integer.parseInt(String.valueOf(choicesResp))-1;
        if (choiceConv == number){
        visitor.tell("The Chest opens and You take the key and 5 gold from the chest.");
        visitor.giveGold(5);
        visitor.giveItem(newItem);
        }
          else{
        visitor.tell("You see a small drawer of the Chest opens, and you get The Key to the door ");
        visitor.takeGold(5);
        visitor.giveItem(newItem);
        }


        Direction leavesTo = directionVistorArrivesFrom.opposite(directionVistorArrivesFrom);

        if(leavesTo.equals(directionVistorArrivesFrom)){
            visitor.tell("You're going to leave towards the way you came");
        }

        if (visitor.giveItem(newItem)){
            visitor.tell("Here is a Key for you!");
            visitor.tell("Good Luck with the rest of your journey!");
            visitor.tell("May Good Fortune be with you!");
        }
      
        return directionVistorArrivesFrom;
    }
      public static int randomNum(int limit){
        Random random = new Random();
        return random.nextInt(limit);
    }
}
