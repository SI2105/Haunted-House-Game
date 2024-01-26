package HauntedHouseGame.contributions;

class Room_ec22798 extends Room
{
    static final Item key1 = new Item("Key");
    static final Item toy = new Item("Toy Car");
    static final Item torch = new Item("Torch");
    static final Item tape = new Item("Sellotape");
    static final Item batteries = new Item("Batteries");

    boolean cupboard_searched = false;
    boolean batteriesInTorch = false;
    boolean bed_searched = false;
    
    public Direction visit(Visitor visitor, Direction initialDirection)
    
    {
        char[] searchList1 = {'t', 'c'};
        char[] searchList2 = {'t', 'b', 'c'};
        char[] y_n = {'y', 'n'};
        Direction finalDirection = initialDirection;
        visitor.tell("Welcome to room EC22798");
        if (!batteriesInTorch)
        {
            visitor.tell("You can see a table and a cupboard.");
            char search1 = visitor.getChoice("Would you like to search the (t)able or the (c)upboard? (t/c)", searchList1);
            if (search1 == 't')
            {
                searchTable(visitor, y_n);
                finalDirection = Direction.TO_SOUTH;
            }
            else if (search1 == 'c')
            {
                searchCupboard(visitor, y_n);
                finalDirection = Direction.TO_SOUTH;
            }
            else
            {
                visitor.tell("An error occurred.");
            }
        }
        else if (batteriesInTorch)
        {
            visitor.tell("With your torch you can see a table, a bed and a cupboard.");
            char search2 = visitor.getChoice("Would you like to search the (t)able, the (b)ed or the (c)upboard? (t/b/c)", searchList2);
            if (search2 == 't')
            {
                searchTable(visitor, y_n);
                finalDirection = Direction.TO_SOUTH;
            }
            else if (search2 == 'b')
            {
                searchBed(visitor, y_n);
                finalDirection = Direction.TO_SOUTH;
            }
            else if (search2 == 'c')
            {
                searchCupboard(visitor, y_n);
                finalDirection = Direction.TO_SOUTH;
            }
            else
            {
                visitor.tell("An error occurred.");
            }
        }
        visitor.tell("You left room EC22798");
        return finalDirection;
    }

    public void searchTable(Visitor visitor, char[] y_n)
    {
        if (!batteriesInTorch)
        {
            if (!visitor.hasIdenticalItem(toy))
            {
                visitor.tell("You found a toy car.");
                char takeCar = visitor.getChoice("Would you like to take the toy car?", y_n);
                if (takeCar == 'y')
                {
                    visitor.giveItem(toy);
                    visitor.tell("You took the toy car. Glued to the bottom was a piece of gold!");
                    visitor.giveGold(1);
                }
                else if (takeCar == 'n')
                {
                    visitor.tell("You did not take the toy car.");
                }
                else
                {
                    visitor.tell("An error occurred");
                }
            }
            if (!visitor.hasIdenticalItem(torch))
            {
                visitor.tell("You found a torch.");
                char takeTorch = visitor.getChoice("Would you like to take the torch?", y_n);
                if (takeTorch == 'y')
                {
                    visitor.giveItem(torch);
                    visitor.tell("You took the torch. However you find it has no batteries in it.");
                    visitor.giveGold(1);
                }
                else if (takeTorch == 'n')
                {
                    visitor.tell("You did not take the torch.");
                }
                else
                {
                    visitor.tell("An error occurred");
                }
            }
            if (!visitor.hasIdenticalItem(batteries))
            {
                visitor.tell("Luckily you also find some batteries!");
                char takeBatteries = visitor.getChoice("Would you like to put the batteries in the torch?", y_n);
                if (takeBatteries == 'y')
                {
                    visitor.giveItem(batteries);
                    batteriesInTorch = true;
                    visitor.tell("You put the batteries in the torch. Upon turning the torch on you find a bed on the far side of the room.");
                    char searchTheBed = visitor.getChoice("Would you like to search the bed? (y/n)", y_n);
                    if (searchTheBed == 'y')
                    {
                        searchBed(visitor, y_n);
                    }
                }
                else if (takeBatteries == 'n')
                {
                    visitor.tell("You did not put the batteries in the torch.");
                }
                else
                {
                    visitor.tell("An error occurred");
                }
            }
        }
        else if (batteriesInTorch)
        {
            if (visitor.hasIdenticalItem(toy))
            {
                visitor.tell("You found no items on the table.");
            }
            else if (!visitor.hasIdenticalItem(toy))
            {
                visitor.tell("You found a toy car.");
                char takeCar = visitor.getChoice("Would you like to take the toy car?", y_n);
                if (takeCar == 'y')
                {
                    visitor.giveItem(toy);
                    visitor.tell("You took the toy car. Taped to the bottom was a piece of gold!");
                    visitor.giveGold(1);
                    //leave room
                }
                else if (takeCar == 'n')
                {
                    visitor.tell("You did not take the toy car.");
                    //leave room
                }
                else
                {
                    visitor.tell("An error occurred");
                }
            }
        }
        else
        {
            visitor.tell("An error has occurred.");
        }
    }

