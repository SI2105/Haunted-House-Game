package OOP.ec22612.MP.contributions;

import java.util.Random;
class Room_ec22628 extends Room {
    static final Item item = new Item("Poké Flute");
    public Direction visit (Visitor visitor, Direction direction) {
        char[] choice1 = new char[] {'a', 'b', 'c', 'd'};
        Direction new_direction = direction.TO_NORTH;
        Random random = new Random();
        int random_int = random.nextInt(3);
        switch (random_int) {
            case 0:
                new_direction = direction.TO_NORTH;
                break;
            case 1:
                new_direction = direction.TO_SOUTH;
                break;
            case 2:
                new_direction = direction.TO_EAST;
                break;
        }
        visitor.tell("As you enter the room you find the west door blocked by a large blueish creature");
        
        if (visitor.hasIdenticalItem(item)) {
            new_direction = direction.TO_WEST;
            visitor.tell("You played the Poké Flute in your inventory and woke up the creature");
        }

        char selection1 = visitor.getChoice("Where do you want to search around the room?\n\na) In the desk\nb) Behind the painting\nc) Under the table\nd) on the windowsill", choice1);

        switch (selection1) {
            case 'a':
                visitor.tell("You found 3 gold!");
                visitor.giveGold(3);
                break;
            
            case 'b':
                visitor.tell("You found a Poké Flute");
                visitor.giveItem(item);
                break;
            
            case 'c':
                visitor.tell("You found 5 gold!! Someone probably lost these");
                visitor.giveGold(5);
                break;

            case 'd':
                visitor.tell("You found nothing...but a nice day outside.");
                break;
        }

        return new_direction;
    }
}