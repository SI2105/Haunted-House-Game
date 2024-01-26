package HauntedHouseGame.contributions;

import java.util.Random;
// Added a guessing game
class Room_ec22429 extends Room {
    
    boolean lights = false;
    boolean empty = false;

    Item piano_sheets = new Item("piano sheets");
    Item piano_key = new Item("piano key");

    public Direction visit (Visitor v, Direction d) {

        v.tell("You are a professional poltergeist investigator. Tonight your job is to investigate the many rooms of the Winchester Mansion and discover their secrets!");
        v.tell("You find yourself in what appears to be a music room. The lights are " + (lights ? "on" : "off") + ".");
        v.tell("There is a) an old piano in the center of the room, b) a chest, c) a piano seat and d) single shelf unit with books on it.");

        char[] choices = {'a','b','c','d'};
        char[] yORn = {'y','n'};
        char[] number = {'0','1','2','3', '4', '5', '6', '7', '8', '9'}; // 48 to 57 in ascii

        char chooseOption = v.getChoice("Which one do you want to invesitgate?" ,choices);
        if (chooseOption == 'a') {
            v.tell("As you approach the piano, it starts playing but no one is there...");
            v.tell("You continue approaching when the piano keys get slammed all together and a poltergeist escapes from the piano.");
            v.tell("It threatens to put a curse on you if you do not give it some of your golden doubloons! What do you do?");
            char pianoGhostChoice = v.getChoice("a) Ignore or b) give the money", choices);
            if (pianoGhostChoice == 'a'){
                v.tell("You got lucky! The ghost thought you couldn't see it. You get to continue your life curse-free.");
            }
            else if (pianoGhostChoice == 'b'){
                v.takeGold(10);
                v.tell("The ghost took the golden doubloons and left you alone. Good news you are curse-free, bad news you are broke.");
            }
        }
        else if (chooseOption == 'b') {
            if (!empty){
                v.tell("Oh wow! You are in luck. Here are 6 golden doubloons!");
                v.giveGold(6);
            }
            else {
                v.tell("Oh bummer! The chest is empty TT");
            }
            
        }
        else if (chooseOption == 'c') {
            v.tell("You approach the seat and inside you find some music sheets and a piano key.");
            char pianoSeatChoice = v.getChoice("Do you wish to take a) the piano sheets or b) the piano key?", choices);
            if (pianoSeatChoice == 'a'){
                v.giveItem(piano_sheets);
            }
            else if (pianoSeatChoice == 'b'){
                v.giveItem(piano_key);
            } 
        }
        else if (chooseOption == 'd') {
            v.tell("You obeserve the books. They are very old.... and dusty. You see 2 books that catch your eye.");
            char bookShelfChoice = v.getChoice("Do you choose a) Twilight : Eclipse or b) Twilight : New Moon ", choices);
            if (bookShelfChoice == 'a'){
                v.giveGold(7);
                v.tell("I see you have very good taste in literature!");
            }
            else if (bookShelfChoice == 'b'){
                v.giveGold(1);
                v.tell("Questionable taste....");
            }
        }

        v.tell("You are tired of exploring the music room. Let's go somewhere else.");
        v.tell("Oh! A ghost has appeared.");
        v.tell("The spirit asks if you took any items from the room? What do you respond with");
        char lieOrtruth = v.getChoice("Did you steal anything? y/n", yORn);
        
        if (lieOrtruth == 'y') {
            v.tell("Thank you for being honest. The ghost will bless you with the chance to win more golden doubloons!");
            v.tell("Would you like to play?");
            char play = v.getChoice("y/n ", yORn);

            if (play == 'y'){
                v.tell("The ghost will think of a random number from 0 to 9. Which number is the ghost thinking of?");
                char guessNumber = v.getChoice("Choose a number inbetween and including 0-9", number);
                Random rnd = new Random();
                char c = (char) (48 + rnd.nextInt(10));

                if (c == guessNumber) {
                    v.tell("You won some golden doubloons");
                    v.giveGold(7);
                    v.tell("Now you can leave, investigator and explore other places");
                    return Direction.TO_EAST;
                }
            }
            else {
                v.tell("Oops.... you lost. But hey, let's look on the bright side.... at least you didn't get cursed.");
                v.tell("Now you can leave, investigator and explore other places");
                return Direction.TO_SOUTH;
            }

        }
        else {
            v.tell("YOU LIED TO THE GHOST! You angered the ghost....");
            v.tell("The ghost decides to take some of your golden doubloons based on the item you stole.");
            if(v.hasIdenticalItem(piano_key)){
                v.takeGold(5);
                v.tell("NOW LEAVE.... before the ghost gets any angrier!");
                return Direction.opposite(d);
            }
            else{
                v.takeGold(3);
                v.tell("NOW LEAVE.... before the ghost gets any angrier!");
                return Direction.opposite(d);
            }
        }
        return Direction.opposite(d);
    }
}
