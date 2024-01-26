package HauntedHouseGame.contributions;

class Room_ec22635 extends Room
{
    
    
    private boolean lightsOn;
    private boolean trunkEmpty;
    private boolean poltergeistFriendly;
    private Item key;
    private int goldPieces;
    
    Room_ec22635()
    {
        
        lightsOn = false;
        trunkEmpty = false;
        poltergeistFriendly = true;
        key = new Item("key");
        goldPieces = 5;
    }
    
    @Override
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom)
    {
        
        visitor.tell("Welcome to Room_ec22987. The lights are " + (lightsOn ? "on" : "off") + ". The trunk is " + (trunkEmpty ? "empty" : "not empty") + ". The poltergeist is " + (poltergeistFriendly ? "friendly" : "grumpy") + ".");
        
       
        char choice = visitor.getChoice("What would you like to do?", new char[] {'a', 'b', 'c'});
        
        
        switch (choice)
        {
            case 'a':
               
                lightsOn = !lightsOn;
                visitor.tell("You turned the lights " + (lightsOn ? "on" : "off") + ".");
                break;
            case 'b':
               
                if (trunkEmpty)
                {
                    visitor.tell("The trunk is empty.");
                }
                else
                {
                    visitor.tell("You found a key in the trunk.");
                    if (visitor.giveItem(key))
                    {
                        trunkEmpty = true;
                        visitor.tell("You took the key.");
                    }
                    else
                    {
                        visitor.tell("You couldn't take the key.");
                    }
                }
                break;
            case 'c':
                
                if (poltergeistFriendly)
                {
                    visitor.tell("The poltergeist is friendly. It gives you " + goldPieces + " pieces of gold.");
                    visitor.giveGold(goldPieces);
                    goldPieces = 0;
                    poltergeistFriendly = false;
                }
                else
                {
                    visitor.tell("The poltergeist is grumpy. It takes " + visitor.takeGold(goldPieces) + " pieces of gold from you.");
                    goldPieces = 0;
                }
                break;
            default:
                visitor.tell("Invalid choice.");
        }
        
        
        return Direction.opposite(directionVisitorArrivesFrom);
    }
}
