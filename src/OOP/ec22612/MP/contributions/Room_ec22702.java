package OOP.ec22612.MP.contributions;

class Room_ec22702 extends Room {

    private boolean lightsOn;
    private boolean trunkEmptied;
    private boolean poltergeistFriendly;

    public Room_ec22702() {
        lightsOn = false;
        trunkEmptied = false;
        poltergeistFriendly = false;
    }

    public Direction visit(Visitor v, Direction d) {
        // First, tell the visitor about the room and its state
        v.tell("You enter the Winchester Mystery House's Room_ec22702. The lights are currently " + (lightsOn ? "on" : "off") + ".");
        v.tell("The trunk in the corner of the room is " + (trunkEmptied ? "empty" : "closed") + ".");
        v.tell("The poltergeist in the room seems to be " + (poltergeistFriendly ? "friendly" : "grumpy") + ".");

        // Then, ask the visitor to make a choice
        char[] choices = {'1', '2', '3'};
        int choice = v.getChoice("What would you like to do?\n1. Turn the lights on/off\n2. Open the trunk\n3. Talk to the poltergeist", choices);

        // Handle the visitor's choice
        if (choice == '1') {
            lightsOn = !lightsOn;
            v.tell("You " + (lightsOn ? "turn on" : "turn off") + " the lights.");
        } else if (choice == '2') {
            if (trunkEmptied) {
                v.tell("You already emptied the trunk.");
            } else {
                v.giveItem(new Item("Gold Bar"));
                trunkEmptied = true;
                v.tell("You find a gold bar in the trunk!");
            }
        } else if (choice == '3') {
            if (poltergeistFriendly) {
                v.tell("The poltergeist happily tells you about the history of the Winchester Mystery House.");
            } else {
                v.tell("The poltergeist angrily throws a vase at you, but misses.");
                v.takeGold(5);
            }
        }

        // Finally, return the direction in which the visitor leaves the room
        return (d);
    }
}
