package OOP.ec22612.MP.contributions;

class Room_ec221183 extends Room
{
    public Direction visit(Visitor visitor, Direction directionOfArrival)
    {
        char choice = visitor.getChoice("Where in the house would you like to go?\n" +
        "a) Downstairs to the basement \n" + "b) Left to the kitchen \n " +
        " c) Upstairs in the living room \n" +"d) Right towards the cave leading outside", new char[] {'a', 'b', 'c', 'd'});
        
        if(choice == 'a')
        {
            directionOfArrival = Direction.FROM_SOUTH;
            visitor.tell("You make your way downstairs to see a most horrible sight laid out before you.");
            visitor.tell("It seems as though there is a stranger hanging from a rope attached to a fan.");
            final Item Scissors = new Item("Scissors");
            char decision = visitor.getChoice("I've given you a pair of scissors. Do you wish to cut the rope and give this stranger a burial? (Y/N)", new char[] {'Y','N'});
            if(decision == 'Y')
            {
                visitor.giveItem(Scissors);
                visitor.tell("Thank you for helping to put this soul at rest. Here are 3 pieces of gold");
                visitor.giveGold(3);
            }
            else if(decision == 'N')
            {
                visitor.tell("COWARD! Fine, I'll just hope the next creature that enters through here has more courage than you. I'll take 5 gold pieces.");
                visitor.tell("Goodbye and fade into obscurity.");
                visitor.takeGold(5);
            }
        }
        
        else if(choice == 'b')
        {
            directionOfArrival = Direction.FROM_WEST;
            visitor.tell("You take a left to the kitchen.\n" + 
            "It looks like a hurricane has hit: the cupboards are open and its contents are everywhere across the room.\n" + 
            "The appliances look smashed to pieces. What could have happened here?");
            visitor.tell("I'll be Frank (not Lampard) with you, a poltergeist is here");
            visitor.tell("Oops... \n" + "It seems as though you've been stabbed in the leg.\n" + 
            "You better hope you're in a country with social healthcare.");
            visitor.takeGold(8);
        }
        
        else if(choice == 'c')
        {
            directionOfArrival = Direction.FROM_NORTH;
            visitor.tell("You take the stairs up to the living room.\n" +
            "Here you find your father gingerly holding a photo album containing photos of your grandmother.\n" +
            "It's the anniversary of her death");
            final Item Tissues = new Item("Tissues");
            visitor.tell("You cry together with your father as you go through the photos and remember days past.");
            visitor.giveItem(Tissues);
            visitor.tell("Your eyes are wet. Here, have a tissue.");
            visitor.tell("Time passes and as you leave, your father hands you 10 gold pieces.");
            visitor.takeGold(10);
        }
        
        else if(choice == 'd')
        {
            directionOfArrival = Direction.FROM_EAST;
            final Item Sword = new Item("Sword");
            visitor.tell("You take a right towards the cave.");
            char decision = visitor.getChoice("Oops... You've run into a dragon! Will you fight or run for it? (F/R)", new char [] {'F','R'});
            if(decision == 'F')
            {
                visitor.giveItem(Sword);
                visitor.tell("You're a real idiot, you know. What is a sword going to do vs FIRE?");
                visitor.tell("The dragon set your trouser leg alight, so you'll have to find money for new clothes and maybe a robo leg.");
                visitor.takeGold(10);
            }
            else if(decision == 'R')
            {
                visitor.tell("It's good to see that you've got your wits about you.");
                visitor.tell("On your way out of the cave, you see a nice little pile of 8 coins.");
                visitor.giveGold(8);
            }
        }
    return directionOfArrival;
    }
}
