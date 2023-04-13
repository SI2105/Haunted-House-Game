package OOP.ec22612.MP.contributions;

class Room_ec22430 extends Room {

    static final Item KNIFE = new Item("Knife"); //items used in this room
    static final Item CLOTH = new Item("Cloth");
    static final Item KEY = new Item("Key");

    public Direction visit(Visitor visitor, Direction dir) {
        visitor.tell(
                "You enter a dimly lit room with little in it except for a cupboard by the left wall and a small wooden box in the centre. A painting hangs on the back wall.");

        char[] options = { 'a', 'b', 'c' }; //array of chars 
        char choice = visitor.getChoice("Do you wish to a) Open cupboard b) Pick up box or c) Inspect painting",
                options); //visitor makes choice
        int coins = 0;

        if (choice == 'a') { 
            visitor.tell(
                    "You open the cupboard door and find a white cloth sitting on the middle shelf. You also find a few coins at the back of the bottom shelf.");
            visitor.giveItem(CLOTH); //gives item cloth
            visitor.giveGold(3);  //gives gold
            coins = coins + 3;
        }

        if (choice == 'b') {
            if (coins > 0) {  //if user has picked up coins
                visitor.tell(
                        "As you bend down to pick up the box a coin falls out of your pocket and a rat suddenly scurries out of a corner and takes it before disappearing into the shadows.");
                visitor.takeGold(1);
                coins = coins - 1;
            }

            if (visitor.hasEqualItem(KNIFE)) { //if user already posesses a knife
                visitor.tell(
                        "You examine the box for a way to open it. You take the knife you have and insert it into one of the gaps to pry the edges apart.");
                visitor.tell("The wood snaps and a key falls out and hits the floor.");
                visitor.giveItem(KEY);
            } else {
                visitor.tell(
                        "You examine the box for a way to open it. There is no latch and the wood is too strong to break with your fingers.");
            }

        }
        if (choice == 'c') {
            visitor.tell("You take the painting of the hook and find a nook etched into the wall with coins inside.");
            visitor.giveGold(2);
            coins = coins + 2;
        }
        return dir;
    }
}
