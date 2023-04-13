package OOP.ec22612.MP.contributions;

import java.util.Arrays;
import java.util.Random;


class Room_ec22898 extends Room
{
    //variables
    char choice; //stores the choices of the visitor
    int pos = 10; //integer version, it will be updates with each input
    int Gold; // gold store in the shop...
    Item[] itemsCollection = new Item[pos]; //collection of all the items the shop has or had
    String[] stockRecord = new String[pos]; //record of the stock of all the items
    int[] pricesRecord = new int[pos]; //prices record of all the items the shop has or had
    Visitor ClassVisitor;

    //constructor
    Room_ec22898()
    {
        choice = 'n';

        Gold = 100;

        itemsCollection[0] = new Item("Flashlight");
        itemsCollection[1] = new Item("Batteries");
        itemsCollection[2] = new Item("UV-light");
        itemsCollection[3] = new Item("Matches");
        itemsCollection[4] = new Item("Candle");
        itemsCollection[5] = new Item("Salt");
        itemsCollection[6] = new Item("OuijaBoard");
        itemsCollection[7] = new Item("Camera");
        itemsCollection[8] = new Item("Tripod");
        itemsCollection[9] = new Item("Headphones");

        Arrays.fill(stockRecord, "in Stock");

        pricesRecord[0] = 3;
        pricesRecord[1] = 1;
        pricesRecord[2] = 6;
        pricesRecord[3] = 1;
        pricesRecord[4] = 2;
        pricesRecord[5] = 1;
        pricesRecord[6] = 5;
        pricesRecord[7] = 10;
        pricesRecord[8] = 2;
        pricesRecord[9] = 5;
    }

    //println but makes it easier so, I don't have to pass visitor each time I need to print something to the user...
    void tell(String text)
    {
        ClassVisitor.tell(text);
    }

    void tell(int text)
    {
        ClassVisitor.tell("" + text);
    }

    // Returns visitor's choice.
    char getChoice(String text, char[] inputArray)
    {
        return ClassVisitor.getChoice(text, inputArray);
    }

    // Returns true if item is accepted.
    boolean giveItem(Item itemGivenToVisitor)
    {
        return ClassVisitor.giveItem(itemGivenToVisitor);
    }

    // Returns true if visitor has the identical (==) item.
    boolean hasIdenticalItem(Item itemToCheckFor)
    {
        return ClassVisitor.hasIdenticalItem(itemToCheckFor);
    }

    // Returns true if visitor has an equal item (same name).
    boolean hasEqualItem(Item itemToCheckFor)
    {
        return ClassVisitor.hasEqualItem(itemToCheckFor);
    }

    //this method gives gold to the visitor... presumably from the house pool of gold
    void giveGold(int numberOfPiecesToGive)
    {
        ClassVisitor.giveGold(numberOfPiecesToGive);
    }

