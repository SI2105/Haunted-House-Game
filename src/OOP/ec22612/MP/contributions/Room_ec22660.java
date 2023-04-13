package OOP.ec22612.MP.contributions;

class Room_ec22660 extends Room { //new version of a4
    Item keyR = new Item("Room Key");
    boolean lightsOn = false;
    boolean poltergeistFriendly = true;
    int count = 0;
    char[] yes_no_choice = {'Y', 'N'};
    char[] multiple_choice = {'a', 'b', 'c', 'd'};
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        visitor.tell("Welcome to the ec22660 Horror House.");
        visitor.tell("You find yourself in a dimly lit room with a creaky floor and old, dusty furniture.");
        if(directionVistorArrivesFrom == Direction.FROM_NORTH){
            visitor.tell("You entered from the north door.");
        } else if(directionVistorArrivesFrom == Direction.FROM_SOUTH){
            visitor.tell("You entered from the south door.");
        } else if(directionVistorArrivesFrom == Direction.FROM_EAST){
            visitor.tell("You entered from the east door.");
        } else if(directionVistorArrivesFrom == Direction.FROM_WEST){
            visitor.tell("You entered from the west door.");
        }
        visitor.tell("The door slams shut behind you, and you hear a faint clicking sound.");
        visitor.tell("You must find the room key to unlock the door to the next room.");
        boolean found = false;
        
        if (lightsOn) {
            visitor.tell("The room is well-lit and you can see everything clearly.");
        } 
        else {
            visitor.tell("The room is dark and you can barely see anything.");
            char choice2 = visitor.getChoice("Would you like to turn the lights on? (Y/N)", yes_no_choice);
            if (choice2 == 'Y') {
                lightsOn = true;
                visitor.tell("Good option. The room is illuminated with a bright white glow");
            }
        }
        
        
        while(!found){
            
            
            if (count == 4) {
                break;
            }
            
            if(visitor.hasEqualItem(keyR)){
                char choice4 = visitor.getChoice("You have the room key. Do you want to leave the room? (Y/N)", yes_no_choice);
                if(choice4 == 'Y'){
                    found = true;
                    visitor.giveGold(5);
                }
            }
            
            char choice3 = visitor.getChoice("There are 4 areas of interest in the room. Choose one (a, b, c or d).\n" +
                                             "a) There's a dusty bookshelf in the northeast of the room.\n" +
                                             "b) There's a large antique chest in the southeast of the room.\n" +
                                             "c) There's an old grandfather clock in the southwest of the room.\n" +
                                             "d) There's a small writing desk in the northwest corner.", multiple_choice);
            
            if(choice3 == 'a'){
                visitor.tell("You search the bookshelf and find a map of the mansion, but do not take it.");
                count += 1;
            } 
            else if(choice3 == 'b'){
                visitor.tell("You try to open the chest");
                if(poltergeistFriendly){
                    visitor.tell("Luckily, the poltergeist is friendly and gave you some gold.");
                    visitor.giveGold(3);
                } 
                else {
                    visitor.tell("You sense an eery presence approaching");
                    visitor.takeGold(4);
                }
                count += 1;
            } 
            else if(choice3 == 'c'){
                if(lightsOn){
                    visitor.tell("You peer towards the grandfather clock and notice a hidden compartment.");
                    visitor.giveItem(keyR);
                } 
                else{
                    visitor.tell("It's too dark to see the grandfather clock.");
                }
                count += 1;
            } 
            else if(choice3 == 'd'){
                visitor.tell("You look through the drawers of the writing desk and find nothing of interest but this angers the poltergeist.");
                poltergeistFriendly = false;
            } 
            else{
                visitor.tell("Please choose a, b, c, or d.");
            }
            
        }
        return directionVistorArrivesFrom.opposite(directionVistorArrivesFrom);
    }
}
