package OOP.ec22612.MP.contributions;

class Room_ec22412 extends Room {
    public Direction visit(Visitor visitor, Direction directionEntered) {
        char[] arrayOfPossibleChoices = {'a', 'b'};
        int gold = 0;
        Item item = new Item("Chains");
        
        visitor.tell("Welcome, what is your choice?");
        
        char option = visitor.getChoice("a) Pickup an item      b) Leave", arrayOfPossibleChoices);
            
        if (option == 'a') {
            if (visitor.hasIdenticalItem(item) || visitor.hasEqualItem(item)) {
                visitor.tell("Sorry, you already have this item, but take some gold instead");
                
                gold = gold + 5;
                visitor.giveGold(gold);
                visitor.takeGold(gold);
                
                return Direction.opposite(directionEntered);
            }
            else {
                visitor.tell("You now have a new item in your pockets, take some extra gold too");
                
                gold = gold + 10;
                visitor.giveGold(gold);
                visitor.takeGold(gold);
                
                return Direction.opposite(directionEntered);
            }
        }
        
        else {
            return Direction.opposite(directionEntered);
        }
    }
}
