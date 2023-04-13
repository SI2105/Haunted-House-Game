package OOP.ec22612.MP.contributions;

class Room_ec22437 extends Room {

    public Direction visit(Visitor v, Direction d) {

        v.tell("Welcome, you are in room ec22437");

        if (d == Direction.FROM_SOUTH) {
            v.tell("You arrived from the south");
        }
        if (d == Direction.FROM_WEST) {
            v.tell("You arrived from the west");
        }
        if (d == Direction.FROM_NORTH) {
            v.tell("You arrived from the north");
        }
        if (d == Direction.FROM_EAST) {
            v.tell("You arrived from the east");
        }

        // String descriptionOfChoices = "You can either: \n a) receive a mystery
        // weapon, which will aid you against any upcoming foes \n b) Steal some gold
        // from this room \n c) Donate some gold to this room to aid other future
        // travellers ";
        // char[] arrayOfPossibleChoices = { "a", "b", "c", };

        if (v.getChoice(
                "You can either: \n a) receive a mystery weapon, which will aid you against any upcoming foes \n b) Steal some gold from this room \n c) Donate some gold to this room to aid other future travellers ",
                new char[] { 'a', 'b', 'c' }) == 'a') {
            new Item("Handgun");
            if (v.hasIdenticalItem(new Item("Handgun")) == true) {
                v.tell("You are already in possesion of a handgun");
            } else {
                v.giveItem(new Item("Handgun"));
            }
        } else if (v.getChoice(
                "You can either: \n a) receive a mystery weapon, which will aid you against any upcoming foes \n b) Steal some gold from this room \n c) Donate some gold to this room to aid other future travellers ",
                new char[] { 'a', 'b', 'c' }) == 'b') {
            v.takeGold(7);
            v.tell("Haha, that is what you get for trying to steal. You lose 7 gold.");
        } else if (v.getChoice(
                "You can either: \n a) receive a mystery weapon, which will aid you against any upcoming foes \n b) Steal some gold from this room \n c) Donate some gold to this room to aid other future travellers ",
                new char[] { 'a', 'b', 'c' }) == 'c') {
            v.giveGold(9);
            v.tell("Your generocity has been rewarded. You gain 9 gold");
        }

        return d.opposite(d);
    }
}
