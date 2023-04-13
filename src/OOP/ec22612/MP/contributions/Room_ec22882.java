package OOP.ec22612.MP.contributions;

import java.util.Random;
/// text 

class Room_ec22882 extends Room {

    private boolean hasWonBefore = false;
    private boolean feelingLucky = false;
    private boolean mageIsInGoodMood = false;
    private final Item Lucky_Person_Prize = new Item("Lucky Person's prize!");/// feelingLucky && !mageIsInGoodMood
    private final Item Loser_Prize = new Item("Loser's prize.");/// !feelingLucky
    private final Item Gamblers_Prize = new Item("Average Gambler's Prize");/// feelingLucky && mageIsInGoodMood

    private int getCurrentGold(Visitor visitor) {
        int total = 0;
        int lastTaken = -1;
        while (lastTaken != 0) {
            lastTaken = visitor.takeGold(10);
            total += lastTaken;
        }

        for (int i = 0; i < total / 10; ++i) {
            visitor.giveGold(10);
        }
        visitor.giveGold(total % 10);

        return total;
    }

    private void addGold(Visitor visitor, int x) {

        for (int i = 0; i < x / 10; ++i) {
            visitor.giveGold(10);
        }
        visitor.giveGold(x % 10);
    }

    public Direction visit(Visitor visitor, Direction initDir) {

        visitor.tell("Good news: You entered the best room!");
        visitor.tell("Bad news: You are controlled by a powerful mage!");

        if (!hasWonBefore) {
            visitor.tell("He will make you bet against your will.");
            visitor.tell("You will have 2 tries to win a lot of gold.");
            visitor.tell("If you don't you will lose all of you gold");

            visitor.tell("You roll two dices. If their sum is bigger than ( >= ) 7 you won!");

            feelingLucky = (new Random()).nextInt(10) > 6; /// 7 8 9. 30%

            mageIsInGoodMood = (new Random()).nextInt(10) > 3; /// 4 5 6 7 8 9. 60%

            if (feelingLucky)
                visitor.tell("You feel lucky.");
            else
                visitor.tell("You don't feel lucky.");

            if (mageIsInGoodMood)
                visitor.tell("And the mage is in a good mood.");
            else
                visitor.tell("And the mage isn't in a good mood.");

            int dummyRandomVar = (new Random()).nextInt(6);
            visitor.tell("Too bad you got only " + Math.min(6 - dummyRandomVar, dummyRandomVar) + " and "
                    + Math.max(6 - dummyRandomVar, dummyRandomVar));

            if (!feelingLucky) {
                dummyRandomVar = (new Random()).nextInt(4);
                visitor.tell("Too bad you got only " + Math.min(4 - dummyRandomVar, dummyRandomVar) + " and "
                        + Math.max(4 - dummyRandomVar, dummyRandomVar));
                visitor.giveItem(Loser_Prize);

                int lastTaken = -1;
                while (lastTaken != 0) {
                    lastTaken = visitor.takeGold(10);
                }

                visitor.tell("You lost all of your gold.");
                visitor.tell("But you got the loser's prize!");
            } else {
                dummyRandomVar = (new Random()).nextInt(8);
                visitor.tell("Too bad you got only " + Math.min(8 - dummyRandomVar, dummyRandomVar) + " and "
                        + Math.max(8 - dummyRandomVar, dummyRandomVar));

                if (mageIsInGoodMood) {
                    visitor.giveItem(Gamblers_Prize);
                    visitor.tell("You won! You get to double you gold!!!");
                    addGold(visitor, getCurrentGold(visitor) * 2);
                }

                if (!mageIsInGoodMood) {
                    visitor.giveItem(Lucky_Person_Prize);
                    visitor.tell("You won in the worst scenario! You get to 10x you gold!!!");
                    addGold(visitor, getCurrentGold(visitor) * 10);
                }

            }

        } else {

            visitor.tell("The mage looks at you for a second.");

            if (visitor.hasEqualItem(Gamblers_Prize))
                visitor.tell("Mage: -Here is just an average gambler.");

            if (visitor.hasEqualItem(Loser_Prize))
                visitor.tell("Mage laughs: - What a loser!!!");

            if (visitor.hasEqualItem(Lucky_Person_Prize))
                visitor.tell("The mage is scared.\nMage: - Wow is this the lucky one?!");
        }
        char dir = visitor.getChoice("Which way would would you like to go? (N, E, S or W) ",
                new char[] { 'N', 'E', 'S', 'W' });
        return askDir(dir, initDir);
    }

    public Direction askDir(char l, Direction initDir) {
        switch (l) {
            case 'N':
                return Direction.TO_NORTH;
            case 'E':
                return Direction.TO_EAST;
            case 'S':
                return Direction.TO_SOUTH;
            case 'W':
                return Direction.TO_WEST;
            default:
                return Direction.opposite(initDir);
        }
    }
}
