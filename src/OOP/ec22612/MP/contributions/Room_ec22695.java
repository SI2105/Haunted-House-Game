package OOP.ec22612.MP.contributions;

import java.util.Random;
class Room_ec22695 extends Room
{
    // Key for room ec22770 to open the chest
    static final Item Key = new Item("Key_ec22770");
    //condition variables so events only happen once
    static boolean DeskCupboardIsOpenned = false;
    static boolean BookShelfComparmentisOpened = false;
    static boolean IsLightTakenOut = false;
    static boolean FirstTimeInRoom = true;
    

    public Direction visit(Visitor visitor, Direction directionintoRoom)
    {
        
        if(DeskCupboardIsOpenned == true && (visitor.hasEqualItem(Key)) == false)//added to give option to user to still pick up key
        {
            char[] Options = {'Y', 'N'};
            char Choice =  visitor.getChoice("The key still remains in the desk. Would you like to take the key. (Y) yes (N) no", Options);
            if(Choice == 'Y')
            {
                visitor.giveItem(Key);
            }
        }

        //all events of room have been complete
        if(DeskCupboardIsOpenned == true && BookShelfComparmentisOpened == true)
        {
            visitor.tell("You have entered the abandom study room.");
            visitor.tell("The room has been ransaked you will find nothing here");
        }
        //intial visit to the room 
        else if(FirstTimeInRoom == true)
        {
            visitor.tell("You have entered an abandom study room.");
            visitor.tell("You look round the room. The room seems lifeless.");
            visitor.tell("The room contains a old study desk in the middle of the room facing a wall covered with books on a bookshelf");
            visitor.tell("Would you like to: ");
            char[] Option = {'a', 'b', 'c'};
            char Choice = visitor.getChoice("(a) exit (b) view the bookshelf (c) view the desk", Option);
            switch(Choice)
            {
                case 'a':
                    visitor.tell("You decide to leave the room");
                    break;

                case 'b':
                    visitor.tell("The bookshelf books are untouched but old. After knocking on the shelf you realise the shelf seems hollow. You leave the room deciding to investigate the shelf later.");
                    break;

                case 'c':
                    visitor.tell("You approach the desk at the centre of the room. The desk contains a small desk light, the only source of light in the room.");
                    TurnOfLight(visitor);
                    break;
            }
            FirstTimeInRoom = false;
        }
        //second time entry of the room focuses on the desk (semi - forcing the user to interact with the room)
        else if(FirstTimeInRoom == false )
        {
            // separate messages depending on the state of the light (on the desk)
            if(IsLightTakenOut == false)
            {

                visitor.tell("The room is dark and you knock yourself into the desk.");

                if(DeskCupboardIsOpenned == false)
                {
                    int Choice = (new Random()).nextInt(2);
                    if(Choice == 0) //two interactions with the desk (the light and the searching desk drawer)
                    {
                        TurnOfLight(visitor);
                    }
                    else
                    {
                        OpenTheDesk(visitor);
                    }
                }
                else //at this point desk already has been searched there for light must be turned on to continue (finding gold by the bookshelf)
                {
                    TurnOfLight(visitor);
                }
            }
            else
            {

                visitor.tell("You re enter the room and focus on the desk on in the center of the room");

                if(DeskCupboardIsOpenned == false && BookShelfComparmentisOpened == false)
                {
                    int Choice = (new Random()).nextInt(2);
                    if(Choice == 0) //two interactions with the bookshelf and the searching desk drawer
                    {
                        OpenTheDesk(visitor);
                    }
                    else
                    {
                        RevealBookshelf(visitor);
                    }
                }
                else
                {
                    if(DeskCupboardIsOpenned == false)
                    {
                        OpenTheDesk(visitor);
                    }
                    if(BookShelfComparmentisOpened == false)
                    {
                        RevealBookshelf(visitor);
                    }
                }


            }

        }

        return Direction.opposite(directionintoRoom); // single entrance in the room there fore the visitor returns in the same direction they entered
    }


    // This method handles the event of interacting with the light on the desk
    void TurnOfLight(Visitor visitor)
    {
        char[] Options = {'Y', 'N'};
        char Choice = visitor.getChoice("Would you like to turn off the desk light (Y) yes or (N) no? (Maybe the darkness will unviel the rooms secrets)", Options);
        if(Choice == 'Y')
        {
            visitor.tell("You turn off the light and the room becomes dark. You turn round noticing something new in the room.");
            visitor.tell("You see a faint glow emerging from the wall. Secrets locked way behind the bars of books");
            IsLightTakenOut = true;
        }
        else
        {
            visitor.tell("The desks light illumination flikers. The light remains lonely lit in the study room.");
        }
        
    }

    // method deals with interacting with the compartment in the bookshelf event
    void RevealBookshelf(Visitor visitor)
    {
        if(visitor.hasEqualItem(new Item("Lever_ec22695"))) //lever will be obtained from room ec22770
        {
            visitor.tell("You are reminded that you have found a lever (from a previous room) that may reveal whats behind the bookshelf");
            visitor.tell("The lever opens a secret compartment behind the bookself, and you find GOLD.");
            int ammount = 1 + (new Random()).nextInt(10); //generates a number from 1-10
            visitor.giveGold(ammount);
            BookShelfComparmentisOpened = true;
        }
        else
        {
            visitor.tell("To open reveal the hidden secreats of the bookself you need a special item. You decide to come back later once you have what you need.");
        }
    }

    // method deals with opening desk event (getting key for room ec22770)
    void OpenTheDesk(Visitor visitor)
    {
        visitor.tell("You notice the desk is left untouched.");
        char[] Options = {'Y', 'N'};
        char Choice =  visitor.getChoice("Would you like to search the desk. (Y) yes or (N) no", Options);
        if(Choice == 'Y')
        {
            visitor.tell("You find two pieces of gold and find a key in the desk draw. Might be useful for later");
            visitor.giveGold(2);
            visitor.giveItem(Key);
            DeskCupboardIsOpenned = true;
        }
        else
        {
            visitor.tell("The desk is remained untouched. Your conscious tells you that you should search the desk");
        }
    }

}