    // Returns number of pieces actually obtained from visitor.
    int takeGold(int numberOfPiecesToTake)
    {
        return ClassVisitor.takeGold(numberOfPiecesToTake);
    }


    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom)
    {
        ClassVisitor = visitor;
        
        Random rand = new Random();
        int rnd;

        if(directionVistorArrivesFrom == Direction.FROM_SOUTH)
        {
            printConfetti();
            WheelSpin(Gold);
        }
        else if((directionVistorArrivesFrom == Direction.FROM_NORTH) || (directionVistorArrivesFrom == Direction.FROM_EAST) || (directionVistorArrivesFrom == Direction.FROM_WEST))
        {
            //you could add bonus if they heard about this shop from others so if they have a pamphlet which would be an item
            //check their pamphlet depending on which version of the pamphlet it is can determine which room promoted us giving the visitor from that room some gold when they visit our room
            //but this only works if there are multiple visitors going around it would be chaos but fun...

            tell("Oh Hello my friend, Welcome to the Room898!!!");

            printConfetti();

            tell("I actually sell stuff did you know. I converted this room into a shop, " +
                    "does it look nice with all that lighting and relaxing music");

            //choice updated for interaction 1
            choice = getChoice("Doesn't the room look nice? ('y' = Yes/'n' = No)", new char[]{'y', 'n'});
            
            if(choice == 'y')
            {
                tell("I know right, that's the vibe I was going for... with these scary scary rooms and arms dealers I couldn't keep up so I made this place nice and warm, " +
                        "\nno demons to worry about... huhhh so calm here...");
            }
            else if(choice == 'n')
            {
                tell("Oh well, I tried making it nice for everyone");
            }

            //choice updated for interaction 2
            choice = getChoice("SO!!!, would you like to take a look at what I've got? ('y' = Yes/'n' = No)", new char[]{'y', 'n'});

            if(choice == 'y')
            {
                tell("I know right that's vibe I was going for");
                tell("with these scary scary rooms and arms dealers I couldn't keep up");
                tell("so I made this place nice and warm, no demons to worry about... huhhh so calm here...");
                shopChoices();
            }
            else if(choice == 'n')
            {
                tell("Oh well, I tried making it nice for everyone");
            }
        }

        //returns something in default
        return askReturnDirection(visitor);
    }


    //calls method to show the items and asks the visitor to select an item then ticks that item sold off as out of stock
    void shopChoices()
    {
        //shows the items to the visitor
        printItems();
        choice = getChoice
                ("What item would you like to have ? (pick letter)",
                        new char[]{'a','b','c','d','e','f','g','h','i','j'}
                );

        //entering a dummy
        Item TransactionItem = new Item("dummy-item-should-be-changes");

        //switching to the choice of the visitor...
        switch (choice)
        {
            case 'a':
                pos = 0;
                TransactionItem = itemsCollection[0];
                break;
            case 'b':
                pos = 1;
                TransactionItem = itemsCollection[1];
                break;
            case 'c':
                pos = 2;
                TransactionItem = itemsCollection[2];
                break;
            case 'd':
                pos = 3;
                TransactionItem = itemsCollection[3];
                break;
            case 'e':
                pos = 4;
                TransactionItem = itemsCollection[4];
                break;
            case 'f':
                pos = 5;
                TransactionItem = itemsCollection[5];
                break;
            case 'g':
                pos = 6;
                TransactionItem = itemsCollection[6];
                break;
            case 'h':
                pos = 7;
                TransactionItem = itemsCollection[7];
                break;
            case 'i':
                pos = 8;
                TransactionItem = itemsCollection[8];
                break;
            case 'j':
                pos = 9;
                TransactionItem = itemsCollection[9];
                break;
            case 'k':
                pos = 10;
                WheelSpin(Gold);
                break;
            default:
                pos = -1;
                tell("input not returned...");
                break;
        }

        //doesn't cause an error if the wheel spin option is selected...
        if(!(hasEqualItem(TransactionItem) || hasIdenticalItem(TransactionItem)) && pos != 10)
        {
            int TransactionGold = takeGold(pricesRecord[pos]);

            //once the gold has been collected from the visitor the transaction is completed...

            if(TransactionGold == pricesRecord[pos])
            {
                Gold += TransactionGold;
                stockRecord[pos] = "Out of stock";

                if(!giveItem(TransactionItem))
                {
                    giveGold(TransactionGold);
                }

                tell(Gold);
            }
        }
        else
        {
            tell("Oh, it seems like you already have this item.");
            tell("sorry... but I'm gonna have to ask you to leave");
        }
    }

    //this item checks which items are available and prints the options and asks the user for a number...
    void printItems()
    {
        tell("a: " + itemsCollection[0].name + ", Stock: " + stockRecord[0] + ", Price: " + pricesRecord[0] + " Gold");
        tell("b: " + itemsCollection[1].name + ", Stock: " + stockRecord[1] + ", Price: " + pricesRecord[1] + " Gold");
        tell("c: " + itemsCollection[2].name + ", Stock: " + stockRecord[2] + ", Price: " + pricesRecord[2] + " Gold");
        tell("d: " + itemsCollection[3].name + ", Stock: " + stockRecord[3] + ", Price: " + pricesRecord[3] + " Gold");
        tell("e: " + itemsCollection[4].name + ", Stock: " + stockRecord[4] + ", Price: " + pricesRecord[4] + " Gold");
        tell("f: " + itemsCollection[5].name + ", Stock: " + stockRecord[5] + ", Price: " + pricesRecord[5] + " Gold");
        tell("g: " + itemsCollection[6].name + ", Stock: " + stockRecord[6] + ", Price: " + pricesRecord[6] + " Gold");
        tell("h: " + itemsCollection[7].name + ", Stock: " + stockRecord[7] + ", Price: " + pricesRecord[7] + " Gold");
        tell("i: " + itemsCollection[8].name + ", Stock: " + stockRecord[8] + ", Price: " + pricesRecord[8] + " Gold");
        tell("j: " + itemsCollection[9].name + ", Stock: " + stockRecord[9] + ", Price: " + pricesRecord[9] + " Gold");
        tell("k: Wheel Spin!!!, price: 2 Gold");
    }

