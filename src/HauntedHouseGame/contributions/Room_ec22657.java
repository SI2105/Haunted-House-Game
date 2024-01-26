package HauntedHouseGame.contributions;

class Room_ec22657 extends Room{
    static final Item roomKeys = new Item("Key");
    static final Item puzzle = new Item("Puzzle");
    static final Item pen = new Item("Pen");
    
    boolean table_search = false;
    boolean bowl_search =false;
    boolean locker_search = false;
    boolean firstTime = true;
    
    public Direction visit(Visitor visitor, Direction direction){
        
        char[] places = {'t', 'b', 'l'};
        char[] take = {'y', 'n'};
        
        if(table_search == true && bowl_search == true && locker_search == true)
        {
            visitor.tell("You have entered an empty Games Room.");
            visitor.tell("It has been trashed, nothing can be found here.");
        }
        else if(firstTime == true)
        {
            visitor.tell("Welcome to the Games Room ec22657!");
            visitor.tell("You can see a bowl, a locker and a table.");
            char ans = visitor.getChoice("Would you like to search the (b)owl, the (l)ocker or the (t)able? (b/l/t)", places);
            if(ans == 'b')
            {
                searchBowl(visitor, take);
                bowl_search = true;
                direction = Direction.TO_NORTH;
            }
            else if(ans == 'l')
            {
                searchLocker(visitor, take);
                locker_search = true;
                direction = Direction.TO_WEST;
            }
            else if(ans == 't')
            {
                searchTable(visitor, take);
                table_search = true;
                direction = Direction.TO_EAST;
            }
            else
            {
                visitor.tell("Please type the correct value.");
            }
        }
        else
        {
            if(bowl_search == false)
            {
                visitor.tell("Welcome to the Games Room ec22657!");
                visitor.tell("Since you didn't take the important thing in this room last time, you need to pay for the second enter prices.");
                visitor.tell("Prices: Two pieces of golds");
                visitor.takeGold(2);
                char ans = visitor.getChoice("Would you like to search the (b)owl, the (l)ocker or the (t)able? (b/l/t)", places);
                if(ans == 'b')
                {
                    searchBowl(visitor, take);
                    bowl_search = true;
                    direction = Direction.TO_NORTH;
                }
                else if(ans == 'l')
                {
                    searchLocker(visitor, take);
                    locker_search = true;
                    direction = Direction.TO_WEST;
                }
                else if(ans == 't')
                {
                    searchTable(visitor, take);
                    table_search = true;
                    direction = Direction.TO_EAST;
                }
                else
                {
                    visitor.tell("Please type the correct value.");
                }
            }
            else{
                visitor.tell("Welcome to the Games Room ec22657!");
                visitor.tell("You have been here before but you didn't take all the items in here.");
                char ans = visitor.getChoice("Would you like to search the (b)owl, the (l)ocker or the (t)able? (b/l/t)", places);
                if(ans == 'b')
                {
                    searchBowl(visitor, take);
                    bowl_search = true;
                    direction = Direction.TO_NORTH;
                }
                else if(ans == 'l')
                {
                    searchLocker(visitor, take);
                    locker_search = true;
                    direction = Direction.TO_WEST;
                }
                else if(ans == 't')
                {
                    searchTable(visitor, take);
                    table_search = true;
                    direction = Direction.TO_EAST;
                }
                else
                {
                    visitor.tell("Please type the correct value.");
                }
            }
        }
        visitor.tell("You left Games Room ec22657.");
        return Direction.opposite(direction);
    }
    
    public void searchBowl(Visitor visitor, char[] take){
    if(!visitor.hasIdenticalItem(roomKeys))
    {
        visitor.tell("Congratulation! You find a keys inside the bowl!");
        char option = visitor.getChoice("Would you like to take the keys? (y/n)", take);
        if(option == 'y')
        {
            visitor.giveItem(roomKeys);
            visitor.tell("You took the keys.");
            visitor.tell("Award: Five pieces of golds");
            visitor.giveGold(5);
        }
        else if (option == 'n')
        {
            visitor.tell("You didn't took the keys");
        }
        else
        {
            visitor.tell("Please type the correct value.");
        }
    }
    else
    {
        visitor.tell("Nothing can be found here.");
    }
    }
    
    public void searchLocker(Visitor visitor, char[] take){
    if(!visitor.hasIdenticalItem(pen))
    {
        visitor.tell("Congratulation! You find a Pen inside the locker!");
        char option = visitor.getChoice("Would you like to take the pen? (y/n)", take);
        if(option == 'y')
        {
            visitor.giveItem(roomKeys);
            visitor.tell("You took the pen.");
            visitor.tell("Award: Two pieces of golds");
            visitor.giveGold(2);
        }
        else if (option == 'n')
        {
            visitor.tell("You didn't took the pen");
        }
        else
        {
            visitor.tell("Please type the correct value.");
        }
    }
    else
    {
        visitor.tell("Nothing can be found here.");
    }
    }
    
    public void searchTable(Visitor visitor, char[] take){
    if(!visitor.hasIdenticalItem(puzzle))
    {
        visitor.tell("Congratulation! You find a piece of puzzle under the table!");
        char option = visitor.getChoice("Would you like to take the puzzle? (y/n)", take);
        if(option == 'y')
        {
            visitor.giveItem(roomKeys);
            visitor.tell("You took a piece of puzzle.");
            visitor.tell("Award: Three pieces of golds");
            visitor.giveGold(3);
        }
        else if (option == 'n')
        {
            visitor.tell("You didn't took the puzzle");
        }
        else
        {
            visitor.tell("Please type the correct value.");
        }
    }
    else
    {
        visitor.tell("Nothing can be found here.");
    }
        
}
    
}
