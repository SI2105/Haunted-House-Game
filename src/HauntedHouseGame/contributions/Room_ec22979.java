package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22979 extends Room{

    final Item chalkboard = new Item("chalkboard");
    final Item brokenLeg = new Item("Broken Leg");
    final Item absinthe = new Item("absinthe");
    final Item ticket = new Item ("Catalina Wine Mixer Ticket");
    Random random = new Random(2);
    final int randomInt = random.nextInt(3);





    public Direction visit(Visitor v, Direction d)
    {
        if(d==Direction.FROM_NORTH)
        {
            v.tell("The room to the North is way more fun. Go back there.");
            v.giveItem(brokenLeg);
            return Direction.TO_NORTH;
        }
        char[] aArray = {'a', 'b', 'c'};

        v.tell("This is the music room.");
        char a = v.getChoice("a) play the piano b) sing or c) drink and chat?", aArray);

        switch(a) {
            case 'a':
                if(randomInt==1) {
                    v.tell("Lovely playing!");
                    v.giveGold(6);
                    v.tell("Here's 6 gold coins for your efforts.");
                }
                else
                    v.tell("That was terrible. You should be embarrassed");
                    v.takeGold(8);
                    v.tell("I've given you 8 gold coins to pay for some lessons.");

                break;
            case 'b':
                if(randomInt==1) {
                    v.tell("Okay but don't quit the day-job");
                    v.giveItem(chalkboard);
                    v.tell("Here's a " + chalkboard.name + ". Scrape your nails on it next time someone asks you to sing; it will sound better. ");

                }
                else{
                    v.tell("You have the voice of an angel!");
                    v.giveItem(ticket);
                    v.tell("Here is a " + ticket.name);
                    v.takeGold(1000);}

                break;
            case 'c':
                v.tell("You have been the best visitor EVER!!! (surreptitiously picks pocket)");
                v.takeGold(10);
                v.tell("Here, take this bottle of " + absinthe.name + " with you.");
                v.giveItem(absinthe);
                break;
            default:
                v.takeGold(5);
        }

        final int directionInt = random.nextInt(4);
        switch(directionInt){
            case 0:
                return Direction.TO_NORTH;
            case 1:
                return Direction.TO_SOUTH;
            case 2:
                return Direction.TO_EAST;
            case 3:
                return Direction.TO_WEST;

        }

        return Direction.TO_WEST;

        }
}
