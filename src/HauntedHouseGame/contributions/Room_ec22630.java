package HauntedHouseGame.contributions;

public class Room_ec22630 extends Room
{
        static final Item Rope = new Item("Rope");
        static final Item penny = new Item("penny");

        public Direction visit(Visitor visitor, Direction DirectionVisitorArrivesFrom)
        {
            
            visitor.tell("You have found a bedroom");
            
            char[] choices = {'a','b'};
            char options = visitor.getChoice("What would you like to do? a) Look inside a drawer b) Look at the desk", choices);
            
            if (options == 'a')
            {
                if (visitor.hasEqualItem(Rope))
                {
                   visitor.tell("You already have a rope");
                }
                else
                {
                    visitor.tell("You do not have a rope");
                    visitor.giveItem(Rope);
                }
                
                visitor.tell("no penny here! Look elsewhere");
       
            }
            if (visitor.hasEqualItem(penny))
            {
                visitor.tell("You already have a penny from elsewhere!");
                visitor.giveGold(5);
                visitor.tell("You now have 5 gold");
            }
            else
            {
                visitor.tell("You dont have a penny");
                visitor.giveItem(penny);
                visitor.giveGold(2);
                visitor.tell("you now have 2 pieces of gold");
            }
            return DirectionVisitorArrivesFrom;
        }
    
     
}
