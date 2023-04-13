package OOP.ec22612.MP.contributions;

class Room_ec22432 extends Room {

    static final Item ROPE = new Item("Rope");
    static final Item KEY = new Item("Key");
    static final Item DAGGER = new Item("Dagger");

    public Direction visit(Visitor visitor, Direction direction) {
        visitor.tell("The door slowly creaks open and you enter. The room posseses a wadrobe, a beaten up fridge and some cardboard boxes.");

        char[] options = { '1', '2', '3' };
        char choices = visitor.getChoice("Please select one 1) Look through the wadrobe  2) Search the fridge 3) Search the boxes",options);
        int coins = 0;

        if (choices == '1') {
            visitor.tell("You open the wadrobe and a shiny dagger is sitting at the bottom. A few gold coins are sitting alongside it too.");
            visitor.giveItem(DAGGER);
            visitor.giveGold(3);
            coins = coins + 3;
        }

        if (choices == '2') {
            if (coins > 0) {
                visitor.tell("As open the fridge door, a bat flys out. You jump startled and fall to the floor. The coins fall from your hand and one of them falls through the cracks of the floor.");
                visitor.takeGold(1);
                coins = coins - 1;
            }

            if (visitor.hasEqualItem(DAGGER)) {
                visitor.tell("Out of anger, you stab the fridge and due to the impact a key falls from the top of the fridge.");
                visitor.giveItem(KEY);
            }

        }
        if (choices == '3') {
            visitor.tell("You start poking through the boxes and more coins start to appear.");
            visitor.giveGold(2);
            coins = coins + 2;
        }
        return direction;
    }
}
