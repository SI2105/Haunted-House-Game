package OOP.ec22612.MP.contributions;// Assignment 4

import java.util.Random;

// Subclass - my room
class Room_ec221025 extends Room
{
    // Method to generate random number 1-10
    public static int generateRandomNumber()
    {
    Random rnd = new Random();
    int random_number = (rnd.nextInt(10) + 1);
    return random_number;
    }

    Item magicSpell = new Item("magic spell");
    Item enchantedBook = new Item("enchanted book");

    // Method visit
    public Direction visit(Visitor visitor, Direction orientation)
    {
        visitor.tell("Welcome to room ec221025");

        // Orientation info
        if (orientation == Direction.FROM_NORTH) 
        {
            visitor.tell("You entered the room from north.");
        }
        else if (orientation == Direction.FROM_SOUTH) 
        {
            visitor.tell("You entered the room from south.");
        } 
        else if (orientation == Direction.FROM_WEST) 
        {
            visitor.tell("You entered the room from west.");
        }
        else if (orientation == Direction.FROM_EAST) 
        {
            visitor.tell("You entered the room from east.");
        }

        // Haunted wheel
        boolean keepSpinning = true;
        int random_number;
        char choice = visitor.getChoice("Do you want to spin the haunted wheel and try you luck? ('Y' for yes or 'N' for no)", new char[]{'Y', 'N'});
        while (keepSpinning)
        {
            if (choice == 'Y')
            {
                random_number = generateRandomNumber();
                
                if (random_number == 4 | random_number == 6)
                {
                    visitor.tell("You lost 10 gold. MUHAHAHAHA!");
                    visitor.takeGold(10);
                }
                else if (random_number == 7)
                {
                    visitor.tell("You won the enchanted book.");
                    visitor.giveItem(enchantedBook);
                }
                else if (random_number == 9)
                {
                    visitor.tell("You won the magic spell.");
                    visitor.giveItem(magicSpell);
                }
                else
                {
                    visitor.tell("You won " + random_number + " gold.");
                    visitor.giveGold(random_number);
                }

                choice = visitor.getChoice("Do you want to spin again? ('Y' for yes or 'N' for no)", new char[]{'Y', 'N'});
                if (choice == 'Y')
                {
                    visitor.tell("You are a brave individual.");
                    keepSpinning = true;
                }
                else if (choice == 'Y')
                {
                    visitor.tell("Goodbye visitor.");
                    keepSpinning = false;
                }
                else
                {
                    visitor.tell("Tell me, do you want to give it a spin? (please type 'Y' if your answer is yes or 'N' if your answer is no)");
                    choice = visitor.getChoice("Tell me, do you want to give it a spin? (please type 'Y' if your answer is yes or 'N' if your answer is no)", new char[]{'Y', 'N'});
                }
            }
            else if (choice == 'N')
            {
                visitor.tell("I see.. you are scared... or maybe you're just a wise person.");
                keepSpinning = false;
            }
            else
            {
                visitor.tell("Tell me, do you want to give it a spin? (please type 'Y' if your answer is yes or 'N' if your answer is no)");
                choice = visitor.getChoice("Tell me, do you want to give it a spin? (please type 'Y' if your answer is yes or 'N' if your answer is no)", new char[]{'Y', 'N'});
                keepSpinning = true;
            }
        }

        // Next move
        String nextOrientation;
        char choiceOrientation = visitor.getChoice("Where you want to go next? ('N' for north, 'S' for south, 'W' for west or 'E' for east)", new char[]{'N', 'S', 'W', 'E'});
        if (choiceOrientation == 'N')
        {
            nextOrientation = "north";
            visitor.tell("you will go " + nextOrientation);
            return Direction.TO_NORTH;
        }
        else if (choiceOrientation == 'S')
        {
            nextOrientation = "south";
            visitor.tell("you will go " + nextOrientation);
            return Direction.TO_SOUTH;
        }
        else if (choiceOrientation == 'W')
        {
            nextOrientation = "west";
            visitor.tell("you will go " + nextOrientation);
            return Direction.TO_WEST;
        }
        else if (choiceOrientation == 'E')
        {
            nextOrientation = "east";
            visitor.tell("you will go " + nextOrientation);
            return Direction.TO_EAST;
        }
        
        visitor.tell("Goodbye visitor.");
        return orientation;
    }
}
