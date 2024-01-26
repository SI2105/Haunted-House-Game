package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22897 extends Room {
    private boolean lightsOn;
    private boolean chestEmpty;
    private Item key;

   Room_ec22897() {
        lightsOn = false;
        chestEmpty = false;
        key = new Item("key");
    }

    public Direction visit(Visitor visitor, Direction visitorDirection) {
        
        
        char YN[] = {'y', 'n'};
        int goldTaken = 0;
        int goldPieces = 0;
        
        if(lightsOn == true){
            visitor.tell("You are in Room number ec22897. The lights are on and the visibility is clear. ");
        }else{
            visitor.tell("You are in Room number ec22897. The lights are off and it's hard to see. ");
        }
            

        if (visitorDirection == Direction.FROM_NORTH) {
            visitor.tell("You arrived from north.");
        } else if (visitorDirection == Direction.FROM_EAST) {
            visitor.tell("You arrived from east");
        } else if (visitorDirection == Direction.FROM_SOUTH) {
            visitor.tell("You arrived from south.");
        } else if (visitorDirection == Direction.FROM_WEST) {
            visitor.tell("You arrived from west.");
        }

        //if lights is switched off allow them to turn it on
        if (!lightsOn) {
            visitor.tell("You can't see much in the dark. Do you want to turn the lights on?");
            char choice = visitor.getChoice("Enter 'y' to turn on the lights, 'n' to leave them off: ", YN);
            if (choice == 'y') {
                lightsOn = true;
                visitor.tell("You flick the light switch and the room is illuminated. You can now see more clearly.");
            } else {
                visitor.tell("You decide to leave the lights off, spooky guy");
                lightsOn = false;
            }
        } else {
            visitor.tell("The lights are already on, Do you want to turn it off and explore in the dark?");
            char choice = visitor.getChoice("Enter 'y' to turn off the lights, 'n' to leave it as is: ", YN);
            switch (choice) {
            case 'y':
                visitor.tell("Woah, a spooky guy - the lights are turned off.");
               lightsOn = false;
                break; 
                    
            case 'n':
                visitor.tell("You decide to explore with the lights on.");
                lightsOn = true;
                break;
        }
            
            
        }

        if (visitor.hasEqualItem(key)) {
            visitor.tell("You already have the key. You don't need to search for it.");
        } else {
            visitor.tell("There's a key on the table. Do you want to take it?");
            char choice = visitor.getChoice("Enter 'y' to take the key, 'n' to leave it: ", YN);
            if (choice == 'y') {
                boolean keyAccepted = visitor.giveItem(key);
                if (keyAccepted) {
                    visitor.tell("You take the key from the table. ");
                } else {
                    visitor.tell("You don't have enough space to carry the key. ");
                }
            } else {
                visitor.tell("You leave the key on the table. ");
            }
        }

        if (!chestEmpty) {
            visitor.tell("There's a Chest in the corner of the room. Do you want to open it?");
            char choice = visitor.getChoice("Enter 'y' to open the chest, 'n' to leave it closed: ", YN);
            if (choice == 'y') {
                visitor.tell("You open the chest and find a pile of gold pieces inside. You dig your hand in and grab a handful.");
                goldPieces = new Random().nextInt(7) + 1;
                visitor.tell("you managed to grab " + goldPieces + " gold pieces.");
                visitor.giveGold(goldPieces);
                chestEmpty = true;
            } else {
                visitor.tell("You leave the chest closed.");
            }
        } 
        
        char paintingExplore = visitor.getChoice("You notice the painting hanging on your left moved, would you like to go and explore it? [y] Yes or [N] No", YN);
        
        switch (paintingExplore) {
                //check if they have gold and takes some
            case 'y':
                visitor.tell("You walk to the painting and take it off the wall, and a massive spider jumped on you");
                
                if (goldPieces != 0){
                    
                    
                    goldTaken = visitor.takeGold(goldPieces);

                    goldPieces = goldPieces - goldTaken;
                    if (goldPieces < 0){
                        goldPieces = 0;
                    }

                    if(goldTaken != 0){
                        visitor.tell("The spider made you drop " + goldTaken +" gold pieces, and you can not reach it anymore :( "); 
                        } 
                }
                else{
                    visitor.tell("You got startled and fall onto the couch"); 
                }
                break; 
           
            case 'n':
                visitor.tell("You decide to hurry off because you got spooked.");
                break;
        }

        
        
        
        
        
        // tells the visitor which direction they leave and returns that same direction
         visitor.tell("you have " + goldPieces + " gold pieces left.");
        char exitChoice = visitor.getChoice("Which direction would you wish to leave my room [N] North or [S] South? ",  new char[]{'n', 's'});
        
        
        
        switch (exitChoice) {
            case 'n':
                visitor.tell("Leaving via North");
                return Direction.TO_NORTH;
            case 's':
                visitor.tell("Leaving via South");
                return Direction.TO_SOUTH;
        }

        
        
        //this wont execute as user must choose north or south
        return null;
        
    
    }
}

    
