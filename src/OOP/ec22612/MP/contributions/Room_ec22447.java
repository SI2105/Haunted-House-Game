package OOP.ec22612.MP.contributions;

class Room_ec22447 extends Room {

    Item knife = new Item ("knife");
    Item pistol = new Item("pistol");
    Item grenade  = new Item("grenade");

    Item AK47 = new Item("ak47");
    Item M4A1 = new Item("m4a1");
    Item AWP = new Item("awp");

    Item sword = new Item("sword");
    Item shield = new Item("shield");
    Item torch = new Item("torch");

    Item book = new Item("book");
    Item ink = new Item("ink");
    Item map = new Item("map");

    char[] choice = {'a', 'b', 'c'};


    @Override
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {


        if (directionVistorArrivesFrom == Direction.FROM_EAST) {

            visitor.tell("You are now in the lobby");
            String optionsYouHave = "You can choose a knife (a) , a pistol (b) , or a grenade (c)";
            int  option = visitor.getChoice(optionsYouHave, choice);

            if (option == 'a') {
                visitor.giveItem(knife);
                visitor.giveGold(2);
                visitor.tell("You picked a knife from the ground");
                visitor.tell("You have gained 2 pieces of gold");
            } else if (option == 'b') {
                visitor.giveItem(pistol);
                visitor.giveGold(1);
                visitor.tell("You have picked  a pistol from the ground");
                visitor.tell("You have gained a piece of gold");
            } else if (option == 'c'){
                visitor.giveItem(grenade);
                visitor.takeGold(3);
                visitor.tell("You just picked up a grenade");
                visitor.tell("3 pieces of gold have been taken from you");
            }
        }

        else if (directionVistorArrivesFrom == Direction.FROM_NORTH) {
            visitor.tell("You are in an alleyway");
            String optionsYouHave = "You can choose an AK47(a),M4A1(b) or AWP(c)";

            int option = visitor.getChoice(optionsYouHave, choice);

            if (option == 'a') {
                visitor.giveItem(AK47);
                visitor.giveGold(5);
                visitor.tell("You picked the AK47 from the ground");
                visitor.tell("You have gained 5 pieces of gold");
            } else if (option == 'b') {
                visitor.giveItem(M4A1);
                visitor.giveGold(2);
                visitor.tell("You picked the M4A1 from the ground");
                visitor.tell("You have gained 2 pieces of gold");
            } else if (option == 'c'){
                visitor.giveItem(AWP);
                visitor.takeGold(1);
                visitor.tell("You picked AWP from the ground");
                visitor.tell("A piece of gold has been taken from you");
            }
        }

        else if (directionVistorArrivesFrom == Direction.FROM_SOUTH) {
            visitor.tell("You are in a dungeon");
            String optionsYouHave = "You can choose a sword (a) , a shield (b) , or a torch (c)";
            int  option = visitor.getChoice(optionsYouHave, choice);

            if (option == 'a') {
                visitor.giveItem(sword);
                visitor.giveGold(5);
                visitor.tell("You picked a sword from the ground");
                visitor.tell("You have gained 5 pieces of gold");
            } else if (option == 'b') {
                visitor.giveItem(shield);
                visitor.giveGold(3);
                visitor.tell("You have picked  a shield from the ground");
                visitor.tell("You have gained 3 pieces of gold");
            } else if (option == 'c'){
                visitor.giveItem(torch);
                visitor.tell("You have picked up a torch");
            }
        }

        else if(directionVistorArrivesFrom == Direction.FROM_WEST) {
            visitor.tell("You are in the library");
            String optionsYouHave = "You can choose a book (a) , ink (b) , or a map(c)";
            int  option = visitor.getChoice(optionsYouHave, choice);

            if (option == 'a') {
                visitor.giveItem(book);
                visitor.giveGold(5);
                visitor.tell("Congratulations you picked up a book that contains clues in it");
                visitor.tell("You have gained 5 pieces of gold");
            } else if (option == 'b') {
                visitor.giveItem(ink);
                visitor.tell("You found some ink");
            } else if (option == 'c'){
                visitor.giveItem(map);
                visitor.tell("CONGRATULATIONS you found a map of your location!!");
                visitor.giveGold(10);
                visitor.tell("You have gained 10  pieces of gold");
            }

        }

        else {
            visitor.tell("Your location is unknown");
        }

        return Direction.opposite(directionVistorArrivesFrom);
    }
}
