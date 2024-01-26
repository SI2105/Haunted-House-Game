package HauntedHouseGame.contributions;

class Room_ec22787 extends Room {
    private boolean lightson = false;
    private boolean chestopen = false;
    private boolean owl_in_room = true;
    private Direction directionVisitorArrivesFrom;

    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        //indication to show visitor has entered their dorm room
        visitor.tell("You have entered your dorm room");
        visitor.tell("Feel free to explore");

        if(directionVisitorArrivesFrom == Direction.FROM_NORTH) {
            //state of room plus given a choice user can turn on the lights or allow them to stay off
            visitor.tell("The lights are off");
            char decision = visitor.getChoice("Do you want to turn on the lights?", new char[]{'y', 'n'});
            if(decision == 'y' || decision == 'Y') {
                    boolean lightson = true;
                    visitor.tell("The lights are now on");
            }
            else {
                    //do nothing
                 }
            visitor.tell("If turn south, you can see a door and exit dorm room");
        }

        else if(directionVisitorArrivesFrom == Direction.FROM_EAST) {
            visitor.tell("You can see a chest");
            //asks visitor to make a choice
            if(!chestopen) {
                char choice = visitor.getChoice("Do you want to open the chest?", new char[]{'y','n'});
                if(choice == 'y' || choice == 'Y') {
                    visitor.tell("Opening chest...");
                    chestopen = true;
                    visitor.tell("You have found a wand in the chest");
                    int collectGold = visitor.takeGold(2);
                    Item wand = new Item("wand");
                    boolean takeWand = visitor.giveItem(wand);
                    if(takeWand) {
                        visitor.tell("You are now in possession of a wand");
                    }
                    else {
                        visitor.tell("You are already carrying a wand");
                    }
                }
            }
        }

        else if(directionVisitorArrivesFrom == Direction.FROM_WEST) {
            visitor.tell("You can see a creature");
            //asks visitor to make a choice
            if(!owl_in_room){
                visitor.tell("Stay away");
            }
            else {
                char choice2 = visitor.getChoice("Would you like to pet the owl?", new char[]{'y','n'});
                if(choice2 == 'y' || choice2 == 'Y') {
                        visitor.tell("You have befriended the owl");
                 }
                 else {
                    //do nothing
                 }
            }
        }


        return directionVisitorArrivesFrom;
    
    }

}

