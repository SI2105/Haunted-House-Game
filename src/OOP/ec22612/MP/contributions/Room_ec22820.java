package OOP.ec22612.MP.contributions;

class Room_ec22820 extends Room {
    static final Item HealthPotion = new Item("Potion");
    static final Item MysteryBox = new Item("Box");
    static final Item OldKey = new Item("OldKey11");
    static final Item Bow = new Item("Bow");

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        Direction d;
        char input;
        int goldTook;
        visitor.tell("Shopkeeper: Welcome to my shop traveler, what would you like to buy?");
        visitor.tell("In front of you you see a Red potion, a mysterious box, an old key and a bow.");
        visitor.tell("Shopkeeper: Would you like to buy any of these fine items?");
        input = visitor.getChoice(
                "1. Red Potion (2 gold) | Funny looking red liquid | Heals you for 5 HP .. (Probably) \n2. Mystery box(4 gold) | Interesting box, who knows what's inside.\n3. Old Key (3 gold) \n4. Bow(2 gold) | A bow that comes with ... no arrows 5. Nothing",
                new char[] { '1', '2', '3', '4', });
        if (input == '1') {
            goldTook = visitor.takeGold(2);
            if (goldTook == 2) {
                visitor.giveItem(HealthPotion);
                visitor.tell("Shopkeeper: Enjoy this potion (-2 gold)");
            } else {
                visitor.giveGold(goldTook);
                visitor.tell("Not enough gold!");
            }
            d = Direction.TO_SOUTH;
        } else if (input == '2') {
            goldTook = visitor.takeGold(4);
            if (goldTook == 4) {
                int random = (int) (Math.random() * 8) + 1;
                visitor.giveItem(MysteryBox);
                visitor.tell("You opened bought and opened the MysteryBox (-4 gold)");
                visitor.tell("You found " + random + " gold inside the mystery box!");
                visitor.giveGold(random);
            } else {
                visitor.giveGold(goldTook);
                visitor.tell("Not enough gold!");
            }
            d = Direction.TO_WEST;
        } else if (input == '3') {
            goldTook = visitor.takeGold(3);
            if (goldTook == 3) {
                visitor.giveItem(OldKey);
                visitor.tell("You take a look at the key and see it has 'ec22486' carved in the back of it (-3 gold)");
            } else {
                visitor.giveGold(goldTook);
                visitor.tell("Not enough gold!");
            }
            d = Direction.TO_EAST;
        } else if (input == '4') {
            goldTook = visitor.takeGold(2);
            if (goldTook == 4) {
                visitor.giveItem(Bow);
                visitor.tell(
                        "Shopkeeper: This bow is very durable trust me, you just have to find some arrows (-2 gold)");
            } else {
                visitor.giveGold(goldTook);
                visitor.tell("Not enough gold!");
            }
            d = Direction.TO_WEST;
        } else {
            visitor.tell("Shopkeeper: Im taking 1 gold off you for being so boring");
            visitor.takeGold(1);
            d = Direction.opposite(directionVistorArrivesFrom);
        }
        return d;
    }
}
