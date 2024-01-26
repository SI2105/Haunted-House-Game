package HauntedHouseGame.contributions;

class Room_ec22582 extends Room {

    static final Item key = new Item("Key");
    static final Item doorMat = new Item("Door mat");

    boolean chestUnlocked = false;
    boolean matSearched = false;

    public Direction visit(Visitor visitor, Direction directionEnteredFrom) {
        
        // welcome user
        visitor.tell("Youve entered the room of ec22582");
        visitor.tell("Unfortunately all 3 doors are barred off");

        if (chestUnlocked & matSearched) {
            // chest open and the key is gone
            visitor.tell("You see a chest wide open and a door mat");
            char[] choices = { 'a', 'b', 'c' };
            char option = visitor.getChoice(
                    "Would you like check the chest (a), under the doormat (b), or leave the room (c)", choices);
            switch (option) {

                case 'a':
                if (visitor.hasEqualItem(key)) {
                    visitor.tell("Youve already opened this chest. You leave");
                } else {
                    visitor.tell("The chest is locked. You leave in dissappointment");
                }

                case 'b':
                    visitor.tell("You find a penny but nothing else");
                    visitor.giveGold(1);

                case 'c':
                    visitor.tell("You leave the same way you came");

                default:
                    visitor.tell("Option " + option + "' not available. You ignore everything and leave");
            }

        } else if (!chestUnlocked & matSearched) {
            // chest closed and the key is gone
            visitor.tell("You see a locked chest and a door mat");
            char[] choices = { 'a', 'b', 'c' };
            char option = visitor.getChoice(
                    "Would you like check the chest (a), under the doormat (b), or leave the room (c)", choices);
            switch (option) {

                case 'a':
                    if (visitor.hasEqualItem(key)) {
                        visitor.tell("You unlocked the chest and you find 10 coins");
                        visitor.tell("Youre glad you came back");
                        visitor.giveGold(10);
                        visitor.tell("You leave with the coins in joy");
                        chestUnlocked = true;
                    } else {
                        visitor.tell("The chest is locked. You leave in dissappointment");
                    }

                case 'b':
                    visitor.tell("You find a penny but nothing else. You leave");
                    visitor.giveGold(1);

                case 'c':
                    visitor.tell("You leave the same way you came");

                default:
                    visitor.tell("Option " + option + "' not available. You ignore everything and leave");
            }

        } else if (!chestUnlocked & !matSearched) {
            // chest closed and the key is still there
            visitor.tell("You see a locked chest and a door mat");
            char[] choices = { 'a', 'b', 'c' };
            char option = visitor.getChoice(
                    "Would you like check the chest (a), under the doormat (b), or leave the room (c)", choices);
            switch (option) {

                case 'a':
                    visitor.tell("The chest is locked. You leave in dissapointment");

                case 'b':
                    visitor.tell("You find a key. You leave With the key");
                    visitor.tell("You leave the room with hope thinking you should come back");
                    visitor.giveItem(key);
                    matSearched = true;

                case 'c':
                    visitor.tell("You leave the same way you came");

                default:
                    visitor.tell("Option " + option + "' not available. You ignore everything and leave");
            }
        }

        Direction directionTheyLeaveIn = Direction.opposite(directionEnteredFrom);

        return directionTheyLeaveIn;
    }

}
