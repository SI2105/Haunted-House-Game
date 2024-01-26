package HauntedHouseGame.contributions;

class Room_ex21327 extends Room {
    
    boolean lightsOn;
    boolean trunkEmpty;
    boolean poltergeistMood; // false == grumpy, true == friendly
    
    char choice; // to store the user's choice

    public Room_ex21327() {
        
        this.lightsOn = false;
        this.trunkEmpty = false;
        this.poltergeistMood = true;
        
    }
    
    
    public Direction visit(Visitor visitor, 
                           Direction directionVistorArrivesFrom) {
        
        visitor.tell("You enter a room");
        if (lightsOn) {
            visitor.tell("The light is ON");
        } else {
            visitor.tell("The light is OFF");
        }
        
        if (trunkEmpty) {
            visitor.tell("There is an empty trunk");
        } else {
            visitor.tell("There is a trunk with a few items in it");
        }
        
        if (poltergeistMood) {
            visitor.tell("The poltergeist is in a friendly mood :-)");
        } else {
            visitor.tell("The poltergeist is in a grumpy mood :-(");
        }
    
        choice = visitor.getChoice("What do you want to do now? Choose...\n"+
                                   "L - Light On/Off\n"+
                                   "T - Trunk Empty/Not Empty\n"+
                                   "P - Poltergeist Mood Friendly/Grumpy\n"+                                      "X - Exit room\n"
                                   , new char[] {'L', 'T', 'P', 'X'});
        
        switch (choice) {
            case 'L':
                lightsOn = !lightsOn; //reverses the state of the lights
                if (lightsOn) {
                    visitor.tell("The lights are now on");
                } else {
                    visitor.tell("The lights are now off");
                } 
                break;                
            case 'T':
                visitor.tell("You open the trunk and...");
                trunkEmpty = !trunkEmpty;
                if (trunkEmpty) {
                    visitor.tell("...it is empty!");
                } else {
                    visitor.tell("...you find a spoon");
                } 
                break;             
            case 'P':
                poltergeistMood = !poltergeistMood;
                if (poltergeistMood) {
                    visitor.tell("The poltergeist says Hello! to you");
                } else {
                    visitor.tell("The poltergeist tells you to get out of the room");
                } 
                break;
                
            case 'X': //move rooms
                visitor.tell("You move back out of the room");
                break;
        }        
        return Direction.opposite(directionVistorArrivesFrom);
    }
    
}
