package OOP.ec22612.MP.contributions;

class Room_ec22887 extends Room {//Updated A4
    boolean visibility = false; 
    Item Lamp = new Item("lamp");
    Item MagicCarpet = new Item("magiccarpet");

    public Direction visit(Visitor visitor, Direction directionarriving)
    {
        Direction exit = directionarriving;
        
        if (directionarriving == Direction.FROM_SOUTH)
        {
            visitor.tell("You came from the South into this room");
        }
        else if (directionarriving == Direction.FROM_NORTH)
        {
            visitor.tell("You came from the North into this room");
        }
        else if (directionarriving == Direction.FROM_WEST)
        {
            visitor.tell("You came from the West into this room");
        }
        else if (directionarriving == Direction.FROM_EAST)
        {
            visitor.tell("You came from the East into this room");
        }
        
        visitor.tell("You walk in and it is too dark for you to see things far from you");
        char choice = visitor.getChoice("Do you want to pick up the lamp? (y/n)", new char[]{'y','n'});
        if (choice == 'y' || choice == 'Y')
        {
            if(!visitor.hasEqualItem(Lamp))
            {
                visitor.giveItem(Lamp);
                visitor.tell("You can now use the lamp to see your surroundings better and find 2 pieces of gold");
                visibility = true; 
                visitor.giveGold(2);
            }
            else
            {
                visitor.tell("You already have a lamp so it's pointless having this lamp");
                visibility = true; 
            }
        }
        else
        {
            visitor.tell("You're taking a RISK!");
        }
        
        visitor.tell("There are four trails going to different parts of the room which seem to be made of different food: Jellybeans, Chocolate chips, Pringles and Pizza Slices ");
        char[] trailchoice = {'1','2','3','4'};
        char trail = visitor.getChoice("1. Jellybeans\n2. Chocolate Chips\n3. Pringles\n4. Pizza Slices", trailchoice);
        if (!visibility)
        {
            visitor.tell("SURPRISE. You don't see the rats that steal some of your gold");
            visitor.takeGold(3);
        }
        
        if (trail == trailchoice[0])
        {
            visitor.tell("You walk along the jellybean path until you get to a desk. As you get closer you see a possessed MOVING HAND which points at a spinner");
            char[] handchoice = {'1', '2', '3'};
            char handoption = visitor.getChoice("Do you want to: 1. Spin the spinner, 2. Ask it to do the spinner, 3. Ignore the hand", handchoice);
            if (handoption == handchoice[0] || handoption == handchoice[1])
            {
                visitor.tell("The Possessed Hand gives you 4 pieces of gold for being friendly and being ignorant");
                visitor.giveGold(4);
            }
            else{
                visitor.tell("The Possessed Hand is upset so it takes 2 pieces of gold");
                visitor.takeGold(2);
            }
        }
        
        else if (trail == trailchoice[1])
        {
            visitor.tell("You walk down the chocolate chip trail and find yourself in the middle of the room where there is a magic carpet on the floor in front of you ");
            char carpetoption = visitor.getChoice("Do you want to take the magic carpet with you or leave it? (y/n)", new char[]{'y','n'});
            if (carpetoption == 'y' || carpetoption == 'Y')
            {
                visitor.giveItem(MagicCarpet);
            }
            else{
                visitor.tell("The journey to the trail was a waste of time for you");
            }
        }
        
        else if (trail == trailchoice[2])
        {
            visitor.tell("You walk down the Pringles trail and find yourself with a cupboard in front of you.");
            char dooroption = visitor.getChoice("Do you want to open the door to the cupboard? (y/n)", new char[]{'y','n'});
            if (dooroption == 'y' || dooroption == 'Y')
            {
                visitor.tell("There is a rubix cube inside with a note that reads:");
                visitor.tell("Take your chances and solve the rubix cube ");
                char solveoption = visitor.getChoice("Do you want to: 1. Spend 5 minutes trying to solve the cube, 2. Spend 30 minutes trying to solve the cube or 3. Leave the cube ", new char[]{'1','2','3'});
                if (solveoption == '1')
                {
                    visitor.tell("You attempted solving the cube so you are given 1 piece of gold");
                    visitor.giveGold(1);
                }
                else if (solveoption == '2' )
                {
                    visitor.tell("You SOLVED IT! You get 4 pieces of gold for solving it successfully");
                    visitor.giveGold(4);
                }
                else
                {
                    visitor.tell("You leave the cupboard with the rubix cube solve unattempted");
                }
            }
            else{
                visitor.tell("There is nothing else to explore down this trail");
            }
        }
        
        else if (trail == trailchoice[3])
        {
            visitor.tell("You walk down the Pizza Slices trail and find yourself at a bed where there is a OUIJI BOARD ");
            char gameoption = visitor.getChoice("Do you want to experiment with the ouiji board? (y/n)", new char[]{'y','n'});
            if (gameoption == 'y' || gameoption == 'Y')
            {
                visitor.tell("Experimenting with the ouiji board doesn't go well and you summon evil spirits, maybe go far away from the bed");
            }
            else{
                visitor.tell("You surivived the chance of evil spirits being summoned well done!");
            }
            
        }
        
        char[] exits={'1','2','3','4'};
        char exitdirection = visitor.getChoice("1. Leave North\n2. Leave East\n3. Leave South\n4. Leave West", exits);
        if (exitdirection == exits[0])
        {
            exit = Direction.TO_NORTH;
        }
        else if (exitdirection == exits[1])
        {
            exit = Direction.TO_EAST;
        }
        else if (exitdirection == exits[2])
        {
            exit = Direction.TO_SOUTH;
        }
        else if (exitdirection == exits[3])
        {
            exit = Direction.TO_WEST;
        }

        return exit;
    }
}
