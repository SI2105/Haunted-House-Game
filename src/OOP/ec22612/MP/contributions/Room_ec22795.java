package OOP.ec22612.MP.contributions;

import java.util.Random;
import java.util.Scanner;

class Room_ec22795 extends Room {

    // A method that prints out the message and returns the answer
    public static String inputanswer()
    {
        Scanner scanner = new Scanner(System.in);
        String giveanswer;
        giveanswer = scanner.nextLine();
        return giveanswer;

    }

    Item candle = new Item("candle");
    Item key = new Item("key");
    char [] choices = {'a','b','c','d'};
    char [] Y_N_option = {'Y','N'};

    public Direction visit (Visitor x, Direction y){
       
        x.tell("You have entered the House of Winchester Mystery House. Now that you are in the room, as you look closer, you'll see that there are doors and windows that lead to nowhere, stairs that abruptly end, and secret passageways that lead to unexpected destinations");
        
        x.tell("Would you like to light the candle, so you can see through the dark(Yes/No)");
        String answer_of_question = inputanswer();

        if(answer_of_question.equals("Yes")){
            x.giveItem(candle);
        }
        boolean ItemFound = false;
        int numTries = 0;
        int maxTries = 5;

        while(!ItemFound && numTries < maxTries){

            char a = x.getChoice("Now you can choose your next move: \n a) There is a cupboard on the southeast of the room \n b) There is a drawer in the northeast of the room \n c) There is a door in the southwest of the room \n d) There is window on the northwest of the room. \n Which option from a-d do you want to follow?", choices);
                   
            if (a == 'a'){
                x.tell("You looked in the cupboard and you found 1 piece of gold");
                x.giveGold(1);
    
            }
            else if (a == 'b'){
                x.tell("You searched the drawer and you found a key. To get the key you need to give 2 pieces of gold");
                x.takeGold(2);
                x.giveItem(key);
            }
            else if (a =='c'){

                if(x.hasIdenticalItem(candle))
                {
                    x.tell("You have the candle and therefore you can see better in the dark");
                    Random random = new Random();
                    int number_of_golds = random.nextInt(10);
                    x.giveGold(number_of_golds);
                    x.tell("You found " + number_of_golds + "pieces of gold in this room");
                   
                }
                else{
                    x.tell("You need to find a candle and come back to explore");
                
                }
            }
            else if(a == 'd'){
                x.tell("You cannot open the window!");
            }
            else{
                x.tell("You might want to leave.");
            }

            if(x.hasEqualItem(key)){
                x.tell("You can use the key to leave this house.");
                char answer2 = x.getChoice("Do you want to leave Y/N",Y_N_option);
                if(answer2 =='Y'){
                    ItemFound = true;
                }
            }
            
            numTries++;
        }
        
        if (ItemFound) {
            return y.opposite(y);
        } else {
            x.tell("You failed to find the key in " + maxTries + " attempts. Better luck next time!");
        return y;
        }

    }


}
