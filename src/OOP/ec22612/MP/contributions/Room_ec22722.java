package OOP.ec22612.MP.contributions;

class Room_ec22722 extends Room{
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
        
        visitor.tell("Welcome to the best room in this mansion.");
        visitor.tell("Let's see what you have");
        
        if(visitor.hasIdenticalItem(new Item("Money")))
            {
                visitor.tell("You're getting robbed");
                visitor.takeGold(5);
            }
        
        else if( visitor.hasIdenticalItem(new Item("Nothing")))
            {
                visitor.tell("That's unfortunate, I'll give you something.");
                visitor.giveGold(5);
            }
        else
        {
            visitor.tell("Good luck mate");
        }
        
        char direction = visitor.getChoice("What direction would you like to go?", new char[]{'w','e','n','s'});
        
        if (direction == 'w') 
        {
            return  Direction.TO_WEST;
        }
        else if (direction =='e')
        {
            return Direction.TO_EAST;
        }
        else if (direction =='n')
        {
            return Direction.TO_NORTH;
        }
        else
        {
            return Direction.TO_SOUTH;
        }
    }

}
