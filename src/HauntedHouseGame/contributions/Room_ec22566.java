package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22566 extends Room{
    public Direction visit (Visitor v, Direction d){
        boolean visited = false;
        if (!visited){ //Checks if visited is false and allows the user to enter if it is.
            Random r = new Random();
            boolean lucky = r.nextBoolean();

            v.tell("Welcome to the Room Of Fate!!" + 
            "\nThe lights are now on." + 
            "\nYou will either recieve 10 gold or lose 10 gold. Are you feeling lucky.");

            if (lucky){ //checks if lucky is true and gives the user 10 gold if it is or takes 10 if it is not
                v.giveGold(10);
                v.tell("You have been quite lucky.");
            }
            else{
                v.takeGold(10);
                v.tell("Your gold is mine.");
            }
            v.tell("Off to the east u go visitor.");
            
            visited = true;
            return Direction.TO_EAST;
        }
        //If visited is true this branch is used to send the user back to where they came from.
        else{
            v.tell("Welcome to the Room Of Fate!!" + 
            "\nThe lights are now off." + 
            "\nThere is no gold while the lights are off." + 
            "\nExit where you entered and come back next time for another shot at the gold.");
            visited = false;
            
            return Direction.opposite(d);
        }
    }
}
