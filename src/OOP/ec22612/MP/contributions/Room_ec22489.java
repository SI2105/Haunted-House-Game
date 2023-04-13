package OOP.ec22612.MP.contributions;

class Room_ec22489 extends Room{
    public Direction visit(Visitor v, Direction d)
    {
        v.tell("Welcome to my room, which is a kit Take a look in the fridge");

        char[] itemChoices = {'C', 'G', 'S'};
        char option = v.getChoice("Would you like to: A) Take the cooked chicken, B) take ONE grape, C) Take a grain of salt", itemChoices);
        Item item;
        if (option == 'C') {
            item = new Item("Cooked chicken");
        } else if (option == 'G') {
            item = new Item("A grape");
        } else {
            item = new Item("A grain of salt");
        }

        if (v.hasIdenticalItem(item)) {
            System.out.println("You already have this item!");
        } else if (v.hasEqualItem(item)) {
            System.out.println("You already have an item with the same name!");
        } else {
            boolean itemAccepted = v.giveItem(item);
            if (itemAccepted) {
                System.out.println("Lesgo. Item accepted!");
            } else {
                System.out.println("Nope. Item rejected!");
            }
        }

        return d.opposite(d);
    }
}
