package OOP.ec22612.MP.contributions;

class Room_ec221085 extends Room {
    private boolean lights = false;
    private boolean paranormalActivities = false;
    private boolean coldtemp = false;
    private boolean fireplace = false;
    private Direction directionVisitorArrivesFrom;

    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        //indication to show visitor has entered
        visitor.tell("You have entered the fireplace");


        if(directionVisitorArrivesFrom == Direction.FROM_NORTH) {
            //state of room plus given a choice user can turn on the lights or allow them to stay off
            visitor.tell("The lights are off");
            char decision = visitor.getChoice("Do you want to turn on the lights?", new char[]{'y', 'n'});
            if(decision == 'y' || decision == 'Y') {
                    lights = true;
                    visitor.tell("The lights are now on");
                    char choice = visitor.getChoice("I have heard weird stories regarding this fire place. do you feel cold?",  new char[]{'y','n'});
                    if(choice == 'y' || choice == 'Y') {
                        coldtemp = true;
                        choice = visitor.getChoice("Any weird activities you might have seen?", new char[]{'y','n'});
                        if(choice == 'y' || choice == 'Y') {
                            visitor.tell("So let us move on from this room. I have heard phantoms are not good friend of people");
                            paranormalActivities = true;
                        }else{
                            visitor.tell("Good, nothing unpleasnt about this room then... let us move on...");
                        }
                        
                    }else{
                        choice = visitor.getChoice("Any paranormal activities you might have seen?", new char[]{'y','n'});
                        if(choice == 'y' || choice == 'Y') {
                            visitor.tell("Then why are standing there? MOVE!");
                            paranormalActivities = true;
                        }else{
                            visitor.tell("Then this room is safe. let us move on to a more pleasent room");
                        }
                    }
                }
                else {
                    visitor.tell("Then becareful where you are stepping your foot");
                    if(!fireplace) {
                        char choice = visitor.getChoice("Do you want to fire up the fireplace?", new char[]{'y','n'});
                        if(choice == 'y' || choice == 'Y') {
                            visitor.tell("Fireplace in now working.");
                            fireplace = true;
                        }
                        visitor.tell("Well,nothing really interesting in site just a book floating in the air");
                        choice = visitor.getChoice("Well, I would say this room is hunted what about you?", new char[]{'y','n'});
                        if(choice =='y'){
                            paranormalActivities = true;
                            visitor.tell("Then I do not recommend you to stay here for the night");
                        }else{
                            visitor.tell("Okay then, nothing about a floating book is weird...");
                        }
                    }   

                    visitor.tell("If turn south, you can see a door and exit the fireplace");
                }
            }

        else if(directionVisitorArrivesFrom == Direction.FROM_EAST) {
            visitor.tell("The lights are off");
            char decision = visitor.getChoice("Do you want to turn on the lights?", new char[]{'y', 'n'});
            if(decision == 'y' || decision == 'Y') {
                    lights = true;
                    visitor.tell("The lights are now on");
            }
            else {
                    //do nothing
                 }
            visitor.tell("The fireplace is infront of you.");
            //asks visitor to make a choice
            if(!fireplace) {
                char choice = visitor.getChoice("Do you want to fire up the fireplace?", new char[]{'y','n'});
                if(choice == 'y' || choice == 'Y') {
                    visitor.tell("Fireplace in now working.");
                    fireplace = true;
                    
                    if(fireplace || lights){
                        visitor.tell("There is a book on the table next to you and a peice of gold");
                        int collectGold = visitor.takeGold(1);
                        //item book
                        Item book = new Item("Book");
                        boolean takeBook = visitor.giveItem(book);
                        if(takeBook) {
                            visitor.tell("The book is dusty and seems old, maybe you can find something in it");
                            choice = visitor.getChoice("Do you want open the book?", new char[]{'y','n'});
                            if(choice == 'y'){
                                visitor.tell("you found a peice of gold!");
                                collectGold += visitor.takeGold(1);
                            }
                        }
                        else {
                            visitor.tell("do not regret the chances you did not take.");
                        }
                    }
                    else{
                        visitor.tell("You can not see anything. Becareful!");
                        choice = visitor.getChoice("Do you feel cold?", new char[]{'y','n'});
                        if(choice == 'y' || choice == 'Y') {
                            visitor.tell("Well, make sense as you did not fire up the fire place, but it can be something more paranormal...");
                            coldtemp = true;

                        }else{
                            visitor.tell("Well, maybe somebody was here before you arrived...  maybe that is why the fireplace is off...");
                        }
                    }
                }
            }
        }

        else if(directionVisitorArrivesFrom == Direction.FROM_WEST) {
            visitor.tell("The lights are off");
            char decision = visitor.getChoice("Do you want to turn on the lights?", new char[]{'y', 'n'});
            if(decision == 'y' || decision == 'Y') {
                    lights = true;
                    visitor.tell("The lights are now on");
            }
            else {
                    //do nothing
            }
                 visitor.tell("The fireplace is infront of you.");
            //asks visitor to make a choice
            if(!fireplace) {
                char choice = visitor.getChoice("Do you want to fire up the fireplace?", new char[]{'y','n'});
                if(choice == 'y' || choice == 'Y') {
                    visitor.tell("Fireplace in now working.");
                    fireplace = true;
                }

                visitor.tell("The fireplace feels eerie. a wind turned fireplace off!");
                fireplace = false;
                //asks visitor to make a choice

                choice = visitor.getChoice("Does the room feel really cold?", new char[]{'y','n'});
                if(choice =='y'){
                    coldtemp = true;
                    visitor.tell("intersting... a ghost might lerk around.");
                    choice = visitor.getChoice("Is anything feel really off place?", new char[]{'y','n'});
                        if(choice =='y'){
                            paranormalActivities = true;
                            visitor.tell("Then I do not recommend you to stay here for the night");
                        }else{
                            visitor.tell("Then it is safe... probably.");
                        }
                }
                else {
                    visitor.tell("I see, then this room is safe. but becareful of what lerk in the shadows...");
                }
            }
        }


        return directionVisitorArrivesFrom;
    
        
    }

}



