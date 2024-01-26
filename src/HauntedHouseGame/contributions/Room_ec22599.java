package HauntedHouseGame.contributions;

class Room_ec22599 extends Room {
    static final Item Gcarrot = new Item("Golden Carrot");
    static final Item sword = new Item("Sword");
    static final Item shield = new Item("shield");
    static final Item bucket = new Item("Bucket");

  public Direction visit(Visitor visitor, Direction visitorDirection){
        char [] options = {'1', '2', '3', '4'};
        visitor.tell("Human: Hello mate,how did you wind up here?");
        visitor.tell("Human: There used to be a bunch of us but i now live here alone :( .");
        visitor.tell("Human: One of my items may be of good use to you on your expedition, ill let you pick one to keep at a fair rate");

        char choice = visitor.getChoice("Select from the following(1-4) - 1. Sword (2 Gold) get at North | 2. Golden Carrot (1 Gold) get at South| 3. Choice from me(free) get at West| 4. Shield (3 Gold) get at East", options);

        if (choice == '1') {
            visitor.takeGold(2);
            visitor.giveItem(sword);
            visitorDirection = Direction.TO_NORTH;
            visitor.tell("Human: Here's an enchanted sword that was left behind by an old traveller.");
        }

        else if (choice == '2') {
            visitor.takeGold(1);
            visitor.giveItem(Gcarrot);
            visitorDirection = Direction.TO_SOUTH;
            visitor.tell("Creature: This carrot will help you if you are ever feeling famished");
        }

        else if (choice == '3') {
            visitor.giveItem(bucket);
            visitorDirection = Direction.TO_WEST;
            visitor.tell("Human: this bucket should come in handy!");
        }

        else if (choice == '4') {
            visitor.takeGold(3);
            visitor.giveItem(shield);
            visitorDirection = Direction.TO_EAST;
            visitor.tell("Creature: This shield will protect you against any damage.");
        }

        else {
            visitor.tell("I dont appreciate being spoken to in that manner,your gold belongs to me");
            visitor.takeGold(5);
            visitorDirection = Direction.opposite(visitorDirection);
        }

        return visitorDirection;


    }

}
