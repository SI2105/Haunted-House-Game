package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ex21299 extends Room {
    
    private final static Item[] objects = { new Item("bow and arrow"), new Item("meat"), new Item("candle")};
    private static int gold_count = 10;
    private static boolean fireplace_on = false;
    private final static Direction[] directions = {Direction.TO_NORTH, Direction.TO_SOUTH, Direction.TO_WEST, Direction.TO_EAST};
    
    public Direction getDirection(Visitor visitor)
    {
        char answer;
        visitor.tell("What direction would you like to leave in?");
        
        answer = visitor.getChoice("a) North, b) South, c) West, d) East, e) random", new char[]{'a', 'b', 'c', 'd', 'e'});
        switch(answer) {
            case('a'):
                return directions[0];
            case('b'):
                return directions[1];
            case('c'):
                return directions[2];
            case('d'):
                return directions[3];
            case('e'):
                return directions[(new Random()).nextInt(4)];
                
        }
        return directions[0];
    }
    
    public void gold_exchange(int quantity, Visitor visitor) {
        
        int gold_received = 0;
        if(gold_count >= quantity){
            
            visitor.tell("Here are " + Integer.toString(quantity) + " pieces of gold for you.");
            visitor.giveGold(quantity);
            gold_count -= quantity;
        }
        else {
            
            visitor.tell("Could you give me some gold? I'm poor!");
            gold_received = visitor.takeGold(quantity-gold_count);

            if (gold_received > 0) {
                
                    gold_count += gold_received;
                    visitor.tell("Thanks!");
            }
            else 
                visitor.tell("Go to hell!!!");
        }
    }
        
    public Direction visit( Visitor visitor, Direction directionVistorArrivesFrom){
        
        char answer;
        boolean bol;
        
        if(fireplace_on) {
            visitor.tell("You have entered a hot minecraft room");
            answer = visitor.getChoice("Do you want the fireplace off? Y for yes and N for no.", new char[]{'Y', 'N'});
            if(answer == 'Y')
                fireplace_on = false;
            
        }
        else {
            visitor.tell("You have entered a cold minecraft room");
            answer = visitor.getChoice("Do you want the fireplace on? Y for yes and N for no.", new char[]{'Y', 'N'});
            if(answer == 'Y')
                fireplace_on = true;
            
        }
            
        visitor.tell("The are various things in the room");
        answer = visitor.getChoice("a) A chest, b) A furnace, c) A hopper. Which one do you want to open?", new char[]{'a', 'b', 'c'});
        
        switch(answer){
            case ('a'):
                visitor.tell("You chose the chest. It contains a bow and arrow. Do you accept it?");
                bol = visitor.giveItem(objects[0]);
                if(bol) {
                    visitor.tell("Suddenly you are beign attacked by a zombie.");
                    answer = visitor.getChoice("Do you shoot: a) the head or b) the heart of the zombie", new char[]{'a', 'b'});
                    if(answer == 'a') {
                        
                        visitor.tell("Good.The zombie is dead.");
                        gold_exchange(5, visitor);

                        visitor.tell("You have to go now");
                        return getDirection(visitor);
                        
                    }
                    else {
                        visitor.tell("You should have gone for the head. The zombie is still alive and running towards you. You have no option but run away.");
                        return directions[1];
                    }
                }
                
                else {
                    visitor.tell("You didn'take it. There's nothing here for you, I'm afraid.");
                    return getDirection(visitor);
                }
                
            case ('b'):
                visitor.tell("You chose the furnace. It contains meat. Do you accept it?");
                bol = visitor.giveItem(objects[1]);
                if(bol){
                    visitor.tell("You ate the meat but it was contaminated. You get food poisoning. Run to the toilet!!");
                    return getDirection(visitor);
                }
                else {
                    visitor.tell("You did the right thing. The meat was contaminated.");
                    gold_exchange(3, visitor);
                    return getDirection(visitor);
                }
            case ('c'):
                visitor.tell("You chose the hopper. It contains a candle. Do you accept it?");
                bol = visitor.giveItem(objects[2]);
                if(bol) {
                    visitor.tell("Good you took the candle. It will help you to travel forward in the darkness.");
                    visitor.tell("Now that you have extra light you see a trapdor in the floor below.");
                    visitor.getChoice("Do you open it? Y) for yes, N) for no.", new char[] {'Y', 'N'});
                    if(answer == 'Y') {
                        visitor.tell("Below the trapdor there is a small compartment with a litte bit of space.");
                        visitor.tell("You are searching through the junk when you suddenly hear footstep behind you");
                        visitor.tell("You turn around and see the outline of a person in the corner of the room....");
                        visitor.tell("As you get closer you see that the man has no eyes...IT'S Herobrine!!!!!!");
                        visitor.tell("You immdeiately run away and leave the room.");
                        return directions[0];
                    }
                    else {
                        visitor.tell("You could have found something inside. Good luck.");
                    }
                                     
                }
                    
                else 
                    visitor.tell("Well, now you are gonna have to walk in the dark. Good luck.");
                
                return getDirection(visitor);
                
        }
        return directions[(new Random()).nextInt(4)];
    }
}
