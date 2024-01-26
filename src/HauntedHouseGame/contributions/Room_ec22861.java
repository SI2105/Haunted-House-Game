package HauntedHouseGame.contributions;

class Room_ec22861 extends Room{

     public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom){
         
             
        visitor.tell("In front of you is a treasure chest, to the left is a graveyard, on the right there is a fountain. Where do you want to go?");
         
         char choice= visitor.getChoice("Enter f, for treasure, l for graveyard, r for gargen", new char[]{'f', 'l', 'r'});
         
         if(choice=='f')
         {
             visitor.tell("You are greedy");
             
             visitor.takeGold(5);
             
             return Direction.opposite(directionVisitorArrivesFrom);
         }
         
         else if(choice=='l')
         {
             visitor.tell("You are brave");
             visitor.giveGold(6);
             
             visitor.tell("For your bravery, you can choose where to go");
             
             choice = visitor.getChoice("Where do you want to go?", new char[]{'n', 'w', 's', 'e'});
             
             if(choice=='n')
             {
                 return Direction.TO_NORTH;
             }
             
             else if(choice=='w')
             {
                 return Direction.TO_WEST;
             }
             
             else if(choice=='s')
             {
                 return Direction.TO_SOUTH;
             }
             
             else
             {
                 return Direction.TO_EAST;
             }
         }
         
         else 
         {
                 if(choice=='r')
                     {
                         visitor.tell("safe choice");
                         visitor.takeGold(3);

                         return Direction.TO_EAST;
                     }
        
         }

	return Direction.opposite(directionVisitorArrivesFrom);
     }
         
         
    
}
