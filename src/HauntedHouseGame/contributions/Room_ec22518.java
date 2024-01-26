package HauntedHouseGame.contributions;

class Room_ec22518 extends Room{
    
    char choice= 'a';
    
    final Item WAY_OUT = new Item("key");
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom)
    {
        visitor.tell("The lights are off");
        
        choice = visitor.getChoice("Would you like to turn them on?", new char[]{'y', 'n'});
        
        if(choice=='y')
        {
            visitor.tell("Infront of you lays an archway, to your east lays a cavern, and to your west a treasure box");
            
            choice = visitor.getChoice("Which way would you like to go?", new char[]{'n', 'e', 'w'});
            
            if(choice=='n')
            {
                return Direction.TO_NORTH;
            }
            
            else if(choice=='e')
            {
                return Direction.TO_EAST;
            }
            
            else if(choice=='w')
            {
                visitor.tell("You have been guillable and set off a booby trap. Because of this, I have taken 5 peices of gold from you");
                visitor.takeGold(5);
            }
        }
        
        
        else{
            
                if(choice=='n')
                {
                    visitor.giveGold(5);
                    visitor.giveItem(new Item("pickaxe"));
                    visitor.tell("You are brave. As a result, you have been given 5 pieces of gold and pickaxe.");
                }
            
        }
        
        
        if(visitor.hasEqualItem(new Item("candle")))
        {
            visitor.tell("Smart, always carry a light soure");
            
            visitor.tell("You can go either north or west");
            
            choice= visitor.getChoice("Which way would you like to go?", new char []{'n', 'w'});
            
            if(choice=='n')
            {
                return Direction.TO_NORTH;
            }
            
            else{
                return Direction.TO_WEST;
            }
        }
        
        
        else if(visitor.hasEqualItem(new Item("compass")))
        {
            visitor.tell("You are going to need that compass to find your way out");
            
            visitor.tell("You can go either south or east");
            
            choice= visitor.getChoice("Which way would you like to go?", new char []{'s', 'e'});
            
            if(choice=='e')
            {
                return Direction.TO_EAST;
            }
            
            else{
                return Direction.TO_SOUTH;
            }
        }
        
        else{
            
            visitor.tell("You have nothing to defend yourself with, nothing to see where youre going, and nothing to guide you");
            
            visitor.tell("I will give you a key, in one of these rooms, you can use it to get out");
            
            visitor.giveItem(WAY_OUT);
            
            return Direction.opposite(directionVistorArrivesFrom);
        }
    
           
        
    }
}
