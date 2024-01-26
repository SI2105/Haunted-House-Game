package HauntedHouseGame.contributions;

class Room_ec22932 extends Room
{ 
    public Direction visit(Visitor v, Direction d) 
    {
        v.tell("you have entered Room_ec222932");
        char choice = v.getChoice("Would you like to look inside the room? (y/n)", new char[] {'y','n'});
        //If statment to check if the userwants to use the torch.
        if(choice == 'y')
        { 
            v.tell("you just found a torch") ;
            char takeTorch = v.getChoice("Would you like to take the torch? (y/n)", new char[]{'y', 'n'});

            if(takeTorch == 'y') 
            {
                Item torch = new Item("torch");
                v.giveItem(torch);
                char useTorch = v.getChoice("would you like to use the torch? (y/n)", new char[] {'y', 'n'});
                
                if(useTorch == 'y')
                {
                    v.tell("You just found a key");
                    char useKey = v.getChoice("unlock cupboard with key? (y/n)", new char[] {'y', 'n'});
                        
                    if (useKey == 'y'){
                        v.tell("Congratulations! You have found gold");
                        v.giveGold(8);
                    }
                    else{
                        v.giveGold(2);
                    }
                }
                else{
                    v.takeGold(5);
                }
                    
            }
            else
            {
                 char exit = v.getChoice("no more items in room. where would you like to exit (N, S, E, W)?", new char[]{'N', 'S', 'E','W'});
                 if (exit == 'N') 
                 {
                    return Direction.TO_NORTH;    
                 }
                 else if (exit == 'S') 
                 {
                    return Direction.TO_SOUTH;
                 } 
                 else if (exit == 'E')
                 {
                    return Direction.TO_EAST;
                 }
                 else if (exit == 'W')
                 {
                    return Direction.TO_WEST;
                 }
            }
        }
        
        else if(choice == 'n')
        {
            v.tell("bad choice");
            v.takeGold(3);
        }
        
        return Direction.opposite(d);
    }

}
