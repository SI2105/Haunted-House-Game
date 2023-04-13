package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ec22551 extends Room 
{
    public Direction visit(Visitor myVisitor, Direction myDirection)
    {
        // take direction that myVisitor entered through
        // set the leaving direction the opposite of this direction
        // also set the visibility state of the room depending on this (hazey/not hazey)
        Direction endDirection = Direction.FROM_SOUTH;
        boolean hazey = false;

        // setup items for rooms
        Item BIG_bayonet = new Item("BIG_bayonet");
        Item BIG_medal = new Item("BIG_medal");

        if (myDirection == Direction.FROM_SOUTH)
        {
            myVisitor.tell("That room was not BIG");
            myVisitor.tell("Don't go SOUTH again, go BIG instead");
            hazey = true;
        }
        else if (myDirection == Direction.FROM_NORTH)
        {
            myVisitor.tell("That room was not BIG");
            myVisitor.tell("Don't go NORTH again, go BIG instead");
            hazey = false;
        }
        else if (myDirection == Direction.FROM_WEST)
        {
            myVisitor.tell("That room was not BIG");
            myVisitor.tell("Don't go WEST again, go BIG instead");
            hazey = true;
        }
        else if (myDirection == Direction.FROM_EAST)
        {
            myVisitor.tell("That room was not BIG");
            myVisitor.tell("Don't go EAST again, go BIG instead");
            hazey = false;
        }
   
        // welcome myVisitor and describe the room
        myVisitor.tell("Welcome to the BIG room");
        myVisitor.tell("Go BIG or go home but you cannot do both");

        // let myVisitor know if the room is hazey or not
        if (hazey == true)
        {
            myVisitor.tell("Beware for the room is hazey");
            myVisitor.tell("Your visibility is significantly lower than it would be normally");
        }
        else if (hazey == false)
        {
            myVisitor.tell("The room is clear, your visibility is fine");
        }
    
        // tell myVisitor about choices
        myVisitor.tell("You are now faced with a very BIG decision");
        myVisitor.tell("1: search the BIG briefcase that lies to your left");
        myVisitor.tell("2: look behind the BIG poster on the wall");
        myVisitor.tell("3: open the BIG chest that lies to your right");
        
        // make myVisitor choose an option
        // if not default to leaving the room instantly
        char[] roomChoices = {'1','2','3'};
        char roomChoice = myVisitor.getChoice("So which one is it, BIG traveller?", roomChoices);
        
        // if the room is hazey, the user stumbles to the floor and loses some coins
        // else myVisitor finds BIG_bayonet and picks it up
        // if already holding a BIG_bayonet the briefcase is empty
        if (roomChoice == '1')
        {
            if (hazey == true)
            {
                myVisitor.tell("*you tripped over something trying to find the briefcase*");
                myVisitor.tell("*you dropped 3 coins*");
                myVisitor.tell("BE CAREFUL NEXT TIME");
                myVisitor.takeGold(3);
            }
            else if (hazey == false)
            {
                myVisitor.tell("*opens the BIG briefcase*");
                
                if (myVisitor.hasIdenticalItem(BIG_bayonet) | myVisitor.hasEqualItem(BIG_bayonet))
                {
                    myVisitor.tell("*the BIG briefcase was empty*");   
                }
                else 
                {
                    myVisitor.tell("You have found a BIG bayonet");
                    myVisitor.giveItem(BIG_bayonet);
                }
            }
        }
        
        // finds an enemy who makes myVisitor drop gold
        // 5 if room is hazey
        // 2 if room is not hazey
        // 0 if none held by myVisitor
        else if (roomChoice == '2')
        {
            if(myVisitor.hasIdenticalItem(BIG_medal) | myVisitor.hasEqualItem(BIG_medal))
            {
                myVisitor.tell("*you peep behind the poster*");
                myVisitor.tell("*you feel the presence of something MODERATELY BIG*");
                myVisitor.tell("*you notice a gleam coming from your medal*");
                myVisitor.tell("you have already encountered this BEHEMOTH");
                myVisitor.tell("run");
            }
            else if (! (myVisitor.hasIdenticalItem(BIG_medal) | myVisitor.hasEqualItem(BIG_medal)))
            {
                myVisitor.tell("*you peep behind the poster*");
                myVisitor.tell("*you feel the presence of something REALLY BIG*");
                myVisitor.tell("*a shiver runs down your spine*");
                myVisitor.tell("YOU HAVE ENTERED WHERE YOU SHOULD NOT HAVE");
                myVisitor.tell("I WILL TAKE YOUR COINS");
                try 
                {
                    myVisitor.takeGold(5);

                }
                catch (Exception e)
                {
                    myVisitor.tell("*you ran away in panic*");
                }
                myVisitor.tell("*you somehow emerge alive and find a BIG MEDAL on your neck*");
                myVisitor.tell("*you check your purse and notice it is a bit lighter*");
                myVisitor.giveItem(BIG_medal);
            }
            
        }
        
        // myVisitor opens the chest and finds a random number of gold (1-10 inclusive)
        else if (roomChoice == '3')
        {
            if (hazey == true)
            {
                myVisitor.tell("*the chest appeared empty*");
            }
            else if (hazey == false)
            {
                Random random = new Random();
                int numGoldFound = 1 + random.nextInt(10);
            
                myVisitor.tell("WOAH! A SECRET COMPARTMENT!!!");
                myVisitor.tell("WOAH! Some BIG gold coins!!!!");
                myVisitor.tell(numGoldFound + " BIG gold coins to be exact");
                myVisitor.giveGold(numGoldFound);
            }
        }
        
        // myVisitor leaves the room as no valid choice was picked
        else
        {
            myVisitor.tell("*you got bored and decided to leave the BIG room*");
            myVisitor.tell("Your loss");
        }
        
        // myVisitor leave the room in a new direction
        // make myVisitor choose a direction
        myVisitor.tell("*you decide it is time to leave*");
        myVisitor.tell("1: NORTH");
        myVisitor.tell("2: EAST");
        myVisitor.tell("3: SOUTH");
        myVisitor.tell("4: WEST");

        char[] directionChoices = {'1','2','3','4'};
        char directionChoice = myVisitor.getChoice("So which one is it, BIG traveller?", directionChoices);
        
        if(directionChoice == '1')
        {
            endDirection = Direction.TO_NORTH;
        }
        else if(directionChoice == '2')
        {
            endDirection = Direction.TO_EAST;
        }
        else if(directionChoice == '3')
        {
            endDirection = Direction.TO_SOUTH;
        }
        else if(directionChoice == '4')
        {
            endDirection = Direction.TO_WEST;
        }

        return endDirection;
    }
}
