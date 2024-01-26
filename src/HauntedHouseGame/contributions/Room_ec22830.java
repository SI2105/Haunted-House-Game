package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22830 extends Room implements Visitable{
    Item newItem = new Item("Jacket");
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
        boolean light = false; 
        
        visitor.tell("Hi, how are you, you're actually in the room of ec22830! You are "+directionVistorArrivesFrom);
        
        char choice = 'a';
        
        while (choice!='d'){
            
            char[] options = {'a', 'b', 'c', 'd'};
            
            choice = visitor.getChoice("What would you like to do :\n"+
                "a) Turn the light on\n"+
                "b) Listen to some music and danse !\n"+
                "c) Flip a coin to win some money...\n"+
                "d) Leave", options);
            
            
                if(choice == 'a'){
                    //This part will switch the light everytime someone enter the room
                    visitor.tell("And there was light!");
                    light = true; 
                    visitor.tell("Ohh... you just find this jacket on the floor. You can keep it!");
                    visitor.giveItem(newItem);
                }
                    
                else if(choice == 'b'){
                    char[] musicOptions = {'a', 'b', 'c', 'd'};
            
                    String Music = "What would you like to listen to :\n"+
                    "a) Kalash - Booba ft Kaaris\n"+
                    "b) 31- Jwles\n"+
                    "c) Jeu Dangereux - Leto\n"+
                    "d) 1994 - Hamza\n";
                    
                    char musicChoice = visitor.getChoice(Music, musicOptions);
                    
                    if(musicChoice == 'a'){
                        visitor.tell("What a classic! Enjoy this pure French Trap song");
                    }
                    else if(musicChoice == 'b'){
                        visitor.tell("If you're into French techno music that was the right choice!");
                    }
                    else if(musicChoice == 'c'){
                        visitor.tell("Ohh I see! You just wanted to chill...");
                    }
                    else{
                        visitor.tell("Safe bet!");
                    }
                }
                    
                    
                else if (choice == 'c'){
                    char[] numbers = {'1','2'};
                    Random rd = new Random();
                    int coin = rd.nextInt(2);
                    char answerCoin = 'h'; 
                    
                    if (coin == 1){
                        answerCoin = 'h';
                    }
                    else if (coin == 2){
                        answerCoin = 't';
                    }

                    char visitorAnswer = visitor.getChoice("Heads or Tail (h/t)",numbers);

                    if (visitorAnswer==answerCoin){
                        visitor.tell("Well done! Here is a coin for you!");
                        visitor.giveGold(1);
                    } else {
                        visitor.tell("You guessed wrong, no gold for you!");
                    }
                }
                    
                else if (choice =='d'){
                    return directionVistorArrivesFrom.TO_NORTH;
                }  
            }
        
            return directionVistorArrivesFrom.TO_SOUTH;
    }
}




   
