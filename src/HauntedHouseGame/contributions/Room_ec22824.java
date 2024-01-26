package HauntedHouseGame.contributions;

class Room_ec22824 extends Room {
    
    static final Item HINT = new Item("Hint");
    static final Item FINGER = new Item("Finger");
    static final Item COINS = new Item("Coins");
    static final Item KEY = new Item("Key");

    @Override
    public Direction visit(Visitor yongZhe, Direction dir) {
        yongZhe.tell("Now that you are in a sunny pink princess room, without any memories");
        int coin = 0;
        char[] options = {'a', 'b', 'c', 'd'};
        char choice = yongZhe.getChoice("There are some things you can a) close the curtains to block out the sun b) open the fancy dresser c) pick up coins in the corner of the room d) sit on a stool at the door of the room", options);
        if (choice == 'a') {
            yongZhe.tell("A piece of paper fell from the heavy curtain, which read: IMPORTANT HINT! do NOT open dresser!!!");
            yongZhe.giveItem(HINT);
            yongZhe.giveGold(4);
            coin = coin + 4;
        }
        if (choice == 'b') {
            if (yongZhe.hasIdenticalItem(KEY)) {
                char[] answer = {'a', 'b'};
                char result = yongZhe.getChoice("Do you want to use this key to open dresser? (y/n)", answer);
                if (result == 'y') {
                    yongZhe.tell("Get a bloody finger that leaks out of the white bone then lost all of you coins");
                    yongZhe.takeGold(coin);
                    coin = 0;
                    yongZhe.giveItem(FINGER);
                } else if (result == 'n') {
                    yongZhe.tell("Congratulations on converting your keys into 5 coins!");
                    yongZhe.giveGold(5);
                    coin = coin + 5;
                }
            } else {
                yongZhe.tell("Try to lift the lid but found that dresser requires a key to open");
            }

        }
        if (choice == 'c') {
            if (coin > 0) {
                yongZhe.tell("A closer look at the coin revealed that it was made of chocolate and said: Sit down and enjoy it <3 (at same time disappeared a coin)");
                yongZhe.giveItem(COINS);
                yongZhe.takeGold(1);
                coin = coin - 1;
            } else {
                yongZhe.tell("Fainted after approaching the coin and reappeared in the doorway. Shouldn't we do something else first?");
            }

        }
        if (choice == 'd') {
            yongZhe.tell("After sitting down and feeling something hard under the cushion, lift the cushion and found a key");
            yongZhe.giveItem(KEY);
            yongZhe.takeGold(3);
            coin = coin + 3;
        }
        return dir;
    }
}