//    //this method checks if the item exists in the itemsSold array and returns if true
//    boolean checkIfSold()
//    {
//        for(int i = 0; i < itemsCollection.length; i++)
//        {
//            for(int j = 0; j < itemsSold.length; j++)
//            {
//                if(itemsCollection[i].name.equals(itemsSold[j].name))
//                {
//                    return true;//meaning item has been sold and therefore cannot be purchased
//                }
//            }
//        }
//
//        return false;
//    }

    //this method does a wheel spin meaning it selects an option at random out of the below 5 and returns it
    void WheelSpin(int Gold)
    {
        if(Gold < 10)
        {
            printConfetti();
            char choice = getChoice("Do you wanna spin the wheel, ('y' for Yes/'n' for No)", new char[]{'y', 'n'});
            if(choice == 'y')
            {
                //make the spin wheel...
                tell("Wheel spin under construction...");
            }
            else
            {
                tell("you missed a good opportunity, either way see you soon");
            }
        }
    }

    //method asks the visitor which way they wish to enter and return it
    Direction askReturnDirection(Visitor visitor)
    {
        //setting default to SOUTH so will not need an if statement for that case...
        Direction direction = Direction.TO_SOUTH;
        String dString = "SOUTH";

        //this lets the visitor choose which direction they want to go
        char choice = getChoice("What direction would you like to go next? ('N' or 'S' or 'W' or 'E')",
                new char[]{'N', 'S', 'E', 'W'});

        //different choices will give differnt results...
        if (choice == 'N')
        {
            dString = "NORTH";
            direction = Direction.TO_NORTH;
        }
        else if (choice == 'W')
        {
            dString = "WEST";
            direction = Direction.TO_WEST;
        }
        else if (choice == 'E')
        {
            dString = "EAST";
            direction = Direction.TO_EAST;
        }

        tell("Being sent through " + dString + " exi" +
                "t");

        //returns south as in default
        return direction;
    }

    //"        .  .  .  .  .";
    //"      .       |       .";
    //"    .         |         .";
    //"  .           |           .";
    //"._____________|____________.";
    //"  .           |           .";
    //"    .         |         .";
    //"      .       |       .";
    //"        .  .  .  .  .";


    //prints confetti
    public void printConfetti()
    {
        String C1 = "  -' # '    ; '&  ; * '* =  / >:  .-  '  ";
        String C2 = "$ ' ,     ; # <  '  =     ; '   #   #   -";
        String C3 = "    £ ##          ''  ]  #  ~   -+=  --  ";
        String C4 = "!!@ ;.         ,  ' ~ '   '    '~  * :;<<";
        String C5 = "> | ¬   ` `    `    `  ~  ' #  < /  ) *  ";
        String C6 = " £!   $% !--  ''  ?  #  ``           --  ";
        String C7 = "!!# ;.         ,  ' ~ '   '   '#~  * :;<<";
        String C8 = "$ ' ,     ; % #  '  =     ; '   #   #   -";
        String C9 = " £!   $% !--  ''  ?  #  ``           --  ";
        String C10 = "   (   -  #  '' :# < ; `¬    ! # }][ ~ #";

        tell(C1);
        tell(C2);
        tell(C3);
        tell(C4);
        tell(C5);
        tell(C6);
        tell(C7);
        tell(C8);
        tell(C9);
        tell(C10);
    }
}
