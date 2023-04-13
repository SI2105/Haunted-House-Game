package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ec22415 extends Room {
    static final Item winchester = new Item("Model 1873 Winchester repeating rifle (.22)");
    static final Item bullets = new Item("15 round magazine for Winchester Model 1873 chambered in .22");

    boolean beastIsDead = false;

    public Direction visit(Visitor v, Direction d) {
        int limit = 1;
        int interact_counter = 0;

        where(v, d);

        welcome(v);

        if((v.hasEqualItem(winchester) & v.hasEqualItem(bullets)) & beastIsDead) {
            switch (v.getChoice(getStringOfChoices(), getArrayOfPossibleChoices())) {
                case 'a':
                    goldGivenToVisitor(v); interact_counter += 1; break;
                case 'b':
                    goldTakenFromVisitor(v); interact_counter += 1; break;
                case 'c':
                    return Direction.TO_NORTH;
                case 'd':
                    return Direction.TO_SOUTH;
                case 'e':
                    return Direction.TO_EAST;
                case 'f':
                    return Direction.TO_WEST;
                case 'g':
                    return Direction.opposite(d);
            }
        }

        if(!v.hasEqualItem(winchester)) {
            giveGun(v);
        }
        else {
            if(!v.hasEqualItem(bullets)) {
                giveBullets(v);
            }
        }

        if(v.hasEqualItem(winchester) & v.hasEqualItem(bullets)) {
            if(!beastEvent(v)) {
                switch (v.getChoice(getStringOfChoicesAtLimit(), getArrayOfPossibleChoicesAtLimit())) {
                    case 'a':
                        return Direction.TO_NORTH;
                    case 'b':
                        return Direction.TO_SOUTH;
                    case 'c':
                        return Direction.TO_EAST;
                    case 'd':
                        return Direction.TO_WEST;
                    case 'e':
                        return Direction.opposite(d);
                }
            }
            else {
                beastIsDead = true;
            }
        }

        switch (v.getChoice(getStringOfChoices(), getArrayOfPossibleChoices())) {
            case 'a':
                goldGivenToVisitor(v); interact_counter += 1; break;
            case 'b':
                goldTakenFromVisitor(v); interact_counter += 1; break;
            case 'c':
                return Direction.TO_NORTH;
            case 'd':
                return Direction.TO_SOUTH;
            case 'e':
                return Direction.TO_EAST;
            case 'f':
                return Direction.TO_WEST;
            case 'g':
                return Direction.opposite(d);
        }

        if(interact_counter == limit) {
            switch (v.getChoice(getStringOfChoicesAtLimit(), getArrayOfPossibleChoicesAtLimit())) {
                case 'a':
                    return Direction.TO_NORTH;
                case 'b':
                    return Direction.TO_SOUTH;
                case 'c':
                    return Direction.TO_EAST;
                case 'd':
                    return Direction.TO_WEST;
                case 'e':
                    return Direction.opposite(d);
            }
        }

        return Direction.opposite(d);
    }

    private static void where(Visitor visitor, Direction direction) {
        if (direction == Direction.FROM_NORTH) {
            visitor.tell("You came from the North");
        }
        else if (direction == Direction.FROM_EAST) {
            visitor.tell("You came from the East");
        }
        else if (direction == Direction.FROM_SOUTH) {
            visitor.tell("You came from the South");
        }
        else if (direction == Direction.FROM_WEST) {
            visitor.tell("You came from the West");
        }
    }

    private static void welcome(Visitor visitor) {
        visitor.tell("Welcome to Room ec22415!");
        visitor.tell("This house is very spooky o_O. So take this Model 1873 Winchester repeating rifle" +
                ", if you don't already have one, to stay safe!");
        visitor.tell("This is the Winchester mystery house after all. " +
                "Visit https://en.wikipedia.org/wiki/Winchester_Mystery_House for more info :D");
    }

    private static void giveGun(Visitor visitor) {
        visitor.tell("Here you go!");
        print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⢀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣈⣧⣴⣿⣶⣶⣶⣶⣶⣶⣶⣶⣶⣾⣿⣿⣷⣶⣾⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣾⣿⡶⢾\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⢀⣀⣤⣴⣾⣿⣿⣿⣿⣿⣿⠿⡿⣿⣿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠟⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⢹\n" +
                "⢠⣀⣀⣀⣀⣤⣤⣶⣶⣾⣿⣿⣿⣿⣾⣿⣿⣿⣿⡿⠿⡉⡋⢉⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠻⢛⣏⣠⣄⠰⠟⠷⠏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⢸⣿⣿⣿⣿⣿⣿⣿⡿⠛⠋⠁⠀⠀⠀⠀⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠶⢸⣿⡿⠿⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        if(!visitor.giveItem(winchester)) {
            visitor.tell("Suit your self!");
        }
        else {
            visitor.tell("I can only give you one item. Sorry, I have no ammunition on me. " +
                    "Hopefully someone else in this house has some bullets. Good luck to you!");
        }
    }

    private static void giveBullets(Visitor visitor) {
        visitor.tell("Here is your ammunition, happy hunting!");
        print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠷⠶⠤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣷⣶⣦⣤⣄⣉⠙⠛⠳⠶⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠿⠉⠛⠻⠿⢿⣿⣿⣿⣿⣶⡆⢠⣿⣿⣶⣦⣄⡀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣴⡄⠀⠀⠀⠀⠀⠀⠉⠉⠛⠛⠀⠘⠿⠿⢿⣿⣿⣿⣶⣄⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣰⣟⠛⠲⢦⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣰⣿⣿⣿⣶⣤⣄⡉⠛⠳⢶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠉⠁⠈⠙⠻⠿⣿⣿⣿⣶⣤⣀⠁⣠⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⢠⣿⣅⠀⠀⠀⠀⠀⠀⠉⠛⠿⢿⠏⢰⣿⣿⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⣰⣿⣤⡉⠛⠶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠛⠛⠿⠷⠄⠀⠀⠀⠀\n" +
                "⠀⠰⠟⠻⣿⣿⣷⣦⣄⠙⠻⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠉⠛⢿⣿⣿⣶⣄⡉⠋⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠿⡿⠃⣰⣿⣿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⠿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        if(!visitor.giveItem(bullets)) {
            visitor.tell("Suit Yourself!");
        }
        else {
            visitor.tell("Happy Hunting");
        }
    }

    private static boolean beastEvent(Visitor visitor) {
        boolean isBeastDead = false;
        visitor.tell("A beast from  T  H  E    V  O  I  D  has appeared :O");
        switch (visitor.getChoice(getStringOfChoicesAtBeast(), getArrayOfPossibleChoicesAtBeast())) {
            case 'a':
                visitor.tell("You killed the beast with one bullet! Nice shot!");
                return !isBeastDead;
            case 'b':
                visitor.tell("Run away!");
                return isBeastDead;
        }
        return isBeastDead;
    }

    private static String getStringOfChoices() {
        return "What now? a-g \n" +
                "a) get random amount of gold " +
                "b) lose random amount of gold " +
                "c) go north " +
                "d) go south " +
                "e) go east " +
                "f) go west " +
                "g) go in opposite direction";
    }

    private static char[] getArrayOfPossibleChoices() {
        char[] choices = new char[7];
        choices[0] = 'a';
        choices[1] = 'b';
        choices[2] = 'c';
        choices[3] = 'd';
        choices[4] = 'e';
        choices[5] = 'f';
        choices[6] = 'g';
        return choices;
    }

    private static String getStringOfChoicesAtLimit() {
        return "What now? a-e \n" +
                "a) go north " +
                "b) go south " +
                "c) go east " +
                "d) go west " +
                "e) go in opposite direction";
    }

    private static char[] getArrayOfPossibleChoicesAtLimit() {
        char[] choices = new char[5];
        choices[0] = 'a';
        choices[1] = 'b';
        choices[2] = 'c';
        choices[3] = 'd';
        choices[4] = 'e';
        return choices;
    }

    private static String getStringOfChoicesAtBeast() {
        return "What now? a-b \n" +
                "a) Kill the Beast " +
                "b) Run away from the Beast";
    }

    private static char[] getArrayOfPossibleChoicesAtBeast() {
        char[] choices = new char[2];
        choices[0] = 'a';
        choices[1] = 'b';
        return choices;
    }

    private static void goldGivenToVisitor(Visitor visitor) {
        Random r = createRand();
        int gold = r.nextInt(10) + 1;
        visitor.giveGold(gold);
    }

    private static void goldTakenFromVisitor(Visitor visitor) {
        Random r = createRand();
        int gold = r.nextInt(10) + 1;
        if(gold > 7) {
            prTroll();
            visitor.tell("You Mad???");
        }

        visitor.takeGold(gold);
    }

    private static void prTroll() {
        print("░░░░░▄▄▄▄▀▀▀▀▀▀▀▀▄▄▄▄▄▄░░░░░░░\n" +
                "░░░░░█░░░░▒▒▒▒▒▒▒▒▒▒▒▒░░▀▀▄░░░░\n" +
                "░░░░█░░░▒▒▒▒▒▒░░░░░░░░▒▒▒░░█░░░\n" +
                "░░░█░░░░░░▄██▀▄▄░░░░░▄▄▄░░░░█░░\n" +
                "░▄▀▒▄▄▄▒░█▀▀▀▀▄▄█░░░██▄▄█░░░░█░\n" +
                "█░▒█▒▄░▀▄▄▄▀░░░░░░░░█░░░▒▒▒▒▒░█\n" +
                "█░▒█░█▀▄▄░░░░░█▀░░░░▀▄░░▄▀▀▀▄▒█\n" +
                "░█░▀▄░█▄░█▀▄▄░▀░▀▀░▄▄▀░░░░█░░█░\n" +
                "░░█░░░▀▄▀█▄▄░█▀▀▀▄▄▄▄▀▀█▀██░█░░\n" +
                "░░░█░░░░██░░▀█▄▄▄█▄▄█▄████░█░░░\n" +
                "░░░░█░░░░▀▀▄░█░░░█░█▀██████░█░░\n" +
                "░░░░░▀▄░░░░░▀▀▄▄▄█▄█▄█▄█▄▀░░█░░\n" +
                "░░░░░░░▀▄▄░▒▒▒▒░░░░░░░░░░▒░░░█░\n" +
                "░░░░░░░░░░▀▀▄▄░▒▒▒▒▒▒▒▒▒▒░░░░█░\n" +
                "░░░░░░░░░░░░░░▀▄▄▄▄▄░░░░░░░░█░░");
    }

    public static <T> void print(T s) {
        System.out.println(s);
    }

    public static Random createRand() {
        return new Random();
    }

}

