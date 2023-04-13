package OOP.ec22612.MP.contributions;

class Room_ec22808 extends Room {
    static final Item sword = new Item("Sword");
    static final Item book = new Item("Book");
    static final Item shield = new Item("Shield");
    static final Item helmet = new Item("Helmet");

  public Direction visit(Visitor visitor, Direction visitorDirection){
        char [] options = {'1', '2', '3', '4'};
        visitor.tell("Man: Welcome to my shop!");
        visitor.tell("Man: What do you want to buy?");

        int choice = visitor.getChoice("Select from the following(1-4) - 1. Book (1 gold) head towards North 2. Sword (2 gold) head towards South 3. Helmet (3 gold) head towards West 4. Shield (4 gold) head towards East", options);

        if (choice == 1) {
            visitor.giveItem(book);
            visitor.takeGold(1);
            visitorDirection = Direction.TO_NORTH;
            visitor.tell("Man: Read the book, it might make you less illiterate.");
        }

        else if (choice == 2) {
            visitor.giveItem(sword);
            visitor.takeGold(2);
            visitorDirection = Direction.TO_SOUTH;
            visitor.tell("Man: Use the sword well kid.");
        }

        else if (choice == 3) {
            visitor.giveItem(helmet);
            visitor.takeGold(3);
            visitorDirection = Direction.TO_WEST;
            visitor.tell("Man: Make sure you wear the helmet, your brain is damaged as it is.");
        }

        else if (choice == 4) {
            visitor.giveItem(shield);
            visitor.takeGold(4);
            visitorDirection = Direction.TO_EAST;
            visitor.tell("Man: The shield will protect you from a sword.");
        }

        else {
            visitor.tell("That's not an option");
            visitorDirection = Direction.opposite(visitorDirection);
        }

        return visitorDirection;


    }

}
