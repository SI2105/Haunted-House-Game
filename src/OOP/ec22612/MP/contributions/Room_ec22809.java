package OOP.ec22612.MP.contributions;

import java.util.Random;
class Room_ec22809 extends Room
{
    static boolean chalice = true;
    static boolean blownUp = false;
    static boolean seenGarden = false;
    public Direction visit(Visitor v, Direction d) {

        //Room descriptions
        if(blownUp = false)
        {
            v.tell("You find yourself in a small candlelit room.");
            v.tell("Along the left side of the wall stands an organ, towering over the cramped space with its bronze pipes.");
            v.tell("On the right there is a small wardrobe, and just in front of you stands a window.");
        }
        else
        {
            v.tell("You enter the same small candlelit room but it is still covered in the dust and soot of the explosion.");
            v.tell("You can still make out the shape of the organ, despite the mangling of its pipes and keys, and you can still see the small wardrobe and window, albeit covered in a black powder.");
        }
        

        // Using loop to avoid further repetition of code, as checks have been made to confirm room state
        for(int i = 0; i<2; i++)
        {
            //Checking to see the state of the room
            if(blownUp = false)
            {
                //Giving the player choices for actions
                char[] choicesForRoom = {'a','b','c'};
                char choice = v.getChoice("a.Play the organ, b.Look in the wardrobe, c.Look through the window", choicesForRoom);
                if(choice == 'a')
                {
                    v.tell("You approach the organ and press a key to check its tuning. Upon pressing the key however, the piano blows up and knocks you to the ground.");
                    int coinsLost = (new Random()).nextInt(10);
                    v.tell("After standing up, you notice that your pockets feel lighter and upon further inspection realise you've lost " + coinsLost + " gold pieces.");
                    v.takeGold(coinsLost);
                    blownUp = true;
                    v.tell("Since the room is now covered in soot and ashes you decide to leave back the way you came, hoping to not trigger any more traps.");
                    return d.opposite(d);
                }
                else if(choice == 'b')
                {
                    //Checking state of the room / Is the item present
                    if(chalice == true)
                    {
                        v.tell("You open the wardrobe and find a sparkly golden chalice adorned with precious gems. Taking a sneaky look around, you realise that nobody is watching and decide to take it.");
                        v.giveItem(new Item("Chalice"));
                        chalice = false;
                    }
                    else
                    {
                        v.tell("You take another look in the wardrobe but find nothing.");
                    }

                }
                else if(choice == 'c')
                {
                    //Checking to see if the player has examined the window before, giving them a different response if so
                    if(seenGarden == false)
                    {
                        v.tell("You take a look out of the window and see a beautiful lush garden. It makes you feel nice.");
                        seenGarden = true;
                    }
                    else
                    {
                        v.tell("You decide to take another look out the window at the garden. It still looks just as green and lush.");
                    }

                }

            }
            // Repeating some code from before as choices may have been changed by the events of potential previous choice
            else
            {
                char[] choicesForRoom = {'a','b','c'};
                char choice = v.getChoice("a.Examine the organ b.Look in the wardrobe, c.Look through the window", choicesForRoom);
                if(choice == 'a')
                {
                    v.tell("You take another close look at the organ but dare not touch it. Its keys have been spread wide apart, with many of them having been flung around the room, and the pipes have developed bends and twists.");
                }
                else if(choice == 'b')
                {
                    if(chalice == true)
                    {
                        v.tell("You open the wardrobe and find a sparkly golden chalice adorned with precious gems. Taking a sneaky look around, you realise that nobody is watching and decide to take it.");
                        v.giveItem(new Item("Chalice"));
                        chalice = false;
                    }
                    else
                    {
                        v.tell("You take another look in the wardrobe but find nothing.");
                    }

                }
                else if(choice == 'c')
                {
                    if(seenGarden == false)
                    {
                        v.tell("You take a look out of the window and see a beautiful lush garden. It makes you feel nice.");
                        seenGarden = true;
                    }
                    else
                    {
                        v.tell("You decide to take another look out the window at the garden. It still looks just as green and lush.");
                    }

                }

                
            }
        }
        // Giving the player choice to decide where to move on to and selecting direction
        v.tell("You start getting bored of the cramped little room and decide you want to move on. You decide to go to the...");
        char[] choicesForDir = {'a','b','c','d'};
        char choiceOfDir = v.getChoice("a.North, b.East, c.South, d.West", choicesForDir);
        switch(choiceOfDir)
        {
            case 'a':
            {
                d = d.TO_NORTH;
            }
            case 'b':
            {
                d = d.TO_EAST;
            }
            case 'c':
            {
                d = d.TO_SOUTH;
            }
            case 'd':
            {
                d = d.TO_WEST;
            }
        }
        return d;
    }

}