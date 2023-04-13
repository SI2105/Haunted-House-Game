package OOP.ec22612.MP.contributions;

public class Room_ec22561 extends Room {
    Item pheonix_tears = new Item("Pheonix Tears");
    char[] choices = new char[]{'a','b','c','d'};
    
    public Direction visit(Visitor visitor, Direction d){
        if(visitor.hasEqualItem(pheonix_tears)){
            visitor.tell("It's seems you have been here before.");
            return d;
        }
        else{
            visitor.tell("To pass this room a quiz you must do.");
            char answer = 'd';
            while(!(answer == 'a')){
                visitor.tell("What can run but can't walk?");
                visitor.tell("Is it a)A river b)a ghost c)an irrate cat d)an irrate dog?");
                answer = visitor.getChoice("Is it a)A river b)a ghost c)an irrate cat d)an irrate dog?",choices);
                if(!(answer == 'a')){
                    visitor.tell("Wrong! I guess your gonna be stuck here a little longer.");
                }
            }
            visitor.tell("You have passed the quiz. For you prize you can have a some pheonix tears and 10 pieces of gold.");
            visitor.giveItem(pheonix_tears);
            visitor.giveGold(10);
        }
        return d.TO_NORTH;
    }
}
