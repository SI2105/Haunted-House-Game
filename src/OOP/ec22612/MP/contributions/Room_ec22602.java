package OOP.ec22612.MP.contributions;

class Room_ec22602 extends Room
{
    static final Item Key = new Item("Key");
    char [] choice = {'a', 'b', 'c'};


    public Direction visit(Visitor visitor, Direction direction)
    {
        visitor.tell("You have three doorways infront of you. Behind are three poorly lit rooms.");
        String question = ("Which door would you like to enter a) Door 1 b) Door 2 c) Door 3?");
        
        visitor.getChoice(question, choice);
        
        if (choice.equals('a'))
        {
            visitor.tell("You have entered through Door 1, the key lies on the floor for you to grab. You gain 5 gold coins.");
            visitor.giveGold(5);
            visitor.giveItem(Key);
            
        }
        
        else if (choice.equals('b'))
        {
            visitor.tell("You have entered through Door 2, there lies a floor full of spiders and you have stomped on a few. You lose 3 gold coins for animal brutality.");
            visitor.takeGold(3);
        }
        
        else if (choice.equals('c'))
        {
            visitor.tell("You have entered throgh Door 3, there is a huge 10 feet drop. You have sustained some injuries. You gain 2 coins for medical care.");
            visitor.giveGold(2);
        }
        
        return Direction.opposite(direction);
            
    }
    
}
