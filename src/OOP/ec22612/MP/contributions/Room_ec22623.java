package OOP.ec22612.MP.contributions;

public class Room_ec22623 extends Room {

    Item item = new Item("Coat");
    boolean temp; // true=cold false=warm

    public Direction visit(Visitor visitor, Direction crimson) {
        char[] yesNo = {'y', 'n'};

        if (crimson == Direction.FROM_WEST) {
            temp = true;
            visitor.tell("You come from west, so you are cold");

            if (temp) {
                if (visitor.hasEqualItem(item) || visitor.hasIdenticalItem(item)) {
                    visitor.tell("You find a coat");
                    visitor.tell("You are already wearing one?");
                } else {
                    char choice = visitor.getChoice("You see a wardrobe do you want to get some clothes from the wardrobe?(y/n)", yesNo);

                    if (choice == 'y') {
                        visitor.tell("You find a coat.");
                        visitor.giveItem(item);
                    } else if (choice == 'n') {
                        visitor.giveGold(2);
                        visitor.tell("You are still cold. However, someone walks by giving you a coat with some money");
                        
                    }
                }
                visitor.tell("You are cold so you may freeze.");
            } else {
                visitor.tell("You are not cold.");
                visitor.tell("Lucky you. Just pay to leave the room now. (You have no choice in this)");
                int gold_taken = visitor.takeGold(1);
                visitor.tell("You have lost " + gold_taken + " in this room.");
            }
        }
        visitor.tell("You are forced to leave the room.");
        return Direction.opposite(crimson);
    }

}
