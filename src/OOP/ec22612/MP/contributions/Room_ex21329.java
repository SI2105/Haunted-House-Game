package OOP.ec22612.MP.contributions;

class Room_ex21329 extends Room {
    boolean lightsOn;
    boolean trunkEmpty;
    boolean poltergeistMood; // false == annoyed, true == neutral
    char choice; // to store the user's given choices
    public Room_ex21329() {
        this.lightsOn = false;
        this.trunkEmpty = false;
        this.poltergeistMood = true;
    }

    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        visitor.tell("You have entered a room\n");
        if (lightsOn) {
            visitor.tell("Light is ON!\n");
        } else {
            visitor.tell("Light is OFF!\n");
        }
        if (trunkEmpty) {
            visitor.tell("There is a trunk\nIt is empty\n");
        } else {
            visitor.tell("There is a trunk with some things\n");
        }
        if (poltergeistMood) {
            visitor.tell("The poltergeist seems to be in a decent mood. You may be safe ...\n");
        } else {
            visitor.tell("The poltergeist seems pissed ...  you may want to ...\n");
        }
        choice = visitor.getChoice("What do you want to do now? Choose...\n"+
                "L - Flip the lights \n"+
                "T - Flip Trunk\n"+
                "P - Flip Poltergeist Mood\n"+
                "E - Exit the room\n", new char[] {'L', 'T', 'P', 'E'});
        switch (choice) {
            case 'L':
                lightsOn = !lightsOn; //changes the state of the lights
                if (lightsOn) {
                    visitor.tell("The lights are now set to on\n");
                } else {
                    visitor.tell("The lights are now set to off\n");
                }
                break;
            case 'T':
                visitor.tell("You open the trunk to find ...\n");
                trunkEmpty = !trunkEmpty;
                if (trunkEmpty) {
                    visitor.tell("... Nothing!\n");
                } else {
                    visitor.tell("...you find a revolver\n....It is jammed\n");
                }
                break;
            case 'P':
                poltergeistMood = !poltergeistMood;
                if (poltergeistMood) {
                    visitor.tell("The poltergeist stares at you and farts\n");
                } else {
                    visitor.tell("The poltergeist starts licking its lips... and grins...\n");
                }
                break;
            case 'E': //change room
                visitor.tell("You leave the room...\n");
                break;
        }
        return Direction.opposite(directionVisitorArrivesFrom);
    }
}
