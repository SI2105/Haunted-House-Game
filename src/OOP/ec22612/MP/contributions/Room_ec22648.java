package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ec22648 extends Room
{
    boolean stolen = false; // Keeps track of whether a visitor has stolen an item
    boolean checkHaunted = false; // Keeps track of whether a visitor has been haunted or not

    // Creating items that the player may pick up during their visit to my room
    static final Item[] itemList = {new Item("Stained Glass Shard"),
            new Item("Jar of Souls"),
            new Item("Melted Wax Candle"),
            new Item("1800s Vintage Coin"),
            new Item("Dusty Journal"),
    };

    public Direction visit(Visitor visitor, Direction direction)
    {
        Random random = new Random();

        visitor.tell("Welcome to the Winchester Mystery House Collection Room, mind your step!");
        visitor.tell("Feel free to browse the various artifacts located around the room!");
        visitor.tell("You remember that you attend QMUL and are currently in £9250 of debt, a whisper in your head tells you to steal one of these rare artifacts.");
        char choice = visitor.getChoice("Would you like to steal the: "
                + "\na) " + itemList[0]
                + "\nb) " + itemList[1]
                + "\nc) " + itemList[2]
                + "\nd) " + itemList[3]
                + "\ne) " + itemList[4]
                + "\nf) None, I'm a good person", new char[]{'a', 'b', 'c', 'd', 'e', 'f'});

        if (choice == 'b')
        {
            visitor.giveItem(itemList[1]);
            stolen = true;
            if (random.nextInt(5) != 0) // 80% chance to get haunted
            {
                checkHaunted = true;
                visitor.tell("The lid of the jar dislodges and the air around you begins to thicken.");
                visitor.tell("You hear a quiet mutter from under the cabinet... 'whhyy aaree youu iin myy hoousee?'");
                visitor.tell("The room silences and you hear an eerie ring followed by the locking of the door behind you.");
                visitor.tell("A hand reaches out and pulls you in from the east door, you hear the cluttering of your gold coins falling on the floor.");
                visitor.takeGold(4);
                return Direction.TO_EAST;
            }
        }
        else if (choice == 'a' || choice == 'c' || choice == 'd' || choice == 'e')
        {
            stolen = true;
            if (choice == 'a')
            {
                visitor.giveItem(itemList[0]);
            }
            else if (choice == 'c')
            {
                visitor.giveItem(itemList[2]);
            }
            else if (choice == 'd')
            {
                visitor.giveItem(itemList[3]);
            }
            else if (choice == 'e')
            {
                visitor.giveItem(itemList[4]);
            }
        }
        if (choice == 'f')
        {
            visitor.tell("I hope you are having a good time! Please take this suspicious cookie from Maid Marisa.");
            visitor.giveItem(new Item("Suspicious Cookie"));
            visitor.tell("Please also enjoy these complimentary *chocolate* gold coins :)");
            visitor.giveGold(3);
            char choice2 = visitor.getChoice("Which way would you like to leave the room? + "
                    + "\na) North"
                    + "\nb) East"
                    + "\nc) South"
                    + "\nd) West", new char[]{'a', 'b', 'c', 'd'});
            if (choice2 == 'a')
            {
                return Direction.TO_NORTH;
            }
            else if (choice2 == 'b')
            {
                return Direction.TO_EAST;
            }
            else if (choice2 == 'c')
            {
                return Direction.TO_SOUTH;
            }
            else if (choice2 == 'd')
            {
                return Direction.TO_WEST;
            }
            else
            {
                visitor.tell("Not sure what you mean, you can leave opposite to the way you came.");
                return Direction.opposite(direction);
            }
        }
        if (!checkHaunted && stolen)
        {
            if (random.nextInt(2) == 0) // 50% chance of Maid Marisa entering the room
            {
                visitor.tell("Maid Marisa enters the room to fulfill her cleaning duties realising that one of the artifacts is missing.");
                visitor.tell("She asks if you have seen where it is.");
                char choice3 = visitor.getChoice("a) No, I haven't seen it...\nb) Yes, it's right here!", new char[]{'a', 'b'});
                if (choice3 == 'a')
                {
                    if (random.nextInt(5) != 0) // 80% chance of her suspecting you
                    {
                        visitor.tell("Maid Marisa suspects that you are lying... you suffer the consequences.");
                        visitor.tell("You are thrown out of the room, you lose some gold coins as you fall to the floor.");
                        visitor.takeGold(5);
                        return direction.TO_EAST;
                    }
                    else
                    {
                        visitor.tell("'Hmm, I better go look for it then.' says Maid Marisa.");
                        visitor.tell("You manage to successfully steal the artifact and sneak out of the opposite door without anyone looking.");
                        return Direction.opposite(direction);
                    }
                }
                else if (choice3 == 'b')
                {
                    if (random.nextInt(2) == 0) // 50% chance of her thinking you are lying
                    {
                        visitor.tell("'What's that you're hiding behind your back?' says Maid Marisa.");
                        visitor.tell("You are thrown out of the room, you lose some gold coins as you fall to the floor.");
                        visitor.takeGold(5);
                        return Direction.TO_EAST;
                    }
                    else
                    {
                        visitor.tell("You point in the north direction to Maid Marisa, running out of the south door while she is distracted");
                        visitor.tell("You manage to successfully steal the artifact and sneak out of the opposite door without anyone looking.");
                        return Direction.opposite(direction);
                    }
                }
            }
            else
            {
                visitor.tell("You manage to successfully steal the artifact and sneak out of the opposite door without anyone looking.");
                return Direction.opposite(direction);
            }
        }
        return Direction.opposite(direction);
    }
}
