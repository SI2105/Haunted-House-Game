package HauntedHouseGame.contributions;

class Room_ec21494 extends Room {
    static final Item KEY = new Item("Key");
    static boolean lights=false;
    static boolean trapdoorOpen=false;
    static boolean treasurechestOpen=false;
    static boolean ghostAngry = false;
    
    public Direction visit(Visitor v, Direction d){
        char[] choices = {'A', 'B', 'C', 'D'};
        v.tell("Welcome! What do you see in the room right now?");
        char choice = v.getChoice("A - lights are off, trapdoor closed, treasure chest closed. B - lights are on, trapdoor closed, treasure chest closed. C - lights are on, trapdoor open, treasure chest closed. D - nothing, you want to leave.", choices);
        if(choice == 'A'){
            optionA(v);
        }
        else if(choice == 'B'){
            optionB(v);
        }
        else if(choice == 'C'){
            optionC(v);
        }
        else if(choice == 'D'){
            v.tell("You have made the cowards choice, goodbye");
            
        }
        return Direction.opposite(d);
    }
    
    void optionA(Visitor v) {
        lights = true;
        v.tell("You creep slowly into the room and CLICK the lights switch on.");
        v.tell("For your bravery, I award you 2 GOLD COINS.");
        v.giveGold(2);
        
        
        if(v.hasEqualItem(KEY)){
            v.tell("Please take out your key.");
            }
        else{
            v.giveItem(KEY);
            v.tell("You were given a KEY");
            v.tell("Please take out your key.");
            }
        
        
        char [] choices2 = {'A','B'};
        v.tell("There are 2 coloured treasure chests in front of you.");
        char choice2 = v.getChoice("A - Open the BLUE chest, B - Open the PINK chest.", choices2);
        
        if(choice2 == 'A'){
            treasurechestOpen = true;
            v.tell("You picked the BLUE chest and found 10 GOLD COINS, well one friend!");
            v.giveGold(10);
        }
        else if(choice2 == 'B'){
            treasurechestOpen = true;
            ghostAngry = true;
            v.takeGold(5);
            v.tell("You picked the PINK chest and awoke Enzo the angry ghost!");
            v.tell("You dropped 5 GOLD COINS!");
        }
    }
        void optionB(Visitor v) {
            lights = true;
            v.tell("Since the lights are already on, you try and unlock either the treasure chest or the trapdoor");
            v.tell("To help you decide, I award you 5 GOLD COINS.");
            v.giveGold(5);
            
            
            if(v.hasEqualItem(KEY)){
                v.tell("Please take out your key.");
                }
            else{
                v.giveItem(KEY);
                v.tell("You were given a KEY");
                v.tell("Please take out your key.");
                }
            
            
            char [] choices2 = {'A','B'};
            v.tell("You must now choose to open either the treasure chest or the trapdoor");
            char choice2 = v.getChoice("A - Open the chest, B - Open the trapdoor.", choices2);
            
            if(choice2 == 'A'){
                treasurechestOpen = true;
                v.tell("You picked the chest and found 15 GOLD COINS, well one friend!");
                v.giveGold(15);
            }
            else if(choice2 == 'B'){
                trapdoorOpen = true;
                ghostAngry = true;
                v.tell("You open the trapdoor and collect 12 GOLD COINS");
                v.giveGold(12);
                v.tell("However Rani, a ghost, has been waiting to possess its next victim and you are its target!");
                v.tell("You escape with your life but drop 7 GOLD COINS in the process");
                v.takeGold(7);
            }
        }

        void optionC(Visitor v) {
            lights = true;
            trapdoorOpen = true;
            v.tell("You strut confidently into the well-lit room but forgot that the trapdoor is open and you fall from a vast height");
            v.tell("For your stupidity, you have lost 10 GOLD COINS.");
            
            
            if(v.hasEqualItem(KEY)){
                v.tell("Please take out your key.");
                }
            else{
                v.giveItem(KEY);
                v.tell("You found a KEY next to a dead body");
                v.tell("Please take out your key.");
                }
            
            
            char [] choices2 = {'A','B'};
            v.tell("The trapddor has shut, locking you inside! But there are 2 coloured locks that could aid your escape");
            v.tell("But hurry, you do not have that much time until the candle wax finishes!");
            char choice2 = v.getChoice("A - Open the YELLOW lock, B - Open the GREEN LOCK.", choices2);
            
            if(choice2 == 'A'){
                ghostAngry = true;
                lights = false;
                v.tell("You picked the YELLOW lock and awoke the ghosts of this haunted room, looks like you're their next victim!");
                v.tell("The candle has extinguished, you finally break the door out of desperation but lose gold as punishment");
                v.tell("You LOSE 8 GOLD COINS");
                v.giveGold(8);
            }
            else if(choice2 == 'B'){
                trapdoorOpen = false;
                lights = false;
                v.tell("You picked the GREEN lock and escaped the basement just as the candle stopped burning!");
                v.tell("You noticed underneath the candle, there is 12 GOLD COINS, you deserve them friend!");
                v.giveGold(12);
            }
        }
    }