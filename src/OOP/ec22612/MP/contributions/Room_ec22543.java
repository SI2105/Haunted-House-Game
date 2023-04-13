package OOP.ec22612.MP.contributions;

import java.util.Random;


class Room_ec22543 extends Room {
    static final Item item = new Item("Diamond Ring");
    public Direction visit (Visitor v, Direction d) {
        char[] choice = new char[] {'a', 'b', 'c', 'd'};
        Direction new_direction = d.TO_NORTH;
        Random random = new Random();
        int random_int = random.nextInt(3);
        switch (random_int) {
            case 0:
                new_direction = d.TO_NORTH;
                break;
            case 1:
                new_direction = d.TO_SOUTH;
                break;
            case 2:
                new_direction = d.TO_WEST;
                break;
        }
        v.tell("The east door is blocked by a poltergeist who was murdered for her diamond ring in this room");

      
        char selection = v.getChoice("Where do you want to search around the room?\n\na) Under the mattress\nb) In the nightstand\nc) Behind the painting\nd) Under the bed", choice);

        switch (selection) {
            case 'a':
                v.tell("You lose 3 gold!");
                v.takeGold(3);
                break;

            case 'b':
                v.tell("You found the diamond ring!");
                v.giveItem(item);
                break;

            case 'c':
                v.tell("You found 4 gold. These must have been here for ages!");
                v.giveGold(4);
                break;

            case 'd':
                v.tell("The murderers already searched under the bed, nothing was found.");
                break;
        }
      
       if (v.hasIdenticalItem(item)) {
            new_direction = d.TO_EAST;
            v.tell("You returned the ring and let her soul rest in peace");
        }


        return new_direction;
    }
}
