package OOP.ec22612.MP.contributions;

import java.util.Random;
    
class Room_ec22413 extends Room{
    
    static final Item Diamond = new Item("Diamond");
    
    
    
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
        
        if (visitor.hasEqualItem(Diamond)==true){
            visitor.tell("You have been here already, leave");  //User may use the room only once
            return Direction.TO_SOUTH;
        }
        
        else{
            char[] choices= {'1','2','3','4','5'};  //array of choices
            
            visitor.tell("");
            visitor.tell("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            visitor.tell("Welcome to the Crusty Crab Casino");
            visitor.tell("1 room, 1 game, 5 attempts.\nAll you gotta do is guess the correct number using that keypad over there.\nIf you dont the house will take 1 gold from you everytime.");
            visitor.tell("");
            visitor.tell("Just because the keypad has 9 numbers does not mean that all numbers matter.\nOnly pick numbers 1 to 5, unless you want to waste a turn.");
            visitor.tell("");

            String choice="";

            int correct_number=0; 
            String Scorrect_number= ""; //variable used to store string of the correct number

            int Gold=0;
            int count=0;

            for (int i=0 ; i<5 ; i++){     //5 attempts
                
                correct_number= ((new Random()).nextInt(5))+1;           //generates new random number 
                //correct_number= 2;
                Scorrect_number= Integer.toString(correct_number);       // converts to a string

                choice= String.valueOf(visitor.getChoice("        1    2    3\n        4    5    6\n        7    8    9\n             0    \n\n",choices)); // gets choice from user
                
                if (choice.equals(Scorrect_number)){
                    break;
                }
                
                Gold += 1;     // take 1 gold and add to the total
                visitor.takeGold(1);
            }
            
            count=5-Gold;

            visitor.giveGold(count);
            
            visitor.tell("Congratulations for completing the game,take this item.\nYou can redeem it for 30 gold in 5 other rooms.");
            
            visitor.giveItem(Diamond);
            
            visitor.tell("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
            visitor.tell("I kind of lied about the price, its a fake diamond.");
            
            visitor.tell("Moneys been tight, I just gave you that item so I can check if you have been here before.\nIf you do have it and come back to this room you will be kicked out, we cant keep giving you money for guessing some numbers.\nIt is a casino after all.");
            
             visitor.tell("Bye.");

            return Direction.TO_EAST;
        }
    } 
}
