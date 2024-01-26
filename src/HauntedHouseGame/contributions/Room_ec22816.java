package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22816 extends Room {
    static final Item[] items = {new Item("Charm Keychain"),
            new Item("Winchester Pair of Socks"),
            new Item("Winchester Gold Tumbler"),
            new Item("Winchester Souvenir Book"),
            new Item("Winchester Glass"),
    };
    static final int[] prices = {1, 2, 3, 4, 1};
    static final Item wallet = new Item("wallet");
    boolean man, drop;
    static boolean light = false;

    public Direction visit(Visitor visitor, Direction from) {
        Random r = new Random();
        char choice;
        Item buy = new Item("");
        man = r.nextBoolean();
        drop = r.nextBoolean();
        visitor.tell("You enter The Mercantile (Winchester Mystery House gift shop)");
        visitor.tell("The gift shop is filled with interesting items.");
        if(!light) {
            visitor.tell("The cashier asks: Hey! Could you turn on the lights?");
            if(visitor.getChoice("Do you turn on the lights?" +
                    "\na) Yes " +
                    "\nb) No", new char[]{'a', 'b'}) == 'a') {
                light = true;
                visitor.tell("Cashier: Thank you so much!");
            }else {
                visitor.tell("Cashier: Hmm.. That's kind of rude :(");
            }
        } else
            visitor.tell("The room is beautifully light by a large chandelier above you.");
        if(man)
            visitor.tell("There's a sketchy man in the corner on your right.");
        if(visitor.getChoice("Would you like to " +
                        "\na) Browse items " +
                        "\nb) Turn around and leave", new char[]{'a', 'b'}) == 'a') {
            visitor.tell("(You approach the counter.)");
            visitor.tell("Welcome to The Mercantile!");
            choice = visitor.getChoice("Please choose from the following souvenirs:" +
                    "\na) " + items[0].name + " - " + prices[0] + " Gold" +
                    "\nb) " + items[1].name + " - " + prices[1] + " Gold" +
                    "\nc) " + items[2].name + " - " + prices[2] + " Gold" +
                    "\nd) " + items[3].name + " - " + prices[3] + " Gold" +
                    "\ne) " + items[4].name + " - " + prices[4] + " Gold", new char[]{'a', 'b', 'c', 'd', 'e'});
            if(choice == 'a') {
                visitor.takeGold(prices[0]);
                visitor.tell("You purchased " + items[0].name + ". You paid " + prices[0] + " Gold.");
                buy = items[0];
            }
            else if(choice == 'b') {
                visitor.takeGold(prices[1]);
                visitor.tell("You purchased " + items[1].name + ". You paid " + prices[1] + " Gold.");
                buy = items[1];
            }
            else if(choice == 'c') {
                visitor.takeGold(prices[2]);
                visitor.tell("You purchased " + items[2].name + ". You paid " + prices[2] + " Gold.");
                buy = items[2];
            }
            else if(choice == 'd') {
                visitor.takeGold(prices[3]);
                visitor.tell("You purchased " + items[3].name + ". You paid " + prices[3] + " Gold.");
                buy = items[3];
            }
            else if(choice == 'e') {
                visitor.takeGold(prices[4]);
                visitor.tell("You purchased " + items[4].name + ". You paid " + prices[4] + " Gold.");
                buy = items[4];
            }
            if(drop) {
                visitor.tell("You notice a hole in the floor.");
                visitor.tell("Oops! You dropped the " + buy.name + " in it.");
                if(visitor.getChoice("Would you like to " +
                        "\na) Ask the cashier for a new one" +
                        "\nb) Accept your losses and exit", new char[]{'a', 'b'}) == 'a') {
                    visitor.tell("You approach the counter.");
                    visitor.tell("You: May I get a new " + buy.name + "?");
                    if(Math.random() < 0.25) {
                        visitor.tell("Cashier: Sure! Here you go!");
                        visitor.giveItem(buy);
                        visitor.tell("You thank the cashier and proceed to leave.");
                    } else {
                        visitor.tell("Cashier: Sorry, no replacements. :(");
                        visitor.tell("Now feeling even more upset, you proceed to leave.");
                    }
                } else {
                    visitor.tell("Your social skills couldn't push you to ask. You go to exit.");
                }
            } else {
                visitor.giveItem(buy);
                visitor.tell("Satisfied with the items you purchased, you go to leave the room.");
            }
        } else {
            visitor.tell("You go to leave the room.");
        }
        if(man)
            return robbery(visitor, from, r);
        else
            visitor.tell("You exit the room.");
        return Direction.TO_NORTH;
    }

    Direction robbery(Visitor visitor, Direction from, Random r) {
        if(r.nextBoolean()) {
            visitor.tell("The sketchy man approaches you as you leave.");
            if(visitor.hasIdenticalItem(wallet)) {
                visitor.tell("He notices your wallet looking pretty empty. He gives you 2 gold.");
                visitor.giveGold(2);
            } else {
                visitor.tell("He forces you to give up 2 gold.");
                visitor.takeGold(2);
                visitor.tell("You swiftly take the North direction exit while panicking.");
                return Direction.TO_NORTH;
            }
        }else {
            visitor.tell("You pass peacefully. The sketchy man ignores you.");
        }
        visitor.tell("You approach the exit.");
        return Direction.TO_EAST;
    }
}
