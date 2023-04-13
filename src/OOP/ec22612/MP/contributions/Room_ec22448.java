package OOP.ec22612.MP.contributions;

class Room_ec22448  extends Room {
    static final Item Eapple = new Item("Enchanted Apple");
    static final Item axe = new Item("Axe");
    static final Item armour = new Item("Armour");
    static final Item Wand = new Item("Wand");

  public Direction visit(Visitor visitor, Direction visitorDirection){
        char [] options = {'1', '2', '3', '4'};
        visitor.tell("How did you wind up here?");
        visitor.tell("This town is now abandoned:( .");
        visitor.tell("Would you like an item to help you on your quest");

        char choice = visitor.getChoice("Select from the following(1-4) - 1. Axe (5 Gold) get at North | 2. Enchanted Apple (1 Gold) get at South| 3. Personal choice get at West| 4. Armour (helps you take less damage) (5 Gold) get at East", options);

        if (choice == '1') {
            visitor.takeGold(2);
            visitor.giveItem(axe);
            visitorDirection = Direction.TO_NORTH;
            visitor.tell("I found this axe near a dead soldier. I want you to have it.");
        }

        else if (choice == '2') {
            visitor.takeGold(1);
            visitor.giveItem(Eapple);
            visitorDirection = Direction.TO_SOUTH;
            visitor.tell("Eat the apple if you ever feel hungry!!");
        }

        else if (choice == '3') {
            visitor.giveItem(Wand);
            visitorDirection = Direction.TO_WEST;
            visitor.tell("The magic wand should aid you on your quest.");
        }

        else if (choice == '4') {
            visitor.takeGold(3);
            visitor.giveItem(armour);
            visitorDirection = Direction.TO_EAST;
            visitor.tell("This armour will help protect your vital organs");
        }

        else {
            visitor.tell("Gimme your gold!!!");
            visitor.takeGold(5);
            visitorDirection = Direction.opposite(visitorDirection);
        }

        return visitorDirection;


    }

}
