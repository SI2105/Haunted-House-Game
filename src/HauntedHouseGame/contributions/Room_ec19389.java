package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec19389 extends Room{

    //defines a class for a chest objects
    static class Chest {
        boolean isUnlocked;
        int gold;
        Item itemInChest;

        //constructor for Chest (sets isOpened and isUnlocked to be false)
        Chest(int gold, Item itemInChest){
            this.isUnlocked = false;
            this.gold = gold;
            this.itemInChest = itemInChest;
        }

        //sets unlockChest to true
        private void unlockChest(){
            this.isUnlocked = true;
        }

        //returns the amount of Gold in the chest
        private int getGoldCount(){
            return this.gold;
        }
        private int takeGoldFromChest() {
            int goldAmount = this.gold;
            this.gold = 0;
            return goldAmount;
        }
    }

    /*method which takes visitor and the chest key items and asks the visitor to guess a number. If guess correctly,
    a key will be awarded*/
    private void numberGuessingGame(Visitor v, Item chestKey){
        char[] numbers = {'1','2','3','4','5'};
        Random rd = new Random();
        int actualAnswerPos = rd.nextInt(4);
        char actualAnswer = numbers[actualAnswerPos];

        char visitorAnswer = v.getChoice("What number do you guess?",numbers);

        if (visitorAnswer==actualAnswer){
            v.tell("nice one, you guessed right. Here's a key");
            v.giveItem(chestKey);
        } else {
            v.tell("you guessed wrong, no key for you! hehe");
        }
        return;
    }

    /*method which takes a visitor and a chest key item. Allows the visitor purchase items from a vending machine*/
    private void vendingMachine(Visitor v, Item chestKey){
        char[] options = {'a','b','c','d','e'};
        char chosenOption = v.getChoice("*You look at the cracked screen of the vending machine and see there are some decent options*\n" +
                "a - chocolate bar (2 gold)\n" +
                "b - can of soda (2 gold)\n" +
                "c - packet of crisps (1 gold)\n" +
                "d - a wierd looking key (maybe for the chest?) (2 gold)\n" +
                "e - a taco (3 gold) (yh idk why there's a taco in there ¯\\_(ツ)_/¯)",options);

        switch (chosenOption){
            case 'a':
                v.takeGold(2);
                v.giveItem(new Item("bar of chocolate"));
                v.tell("You got a bar of chocolate");
                return;
            case 'b':
                v.takeGold(2);
                v.giveItem(new Item("can of soda"));
                v.tell("You get for a can of soda");
                return;
            case 'c':
                v.takeGold(1);
                v.giveItem(new Item("packet of crisps"));
                v.tell("You got a packet of crisps");
                return;
            case 'd':
                v.takeGold(2);
                v.giveItem(chestKey);
                v.tell("You got a wierd looking key");
                return;
            case 'e':
                v.takeGold(3);
                v.giveItem(new Item("a taco"));
                v.tell("Oh that wasn't a wise choice mate. Those has been in there for some time and judging from that smell, i wouldn't eat that");
                return;
            default:
                v.tell("Guess you just wanted to look at the vending machine. Fine by me. Hope it made you happy.\n" +
                        "didn't make me happy tho, worst investment in my life if you ask me");
                return;
        }
    }

    /*method which takes a visitor and a check key item
    allows the visitor to open and select a drawer and recieve its items*/
    private void openDrawers(Visitor v, Item chestKey){
        v.tell("So this drawer is a little funny\n" +
                "You can only open one drawer at a time.\n" +
                "And once you open one, you cant open another one till you leave the room and come back.\n" +
                "so pick a drawer and test your luck :)s");

        char chosenOption = v.getChoice("a) Open the top drawer\n" +
                "b) Open the middle drawer\n" +
                "c) Open the last drawer",new char[]{'a','b','c'});

        switch (chosenOption){
            case 'a':
                v.tell("You have chosen the top drawer");
                v.giveItem(chestKey);
                return;
            case 'b':
                v.tell("You have chosen the middle drawer");
                v.tell("Seems its empty");
                return;
            case 'c':
                v.tell("You have chosen the last drawer\n" +
                        "You found some old glasses");
                v.giveItem(new Item("Old glasses"));
                return;
        }
    }

    /*method which takes a visitor and a chest key item.
    gives the visitor a choice from 3 chests. One can be opened to receive it's rewards*/
    private void chestSelection(Visitor v, Item chestKey) {

        Chest chest1 = new Chest(2, new Item("boots"));
        Chest chest2 = new Chest(4, new Item("helmet"));
        Chest chest3 = new Chest(6, new Item("chest-plate"));

        v.tell("ok, its that time. Pick a chest, any chest. hope you have a key to open it :D");
        char chestChoice = v.getChoice("a) pick the chest on the left\n" +
                "b) pick the chest in the middle\n" +
                "c) pick the chest on the right",new char[]{'a','b','c'});

        if (v.hasEqualItem(chestKey)){
            switch (chestChoice) {
                case 'a':
                    v.tell("Wise choice.\n" +
                            "You get "+chest1.getGoldCount()+" gold coins");
                    chest1.unlockChest();
                    v.giveGold(chest1.takeGoldFromChest());
                    break;
                case 'b':
                    v.tell("Wise choice.\n" +
                            "You get "+chest2.getGoldCount()+" gold coins");
                    chest2.unlockChest();
                    v.giveGold(chest2.takeGoldFromChest());
                    break;
                case 'c':
                    v.tell("Wise choice.\n" +
                            "You get "+chest3.getGoldCount()+" gold coins");
                    chest3.unlockChest();
                    v.giveGold(chest3.takeGoldFromChest());
                    break;
            }
        }
    }

    //visit method
    public Direction visit(Visitor v, Direction d) {

        //declares two item objetcs
        Item key = new Item("Rusty key");
        Item chestKey = new Item("Gold key");

        //welcome text
        v.tell("Hello Stranger, Welcome.. Please come in and take what ever you want :) Hope you have some coins for the vending machine\n" +
                "I lost the key for that a while back so the snacks just sit there, mocking me... :(\n" +
                "There are also three chests here. If you can find a key, you can get some gold from one of them.\n" +
                "Hopefully you pick a good chest.");

        //checks if the visitor has a specific key. If so, gold is awarded
        if(v.hasEqualItem(key)){
            v.tell("oh you found the key to my safe. You can take half of whats inside i guess");
            v.giveGold(10);
        }

        //available options for visitor
        char choice = v.getChoice("What would you like to do\n" +
                "a) Use vending machine\n" +
                "b) Check the table drawers\n" +
                "c) play a game with the room owner", new char[]{'a','b','c'});

        switch (choice){
            case 'a':
                vendingMachine(v, chestKey);
                break;
            case 'b':
                openDrawers(v, chestKey);
                break;
            case 'c':
                v.tell("So you wanna play a game huh? fine, its a simple game, if you can guess the number im thinking i will give you 3 gold coins.\n" +
                        "its a number between 1 and 5");
                numberGuessingGame(v, chestKey);
                break;
            default:
                v.tell("I guess you don't want to do much. oh well, good luck in the next room");
                break;
        }

        chestSelection(v,chestKey);

        //returns the opposite direction the visitor came from
        return Direction.opposite(d);
    };




}
