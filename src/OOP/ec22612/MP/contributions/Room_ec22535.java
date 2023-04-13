package OOP.ec22612.MP.contributions;

class Room_ec22535 extends Room {
    
    //Tell visitor about room and state
    static final Item FOOTBALL = new Item("football"); 
    static final Item KEY = new Item("key"); 
    boolean safe = false;
    
    // Returns direction the visitor leaves towards
    public Direction visit(Visitor v, Direction d) { 
        v.tell("Welcome to my room! It'll cost 2 pieces of gold for entrance!");
        v.takeGold(2);
        
        v.tell("However, you have the opportunity to win something back!");
        
        //Interact with visitor
        String options = "Pick a letter, A, B or C to see what you win";
        char [] choices = {'A', 'B', 'C'};
        char choice = v.getChoice(options, choices);  //returns visitors choice
    
        switch (choice)
        {
            case 'A':
                v.tell("you won my football!");
                v.giveItem(FOOTBALL);
                break;
            case 'B':
                v.tell("wooow, you've won a key. Maybe open my safe to win something more valuable...");
                v.giveItem(KEY);
                optionB(v);
                break;
            case 'C':
                v.tell("Oh no! You've won some of my gold.");
                v.giveGold(5);
                break;
            default: 
                v.tell("Unlucky, looks like you dont get anything.");
         }
         
         char [] second_choices = {'N', 'E', 'S', 'W'};
         char dir = v.getChoice("Pick a direction to exit", second_choices);  
         if(dir == 'N'){
             return Direction.TO_NORTH;
         }
         else if(dir =='E'){
             return Direction.TO_EAST;  
         }
         else if(dir =='S'){
             return Direction.TO_SOUTH; 
         }
         else if (dir =='W'){
            return Direction.TO_WEST;
         } 
         else {
            return Direction.opposite(d);
         }
            
    }
    
    void optionB(Visitor v) {
        if(v.hasIdenticalItem(KEY)){
            v.tell("Make sure you use the key i gave you, not your own!");
        }
        safe = true;
        v.tell("Oh wow, i was right, please take the gold!");
        v.giveGold(5);
    }
}
