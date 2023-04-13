package OOP.ec22612.MP.contributions;

import java.util.Random;
import java.util.Scanner;

class Room_ec22718 extends Room {
    

    static final Item SWEETS = new Item("Haribow");
    private boolean lampON = true;


    
    // for inputs
    public static String input(Visitor v,String text){
        Scanner sc = new Scanner(System.in);
        v.tell(text);
        return sc.nextLine();
    }

    public static int inputInt(Visitor v,String text){
        int number =0;
        
        try{
            number = Integer.parseInt(input(v,text));
        }catch (NumberFormatException e){
            v.tell("invalid");
            inputInt(v,text);
        }
        
        return number;
    }
    
    // to validate choices
    public static char options(Visitor v, boolean light){
        String choices= "";
        if (light){
            choices = "Would you like to (1) Turn off the lights and leave, (2) Recieve a gift, (3) Roll a dice to change direction?";
        }else{
            choices = "Would you like to (1) Turn on the lights and leave, (2) Recieve a gift, (3) Roll a dice to change direction?";
        }
        char[] toChoose = {'1','2','3'};
    
        char optionChoice =v.getChoice(choices, toChoose);
        return optionChoice;
    }
    
    // method 
    public Direction visit (Visitor v, Direction d) {
        
        // type of room
        v.tell("Welcome to the sweet room");
        v.tell("Enjoy your visit :)");
        
        // state of room
        if (lampON){
            v.tell("The lights are on!");
        }else{
            v.tell("The lights are off");
        }
        
        char validChoice =options(v, lampON);
        
        if (validChoice == '1'){
            if (lampON){
                lampON= false;
                v.tell("The lights are now off");
                v.tell("It is very dark");
            }else{
                lampON= true;
                v.tell("Thank you!");
                v.tell("This room was too dark");
                v.giveGold(2);
            }
            
        }else if (validChoice == '2'){
            
            if (v.hasEqualItem(SWEETS)){
              v.takeGold(1);
             
            }else{
              v.tell("I have some sweets for you!");
              v.giveItem(SWEETS);
            }
                
        }else if( validChoice =='3'){
                
              input(v,"Press enter to spin the dice"); 
              Random r = new Random(); 
              int diceRoll = r.nextInt(7)+1;
                
              if (diceRoll%3 ==0){
                  d = Direction.TO_NORTH;
              }else if (diceRoll ==5){
                  d = Direction.TO_EAST;
              }else if (diceRoll<3 || diceRoll>5){
                  d = Direction.TO_SOUTH;
              }else{
                  d= Direction.TO_WEST;
              }
        }else{
                
            v.tell("You shouldnt be here");
        }

        return d;
    }

}
