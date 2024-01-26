package HauntedHouseGame.contributions;

class Room_ec22929 extends Room{

    static final Item TEA = new Item("Tea"); //items used in this room
    static final Item SUGAR = new Item("Sugar");
    static final Item POT = new Item("Pot");

    public Direction visit(Visitor customer, Direction dir) {
        customer.tell(
                "You enter a dimly lit kitchen with little in it except for a cupboard by the left wall and a small wooden box in the centre. A menu hangs by the back wall. And a grimy sugar machine");

        char[] options = { 'a', 'b', 'c' }; //array of chars 
        char choice = customer.getChoice("Do you wish to a) Open cupboard b) Pick up wooden box c) Inspect menu or d) Clean sugar machine",
                options); //customer makes choice
        int coins = 0;

        if (choice == 'a') { 
            customer.tell(
                    "You open the cupboard door and find a pack of green tea leaves sitting on the middle shelf. You also find a few coins at the back of the bottom shelf.");
            customer.giveItem(TEA); //gives item cloth
            customer.giveGold(3);  //gives gold
            coins = coins + 3;
        }

        else if (choice == 'b') {
            if (coins > 0) {  //if user has picked up coins
                customer.tell(
                        "As you bend down to pick up the box a coin falls out of your pocket and a swarm of ants suddenly scurries out of a corner and takes it before disappearing into the shadows.");
                customer.takeGold(1);
                coins = coins - 1;
            }

            if (customer.hasEqualItem(TEA)) { //if user already posesses a knife
                customer.tell(
                        "You examine the box for a way to open it. As it opens very easily, as it squeaks.");
                customer.tell("The box falls apart from a tiny push, as a stainless steel pot falls out.");
                customer.giveItem(POT);
            } else {
                customer.tell(
                        "You examine the box for a way to open it. It is too strong for you to open it");
            }

        }
        else if (choice == 'c') {
            customer.tell("You take the menu of the hook and find a nook etched into the wall with coins inside.");
            customer.giveGold(2);
            coins = coins + 2;
        }
        
        else if (choice == 'd') {
            customer.tell("You take the grimy sugar machine and take it to the nearby corroded tap to scrub clean. And you find a coin deep inside the machine.");
            customer.giveGold(1);
            coins = coins + 1;
        }

        
        return dir;
    }
}
     
