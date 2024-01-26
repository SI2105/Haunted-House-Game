package HauntedHouseGame.contributions;

class Room_ec22446 extends Room
{
    char[] choiceList = {'a', 'b', 'c'};
    String choiceDes = "Here are the choices: [a = Open door] [b = Tie shoes] [c = Get a little crazy]"; 
    char choice;

    boolean itemChoice;

    Item snickers = new Item("Snickers");
    Item crowbar = new Item("Crowbar");

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom)
    {
        // Entered back of a van msg
        visitor.tell("You are in an empty room that is moving around a lot, you should probably think twice before going in a van for sweets.");
        visitor.tell("You are free to explore.");

        // User makes a choice from the list of options
        choice = visitor.getChoice(choiceDes, choiceList);
        
        if (choice == 'a')
        {
            visitor.tell("Why would the door not be locked?");
        }
        else if  (choice == 'b')
        {
            visitor.tell("Your shoes are now tied, at least you look cool now.");
        }
        else if (choice == 'c')
        {
            itemChoice = visitor.giveItem(crowbar);

            if (!itemChoice)
            {
                visitor.tell("Hmmmm, not much of an aggressive type eh?");
            }
            else
            {
                visitor.tell("Oh my goodness your insane, why do you have a crowbar in your pants.");
                visitor.tell("What are you doing break out then!");
                return Direction.TO_EAST;
            }
        }
        else
        {
            visitor.tell("You did not enter a valid choice, this is why your stuck in the van.");
        }

        // Give visitor the sweet
        visitor.tell("Your not you when your hungry, here's a snickers.");
        visitor.giveItem(snickers);

        if (!itemChoice)
        {
            visitor.tell("So your gonna use your brain now?");
        }
        else
        {
            visitor.tell("Your in the back of a van and got your sweet, your pretty crazy, well here's your reward...");
            visitor.giveGold(5);
        }

        // returning direction left from 
        visitor.tell("Well the van stopped, good luck from here on out.");
        Direction dirrectionLeaving = Direction.opposite(directionVistorArrivesFrom);
        return dirrectionLeaving;
    }
}