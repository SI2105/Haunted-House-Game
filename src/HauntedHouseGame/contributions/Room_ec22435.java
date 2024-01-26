package HauntedHouseGame.contributions;

class Room_ec22435 extends Room{

    static boolean chestOpen = false;
    static boolean daggerPicked = false;

    static Item dagger = new Item("dagger");

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        char [] choices = new char[] {'a','b','c','d'};
        char [] choices2 = new char[] {'a','b'};
        Direction directionVisitorLeavesTo = directionVistorArrivesFrom;
        visitor.tell("You enter a cold room and there are 4 doors in each corner of the room (including the one you just walked through).\n\nDo you enter: \n");
        char door = visitor.getChoice("a)the blue door\nb)the red door\nc)the green door\nd)back through the black door", choices);

        if (door == 'a'){
            directionVisitorLeavesTo = Direction.TO_WEST;
            visitor.tell("You enter a room with a single chest that is locked");

            if ((chestOpen == false) && ((visitor.hasEqualItem(new Item("lockpick")) == true) || visitor.hasIdenticalItem(new Item("lock pick")) == true)){
                visitor.tell("You used your lockpick to open the chest and see that it is full with gold. You fill your pockets with the gold. You have picked up 10 gold");
                visitor.giveGold(10);
                chestOpen = true;                                
            }
            else if (chestOpen == true){
                visitor.tell("You have already opened the chest");
            }
            else {
                visitor.tell("You don't have anything to pick the lock with");
            }
        }

        else if (door == 'b'){
            directionVisitorLeavesTo = Direction.TO_WEST;
            char bChoice;

            if (daggerPicked == false){
                visitor.tell("You enter a room that contains a dagger\n\nDo you:\n");
                bChoice = visitor.getChoice("a)pick up the dagger\nb)ignore the dagger", choices2);
                if (bChoice == 'a'){
                    if (visitor.hasEqualItem(dagger) == false){
                        visitor.giveItem(dagger);
                    }
                    else{
                        visitor.tell("You already have this item");
                    }
                }
            }
            else{
                visitor.tell("The room is empty");
            }
        }

        else if (door == 'c'){
            directionVisitorLeavesTo = Direction.TO_EAST;
            visitor.tell("You enter a room and see a goblin \nIt grumbles at you, ushering its hand out");
            visitor.tell("After giving it 5 pieces of gold, it waddles away into the corner");
            visitor.takeGold(5);
        }

        else{
            directionVisitorLeavesTo = Direction.TO_SOUTH;
        }

        return directionVisitorLeavesTo;
    }
}
