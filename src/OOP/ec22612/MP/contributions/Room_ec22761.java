package OOP.ec22612.MP.contributions;

import java.util.ArrayList;
import java.util.Random;

public class Room_ec22761 extends Room {

    private int goldInSlotMachine = 30;
    private boolean machineBroken = false;
    private final int MACHINE_PRICE = 2;
    private final int MACHINE_PRIZE = 10;
    private final int SHOP_PRICE = 10;

    private ArrayList<Item> shopInventory = new ArrayList<>();

    /**
     * Not all terminals support unicode emojis, so this will have to do.
     */
    private final String BANANA =
                    "  ____                                   \n" + // Under 80 characters per line and under 8 lines
                    " |  _ \\                                 \n" +
                    " | |_) | __ _ _ __   __ _ _ __   __ _    \n" +
                    " |  _ < / _` | '_ \\ / _` | '_ \\ / _` | \n" +
                    " | |_) | (_| | | | | (_| | | | | (_| |   \n" +
                    " |____/ \\__,_|_| |_|\\__,_|_| |_|\\__,_|  ";
    private final String LEMON =
                    "  _                                    \n" +
                    " | |                                   \n" +
                    " | |     ___ _ __ ___   ___  _ __      \n" +
                    " | |    / _ \\ '_ ` _ \\ / _ \\| '_ \\ \n" +
                    " | |___|  __/ | | | | | (_) | | | |    \n" +
                    " |______\\___|_| |_| |_|\\___/|_| |_|    ";
    private final String CHERRY =
                    "   _____ _                             \n" +
                    "  / ____| |                            \n" +
                    " | |    | |__   ___ _ __ _ __ _   _    \n" +
                    " | |    | '_ \\ / _ \\ '__| '__| | | | \n" +
                    " | |____| | | |  __/ |  | |  | |_| |   \n" +
                    "  \\_____|_| |_|\\___|_|  |_|   \\__, |\n" +
                    "                               __/ |   \n" +
                    "                              |___/      ";
    private final String[] FRUITS = {BANANA, LEMON, CHERRY};

    /**
     * Creates a new Room for ec22761
     */
    public Room_ec22761() {
        this.populateInventory();
    }

    /**
     * Populates the {@link #shopInventory} of this room.
     * @see #visitShop(Visitor)
     */
    private void populateInventory() {
        this.shopInventory.add(new Item("Key"));
        this.shopInventory.add(new Item("Rope"));
        this.shopInventory.add(new Item("Torch"));
    }

    /**
     * Allows a passed visitor to purchase any items from the
     * shop (An array list called {@link #shopInventory}).
     * <p>
     * If the shop is empty, this method simply returns. Otherwise,
     * it dynamically creates flavor text and a list of options for all items in the shop.
     * <p>
     * If an item is purchased, it is removed from the shop and the price is deducted from the visitor's
     * gold using the safe {@link #takeGoldFromVisitor(Visitor, int)} method.
     *
     * @param v The visitor
     */
    private void visitShop(Visitor v) {
        if(shopInventory.isEmpty()) {v.tell("The shop is empty."); return;}

        v.tell("Welcome to the shop. You see " + shopInventory.size() + " items in glass containers, each requiring " + SHOP_PRICE + " gold to open.");
        char[] options = new char[shopInventory.size()];
        String description = "Would you like to:\n";
        for (int i = 0; i < options.length; i++) {
            options[i] = (char) (97+i); // Java Unicode Trick
            description += options[i] + ") Buy the " + shopInventory.get(i).name + "?\n";
        }
        char choice = v.getChoice(description, options);
        for (int i = 0; i < options.length; i++) {
            if(options[i] == choice && this.takeGoldFromVisitor(v, this.SHOP_PRICE)) {
                v.giveItem(shopInventory.get(i));
                shopInventory.remove(i);
                break;
            }
        }
    }

    /**
     * Safely gives the specified gold to the passed visitor.
     * <p>
     * If the machine does not have enough money to meet the request, the visitor is not
     * passed anything. If the method is called with the gold parameter
     * being greater than 10, it will be changed to 10, and if it is less
     * than 1, it will be changed to 1.
     * <p>
     * Also decrements the instances {@link #goldInSlotMachine} by the passed in gold.
     *
     * @param visitor The visitor to give money to
     * @param gold The amount of gold to give the visitor
     */
    private void giveGoldToVisitor(Visitor visitor, int gold) {
        if((goldInSlotMachine - gold) <= 0) {
            visitor.tell("Not enough money in the machine!");
            return;
        }
        visitor.giveGold(Math.max(1, Math.min(gold, 10))); // Ensure we don't ever give too much gold
        goldInSlotMachine -= Math.max(1, Math.min(gold, 10));
    }

