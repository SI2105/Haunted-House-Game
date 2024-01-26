package HauntedHouseGame.contributions;

class Room_ec22424 extends Room {
    private boolean lightsOn;
    
    // Light is on initially
    Room_ec22424(boolean light) {
        lightsOn = light;
    }
    
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        // Ask for lights on or off
        visitor.tell("Lights on or off?");
        char[] choices = new char[2]; choices[0] = '1'; choices[2] = '2';
        char lightsChoice = visitor.getChoice("1 for on, 2 for off. [1/2]", choices); 
        if (lightsChoice == '1') {
            if (lightsOn) { visitor.tell("Lights are already on."); }
            else { visitor.tell("Cool"); }
            lightsOn = true;
        }
        else {
            if (!lightsOn) { visitor.tell("Lights are already off."); }
            else { visitor.tell("As you wish."); }
            lightsOn = false;
        }
        
        // Ask if visitor likes the room
        choices[0] = 'y'; choices[1] = 'n';
        visitor.tell("This is a really cool room, don't you think?");
        if (visitor.getChoice("Yes/No? [y/n]", choices) == 'y') {
            visitor.tell("Thanks bro, take this.");
            visitor.giveItem(new Item("Rugged winter gloves"));
            visitor.giveGold(4);
        }
        else {
            visitor.tell("Wow, you could have just lied bro.");
            visitor.tell("I'm taking this.");
            visitor.takeGold(2);
        }
        
        return Direction.opposite(directionVisitorArrivesFrom);
    }
}
