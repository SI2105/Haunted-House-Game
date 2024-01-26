package HauntedHouseGame.contributions;

class Room_ec22478 extends Room
{
    static final Item MONEY = new Item("Money");
    static final Item CHOCOLATE = new Item("Chocolate");
    static final Item PHONE = new Item("Phone");

    public Direction visit(Visitor visitor, Direction direction) 
    {
        visitor.tell("You enter the room. There is some money on the table, some chocolate in a cupboard and a phone under a box.");
        char[] optionsGiven = { '1', '2', '3' };
        char userOption = visitor.getChoice("Please select an option:\n1) Walk up to the table\n2) Open the cupboard\n3) Lift the box", optionsGiven);
        int points = 0;
        
        if (userOption == '1') 
        {
            visitor.tell("You approach the table and pick up the money.");
            visitor.giveItem(MONEY);
            visitor.giveGold(4);
            points += 4;
        }
        else if (userOption == '2') 
        {
            if (points > 0) 
            {
                visitor.tell("You see a cupboard next to the table. You remember finding some money earlier and decide to use it to open the cupboard.");
                visitor.takeGold(2);
                points -=2;
                visitor.tell("You find some chocolate inside the cupboard.");
                visitor.giveItem(CHOCOLATE);
            }
            else 
            {
                visitor.tell("You approach the cupboard, but it seems to be locked. You need to find some money first to open it.");
            }
        }
        else if (userOption == '3') 
        {
            visitor.tell("You approach the box and lift it. Underneath, you find a phone.");
            visitor.giveGold(3);
            points += 3;
        }
        else 
        {
            visitor.tell("Invalid option. Please select a valid option.");
        }

        return direction;
    }
}