    public void searchBed(Visitor visitor, char[] y_n)
    {
        if (bed_searched)
        {
            if (visitor.hasIdenticalItem(toy) || visitor.hasIdenticalItem(tape))
            {
                visitor.tell("You did not find anything else in the bed. During your search you dropped some gold under the bed and it mysteriously disappeard. Could the tale of a wild being named Eshan who lurks under beds be true??");
                visitor.takeGold(1);
                //leave room
            }
            else if (!visitor.hasIdenticalItem(toy))
            {
                visitor.tell("You did not find anything else under the bed");
                //leave room
            }
            else
            {
                visitor.tell("An error occurred.");
            }
        }
        else if (!bed_searched)
        {
            visitor.tell("You searched through the bed. You were able to find a key under the pillow. A mysterious hand from underneath the bed handed you some gold. Could it be the rumoured Eshan who lurks under beds??");
            visitor.giveGold(2);
            visitor.giveItem(key1);
            char searchTheCupboard = visitor.getChoice("Do you want to try use the key on the cupboard? (y/n)", y_n);
            if (searchTheCupboard == 'y')
            {
                searchCupboard(visitor, y_n);
            }
            else if (searchTheCupboard == 'n')
            {
                //leave room
            }
        }
        else
        {
            visitor.tell("An error occurred.");
        }
    }

    public void searchCupboard(Visitor visitor, char[] y_n)
    {
        if (visitor.hasIdenticalItem(key1) && !visitor.hasIdenticalItem(tape) && !cupboard_searched)
        {
            visitor.tell("You unlock the cupboard to find a roll of sellotape as well lots of gold!");
            visitor.giveGold(5);
            char takeTape = visitor.getChoice("Would you like to take the sellotape? (y/n)", y_n);
            if (takeTape == 'y')
            {
                visitor.tell("You took the sellotape.");
                visitor.giveItem(tape);
            }
            else if (takeTape == 'n')
            {
                visitor.tell("You did not take the sellotape.");
            }
            else
            {
                visitor.tell("An error occurred.");
            }
        }
        else if (visitor.hasIdenticalItem(key1) && !visitor.hasIdenticalItem(tape) && cupboard_searched)
        {
            visitor.tell("You open the cupboard a roll of sellotape.");
            char takeTape = visitor.getChoice("Would you like to take the sellotape? (y/n)", y_n);
            if (takeTape == 'y')
            {
                visitor.tell("You took the sellotape.");
                visitor.giveItem(tape);
            }
            else if (takeTape == 'n')
            {
                visitor.tell("You did not take the sellotape.");
            }
            else
            {
                visitor.tell("An error occurred.");
            }
        }
        else if (visitor.hasIdenticalItem(key1) && visitor.hasIdenticalItem(tape) && cupboard_searched)
        {
            visitor.tell("You opent the cupboard to find absolutely nothing.");
        }
        else if (!visitor.hasIdenticalItem(key1))
        {
            visitor.tell("You try to opent the cupboard but find it is locked.");
        }
        else
        {
            visitor.tell("An Error has occurred");
        }
    }
}
