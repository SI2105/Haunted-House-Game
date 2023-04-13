package OOP.ec22612.MP.contributions;

class Room_ec22454 extends Room {
    static final Item sword = new Item("Sword");
    static final Item book = new Item("Book");
    static final Item shield = new Item("Shield");
    static final Item armour = new Item("Armour");

  public Direction visit(Visitor visitor, Direction visitorDirection){
        char [] options = {'1', '2', '3', '4'};
        visitor.tell("Ghost; Hello I am the keeper of this room, If you open any of chest you will obtain an item which will help you in the house");

        char choice = visitor.getChoice("Select from the following(1-4) - 1. Red Chest | 2. Blue Chest | 3. Green Chest| 4. Purple Chest", options);

        if (choice == '1') {
            visitor.takeGold(2);
            visitor.giveItem(sword);
            visitorDirection = Direction.TO_NORTH;
            visitor.tell("Ghost: Here you have a sword, you have also lost 2 coins in order to take the sword.");
        }

        else if (choice == '2') {
            visitor.takeGold(1);
            visitor.giveItem(book);
            visitorDirection = Direction.TO_SOUTH;
            visitor.tell("Ghost: Here you have a book that is worthless, you have lost 1 gold coin.");
        }

        else if (choice == '3') {
            visitor.takeGold(5);
            visitor.giveItem(armour);
            visitorDirection = Direction.TO_WEST;
            visitor.tell("Ghost: Here you have obtained armour which will help you defend against other ghost, you have lost 5 gold coin");
        }

        else if (choice == '4') {
            visitor.takeGold(3);
            visitor.giveItem(shield);
            visitorDirection = Direction.TO_EAST;
            visitor.tell("Ghost: You have a shield which will protect you, you lost 3 gold coin.");
        }

        else {
            visitor.tell("You chose poorly, you will now lose 7 gold coin");
            visitor.takeGold(7);
            visitorDirection = Direction.opposite(visitorDirection);
        }

        return visitorDirection;


    }

}
