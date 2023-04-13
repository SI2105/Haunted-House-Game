package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ec22569 extends Room 
{
    static final Item BRACELET = new Item("Bracelet");
    static final Item NECKLACE = new Item("Necklace");
    char[] two_options = {'a', 'b'};
    char[] three_options = {'a', 'b', 'c'};
    boolean has_torch = false;
    boolean opened_first = false;
    boolean opened_second = false;
    boolean opened_third = false;
    boolean visited_table = false;
    boolean visited_dressing_table = false;
    boolean lights_on = false;

    public Direction visit(Visitor visitor, Direction direction)
    {
        // print entered a new room
        visitor.tell("");
        visitor.tell("YOU HAVE ENTERED INTO A NEW ROOM.");
        
        // print which location entered from
        if (direction == Direction.FROM_NORTH) 
        {
            visitor.tell("You have entered from the North.");
        }
        else if (direction == Direction.FROM_EAST) 
        {
            visitor.tell("You have entered from the East.");
        }
        else if (direction == Direction.FROM_SOUTH) 
        {
            visitor.tell("You have entered from the South.");
        }
        else if (direction == Direction.FROM_WEST) 
        {
            visitor.tell("You have entered from the West.");
        }
        else
        {
            // randomly generate a number and assign to N.E.S.W. and then print entrance statement
            Random random_entrance = new Random ();
            int entrance = random_entrance.nextInt(4);
            
            if (entrance == 0)
            {
                visitor.tell("You have entered from the West.");
            }
            else if (entrance == 1)
            {
                visitor.tell("You have entered from the North.");
            }
            else if (entrance == 2)
            {
                visitor.tell("You have entered from the East.");
            }
            else if (entrance == 3)
            {
                visitor.tell("You have entered from the South.");
            }
        }
        
        visitor.tell("The room you have entered is dark and you struggle to see anything.");
        
        // code not accepted by jenkins ?
        //if (visitor.hasEqualItem(TORCH))
        // { 
        //     has_torch = true;
        // }
        // else if (visitor.hasEqualItem(TORCH))
        // {
        //     has_torch = true;
        // }
        // else
        // {
        //     has_torch = false;
        // }
        
        // randomly generate to determine whether user has a torch or not
        Random random = new Random ();
        int torch = random.nextInt(2);
        
        if (torch == 0)
        {
            has_torch = false;
        }
        else
        {
            has_torch = true;
        }        
        
        // if the lights are switched off
        if (lights_on == false)
        {
            // if visitor has a torch
            if (has_torch == true)
            {
                visitor.tell("You switch your torch on and use it to look around.");
            }
            // visitor has no torch
            else
            {
                visitor.tell("You don't have a torch so you try to find a light switch.");
                visitor.tell("Whilst stumbling in the darkness, you drop some gold pieces you may have had.");
                visitor.takeGold(2);
                lights_on = true;
                visitor.tell("After finding the light switch and switching it on, you look around.");
            }
        }
        // if lights are switched on
        else
        {
            visitor.tell("The lights have been left on from your previous visit.");
        }
        
        visitor.tell("You look around the largely empty room and see two pieces of furniture: a small table and a dressing table.");
        
        // visitor has not visited small table on previous visit(s)
        if (visited_table == false)
        {
            visitor.tell("You have not yet visited the table.");
        }
        // visitor has visited small table on previous visit(s)
        else
        {
            visitor.tell("You have visited the table before.");
        }
        // visitor has not visited dressing table on previous visit(s)
        if (visited_dressing_table == false)
        {
            visitor.tell("You have not yet visited the dressing table.");
        }
        // visitor has visited dresisng table on previous visit(s)
        else
        {
            visitor.tell("You have visited the dressing table before.");
            
            // check if visitor has opened all compartments of dressing table on previous visit(s)
            if (opened_first == false || opened_second == false || opened_third == false)
            {
                visitor.tell("However, you have not yet opened all the compartments.");
            }
            else
            {
                visitor.tell("You have opened all the compartments before.");
            }
        }
        
        // let visitor choose which furniture item to look at further on this visit
        visitor.tell("Which do you choose to visit a) small table b) dressing table?");
        char furniture_choice = visitor.getChoice("Enter only 'a' or 'b'", two_options);
        
        // visitor has chosen small table
        if (furniture_choice == ('a'))
        {
            // if visitor has not visited before
            if (visited_table == false)
            {
                // set visit to true
                visited_table = true;
                visitor.tell("You have chosen to visit the small table and make your way towards it.");
                visitor.tell("You find some pieces of gold on the table. Do you wish to collect it?");
                visitor.tell("a) yes b) no");
                char gold_choice = visitor.getChoice("Enter only 'a' or 'b'", two_options); 
                // visitor collects gold
                if (gold_choice == ('a'))
                {
                    visitor.tell("You have collected some gold.");
                    visitor.giveGold(2);
                }
                visitor.tell("You look to the other side of the table and see an antique diamond bracelet.");
                visitor.tell("Do you wish to collect it?");
                visitor.tell("a) yes b) no");
                char bracelet_choice = visitor.getChoice("Enter only 'a' or 'b'", two_options); 
                // collect bracelet
                if (bracelet_choice == ('a'))
                {
                    visitor.giveItem(BRACELET);
                    visitor.tell("You have collected the bracelet.");
                }
                // chose not to collect bracelet
                else
                {
                    visitor.tell("You have not collected the bracelet.");
                
                }                
                visitor.tell("Aside from the gold, the table is empty.");
            }
            // visitor has already visited before
            else
            {                
                visitor.tell("You have already visited the table in this room so there is nothing else to find.");
            }
            // end visit to small table
            visitor.tell("You walk away from the table.");
        }
        // visitor has chosen dressing table
        if (furniture_choice == ('b'))
        {
            // check if visitor has not visited dressing table previously or if any compartments have not been open 
            if (visited_dressing_table == false || (opened_first == false || opened_second == false || opened_third == false))
            {
                visited_dressing_table = true;
                visitor.tell("You have chosen to visit the dressing table and make your way towards it.");
                visitor.tell("You see the multiple compartments of the dressing table.");
                visitor.tell("Do you wish to open one of the compartments?");
                visitor.tell("a) yes b) no");
                char open_dressing_table = visitor.getChoice("Enter only 'a' or 'b'", two_options);
                // chooses to open one of the compartments
                if (open_dressing_table == ('a'))
                {
                    visitor.tell("There are 3 available compartments to open. Which do you wish to open?");
                    visitor.tell("a) first b) second c) third");
                    char which_compartment = visitor.getChoice("Enter only 'a', 'b' or 'c'", three_options);
                    // chooses to open first compartment
                    if (which_compartment == ('a'))
                    {
                        // if not yet opened
                        if (opened_first == false)
                        {
                            opened_first = true;
                            visitor.tell("You attempt to open the first compartment but it is jammed.");
                        }
                        // if opened before
                        else
                        {
                            visitor.tell("You try again to open this compartment but it is still jammed.");
                        }
                        
                        visitor.tell("You give up on the dressing table.");
                    }
                    // chooses to open second compartment
                    else if (which_compartment == ('b'))
                    {
                        // if not yet opened
                        if (opened_second == false)
                        {
                            opened_second = true;
                            visitor.tell("You try to open the second compartment but it breaks and falls onto you.");
                            visitor.tell("Whilst struggling to get up, you drop a piece of gold.");
                            visitor.takeGold(1);
                        }
                        // if opened before
                        else
                        {
                            visitor.tell("This compartment is broken from previously trying to open it.");
                        }
                        
                        visitor.tell("Out of anger, you decide to give up on the dressing table.");
                    }
                    // chooses to open third compartment
                    else
                    {
                        if (opened_third == false)
                        {
                            opened_third = true;
                            visitor.tell("You successfully open the third compartment.");
                            visitor.giveItem(NECKLACE);
                            visitor.giveGold(3);
                            visitor.tell("You find a necklace and some pieces of gold.");
                        }
                        else
                        {
                            visitor.tell("You look into one of the corners of the compartment and spot a piece of gold.");
                            visitor.giveGold(1);
                        }
                        
                        visitor.tell("You decide to not push your luck further and leave the dressing table alone.");
                    }
                    // visitor chose not to open dressing table
                    if (open_dressing_table == ('b'))
                    {
                        visitor.tell("You look on the floor next to the dressing table and find some gold.");
                        visitor.tell("Do you wish to collect the gold?");
                        visitor.tell("a) yes b) no");
                        char gold_choice = visitor.getChoice("Enter only 'a' or 'b'", two_options);
                        // visitor chooses to collect gold
                        if (gold_choice == ('a'))
                        {
                                visitor.giveGold(2);
                        }

                    }
                    
                    // end of dressing table visit
                    visitor.tell("You walk away from the dressing table.");
                }
            }
        }
        
        // if visitor does not have torch
        if (has_torch == false)
        {
            // asks if visitor wants to switch lights off
            visitor.tell("Before exiting the room, do you wish to turn the lights off?");
            visitor.tell("a) yes b) no");
            char lights_choice = visitor.getChoice("Enter only 'a' or 'b'", two_options);
            // visitor chose to switch lights off
            if (lights_choice == ('a'))
            {
                lights_on = false;;
                visitor.tell("You have switched the lights off.");
            }
            // visitor will leave lights on
            else
            {
                 visitor.tell("You have left the lights switched on.");
            }
        }
       
        // opposite direction entered from
        Direction leaving_direction = Direction.opposite(direction);
   
        visitor.tell("");
        return leaving_direction;
    }
}
