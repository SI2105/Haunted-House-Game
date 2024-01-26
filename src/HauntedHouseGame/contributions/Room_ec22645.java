package HauntedHouseGame.contributions;

class Room_ec22645 extends Room
{
    int Gold = 10;
    Item ID = new Item("ID");
    Item Vacuum = new Item("Vacuum");
    Item Bread = new Item("Bread");

    char [] choices = {'a','b'};
    public Direction visit (Visitor guest, Direction orientation) 
    {
        if (orientation == Direction.FROM_NORTH) 
        {
            guest.tell("You enter from the North entrance and Frankensteins monster appears, he asks whether you would like to negotiate.");
            char options = guest.getChoice("What will you do? ", choices);
            guest.tell("(a) Accept negotitation offer");
            guest.tell("(b) Try to run away");                
            if(options=='a')
            {
                guest.tell("You negotiated a deal paying gold to spare your life(The scientist needed funds for a new monster),he gives you a key to exit with.");
                guest.tell("You have now lost 5 gold.");
                guest.takeGold(5);
            }
            else if (options=='b')
            {
                guest.tell("The scientist gave the monster legs from one of the fastest humans.");
                guest.tell("Frankensteins monster catches up to you as you run.");
                guest.tell("You thought you were dead but he just forcefully took all your gold.");
                guest.takeGold(10);
            }          
            return Direction.TO_NORTH;
        }
        else if (orientation == Direction.FROM_SOUTH) 
        {
            guest.tell("You enter from the South entrance and you hear footsteps but no one is there, you realise someone has pickpocketed you fro 3 gold.");
            guest.takeGold(3);
            guest.tell("The thief accidentally drops his wallet which contained 10 gold. You now have more gold than before you were robbed, and now have his ID.");
            guest.giveGold(10);
            guest.giveItem(ID);
            if(guest.hasIdenticalItem(ID))
            {
                char options = guest.getChoice("Will you report to the police? ", choices);
                guest.tell("(a) Yes report");
                guest.tell("(b) No I'm richer anyways");                
                if(options=='a')
                {
                    guest.tell("You now have the name of the thief and reported it to the police.");
                    guest.tell("You find out he has been dead for more than 100 years.");
                    guest.tell("You get so scared you run away, accidentally dropping the 10 gold you just found.");
                    guest.takeGold(10);
                }
                else if (options=='b')
                {
                    guest.tell("You escape richer than ever!");
                }           
            }
            return Direction.TO_SOUTH;
       }
        else if (orientation == Direction.FROM_EAST) 
        {
            guest.tell("You enter from the East entrance a ghost appears from behind you.");
            guest.tell("2 gold drops from your pocket as you run from the ghost");
            guest.takeGold(2);
            guest.tell("You find a ghost vacuum (from ghostbusters) and you catch the ghost.");
            guest.giveItem(Vacuum);
            guest.tell("Even though you just caught a ghost and should have tremendous confidence you instantly leave, not realising you have dropped some gold."); 
            return Direction.TO_EAST;        
        }
        else if (orientation == Direction.FROM_WEST) 
        {
            guest.tell("You enter from the West entrance and you get stuck in a maze");
            guest.tell("You use your gold coins to leave a trail so you can escape.");
            guest.takeGold(7);
            guest.tell("You find a packet of mouldy bread and rip it to pieces to leave a trail with, so you dont lose more gold.");
            guest.giveItem(Bread);
            guest.tell("You found the exit, somehow its the entrance you came from.");
            if(guest.hasIdenticalItem(Bread))
            {
                char options = guest.getChoice("Do you want to return to get your gold at the risk of getting lost again? ", choices);
                guest.tell("(a) Yes");
                guest.tell("(b) No");                
                if(options=='a')
                {
                    guest.tell("Your bread runs out before you find all your gold, so you return to insure you don't get lost again.");
                    guest.giveGold(4);
                }
                else if (options=='b')
                {
                    guest.tell("You won, but at what cost...");
                }
            }
           
            return Direction.TO_WEST;
        }
        return Direction.TO_NORTH;
    }
}
