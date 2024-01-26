package HauntedHouseGame.contributions;


class Room_ec22451 extends Room{
    int gold = 5;
    char [] walletcolours = {'r','b','g','n'};
    char [] poorman = {'0','1','2','3','4'};
    Item Red_Wallet= new Item("Red Wallet");
    Item Blue_Wallet = new Item("Blue Wallet");
    Item Green_Wallet = new Item("Green Wallet");
    boolean companion = false;
    boolean declined = false;
    public Direction visit(Visitor visitor, Direction direction)
    {
        if(direction == Direction.FROM_NORTH)
        {
            visitor.tell("You stumble on your own foot and drop your wallet, gold spills everywhere. You count your pieces gold.");
            visitor.tell("A rat thief stole 3 pieces of gold from you, you chase him down but lose him. Unlucky!");
            visitor.tell("You now have "+this.gold+" pieces of gold. ");
            visitor.takeGold(3);

        }
        else if(direction == Direction.FROM_EAST)
        {
            visitor.tell("You find a merchant offering one of 3 wallets to you for 1 coin.");
            if(visitor.hasEqualItem(Red_Wallet)|visitor.hasEqualItem(Blue_Wallet)|visitor.hasEqualItem(Green_Wallet))
            {
                visitor.tell("You already have a wallet so you decline the offer.");
            }
            else
            {

                char colour = visitor.getChoice("There are 3 colours, red, blue and green. \n Which do you like the most? (n for none) (r/b/g/n)",walletcolours);
                if(this.gold > 0 | colour == 'n')
                {
                    if(colour == 'r')
                    {
                        visitor.giveItem(Red_Wallet);
                        visitor.tell("You find 2 pieces of gold in your wallet. You now have "+(this.gold+1)+" pieces of gold.");
                        visitor.tell("Red, the most commonly picked colour, solid choice, however, not everyone is a fan of it");
                        visitor.tell("You were targetted for your red wallet, they are probably just jealous");
                        visitor.tell("A group of rats stole 1 piece of gold from you, watch out you bozo!");
                        // No need to  edit number of coins as it equalizes

                    }
                    else if(colour == 'b')
                    {
                        visitor.giveItem(Blue_Wallet);
                        visitor.tell("Can't go wrong with blue.");
                        visitor.tell("You find no pieces of gold in your wallet. ");
                        visitor.takeGold(1);

                    }
                    else
                    {
                        visitor.giveItem(Green_Wallet);
                        visitor.tell("Green?!?! I've seen worse colours :/");
                        visitor.tell("You find 6 pieces of gold in your wallet. You now have "+(this.gold+6)+" pieces of gold, lucky you!");
                        giveGold(5);
                    }
                }
                else
                {
                    visitor.tell("You don't grab a wallet and keep exploring. ");
                }
            }
        }
        else if(direction == Direction.FROM_SOUTH)
        {
            visitor.tell("You keep your head down to not draw unwanted attention");
            visitor.giveGold(7);
            visitor.tell("You found 7 pieces of gold on the floor, lucky you! ");
        }
        else
        {
            visitor.tell("A homeless man begs you for money");
            char give = visitor.getChoice("How many coins do you want to give to the homeless man? (0-4)",poorman);
            if(give == '0')
            {
                visitor.tell("The homeless man chases you down and makes you fall.");
                visitor.tell("You drop 2 coins and the homeless man runs away with it");
                visitor.takeGold(2);
                declined = true;
            }
            else if(give == '4')
            {
                visitor.tell("The homeless man thanks you and now protects you. ");
                companion = true;
                visitor.takeGold(4);
            }
            else
            {
                if(give == '1')
                {
                    visitor.takeGold(1);
                }
                else if(give == '2')
                {
                    visitor.takeGold(2);
                }
                else
                {
                    visitor.takeGold(3);
                }
                visitor.tell("The homeless man thanks you as you keep walking on. ");
            }

        }
        visitor.tell("You get chased by 3 ugly monsters. ");

        if(!companion & !declined)
        {
            visitor.tell("The monsters stole 2 pieces of gold from you before a homeless man saves you. \n You pay the homeless man a coin for being your hero. ");
            visitor.takeGold(3);
            visitor.tell("You walk out the room but the homeless man cannot come with you. ");
            return Direction.TO_NORTH;
        }
        else if(declined)
        {
            visitor.tell("You run out the south door and drop 6 coins but get out alive. ");
            visitor.takeGold(6);
            return Direction.TO_SOUTH;
        }
        else
        {
            visitor.tell("The ugly monsters are defeated by the homeless man. You leave the room but the homeless man cannot follow. ");
            return Direction.TO_WEST;
        }
    }

    public void giveGold(int NumberOfPiecesToGive){
        if (this.gold+NumberOfPiecesToGive > 10){
            System.out.println("You are targetted by a couple rat thiefs for how much gold you have. You now have only 10 pieces of gold. ");
            this.gold = 10;

        }

        else{
            this.gold+=NumberOfPiecesToGive;
        }
    }

    public int takeGold(int NumberOfPiecesToTake){
        if (this.gold-NumberOfPiecesToTake < 1){
            System.out.println("A homeless man feels bad for how poor you are and you now have 1 coin. ");
        }

        else{
            this.gold-=NumberOfPiecesToTake;
        }
        return NumberOfPiecesToTake;
//
    }
}
