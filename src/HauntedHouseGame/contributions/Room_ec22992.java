package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22992 extends Room {
    private final QuantifiedItem TORCH = new QuantifiedItem("Torch");
    private final Item LIGHTER = new Item("Lighter");

    // Get the direction from the letter, alternatively, go back to where we started.
    private Direction getDirection(char letter, Direction startDirection) {
        switch (letter) {
            case 'N':
                return Direction.TO_NORTH;
            case 'E':
                return Direction.TO_EAST;
            case 'S':
                return Direction.TO_SOUTH;
            case 'W':
                return Direction.TO_WEST;
            default:
                return Direction.opposite(startDirection);
        }
    }

    // Gets a random direction by generating a number between 0-3, and associating a direction with that number
    private Direction getRandomDirection() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                return Direction.TO_NORTH;
            case 1:
                return Direction.TO_EAST;
            case 2:
                return Direction.TO_SOUTH;
            default:
                return Direction.TO_WEST;
        }
    }

    public Direction visit(Visitor visitor, Direction startDirection) {
        // Room (corridor) introduction.
        visitor.tell("You are in long, dark, eerie corridor...");
        visitor.tell("The door creaks behind you as it rapidly closes.\n");
        
        // If the visitor does not have a torch, ask them if they want to grab one.
        if (!visitor.hasEqualItem(TORCH)) {
            visitor.tell("A torch sputters in the distance... so that is what is moving the shadows, or something more sinister perhaps?");
            char choice = visitor.getChoice("Do you reach for the torch? (y/n) ", new char[] {'y', 'n'});
            if (choice == 'y')
                visitor.giveItem(TORCH);
        }

        // Randomly decide is the visitors' torch dies.
        boolean doesTorchDie = new Random().nextBoolean();

        // If their torch does die and it is not already dead, inform them, and deduct some gold.
        if (doesTorchDie && TORCH.hasQuantityLeft() && visitor.hasEqualItem(TORCH)) {
            visitor.tell("\nThe bulb in your torch is flickering intermittently.");
            visitor.tell("Your torch begins to dim, until finally, you are left with no light. (-2 Gold)");
            visitor.takeGold(2);
            TORCH.decreaseQuantity(1);
        }

        // If their torch is dead, check if they have a "lighter", and relight their torch, giving them +3 gold.
        if (!TORCH.hasQuantityLeft() && visitor.hasEqualItem(LIGHTER)) {
            visitor.tell("\nYou attempt to relight the torch with your lighter.");
            visitor.tell("You successfully relit the torch. (+3 Gold)");
            visitor.giveGold(3);
            TORCH.increaseQuantity(1);
        }

        // Lore and story description to the visitor.
        // START LORE
        visitor.tell(String.format("\nYou walk forwards, %swearily and at a slow pace.", TORCH.hasQuantityLeft() ? "" : "in darkness, "));
        visitor.tell("You start to hear a periodic creaking sound, like somebody moving out of sight, you also notice a slight glow...");

        visitor.tell("\nA crystal ball, illuminating a note, on a rocking chair... that's all it was.");
        visitor.tell("The note is signed \"Sarah Winchester\" and details of spiritual activity in this room.");
        // END LORE

        // Ask the user if they want to interact with the mysterious crystal ball.
        char choice = visitor.getChoice("\nDo you interact with the crystal ball? (y/n) ", new char[] {'y', 'n'});

        // If they say no, reward them with some gold for being smart and send them to the end of the corridor!
        if (choice == 'n') {
            visitor.tell("\nWise decision, let's get you to safety, run to the end of this godforsaken corridor! (+2 Gold)");
            visitor.giveGold(2);
            return Direction.opposite(startDirection);
        }

        // They said yes by this point, so we generate randomly if the spirits being interacted with are evil or angelic.
        boolean areEvilSpirits = new Random().nextBoolean();

        // If the spirits are evil, we randomly send them out any door (as they confused), and we take some gold as they are traumatised.
        // You could also think of it as the "gold being taken by the spirits".
        if (areEvilSpirits) {
            visitor.tell("\nAll you can hear is cries for help and constant screaming.");
            visitor.tell("You begin to go unconscious, and you later awaken confused, beside a door. (-3 Gold)");
            visitor.takeGold(3);
            return getRandomDirection();
        }

        // The spirits are good by this point, so we tell them an angelic spirit saved them and lets them choose their exit route.
        // The angelic spirit also rewards them with 5 gold for their experience in this corridor.
        visitor.tell("\nYou hear an angelic voice, offering you salvation from this unearthly corridor. (+5 Gold)");
        visitor.giveGold(5);

        // The angelic spirit offers them the option to choose which they want to go.
        char direction = visitor.getChoice("\nWhich way would would you like to go? (N, E, S or W) ", new char[] {'N', 'E', 'S', 'W'});
        return getDirection(direction, startDirection);
    }

    // A blueprint for an item with a given quantity, of which you can set the quantity outright, decrease or increase it by a specified amount.
    // You can also check if the item has quantity left, this can be used for i.e., has an item been taken, has a battery run out of charge, etc.
    public static class QuantifiedItem extends Item {
        private int quantity;

        public QuantifiedItem(String name, int quantity) {
            super(name);
            this.quantity = quantity;
        }

        public QuantifiedItem(String name) {
            this(name, 1);
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public void increaseQuantity(int amount) {
            quantity += amount;
        }

        public void decreaseQuantity(int amount) {
            quantity = quantity >= amount ? quantity - amount : 0;
        }

        public boolean hasQuantityLeft() {
            return quantity > 0;
        }
    }
}