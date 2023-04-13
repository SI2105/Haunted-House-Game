package OOP.ec22612.MP.contributions;

class Room_ec22583 extends Room
{  
public Direction visit( Visitor visitor,
        Direction directionVistorArrivesFrom){
    
           
        if(visitor.hasIdenticalItem(new Item("Gun")))
           {
               visitor.tell("Stay safe man");
               visitor.giveGold(5);
           }
        else if(visitor.hasIdenticalItem(new Item("Knife")))
                {
                    visitor.tell("Guns are better but not bad");
                    visitor.giveGold(5);
                }
        
                else
                {
                    visitor.tell("You should be better protected in a haunted house");
                    
                    visitor.takeGold(5);
                }
                
            char choice = visitor.getChoice("Where do you want to go?", new char []{'n', 'w', 'e', 's'});
                
                
                if(choice=='n')
                {
                    return Direction.TO_NORTH;
                }
                
                else if(choice=='w')
                {
                    return Direction.TO_WEST;
                }
                
                else if(choice=='e')
                {
                    return Direction.TO_EAST;
                }
                
                else
                {
                    return Direction.TO_SOUTH;
                }
                
             
}

}

