package OOP.ec22612.MP.contributions;

class Room_ec22993 extends Room{
    
    
//  only item for room
    static final Item Gem = new Item("gem");
    
    public Direction visit(Visitor visitor, Direction d){
        
        
        visitor.tell("Do you dare to enter?");
        char choice = visitor.getChoice("choose y for yes or choose n for no.", new char [] {'y', 'n'});
        
        if(choice=='n'){
            visitor.tell("Maybe you will test your luck next time.");
            
            return Direction.opposite(d);
        }
        
        else{
            visitor.tell("You now enter room 22993");
            visitor.tell("Test your luck");
        }
        
        visitor.tell("you notice three buttons on the wall");
        choice = visitor.getChoice("Do you decice to press a button? y for yes, n for no.", new char [] {'y', 'n'});
        
        if(choice=='n'){
            visitor.tell("You leave the room the same as you came");
                
                return Direction.opposite(d);
        }
        
        
        else{
        
            choice = visitor.getChoice("Do you press button a, button b or button c?", new char [] {'a', 'b', 'c'});
        
            if(choice=='a'){
                if(visitor.hasEqualItem(Gem)){
                    visitor.tell("you seem to have already obtained a gem, this now turns into a trap");
                    int price = visitor.takeGold(2);
                    if(price != 2){
                        visitor.tell("you don't have two gold? I'll let you go");
                    }
                
                    else{
                        visitor.giveItem(Gem);
                }
                }
          
             else if(choice=='b'){
                 visitor.tell("You're in luck, four gold for you!");
                 visitor.giveGold(4);
             }
                   
             else if(choice=='c'){
                 visitor.tell("Bad Luck, we are taking three gold!");
                 int fare = visitor.takeGold(3);
                 if(fare != 3){
                     visitor.tell("You don't have three gold? Bring it next time that you visit!");
                 }
             }
            }
            return d;
        }
    }
}
      
                   
                    
