package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22476 extends Room
{
    // Setting items
    static final Item sweets = new Item("Sweets");
    static final Item chocolate = new Item("Chocolate");
    static final Item snake = new Item("Snake");
    static final Item wire = new Item("Wire");
    static Item i;
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom)
    {
        visitor.tell("Hello! You are in Room_ec22476.");
        
        // Allows user to make a choice as they enter a room
        String descriptionOfChoices = "The following are your choices: "+
        "\na - Blow out a candle"+
        "\nb - Light a candle"+
        "\nc - Open a cupboard"+
        "\nd - Drink water";
    
        char[] arrayOfPossibleChoices = {'a', 'b', 'c', 'd'};
        
        char choice = visitor.getChoice(descriptionOfChoices, arrayOfPossibleChoices);
        
        String itemName; // Added to allow generalisation of code
        
        if (choice == 'a')
        {
            visitor.tell("The candle dims as it is blown out.");
            visitor.tell("You trip over a wire.");
            i = wire;
            itemName = "wire";
        }
        else if (choice == 'b')
        {
            visitor.tell("The candle lights as it is lit.");
            visitor.tell("You find a bag of chocolates.");
            i = chocolate;
            itemName = "chocolate";
        }
        else if (choice == 'c')
        {
            visitor.tell("The cupboard creaks as it is opened.");
            visitor.tell("You find a bag of sweets.");
            i = sweets;
            itemName = "sweets";
        }
        else
        {
            visitor.tell("The water leaks from the cup.");
            visitor.tell("As you look inside the cup you notice"
            + " a snake.");
            i = snake;
            itemName = "snake";
        }
        
        // Determining random number of gold to give or take from user
        Random random = new Random();
        int numberToBeGivenOrTaken = random.nextInt(11);
        
        // Gives or takes gold depending on whether user has item
        if(visitor.hasIdenticalItem(i) || (visitor.hasEqualItem(i)))
        {
            if (visitor.giveItem(i))
            {
                visitor.tell("You have accepted the " + itemName + "!");
                visitor.takeGold(numberToBeGivenOrTaken);
            }
        }
        else
        {
            if (visitor.giveItem(i))
            {
                visitor.tell("You have accepted the " + itemName + "!");
                visitor.giveGold(numberToBeGivenOrTaken);
            }
        }
        
        // Goodbye message
        visitor.tell("Thanks for entering Room_ec22476!");
        
        // Determines direction user would like to leave
        descriptionOfChoices = "The following are your choices: "+
        "\nN - Go North"+
        "\nE - Go East"+
        "\nS - Go South"+
        "\nW - Go West";
    
        char[] arrayOfPossibleChoices1 = {'N', 'E', 'S', 'W'};
        
        choice = visitor.getChoice(descriptionOfChoices, arrayOfPossibleChoices1);
        

        if (choice == 'N')
        {
            return Direction.TO_NORTH;
        }
        else if (choice == 'E')
        {
            return Direction.TO_EAST;
        }
        else if (choice == 'S')
        {
            return Direction.TO_SOUTH;
        }
        else
        {
            return Direction.TO_WEST;
        }
    }   
}
