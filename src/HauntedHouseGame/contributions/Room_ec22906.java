package HauntedHouseGame.contributions;

import java.util.Scanner;

class Room_ec22906 extends Room {
    static final Item KEY = new Item("Key");
    char[] two_options = {'a', 'b'};
    char[] four_options = {'a','b','c','d'};
    boolean has_flashlight = false;
    boolean lights_on = false;
    boolean visited_chest = false;
    boolean opened_chest = false;
    boolean visited_vault = false;
    boolean opened_vault = false;
    int code = 860;
    
    public static int inputInt(String msg){
        int number=0;
        int count = 0;
        System.out.println(msg);
        try (Scanner s = new Scanner(System.in)) {
            while(count == 0){
                if (s.hasNextInt()){
                    number = s.nextInt();
                    if (number <= 0){
                        System.out.println("Please enter positive whole numbers only");
                        System.out.println(msg);
                    }else count = count + 1;
                
                }else if (s.hasNextLine()){
                    System.out.println("Please enter numbers only");
                    System.out.println(msg);
                    s.next();
                }
            }
        }
        
        return number;
    }
    
    public Direction visit(Visitor guest, Direction direction) {        
        guest.tell("You (the visitor) have enetered this room from the " + direction);
        guest.tell("You enter into a dark and chilly room shutting the door behind you.");
        guest.tell("After looking through your memories I can see you are a good person therefore I shall reward you with 5 gold");
        guest.giveGold(5);
        
        if(guest.hasIdenticalItem(new Item("bananas"))){
            guest.tell("Nice banana");
            guest.tell("Take me!");
            guest.giveGold(3);
        }
        
        if (lights_on == false){
            
            if(has_flashlight == true){
                guest.tell("You switch your torch on and use it to look around.");
                guest.tell("You should have brought a torch/flashlight if you were gonna go exploring bozo.");
            
            } else{
                guest.tell("Look at you stumbling around for a light source, you're gonna have to run your pockets for that I won't lie");
                guest.takeGold(3);
                guest.tell("After alot of feeling around you find a switch and manage to turn on the lights.");
                lights_on = true;
                guest.tell("After turning on the lights you begin to look around the room");
            }
        }else{
            guest.tell("For some reason the lights were left on from a previous visit.");
        }
        
        guest.tell("You look around the room to see a large treasure chest and a vault with a keycode combination...");
        
        if(visited_chest == false){
            guest.tell("You are yet to visit the chest.");
        }
        else{
            guest.tell("You have already visited the chest."); 
        }
        if(visited_vault == false){
            guest.tell("You are yet to visit the vault.");
        }
        else{
            guest.tell("You have already visited the vault.");
            if (opened_chest == false || opened_vault == false){
                guest.tell("However, you have not yet opened all the compartments.");
            }else{
                guest.tell("You have opened all the compartments before.");
            }
        }
        
        char guest_choice = guest.getChoice("Which do you choose to visit: type 'a' to visit the chest or type 'b' to visit the vault", two_options);
        
        if(guest_choice== 'a'){
            if(visited_chest == false){
                visited_chest = true;
                guest.tell("You make your way towards the chest.");
                guest.tell("You find some gold in the chest and a key, do you wish to take the gold or the key?");
                char item_choice = guest.getChoice("type 'a' to take the gold or type 'b' to take the key", two_options);
                if (item_choice == ('a')){
                    guest.giveGold(5);
                }if (item_choice == ('b')){
                    guest.giveItem(KEY);
                }
                else{
                    guest.tell("You have already visited the chest in this room so there is nothing to find.");
                }
                
                guest.tell("You slowly back away from the chest");
            }
            
        }if(guest_choice == 'b'){
            if(visited_vault == false){
                visited_vault = true;
                guest.tell("You make your way towards the vault.");
                guest.tell("You realise the vault has a pin type lock");
                guest.tell("You begin attempting to pick the lock, a screen on the left side tells you how many attempts you have.");
                guest.tell("You have 5 attempts to pick the lock");
                guest.tell("The pin has 3 possible numbers and you can only enter numbers 0-9.");
                

                for(int i=5; i>0; i--){
                    int user_Code = inputInt("Guess the pin for the vault");
                    if(user_Code == code){
                        guest.tell("Well done you have unlocked the hidden treasure trove of this room.");
                        guest.tell("You will now be granted with 30 gold for your troubles.");
                        guest.giveGold(30);
                        break;
                    }else{
                        guest.tell("Good try however that is now the right answer, you now have "+i+" tries left.");
                    }
                }
            }
        }
        if (has_flashlight == false){
            guest.tell("Before exiting the room, do you wish to turn the lights off?");
            char lights_choice = guest.getChoice("type 'a' for yes and  'b' for no", two_options);
            if (lights_choice == ('a')){
                lights_on = false;;
            }
        }

        char which_direction = guest.getChoice("type: 'a' to go north, 'b' to go east, 'c' to go south, 'd' to go west.", four_options);

        Direction leaving_Direction = Direction.UNDEFINED;
        if(which_direction == ('a')){
            leaving_Direction = Direction.TO_NORTH;
            
        }if(which_direction == ('b')){
            leaving_Direction = Direction.TO_EAST;

        }if(which_direction == ('c')){
            leaving_Direction = Direction.TO_SOUTH;

        }if(which_direction == ('d')){
            leaving_Direction = Direction.TO_WEST;
        }

        guest.tell("You exited the room moving " + leaving_Direction);
        return leaving_Direction;
    }
}
