package HauntedHouseGame.contributions;

class Room_ec22766 extends Room{
    public boolean lightsOn=false;
    public boolean cupboardOpen=false;
    public boolean visited=false;
    char[] options={'a','b','c','d','e','f'};
    char[] directions={'a','b','c','d'};
    final Item candle = new Item("Candle");
    Direction finalDirection;

    public static void main(String[] args)
    {
    }

    public Direction visit(Visitor visitor, Direction userDirection)
    {
        visited=true;
        if ((lightsOn==true) && (cupboardOpen==true))
        {
            visitor.tell("Welcome to my room. This room currently has lights on and the cupboard is open.");
        }
        else if ((lightsOn==true) && (cupboardOpen==false))
        {
            visitor.tell("Welcome to my room. This room currently has lights on and the cupboard is closed.");
        }
        else if ((lightsOn==false) && (cupboardOpen==true))
        {
            visitor.tell("Welcome to my room. This room currently has lights off and the cupboard is open.");
        }
        else
        {
            visitor.tell("Welcome to my room. This room currently has lights off and the cupboard is closed.");
        }
        char visitorChoice = visitor.getChoice("Please choose one of the following options: a)exit the Room b)Check cupboard c)Off the lights d)On the lights e)Open the cupboard f)Close the cupboard", options);
        while (visitorChoice!='a')
        {
            if (visitorChoice=='b')
            {
                if (cupboardOpen==false)
                {
                    visitor.tell("Oh no the cupboard is closed, please open the cupboard before checking the checking the cupboard.");
                }
                else
                {
                    visitor.tell("Well Done, you have found a gold chest. You get 5 gold tokens");
                    visitor.giveGold(5);
                    visitor.tell("5 gold tokens have now been added to your purse");
                }
            }



            else if (visitorChoice=='c')
            {
                if (lightsOn==false)
                {
                    visitor.tell("The lights are already off");
                }
                else
                {
                    visitor.tell("The lights are now off");
                    lightsOn=false;
                    if (visited==true)
                    {
                        if (visitor.hasIdenticalItem(candle))
                        {
                            visitor.tell("Oh ok, you already have a candle...if not, I was going to give you one.");
                        }
                        else
                        {
                            visitor.tell("Oh ok, here you go...here is a candle to help you see in the dark.");                        
                            visitor.giveItem(candle);
                        }
                    }
                }

            }
            else if (visitorChoice=='d')
            {
                if (lightsOn==true)
                {
                    visitor.tell("The lights are already on");
                }
                else
                {
                    lightsOn=true;
                    visitor.tell("The lights are now on");

                    visitor.tell("Please give 2 gold tokens to pay for the electricity.");
                    visitor.takeGold(2);
                    visitor.tell("Thank you.");
                }
            }
            else if (visitorChoice=='e')
            {
                if (cupboardOpen==true)
                {
                    visitor.tell("The cupboard is already open.");
                }
                else
                {
                    cupboardOpen=true;
                    visitor.tell("The cupboard is now open...(Hint)You can check inside if you want");
                }

            }
            else //option f
            {
                if (cupboardOpen==false)
                {
                    visitor.tell("The cupboard is already closed.");
                }
                else
                {
                    cupboardOpen=false;
                    visitor.tell("The cupboard is now closed");
                }

            }
            visitorChoice = visitor.getChoice("Please choose one of the following options: a)exit the Room b)Check cupboard c)Off the lights d)On the lights e)Open the cupboard f)Close the cupboard", options);
        }//End of while loop
    
        char choiceDirection= visitor.getChoice("Please enter the option corresponding to your current direction: a)North b)East c)South d)West", directions);
    //How to create specific direction as visitor does not have a direction attribute?

        visited=false;
        switch(choiceDirection){
            case 'a':
                finalDirection=Direction.TO_NORTH;
                break;                    
            case 'b':
                finalDirection=Direction.TO_EAST;
                break;
            case 'c':
                finalDirection=Direction.TO_SOUTH;
                break;
            case 'd':
                finalDirection=Direction.TO_WEST;
                break;
            default:
        }

        return finalDirection;
        
    }//End of visit method
    
}
