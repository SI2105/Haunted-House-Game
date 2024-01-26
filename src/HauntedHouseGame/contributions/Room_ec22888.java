package HauntedHouseGame.contributions;

class Room_ec22888 extends Room {

    static final Item PEN = new Item("Pen");
    static final Item RAZOR = new Item("Razor");
    static final Item TIN = new Item("Tin");

    public Direction visit(Visitor vtr, Direction drctn) {
        vtr.tell(
                "You wake up in room full of cobwebs and poorly lit. You seem to be drowsy and have bad vision. But from what you can see there is a dusty old table with three draweres.");

        char[] options = { 'a', 'b', 'c', 'd' };
        char choice = vtr.getChoice("Do you wish to a) Open the first drawer in the desk b) The second or c) The third d) Leave", options);
        int coins = 0;

        if (choice == 'a') {
            vtr.tell(
                    "You open the first drawer and you find a pen, but there is nothing else in the first drawer to your dismay.");
            vtr.giveItem(PEN);
            vtr.tell("You close the slowly close the first drawer.");
        }

        if (choice == 'b') {
            if (coins == 0) {
                vtr.tell(
                        "As you bend down to gain acces to the second drawer, you notice something glistering in the back of the drawer with the little light available. You make out that is is a four coins.");
                vtr.giveGold(4);
                coins = coins + 4;
                vtr.tell("You completely remove the second drawer leaving a gap in between the first and third drawers. A razor falls out as you do this.");
                vtr.giveItem(RAZOR);
            }
            
            else {
                vtr.tell("The drawer seems to be empty");
            }
        }
        
        if (choice == 'c') {
            if (vtr.hasEqualItem(RAZOR) && coins > 0) {
                vtr.tell("The third drawer only contains a single item like the first drawer or so you thought. There is an empty tin can and a small wooden box.");
            vtr.giveItem(TIN);
            vtr.tell("On further examination of the box, you are in notice that the wood of the box seems to be rotting away.");
            vtr.tell("You pry the box open and moths come flying out, in the commotion somne coins fell out of your pocket.");
            vtr.takeGold(2);
            coins = coins - 2;
            } 
            
            else {
                vtr.tell(
                        "You examine the box for a way to open it. There is no latch and the wood is too strong to open with your fingers.");
            }
        }
        
        if (choice == 'd') {
            return drctn;
        }
        return drctn;
    }
}
