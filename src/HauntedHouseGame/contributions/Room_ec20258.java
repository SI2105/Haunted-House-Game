package HauntedHouseGame.contributions;

class Room_ec20258 extends Room {

    boolean lightsOn = false;
    boolean trunkEmpty = false;
    boolean poltergeistMood = true;

    public Direction visit(Visitor v, Direction d) {

        v.tell("You enter a room\nThe light is " + (lightsOn ? "ON" : "OFF") + "\nThere is " + (trunkEmpty ? "an empty" : "a") + " trunk with " + (trunkEmpty ? "no" : "a few") + " items in it\nThe poltergeist is " + (poltergeistMood ? "in a friendly mood :-)" : "in a grumpy mood :-("));

        char choice = v.getChoice("What do you want to do now? Choose...\nL - Light On/Off\nT - Trunk Empty/Not Empty\nP - Poltergeist Mood Friendly/Grumpy\nX - Exit room\n", new char[] {'L', 'T', 'P', 'X'});
        if (choice == 'L') {
            lightsOn = !lightsOn;
            v.tell("The lights are now " + (lightsOn ? "on" : "off"));
        } else if (choice == 'T') {
            trunkEmpty = !trunkEmpty;
            v.tell("You open the trunk and it is " + (trunkEmpty ? "empty!" : "...you find a spoon"));
        } else if (choice == 'P') {
            poltergeistMood = !poltergeistMood;
            v.tell("The poltergeist " + (poltergeistMood ? "says Hello! to you" : "tells you to get out of the room"));
        } else {
            v.tell("You move back out of the room");
        }

        return Direction.opposite(d);
    }
}
