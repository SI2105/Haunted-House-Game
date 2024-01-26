package HauntedHouseGame.contributions;

class Room_ec22587 extends Room{
public static Item torch = new Item("Torch");
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom)
    {
    
     boolean lightson = false; //light turned off 
    visitor.tell("The room is dark and has all items unarranged.");
    
    //gets the direction visitor exists to 
    boolean True = visitor.hasIdenticalItem(torch);
    
    if(!True )
    {
        
        visitor.tell("You can turn the lights on");
        char[] question = {'y','n'};
        char answer  = visitor.getChoice( "You can turn the lights on",question);
         
        
        if(answer == 'y')
        {
            
         lightson = true;
            
        }
        else 
        {
            
        visitor.tell("YOU CHOSE THE WRONG OPTION");
            
            }
      }
    
    return Direction.opposite(directionVistorArrivesFrom); 
    }
}
