package OOP.ec22612.MP.contributions;

class Room_ec221013 extends Room
{
    public Direction visit(Visitor visitor, Direction ArrivedFrom)
    {
        Boolean lights = false;
        Boolean trap = true;
        char[] yn = {'y', 'n'};
        char[] options = {'l', 'r', 'a'};
        
        if (lights == false)
        {
            visitor.tell("The Outsider is watching you...");
            visitor.tell("The candle is out. THe Outsider will take 3 gold to light it.");
            char lightsChoice = visitor.getChoice("Do you want to turn them on? y/n", yn);
            if (lightsChoice == 'y')
            {
                visitor.takeGold(3);
                lights = true;
            }
            else if (lightsChoice == 'n')
            {
                visitor.tell("Brave... The Outsider is impressed. He lights it without taking any gold.");
                lights = true;
            }
        }
        visitor.tell("You stumble upon 3 doors. Left, right and ahead.");
        char doorsChoice = visitor.getChoice("Which door do you pick? l/r/a", options);
            
        if (doorsChoice == 'l')
        {
            if (trap == true)
            {
                visitor.tell("Someone has set a trap, this door is rigged with explosives.");
                visitor.tell("You dive back into the main room, dropping 5 gold.");
                visitor.takeGold(5);
                trap = false;
            }
            else if (trap == false)
            {
                visitor.tell("You return and find 1 gold");
                visitor.giveGold(1);
            }
                
        }
        else if (doorsChoice == 'r')
        {
            visitor.tell("The Outsider has put 3 gold pieces on a table for you.");
            visitor.tell ("You take it and return into the main room");
            visitor.giveGold(3);
        }
        else if (doorsChoice == 'a')
        {
            visitor.tell("You find the Outsider's body in his office.");
            char lootChoice = visitor.getChoice("Do you loot him?", yn);
            if (lootChoice == 'y')
            {
                visitor.tell("The Outsider watches on as you loot 3 gold");
                visitor.giveGold(3);
            }
            else if (lootChoice == 'n')
            {
                visitor.tell("The Outsider rewards you with 8 gold.");
                visitor.giveGold(8);
            }
        }
        
        visitor.tell("You return the way you came.");
        return Direction.opposite(ArrivedFrom);
    }
}
