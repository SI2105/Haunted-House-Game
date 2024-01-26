package HauntedHouseGame.contributions;

class Room_ec22704 extends Room {
    private  Item LONG_THING = new Item("Long Object for bed use");
    private  Item CANDLE = new Item("Candle");
    private Item TORCH = new Item("Torch");
    private Item FLAME_THROWER = new Item("Flame Thrower");
    
    //takes gold and welcomes them

    public Direction visit(Visitor visitor, Direction from) {
        visitor.tell("Welcome to ec22704's room in the house!");
        visitor.tell("You must pay 2 gold to enter");
        visitor.takeGold(2);

        String navigationOption = ("What would you like to do in my room? a) Look around, b) Turn on the generator, c) Check the drawer");
        char[] options = {'a', 'b', 'c'};
        char userOption = visitor.getChoice(navigationOption, options);

        if (userOption == 'a') {
            visitor.tell("You're looking around my room... be careful where you step!");
            String itemOptions = ("You found some things in my room... Which one would you like to take? a) Torch, b) Candle, c) Flame Thrower");
            char userItemOption = visitor.getChoice(itemOptions, options);

            if (userItemOption == 'a') {
                visitor.giveItem(TORCH);
            } else if (userItemOption == 'b') {
                visitor.giveItem(CANDLE);
            } else if (userItemOption == 'c') {
                visitor.giveItem(FLAME_THROWER);
            }
        } else if (userOption == 'b') {
            visitor.tell("You turned on the generator... Thanks! Here's some gold for your kindness.");
            visitor.giveGold(3);
        } else if (userOption == 'c') {
            visitor.tell("Hey, what are you doing? You shouldn't go through my things! But... what is that in your hand? You must have dropped some gold, give it to me!");
            visitor.giveItem(LONG_THING);
            visitor.takeGold(2);
        }
        else
        {
            visitor.tell("NOT VALID OPTION");
        }

        return Direction.opposite(from);
    }
}
