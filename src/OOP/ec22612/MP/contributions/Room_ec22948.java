package OOP.ec22612.MP.contributions;

class Room_ec22948 extends Room {
    private int gold;
    
    public Room_ec22948(){
        gold = 1;
    }
    
    
    public Direction visit(Visitor visitor, Direction direction)
    {
        if(direction == Direction.FROM_NORTH)
        {
            visitor.tell("You came from the north.");
        }
        else if (direction == Direction.FROM_EAST)
        {
            visitor.tell("You came from the east.");
        }
        else if (direction == Direction.FROM_SOUTH)
        {
            visitor.tell("You came from the south.");
        }
        else if (direction == Direction.FROM_WEST)
        {
            visitor.tell("You came from the west.");
        }
        
        
        
        visitor.tell("You enter the room, it is very dark inside." + 
                    "The only thing yuo can see is 4 doors on each wall"+
                    "and a gold coin in the middle of the room");
        char[] options1 = {'1', '2'};
        int choice1 = visitor.getChoice("1. Pick up the gold coin\n2. Leave the coin and go away.",options1);
        switch(choice1)
        {
            case '1':
                visitor.tell("You pick up the coin");
                visitor.tell("<AAAAAARGHHH>Very lound voice screams at you.");
                 visitor.giveGold(1);
                break;
            case'2':
                visitor.tell("As you pass the coin, it dissapears with an <UUUUUUUUUU> sound");
                visitor.tell("Flash! And you see a rifle on the floor. You pick it up");
                visitor.giveItem(new Item("M 16 rifle"));
                break;
        }
        
        visitor.tell("You stand in the middle of the room thinking where to go");
        char[] directionToGo = {'1','2','3','4'};
        int choiceDirection = visitor.getChoice("1. Go EAST\n2. Go WEST\n3.Go NORTH\n4.Go SOUTH",directionToGo);
        if(choiceDirection==1)
        {
            direction = Direction.TO_EAST;
        }
        else if (choiceDirection==2)
        {
            direction = Direction.TO_WEST;
        }
        else if (choiceDirection==3)
        {
            direction = Direction.TO_NORTH;
        }
        else
        {
            direction = Direction.TO_SOUTH;
        }

        return direction;
    }
}
