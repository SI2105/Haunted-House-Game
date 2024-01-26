package HauntedHouseGame.contributions;

import java.util.Random;
//hope this goes well...

class Room_ec22553 extends Room
{
    String light_status = "On";
    String button_status = "UnPressed";
    boolean looted_gold = false;
    boolean looted_paperclip = false;
    public Direction visit(Visitor v, Direction directionVistorArrivesFrom)
    {
        Random random = new Random();
        Item paperclip = new Item("paperclip");
        char[] choices = {'Y','N'};

        /*************** -Room introduction section - ******************/

        v.tell("You entered a new room");
        v.tell(("The lights are " + light_status));
        if(light_status.equals("Off"))
        {
                v.tell("All you can see in the darkness are the doors");
                char candle = v.getChoice("You see a candle, do you light it? (Y/N)", choices);
                switch(candle)
                {
                    case 'Y':{light_status = "On";}
                    v.tell(("The lights are " + light_status));
                }

        }


        /*************** -Item section section - ******************/
        if(light_status.equals("On"))
        {
            if(button_status.equals("UnPressed"))
            {
                button_status = "Pressed";
                char button = v.getChoice("There is a button in the middle of the room, do you press it? (Y/N)", choices);
                switch(button)
                {
                    case 'Y':
                    {
                        v.tell("You press the button and a compartment in the wall opens!");
                        if(!looted_gold)
                        {
                            if(random.nextInt(1) == 0)
                            {
                                v.tell("There is a slight shimmer of light");
                                int random_gold = random.nextInt(9);
                                v.giveGold(random_gold);
                                v.tell("Lying there were " + random_gold + " gold coins");
                                looted_gold = true;
                            }
                        }
                        if(!looted_paperclip)
                        {
                            v.tell("There was a paperclip laying there...");
                            char paperclip_choice = v.getChoice("Would you like to pickup the paperclip? (Y/N)", choices);
                            switch(paperclip_choice)
                            {
                                case 'Y':
                                {
                                    if(v.hasEqualItem(paperclip))
                            {
                                v.tell("But it looks like you already have one, so you cant pick it up...");
                            }
                            else
                            {
                                v.giveItem(paperclip);
                                v.tell("You picked up the paperclip!");
                                looted_paperclip = true;
                            }
                                }
                            }
                        }
                    }
                }
            }
            else
            {
                v.tell("The button in the room has been pressed already");
                v.tell("You spot the open compartment in the wall");
                char compartment = v.getChoice("Do you want to inpect the compartment? (Y/N)", choices);
                switch(compartment)
                {
                    case 'Y': 
                    {
                        if(!looted_gold)
                        {
                            if(random.nextInt(1) == 0)
                            {
                                v.tell("There is a slight shimmer of light");
                                int random_gold = random.nextInt(9);
                                v.giveGold(random_gold);
                                v.tell("Lying there were " + random_gold + " gold coins");
                                looted_gold = true;
                            }
                        }
                        else if(!looted_paperclip)
                        {
                            v.tell("There was a paperclip laying there...");
                            if(v.hasEqualItem(paperclip))
                            {
                                v.tell("But it looks like you already have one, so you cant pick it up...");
                            }
                            else
                            {
                                v.giveItem(paperclip);
                                looted_paperclip = true;
                            }
                        }
                        else 
                        {
                            v.tell("You check and sadly, nothing is there");
                        }
                    }
                }
            }
        }
        else
        {
            v.tell("It is too dark to see anything in the room");
        }

        
        
        /*************** -Direction section - ******************/
        char[] direction_choices = {'N','E','S','W'};

        char path_choice = v.getChoice("Which direction would you like to go next?", direction_choices);
        

        switch(path_choice)
        {
            case 'N':
            {
                v.tell("You left the room going NORTH");
                return this.visit(v, Direction.TO_NORTH);
            }
            case 'E':
            {
                v.tell("You left the room going EAST");
                return this.visit(v, Direction.TO_EAST);
            }
            case 'S':
            {
                v.tell("You left the room going SOUTH");
                return this.visit(v, Direction.TO_SOUTH);
            }
            case 'W':
            {
                v.tell("You left the room going WEST");
                return this.visit(v, Direction.TO_WEST);
            }
        }
        return Direction.UNDEFINED;
    }
}
