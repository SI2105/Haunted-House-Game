package HauntedHouseGame.contributions;

class Room_ec21582 extends Room{
	
	char [] diffOptions = {'a', 'b', 'y', 'n', 'r', 'l', 's'};
	Item torch = new Item("Torch");
	Item ring = new Item("Ring");
	boolean lightAccept = false;

    public Direction visit(Visitor visitor, Direction direction)
    {
        visitor.tell("Welcome to Harry's Home, want to find some golds?");
        char [] direct = {'l', 'r'};
        char ans = visitor.getChoice("Which direction will you like to go? Left or Right (Please response 'l' or 'r'.", diffOptions);
        if (ans == 'l')
        {
            visitor.tell("Go to the end of the corridor there is a shelf beside a painting, open it and reach inside.");
            visitor.tell("You will get 5 coins");
            visitor.giveGold(5);
            visitor.tell("No! Someone is pulling you inside of that shelf!");
            
            char options = visitor.getChoice("Will you rather pull yourself away from it (enter 'a') or been pulled inside of the shelf (enter 'b') or ?", diffOptions);
            if (options == 'a')
            {
                visitor.tell("While you are struggling with it, a ghost came and grab 2 of your golds away");
                visitor.takeGold(2);
                return Direction.TO_WEST;
            }
            else if (options == 'b')
            {
                char light = visitor.getChoice("You are draged to a underground, there is a torch beside wll you like to take it ('y' or 'n').", diffOptions);
                
                if (light == 'y') {
                	lightAccept = true;
                	visitor.giveItem(torch);
                }
                
                return Direction.TO_EAST;
            }

        }

        else if (ans == 'r')
        {
            visitor.tell("There is a room, you unlock the room door and at the right side there's a big box you opens it, there's one rectangle box 'r' and a sqare box 's'. ");
            char rightOption = visitor.getChoice("Do you open the door (a) or search the chest of drawers (b)?", diffOptions);
            if (rightOption == 'r')
            {
                visitor.tell("There is a letter from the future you. You will receive 1 gold");
                visitor.giveGold(1);
                return Direction.TO_NORTH;
            }

            else if (rightOption == 's')
            {
                visitor.tell("You will find 3 golds and a King Ring.");
                visitor.giveGold(3);
                visitor.giveItem(ring);
                return Direction.TO_SOUTH;
            }

        }
        return direction;
    }
	
}
