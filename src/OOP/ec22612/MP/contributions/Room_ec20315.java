package OOP.ec22612.MP.contributions;

class Room_ec20315 extends Room {
    
    private boolean lightsOn = false; 
    public Direction visit(Visitor visitor, Direction arrivesFrom){ 
        visitor.tell("You have entered the room from " + arrivesFrom);
        if (lightsOn) { 
            visitor.tell("The light is on. You can see around the room. ");
        }
        else { 
            visitor.tell("The light is off. You can't see anything. "); 
        } 

        boolean bookSwitch = false;
        while (!bookSwitch) {
            visitor.tell("There is a bookshelf");
            char choice = visitor.getChoice("What would you like to do?\n" +
            "a. Turn on the lights\n" +
            "b. Turn off the lights\n" +                                 
            "c. Take a book off the shelf\n" +
            "d. Leave the room", new char[]{'a', 'b', 'c', 'd'});
            

            if (choice == 'a') {
                lightsOn = true;
                visitor.tell("You turn on the lights. ");
            } else if (choice == 'b') {
                if(lightsOn==false){
                    visitor.tell("The light was already off. ");
                }else if(lightsOn==true){
                    lightsOn = false;
                    visitor.tell("You turn off the lights. It's dark. ");
                }
            }  else if (choice == 'c') {
                visitor.tell("You take a book off the shelf. "); 
                Item book = new Item("Book");
                visitor.giveItem(book);
            } else if (choice == 'd') {
                visitor.tell("You leave the room.");
            } else {
                visitor.tell("Invalid");
            }
        } 

        return Direction.opposite(arrivesFrom);
    }
}

