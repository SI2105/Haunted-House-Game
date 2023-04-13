package OOP.ec22612.MP.contributions;

class Room_ec22771 extends Room{
    int goldInChest = 0;
    boolean lightsOn = false;
    boolean chestOpened = false;
    char[] options = {'y', 'n'};
    char[] directions = {'n', 'w', 's', 'e'};
    
    public String directionFrom(Direction d) {
        if(d == Direction.FROM_NORTH) {
            return "North";
        } else if(d == Direction.FROM_WEST) {
            return "West";
        }else if(d == Direction.FROM_SOUTH) {
            return "South";
        } else if(d == Direction.FROM_EAST) {
            return "East";
        } else {
            return "Unkown Direction";
        }
    }

    public String directionTo(Direction d){
        if(d == Direction.TO_NORTH) {
            return "North";
        } else if(d == Direction.TO_WEST) {
            return "West";
        }else if(d == Direction.TO_SOUTH) {
            return "South";
        } else if(d == Direction.TO_EAST) {
            return "East";
        } else {
            return "Unkown Direction";
        }

    }

    public Direction visit(Visitor visitor, Direction direction){
        visitor.tell("You have entered the room from the "  + directionFrom(direction));
        visitor.tell("You have entered a dusty room, and can hear a faint musical tune");

        //if the lights are off the in the room, the user will be given the option to turn the lights on or keep them off
        if (!lightsOn) {
            visitor.tell("The lights are off but you faintly see a light switch to your side.");
            char lightChoice = visitor.getChoice("Would you like to turn the lights on? y/n", options);
            if (lightChoice == 'y') {
                visitor.tell("You decide to switch on the lights. \nThe light bulb is dull and flickering.");
                lightsOn = true;
            } else {
                visitor.tell("Why would you not turn the light on? You continue to sit in the dark room.");
            }
        } else if (lightsOn) {
            visitor.tell("The lights were left on in here from the last visitor.");
        }

        //if the user turned on the lights, they will be able to see a chest in the room which they can interact with
        if (lightsOn){
            visitor.tell("The room is comprised of mirrors that span the entire length of each wall, reflecting the emptiness of the room");
            visitor.tell("The only thing in this barren room is a woman in the middle, sat on her knees playing a guitar.");
            visitor.tell("She was clothed in a black dress, with black hair covering her face");
            visitor.tell("There is a small chest infront of the woman, she hums in a melodic tune 'come closer, approach the chest' ");
            char chestChoice = visitor.getChoice("Do you approach the chest? y/n", options);
            if (chestChoice  ==  'y'){
                visitor.tell("You decided to approach the chest");
                if (chestOpened){
                    visitor.tell("You find that the chest was already open, theres some gold left in the chest. \nYou take the gold and close the chest");
                    visitor.tell("The woman says 'How lucky', and giggles revealing her face. The most beautiful woman you have seen in your life");
                    visitor.giveGold(goldInChest);
                    goldInChest = 0;
                    chestOpened = false;
                } else if (!chestOpened){
                    visitor.tell("You approach the chest and find it already open. An imp jumps out, smacking you and runs away, taking some gold in the process");
                    visitor.tell("The woman says 'How unlucky', and giggles revealing her face. The most revolting woman you have ever seen in your life");
                    goldInChest = visitor.takeGold(10);
                    chestOpened = true;
                } else {
                    visitor.tell("It appears you are not a curious person. You decide to leave they mysterious chest alone.");
                }
            }
        } else {
            visitor.tell("There appears to be a person seated in the middle of the room, but you can not clearly make it out as you did not turn on the lights.");
        }

        //the user will have the choice to turn them off or leave them on for the next player.
        if (lightsOn){
            char lights_choice = visitor.getChoice("Before you exit the room, do you wish to turn the lights off? y/n", options);
            if (lights_choice == ('y')){
                lightsOn = false;;
                visitor.tell("The room returns to it's original dark and dreary state");
            } else {
                visitor.tell("You leave the lights on for the next visitor. How nice");
            }
        }

        visitor.tell("Before you leave, the woman in the middle of the room says:");
        visitor.tell("'Head my warning, to go forwards you must go backwards' \n'to go up you must go down' \n'to go left you must go right'");
        visitor.tell("'The doors are not as they seem'");
        char newDirection = visitor.getChoice("Which direction would you like to leave in? (N/W/S/E)", directions);
        Direction leaving = Direction.UNDEFINED;
        String directionPicked = "";
        switch (newDirection){
            case 'n':
            directionPicked = "North";
                leaving = Direction.TO_SOUTH;
                break;
            case 'w':
            directionPicked = "West";
                leaving = Direction.TO_EAST;
                break;
            case 's':
                directionPicked = "South";
                leaving = Direction.TO_NORTH;
                break;
            case 'e':
                directionPicked = "East";
                leaving = Direction.TO_WEST;
                break;
        }

        visitor.tell("You picked the " + directionPicked + " door but ended up leaving in the " + directionTo(leaving));
        visitor.tell("That must have been the womans warning.");
        return leaving;
    }
}
