package OOP.ec22612.MP.contributions;

class Room_ec22422 extends Room
{
    public Direction visit(Visitor theVisitor, Direction theDirection)
    {
        //set leaving direction
        Direction finalDirection = Direction.opposite(theDirection);

        //create items in the room
        Item Purse = new Item("Purse");
        Item Wallet = new Item("Wallet");

        //Tell user about the items
        theVisitor.tell("You have found a key.");
        theVisitor.tell("There are 2 chests in front of you.");
        theVisitor.tell("You can only open 1");

        theVisitor.tell("What will you do?");
        theVisitor.tell("l: Open the left chest.");
        theVisitor.tell("r: Open the right chest.");

        char[] decision = {'l','r'};
        char oneToOpen = theVisitor.getChoice("Make your choice", decision);

        //The left chest gives a purse
        //The right chest gives a wallet

        if (oneToOpen == 'l')
        {
            theVisitor.tell("You opened the left chest");
            theVisitor.tell("You found a purse");
            theVisitor.giveItem(Purse);
            theVisitor.tell("It contains 5 coins");
            theVisitor.giveGold(5);
        }

        if (oneToOpen == 'r')
        {
            theVisitor.tell("You opened the right chest");
            theVisitor.tell("You found a wallet");
            theVisitor.giveItem(Wallet);
            theVisitor.tell("It contains a photo");
        }

        if (theVisitor.hasEqualItem(Wallet))
        {
            theVisitor.tell("A man approaches you");
            theVisitor.tell("Man: I see you have the photo from that wallet");
            theVisitor.tell("Man: May I have it?");
            theVisitor.tell("y: Yes");
            theVisitor.tell("n: No");

            char[] toGive = {'y','n'};
            char give = theVisitor.getChoice("Make your choice", toGive);

            if (give == 'y')
            {
                theVisitor.tell("Man: Thank you so much");
                theVisitor.tell("Man: Take this");
                theVisitor.tell("You recieve 8 coins");
                theVisitor.giveGold(8);
            }

            if (give == 'n')
            {
                theVisitor.tell("Man: Oh well");
                theVisitor.tell("Man: Bye Bye");
            }
        }

        theVisitor.tell("You now decide its time to move on");
        theVisitor.tell("You leave the room in the opposite direction you entered");
        return finalDirection;
    }
}
