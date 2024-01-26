package HauntedHouseGame.contributions;//imports what is needed for my room to run
import java.util.Random;
import java.util.Scanner;

//creates a child class of the Room
class Room_ec22548 extends Room {

    public Direction visit(Visitor visitor, Direction visitorArrivalDirection) {
        //creates a scanner so code can take inputs
        Scanner scan = new Scanner(System.in);

        visitor.tell("You have arrived in a dark room, you hear a faint growling, it seems like you are not alone.");

        //uses given information from visitor class to give options of what to do in room
        String searchOrRunQuestion = "Will you run away or search the room for items? (r = run away, s = search room): ";
        char[] searchOrRunOptions = new char[] {'r','s'};
        char searchOrRun = visitor.getChoice(searchOrRunQuestion, searchOrRunOptions);

        //sets up a random amount of gold between 0-10 gold to give or take from the playe based on their choice later
        Random num = new Random();
        int numGold = num.nextInt(10);
        while ((numGold >= 10) || (numGold <= 0)) {
            numGold = num.nextInt(10);
        }

        //checks if plater chose to search roon
        if (searchOrRun == 's') {
            //gives specific options about searching the room
            String searchAreaQuestion = "Would you like to search thse treasure chest in the corner or under the oak trapdoor? (t = treasure chest, o = oak trapdoor): ";
            char[] searchAreaOptions = new char[] {'t','o'};
            char searchArea = visitor.getChoice(searchAreaQuestion, searchAreaOptions);

            //if bad option selected takes away the random amount of gld that was assigned earlier
            if (searchArea == 't') {
                visitor.takeGold(numGold);

                visitor.tell("Bad luck :( you triggered the trap and dropped 10 gold running away.");
            } 
            //if good option is picked gives the random amount of gold plus an item
            else if (searchArea == 'o') {
                visitor.giveItem(new Item("Rusted Key"));

                visitor.giveGold(numGold);
                    
                visitor.tell("You sneak past the traps around the trapdoor and find some gold and a rusted key.");
                visitor.tell("Maybe the key will come in useful in another room.");
            }
            //if someone no option that is valid is picked little easter egg is given
            else {
                visitor.giveItem(new Item("Easter egg from room ec22548"));
                visitor.tell("It seems you have clipped through the room, returning you fro whence you came.....");
            }
        }


        //returns the opposite direction from where you came from
        return visitorArrivalDirection.opposite(visitorArrivalDirection);
    }
}