    /**
     * Safely takes the specified gold from the passed visitor.
     * <p>
     * If the visitor does not have enough money to meet the request, the method
     * returns false. If the method is called with the gold parameter
     * being greater than 10, it will be changed to 10, and if it is
     * less than 1, it will be changed to 1.
     * <p>
     * Also increments the instances {@link #goldInSlotMachine} by the passed in gold.
     *
     * @param visitor The visitor to take money from
     * @param gold The amount of gold to take from the visitor
     * @return whether the transaction was successful or not
     */
    private boolean takeGoldFromVisitor(Visitor visitor, int gold) {
        int goldTaken =  visitor.takeGold(Math.max(1, Math.min(gold, 10))); // Ensure we don't ever give too much gold
        if(goldTaken == gold) {
            this.goldInSlotMachine += gold;
            return true;
        } else {
            visitor.tell("You have insufficient funds.");
            visitor.giveGold(goldTaken);
            return false;
        }
    }

    /**
     * Allows the user to play a slot machine once.
     * <p>
     * If all results from the generated String array match, the user wins
     * the amount of gold specified in {@link #MACHINE_PRIZE}.
     *
     * @param visitor The visitor who is playing the game
     */
    private void playSlotMachine(Visitor visitor) {
        if(!takeGoldFromVisitor(visitor, MACHINE_PRICE)) return;

        Random random = new Random();
        String[] result = new String[3];
        for (int i = 0; i < result.length; i++) {
            result[i] = FRUITS[random.nextInt(FRUITS.length)];
        }
        for(String f : result) {
            visitor.tell(f);
        }

        if(result[0].equals(result[1]) && result[1].equals(result[2])) {
            visitor.tell("You win!\nTime to leave, let's not push your luck.");
            giveGoldToVisitor(visitor, MACHINE_PRIZE);
        } else {
            visitor.tell("You lost!\nBest to leave before you lose more money.");
        }
    }

    /**
     * Allows a visitor to visit this room from a passed direction.
     * <p>
     * Questions the visitor if they would like to hit a slot machine,
     * play it or leave the room.
     *
     * @param visitor The visitor visiting
     * @param direction The direction the visitor enters from
     * @return The opposite of the entered direction
     */
    public Direction visit(Visitor visitor, Direction direction) {
        visitor.tell(("You enter an old arcade room from the " + directionToString(direction) + " side." +
                      "\nIn the room sits a slot machine in the corner, a shop on the far wall" +
                      "\nand an exit on the " + directionToString(Direction.opposite(direction)) + " side of the room."));

        char response = visitor.getChoice("a) Turn on the slot machine\nb) Kick the slot machine\nc) Visit the Shop\nd) Leave the room",
                new char[]{'a','b','c', 'd'});

        if(response == 'a') {
            if (machineBroken) {
                visitor.tell("You attempt to turn on the machine but it's been broken!");
            } else {
                char playGame = visitor.getChoice(("The machine is working, and requires " + MACHINE_PRICE +" gold to play,\n" +
                                                   " with a prize of " + MACHINE_PRIZE + " gold. Would you like to? (y/n)"),
                        new char[]{'y', 'n'});
                if (playGame == 'y') {
                    playSlotMachine(visitor);
                }
            }
        } else if (response == 'b') {
            if(machineBroken) {
                visitor.tell("You kick the machine but it's broken and nothing happens.");
            } else {
                visitor.tell("You kick the machine and it sparks! A strange key falls out the bottom," +
                             "\nhowever the machine doesn't look like it will be working again anytime soon.");
                machineBroken = true;
                visitor.giveItem(new Item("Key"));
            }
        } else if (response == 'c') {
            this.visitShop(visitor);
        }

        visitor.tell("You've seen enough of the room. Time to go.");
        return Direction.opposite(direction);
    }

    /**
     * A simple utility method to convert a direction to a String name.
     *
     * @param dir The direction to convert
     * @return The name of the direction
     */
    private String directionToString(Direction dir) {
        if(dir == Direction.FROM_NORTH) return "North";
        if(dir == Direction.FROM_EAST) return "East";
        if(dir == Direction.FROM_SOUTH) return "South";
        if(dir == Direction.FROM_WEST) return "West";
        return "Invalid Direction";
    }
}