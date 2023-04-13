package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ec22562 extends Room {
    //New item created
    static final Item Key = new Item("Key");
    //this is true if candle is lit
    static boolean candle = true;

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        //Random number
        Random random = new Random();
        int randInt = random.nextInt(10);
        
        //Array of choices for the user 
        char[] choices = { 'a', 'b', 'c' };
        //variable to store the users choice. Invalid option as default
        char choice = '0';

        //If candle is lit, give these options
        if (this.candle) {
            visitor.tell("You have entered a dark, abandoned room with a trunk, a chest and a single lit candle in the middle");
            choice = visitor.getChoice("You can (a) open the trunk, (b) open the chest or (c)blow out the candle", choices);
        }
        else{ //If candle is not lit, give these options
            visitor.tell("You have entered a dark, abandoned room with a trunk, a chest and a single candle in the middle which has been blown out");
            choice = visitor.getChoice("You can (a) open the trunk, (b) open the chest or (c)relight the candle", choices);
        }
        if (choice == ('a')) {
            //If user opens the trunk, check if user already has a key
            if (visitor.hasEqualItem(Key)) {
                //If the user has already collecteed 
                visitor.tell("You have already collected a key");
            } else {
                //If the user doesnt have the item, give it to them
                visitor.giveItem(Key);
            }
        //If user choses to open the chest
        } else if (choice == ('b')) {
            //Give the user a random number of gold
            visitor.giveGold(randInt);
            //If the candle is lit and the user choses to blow it out
        } else if (choice == ('c') && this.candle) {
            visitor.tell("The candle has been blown out");
            //Candle is now blown out 
            this.candle = false;
            //If the candle is not lit and the user choses to relight it
        } else if (choice == ('c') && !(this.candle)){
            visitor.tell("The candle has been relit");
            //Candle is now lit
            this.candle = true;
        } else{ //If the user enters an invalid option
            visitor.tell("Invalid option");
        }

        //return the opposite direction from where they came from
        return Direction.opposite(directionVistorArrivesFrom);
       
    }
}
