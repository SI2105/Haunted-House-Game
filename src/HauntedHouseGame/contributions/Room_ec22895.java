package HauntedHouseGame.contributions;

import java.util.Random;

//contribution for ec22895
class Room_ec22895 extends Room { 

    static final Random random = new Random();
    static final Item eraser = new Item("eraser");
    static final Item notebook = new Item("notebook");
    static boolean lightsOn = random.nextBoolean();
    static final int numberOfSnacks = random.nextInt(6);

    public Direction visit(Visitor visitor, Direction origin) {
        visitor.tell("Welcome to Room_ec22895!");
        visitor.tell("Room State: Lights are " + getLightStates() + " and there are  " + numberOfSnacks + " snacks.");
        char choice = visitor.getChoice("There is a plate of sandwiches and a plate of crisps. Choose option a for sandwiches and b for crisps.", new char[] {'a', 'b'});
        if(choice == 'a') {
           visitor.tell("After you ate the sandwiches, you found an eraser.");
           visitor.giveItem(eraser);
        }
        else {
            visitor.tell("After eating the crisps, you found a notebook full of famous artwork.");
            visitor.giveItem(notebook);
            visitor.giveGold(10);
            visitor.tell("You received 10 gold as a prize reward.");
        }
        return Direction.opposite(origin);
    }

    public static String getLightStates() {
        if(lightsOn) {
            return "on";
        }
        return "off";
    }
}
