package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22938 extends Room {
    
    static final Item watch = new Item("Watch");
    static final Item coat = new Item("Coat");
    static final Item matchsticks = new Item("Matchsticks");
    
    public Direction visit (Visitor visitor, Direction directionArrivedFrom) {
        
        visitor.tell("Welcome to the Seance Room");
        visitor.tell("It is believed that Sarah Winchester herself came to the Seance Room every day at midnight to talk to the 'good' spirits.");
        visitor.tell("The 'good' spirits would give her the visions for the house that would help confuse the 'bad' spirits.");
        visitor.tell("But how was she so sure she was speaking to the 'good' spirits...?");
        
        visitor.tell("The Seance room is only available at midnight, please check the your watch:");
        visitor.giveItem(watch);
        
        String time = "";
        Random rand = new Random();
        
        // Checks if its the correct time
        if (rand.nextInt(1) == 0) {
            visitor.tell("Time - 00:00am");
            time = "00:00am";
            visitor.tell("You have been awarded gold for coming on time");
            // If user loses gold, this guarantees that the user loses gold they already own instead of going into negative
            visitor.giveGold(3);
        }
        else {
            visitor.tell("Time - 11:00pm");
            time = "11:00pm";
            visitor.tell("The seance room has not been made available yet. Please leave. Now.");
        }
        
        
        // If it is midnight, they may proceed
        if (time.equals("00:00am")) {
            visitor.tell("It is midnight...you may proceed.");
            
            char[] sideOptions = {'l','r'};
            visitor.tell("There are candles to your left and to your right, there are clothing hooks.");
            char choice = visitor.getChoice("Would you like to go left or right? (l/r)", sideOptions);
            
            String candleOrHook = "";
            String message = "";
            String message2 = "";
            String itemName = "";
            
            
            if (choice == 'l') {
                candleOrHook = "candle";
                visitor.tell("Here is a box of matchsticks.");
                visitor.giveItem(matchsticks);
                itemName = "matchstick";
                message = "Sarah used these candles to hold her seances every day...why 13?";
                message2 = "You must light one of these candles.";
            }
            else if (choice == 'r') {
                candleOrHook = "hook";
                visitor.tell("Here is a coat.");
                visitor.giveItem(coat);
                itemName = "coat";
                message = "Sarah used these hooks to hold her clothes every seance...why 13?";
                message2 = "You must hook your coat on one of these candles.";
            }
            
            char[] numOptions = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd'};
            
            // User may make a choice in order to gain or lose some gold
            visitor.tell("There are 13 " + candleOrHook + "s.");
            visitor.tell(message);
            visitor.tell("Its believed that Sarah Winchesters favourite number was 13...wonder why.");
            visitor.tell(message2);
            visitor.tell("You have 13 options. Pick a number between 1-13.");
            visitor.tell("For numbers above 9, you must select the corresponding letter:");
            visitor.tell("a = 10, b = 11, c = 12, d = 13");
            choice = visitor.getChoice("Pick your option between 1-13. You only have one " + itemName + "...choose carefully.", numOptions);
            
            int randomNum = rand.nextInt(12);
            
            if (choice == numOptions[randomNum]) {
                visitor.tell("Congratulations! You selected the correct " + candleOrHook + ".");
                visitor.tell("You have awoken the good spirits. You have been awarded gold.");
                visitor.giveGold(10);
            }
            else {
                visitor.tell("Oh no! You selected the wrong " + candleOrHook + ".");
                visitor.tell("You have awoken the bad spirits. They have stolen some of your gold.");
                visitor.takeGold(3);
            } 
        }
        
        // Leaving
        return Direction.opposite(directionArrivedFrom);
    }
}
