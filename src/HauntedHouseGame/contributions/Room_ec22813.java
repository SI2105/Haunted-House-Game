package HauntedHouseGame.contributions;

class Room_ec22813 extends Room{

    public Direction visit(Visitor x, Direction y)
        {
            Boolean lights = false;
            Boolean Reaper = true;
            char[] choices = {'Y', 'N'};
            char[] options = {'l', 'r', 'm'};
        
            if (lights == false)
                {
                    x.tell("You are in a dark room and see something flickering on your left");
                    x.tell("The light is gone. The Reaper will take 3 gold to turn on it.");
                    char light = x.getChoice("Do you want to turn on the light?", choices);
            if (light == 'Y')
                {
                    x.takeGold(3);
                    lights = true;
                }
            else if (light == 'N')
                {
                    x.tell("The Reaper did nothing...");
                    lights = false;
                }
        }
        x.tell("You stumble upon 3 doors. Left, right and middle.");
        char door = x.getChoice("Which door do you pick?", options);
            
        if (door == 'l')
            {
                if (Reaper == true)
                    {
                        x.tell("The reaper is geting angry!!");
                        x.tell("You can't escape from him and he took 5 gold from you.");
                        x.takeGold(5);
                        Reaper = false;
                    }
            else if (Reaper == false)
                {
                    x.tell("You got 1 gold");
                    x.giveGold(1);
                }
                
            }
        else if (door == 'r')
        {
            x.tell("There are 5 gold pieces on the table!");
            x.tell ("You took it and return into the main room");
            x.giveGold(5);
        }
        else if (door == 'm')
        {
            x.tell("You found a way to kill the reaper");
            char kill = x.getChoice("Do you want to kill him?", choices);
            if (kill == 'Y')
            {
                x.tell("You killed him and 2 gold are given to you");
                x.giveGold(2);
            }
            else if (kill == 'N')
            {
                x.tell("The reaper thank you for your kindness and give you 10 gold.");
                x.giveGold(10);
            }
        }
        
        x.tell("You return to the start.");
        return Direction.opposite(y);
    }
}
