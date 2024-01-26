package HauntedHouseGame.contributions;

class Room_ec22987 extends Room
{
    
    // State of the room
    private boolean lightsOn;
    private boolean trunkEmpty;
    private boolean poltergeistFriendly;
    private Item key;
    private int goldPieces;
    
    Room_ec22987()
    {
        // Initialize the state of the room
        lightsOn = false;
        trunkEmpty = false;
        poltergeistFriendly = true;
        key = new Item("key");
        goldPieces = 5;
    }
    
    @Override
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom)
    {
        // Greet the visitor and provide information about the room's state
        visitor.tell("Welcome to Room_ec22987. The lights are " + (lightsOn ? "on" : "off") + ". The trunk is " + (trunkEmpty ? "empty" : "not empty") + ". The poltergeist is " + (poltergeistFriendly ? "friendly" : "grumpy") + ".");
        
        // Ask the visitor to make a choice
        char choice = visitor.getChoice("What would you like to do?", new char[] {'a', 'b', 'c'});
        
        // Handle the visitor's choice
        switch (choice)
        {
            case 'a':
                // Toggle the lights
                lightsOn = !lightsOn;
                visitor.tell("You turned the lights " + (lightsOn ? "on" : "off") + ".");
                break;
            case 'b':
                // Check the trunk
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
                // Interact with the poltergeist
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
        
        // Return the direction in which the visitor leaves
        return Direction.opposite(directionVisitorArrivesFrom);
    }
}
