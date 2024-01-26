package HauntedHouseGame.contributions;

class Room_ec22614 extends Room {
    static final Item flashlight = new Item("flashlight");
    static final Item diary = new Item ("diary");
    static final Item matchsticks = new Item ("matchsticks"); //three items that can be collected
    
    public Direction visit(Visitor v, Direction d){
        //tells user about the room
        v.tell("Welcome to the smallest room in the house!");
        v.tell("To enter you must lose two pieces of gold!");
        v.takeGold(2);
        
        String option = ("Would you like to a)look around the room, b)light some candles or c) look in the cupboard");
        char[] choice = new char[3];
        choice[0] = 'a';
        choice[1] = 'b';
        choice[2] = 'c'; //this array holds the different choices the user can make
        
        char userOption = v.getChoice(option, choice);
        //option A
        if (userOption == 'a'){
            v.tell("You have chosen to look around the room, you come across some Items along the way...");
            String itemChoice = ("a) a flashlight, which can be very useful, b) a diary, which could be an interesting read and c) some matchsticks, which can come in handy");
            v.tell("You may only take one, which do you choose?");
            
            char userItemChoice = v.getChoice(itemChoice, choice);
            if (userItemChoice == 'a'){
                v.giveItem(flashlight);
            }
            
            else if (userItemChoice == 'b'){
                v.giveItem(diary);
            }
            
            else if (userItemChoice == 'c'){
                v.giveItem(matchsticks);
            }
        }
        //option B
        else if (userOption == 'b'){
            v.tell("Lighting the candles has helped you find some gold!!");
            v.giveGold(3);
        }
        
        //option C 
        else if (userOption == 'c'){
            v.tell("You have found a stash of gold!!");
            v.giveGold(6);
        }
        
        return d.opposite(d);
    }
}
     
