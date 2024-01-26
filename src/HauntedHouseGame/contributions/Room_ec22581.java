package HauntedHouseGame.contributions;

class Room_ec22581 extends Room
{
    public int coins_collected = 0; // Amount of coins collected so far

    public Direction visit(Visitor visitor, Direction dir) // Visit method to handle Visitor object
    {
        // Check if enough coins were collected
        if (coins_collected < 200)
        {
            // Tell scenario and give a choice
            visitor.tell("Alright Neo! You've got a choice. Red pill or blue pill. The red pill will get you gone and the blue pill will get you 10x more gone.");

            char[] options = {'r', 'b'};
            char choice = visitor.getChoice("Which one will you choose?", options);

            // Create possible items
            Item rpill = new Item("Red Pill");
            Item bpill = new Item("Blue Pill");

            // Give item depending on choice and take 10 coins on occasion
            if (choice == 'r' && !visitor.hasEqualItem(rpill))
            {
                visitor.giveItem(rpill);
            }
            else if (choice == 'b' && !visitor.hasEqualItem(bpill))
            {
                visitor.giveItem(bpill);
                coins_collected += visitor.takeGold(10);
            }
            else
            {
                visitor.tell("Incorrect choice! Give me 10 coins for wasting my time. Get out!");
                coins_collected += visitor.takeGold(10);
            }
        } else {
            visitor.tell("Enough of this blue pill nonsense!!");
        }
    
        return Direction.opposite(dir); // Return visitor to where they came from
    }
}
