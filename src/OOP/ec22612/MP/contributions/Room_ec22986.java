package OOP.ec22612.MP.contributions;

class Room_ec22986 extends Room
{
    Boolean light=false;
    
    public Direction visit(Visitor visitor,Direction directionVistorArrivesFrom){
        
        Direction directionVisitorexitsto = Direction.opposite(directionVistorArrivesFrom);
                    
        
        if(!visitor.hasIdenticalItem(new Item("candle")))
        {
            char choice = visitor.getChoice("Would you like to turn on the light?", new char[]{'y', 'n'});
            
            if(choice == 'y')
            {
                light=true;
            }
            
        }
        else{}
           
           
           char exit=visitor.getChoice("Where would you like to go next? \n a) Blacksmith room \n b) Wizard's room \n c) Indiana John's room \n d) gaming room", new char[]{'a', 'b', 'c', 'd'});
               
               if(exit == 'a')
               {
                   directionVisitorexitsto=Direction.TO_NORTH;
                   
               }
               else if(exit=='b')
               {
                   directionVisitorexitsto=Direction.TO_SOUTH;
                   visitor.tell("You lost 5 pieces of gold");
                    visitor.takeGold(5);
               
               }
        
                else if(exit=='c')
                {
                    directionVisitorexitsto=Direction.TO_EAST;
                    visitor.tell("You have won 5 pieces of gold!!");
                    visitor.giveGold(5);
                
                }
                else
                {
                    directionVisitorexitsto=Direction.TO_WEST;
                    visitor.tell("You have lost 2 pieces of gold, as entry fees");
                    visitor.takeGold(2);
                }
                
                
        return directionVisitorexitsto;
    }
}

    
