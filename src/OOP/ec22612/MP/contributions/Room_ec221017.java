package OOP.ec22612.MP.contributions;

class Room_ec221017 extends Room
{
    //so much change made :3 01.04.2023.
    char [] yesnoChoices = {'y','n'};
    char [] items = {'r','p','f'};
    char [] leaving = {'s','w','n','e'};

    Item hangy = new Item("sturdy rope");
    Item strap = new Item("FN-57 pistol");
    Item sun = new Item("flashlight");

    public Direction visit (Visitor v, Direction d)
    {
        if(d == Direction.FROM_SOUTH)
            v.tell("You have entered the room from its south door.");
        else if(d == Direction.FROM_WEST)
            v.tell("You have entered the room from its west door.");
        else if(d == Direction.FROM_NORTH)
            v.tell("You have entered the room from its north door.");
        else if(d == Direction.FROM_EAST)
            v.tell("You have entered the room from its east door.");
        
        //INTRO
        v.tell("The room is well lit. It feels like a nobleman's living-room.");
        v.tell("You see an old man sitting on the couch in front of a cozy fireplace in a luxurious room. You approach him.");
        v.tell("'Jesus! You scared me. Welcome to the ec221017 room, yeah I know, whoever designed these room names, they are not Jesus-approved'");

        //STORY TIME
        v.tell("'Damn you look crusty as hell, I see the other rooms don't treat you well. All my neighbours are stingy with items and gold.'");
        v.tell("'I would be happy to give you some gold and some items that you might find useful in your journey. The only thing I want in exchange is for you to tell me your story.'");
        char choice1 = v.getChoice("Are you fine with that? (y/n)", yesnoChoices);
        if(choice1 == 'y')
        {
            v.tell("You tell him your story. He just sits there and listens silently except when he ask a question to either understand or help you move to the next part of your life");

            //BESTOWMENT :3
            v.tell("After you finish he smiles, and stands up. He gives you a pouch with 10 gold coins shimmering inside.");
            v.tell("'As promised.'");
            v.giveGold(10);

            v.tell("'And you can choose one item from these 3.'");
            v.tell("You see a thick coil of rope, a FN-57 pistol with a box of bullets and a flashlight appear.");
            char choice2 = v.getChoice("Choose one of them: rope(r) / pistol(p) / flashlight(f)", items);
            if(choice2 == 'r')
            {
                v.giveItem(hangy);
                v.tell("'A very sturdy rope, it will serve you well.'");
            }
            else if (choice2 == 'p')
            {
                v.giveItem(strap);
                v.tell("'A reliable gun. They always solve every problem :3'");
            }
            else
            {
                v.giveItem(sun);
                v.tell("'Flashlights always come in handy.'");
            }

            //LEAVING
            v.tell("'From visitors who returned, I know that the north door leads to the safest room. You might want to go that way.'");
            v.tell("'Of course, you are free to choose.'");
            char choice3 = v.getChoice("Choose the direction you want to leave towards: north(n) / south(s) / east(e) / west(w)", leaving);
            if(choice3 == 'n')
            {
                v.tell("'I wish you good luck'");
                v.tell("You leave the room using the north door.");
                d = Direction.TO_NORTH;
                return d;
            }
            else if(choice3 == 's')
            {
                v.tell("'I wish you good luck'");
                v.tell("You leave the room using the south door.");
                d = Direction.TO_SOUTH;
                return d;
            }
            else if(choice3 == 'e')
            {
                v.tell("'I wish you good luck'");
                v.tell("You leave the room using the east door.");
                d = Direction.TO_EAST;
                return d;
            }
            else // choice3 = w
            {
                v.tell("'I wish you good luck'");
                v.tell("You leave the room using the west door.");
                d = Direction.TO_WEST;
                return d;
            }

        }
        else
        {
            //looser ending
            v.tell("He seems mad. His gentle attitude disappears while his smile becomes cold as he says a 2 sentances with a chilling undertone.");
            v.tell("'Then you have nothing to do here. Leave.'");
            v.tell("You can't react as an invisible hand lifts you by the collar and throws you out the west door.");
            d = Direction.TO_WEST;
            return d;
        }


    }

}
