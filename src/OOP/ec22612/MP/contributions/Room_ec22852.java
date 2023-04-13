package OOP.ec22612.MP.contributions;

class Room_ec22852 extends Room{

    boolean drawerCOpened = false;
    Item key = new Item("Special Key");

    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {

        visitor.tell("Welcome to room_ec22852");

        char[] choices = {'a', 'b', 'c'};
        char user_choice = visitor.getChoice("Would you like to:\n    a) Open drawer a\n    b) Open drawer b\n    c) Open drawer c", choices);

        if(user_choice == 'a') {
            visitor.tell("You have found a key, take it and keep it safe!");
            visitor.giveItem(key);
        }

        else if(user_choice == 'b'){
            if (visitor.hasEqualItem(new Item("Special Key"))) {
                visitor.tell("You have opened this drawer with your special key");
                visitor.tell("Here is your reward");
                visitor.giveGold(10);
            }
            else {
                visitor.tell("This drawer is locked, you don't have the special key");
            }
        }

        else{
            if (drawerCOpened) {
                visitor.tell("You are lucky this drawer has already been opened, you won't be fined again!");
            }
            else {
                visitor.tell("You have to pay a fine of 5 gold");
                visitor.takeGold(5);
                drawerCOpened = true;
            }
        }


        return Direction.opposite(directionVisitorArrivesFrom);
    }
}
