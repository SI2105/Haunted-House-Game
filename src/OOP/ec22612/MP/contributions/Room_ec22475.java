package OOP.ec22612.MP.contributions;

class Room_ec22475 extends Room{
    public Direction visit (Visitor visitor, Direction directionVistorArrivesFrom)
    {
        char Q;
        char Q1;
        char [] choices = {'a' , 'b'};
        int g1 = 5;
        int g2 = 3;
        Item ring = new Item("Ring");
        
        visitor.tell("Lucky you.... you've entered my room!");
        visitor.tell("Don't worry.. This is a friendly room!");
        visitor.tell("You will have the following 2 options to choose! Remember to choose wisely as you may win some gold and item!");
        
        String question = "These are the options: a. Explore the room ...  b. Exit the room";
        
        Q = visitor.getChoice(question, choices);
        
        if (Q == 'a')
        {
            visitor.tell("You found an item on the floor! Do you want to pick it up?");
            
            Q1 = visitor.getChoice("a. Pick up the item ...b. Leave the item behind " , choices);
            if (Q1 == 'a')
            {
                if (visitor.hasIdenticalItem(ring) || visitor.hasEqualItem(ring))
                {
                    visitor.tell("It seems like you already have the item, unfortunately you can only carry the same item once..");
                    visitor.tell("But don't worry! Here take some gold with you..");
                    
                    visitor.tell("You have obtained 5 gold pieces!");
                    visitor.giveGold(g1);
                    
                    visitor.tell("Good luck on your next room!");
                    return Direction.opposite(directionVistorArrivesFrom);
                }
                else
                {
                    visitor.tell("You have obtained a magical ring! (Check your inventory for item description....)");
                    visitor.giveItem(ring);
                    
                    visitor.tell("Good luck on your next room!");
                    return Direction.opposite(directionVistorArrivesFrom);
                }
            }
            else
            {
                visitor.tell("Looks like there's nothing else in the room..");
                visitor.tell("Don't be sad.. I'll give you some gold instead...");
                
                visitor.tell("You have obtained 3 gold pieces!");
                visitor.giveGold(g2);
                
                visitor.tell("Good luck on your next room!");
                return Direction.opposite(directionVistorArrivesFrom);
            }
        }
        else if (Q == 'b')
        {
            visitor.tell("It is sad to see you go.... anyways good luck on your next room!");
            return Direction.opposite(directionVistorArrivesFrom);
        }
        else
        {
            return Direction.opposite(directionVistorArrivesFrom);
        }
    }
}
