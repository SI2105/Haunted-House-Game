package OOP.ec22612.MP.contributions;

class Room_ec22568 extends Room
{
    public Direction visit(Visitor visitor, Direction directionOfVisitor)
    {
        visitor.tell("You have arrived at ec22568's room!");
        visitor.tell("Enjoy my room!"); //Entered the room//
        if(directionOfVisitor.equals(Direction.FROM_SOUTH))
        {
            visitor.tell("There is a staircase infront of you. Below the staircase is a monster.");
            final Item Knife = new Item("Knife");
            char answer = visitor.getChoice("You have been given Knife. Do you want to fight the monster? (Y/N)", new char[] {'Y','N'});
            if(answer == 'Y')
            {
                visitor.giveItem(Knife);
                visitor.tell("Sorry, I didn't say the size of the monster. I wish the best for you!");
            }
            else if(answer == 'N')
            {
                visitor.tell("Good choice, you wouldn't have made it out alive! Here's 10 gold coins!");
                visitor.takeGold(10);
            }
        }
        
        else if(directionOfVisitor.equals(Direction.FROM_WEST))
        {
            visitor.tell("There is a group of zombies coming to attack you\n" + 
            "Run before it's too late!!!!!!!!\n" +
            "Take these 8 gold coins, not sure how they will help you!!!!");
            visitor.takeGold(8);
        }
        
        else if(directionOfVisitor.equals(Direction.FROM_NORTH))
        {
            visitor.tell("This is a peacefull section.\n" +
            "Enjoy your tea and enjoy the view! Here are 10 gold coins!");
            final Item Tissues = new Item("Tissues");
            visitor.takeGold(10);
        }
        
        else if(directionOfVisitor.equals(Direction.FROM_EAST))
        {
            final Item Towel = new Item("Towel");
            visitor.tell("There is a lit candle infront of you.");
            char decision = visitor.getChoice("I have given you a wet towel. Do you wish to extinguish the candle ", new char [] {'Y','N'});
            if(decision == 'Y')
            {
                visitor.giveItem(Towel);
                visitor.tell("Well done ... there is no light in the room, how are you going to see?");
            }
            else if(decision == 'N')
            {
                visitor.tell("Good choice! It would've have been pitch black in this room!");
                visitor.tell("Here is 12 gold coins");
                visitor.giveGold(12);
            }
        }
    return directionOfVisitor;
    }
}