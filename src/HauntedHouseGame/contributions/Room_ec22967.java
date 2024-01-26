package HauntedHouseGame.contributions;

public class Room_ec22967 extends Room{
    
    static final Item key = new Item("Key_ec22967");
    static final Item lever = new Item("Lever_ec22967");
    static Boolean ChestOpen = false;
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom)
    {
        
        visitor.tell("You've found the room. the key lies beside the tree.");
        
        char[] Option = {'a','b','c'};
        
        char choice = visitor.getChoice("What part of the room would you like to visit a) The Bookshelf b) The Dead Plant c)The desk", Option);
        
        
        if (choice == 'b')
        {
            if (visitor.hasEqualItem(lever)){
                visitor.tell("you got the lever from a previous visit");
            }
            else{
                visitor.tell("you now have the lever which unlocks a secret in another room, but which room?");
                visitor.giveItem(lever);
            }
        }
        
        else{
            visitor.tell("You chose incorrect for the key. Maybe on your next visit you may get lucky");
        }
        
        if(ChestOpen == false)
        {
            if(visitor.hasEqualItem(key))
            {
                visitor.tell("you found the key for another room you can open the chest which should give what you need for your next quest.");
                visitor.giveGold(9);
                ChestOpen = true;
            }
            
            else
            {
                visitor.tell("you dont have the key to open the chest, come back later when you are at your best i.e when you get the item");
            }
        }
        else
        {
            visitor.tell(" the chest has opened up already");
        }
        
        return directionVisitorArrivesFrom;
    }
}
          
