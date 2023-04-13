package OOP.ec22612.MP.contributions;

class Room_ec22462 extends Room {

    static boolean firstVisit = true; // different messages depending on first or nth visit

    // different states the room can take
    static boolean pianoKeylid = true;
    static boolean steam = true;

    public Direction visit(Visitor v, Direction d) {

        v.tell("You entered room ec22462.");
        if (firstVisit==true) {v.tell("Steam envelops the room. Is a pipe leaking?");}
        else {
            if (steam=true) {v.tell("Unsurprisingly, steam still envelops the room.");}
            else {v.tell("The room is clear and you have full visibility.");}
        }
        v.tell("Do you want to:");
        char [] ui = {'a','b'};
        char option = v.getChoice("(a) Exit immediately (b) Explore", ui);

        switch(option) {
            case 'a': // nothing happens
                v.tell("Boooooring.");
                firstVisit=false;
                break;
                
            case 'b': // follows a set path of interactions depending on first or nth visit
                if (firstVisit==true) {v.tell("You decide to explore the room.");}
                else {v.tell("You decide to explore the room once again.");}
                if (steam==true) {removeSteam(v);}
                piano(v);
                v.tell("It appears there is nothing left to explore.");
                v.tell("You leave room ec22462 through an exit opposite the entrance.");
                firstVisit=false;
                break;
        }
        return Direction.opposite(d); // returns opposite of direction entered
    }

    void removeSteam(Visitor v) { // interaction to remove the steam in the room
        if (firstVisit==true) {v.tell("It might be a good idea to get rid of the steam in this room.");}
        else {
            v.tell("After experiencing what happened last time,");
            v.tell("surely you'll get rid of the steam now, right?");
        }
        
        char [] ui = {'y', 'n'};
        char option = v.getChoice("Get rid of the steam? (y/n)", ui);
        if (option == 'y') { // yes option
            v.tell("You follow the sound of the steam.");
            v.tell("Looks like a pipe was leaking. You fix it.");
            steam = false;
            v.tell("Your visibility is clearer. A vent system pulls away the steam.");
        }
        else if (option == 'n') { // no option
            v.tell("Suit yourself.");
            if (firstVisit==true) {
                v.tell("You slip and fall. Nice one.");
                v.tell("Some gold drops from your pockets as a result, to add insult to injury. (-5)"); 
            }
            else {
                v.tell("You slip and fall again. You really don't learn.");
                v.tell("You lose more gold. (-5)");
            }
            v.takeGold(5);
        }
    }

    void piano(Visitor v) { // interaction to play piano

        if (steam==false) { // if the steam is cleared
            v.tell("Looking around, you notice a piano.");
            if (pianoKeylid==false) {v.tell("The keylid is open from the last time you played it.");}
            v.tell("Surprise, surprise, you're faced with another choice.");
            char [] ui = {'y', 'n'};
            char option = v.getChoice("Play the piano? (y/n)", ui);
            if (option == 'y') {
                if (firstVisit==true) { // yes option
                    v.tell("You open the keylid and find a bag of gold!");
                    v.tell("Must be your lucky day! (+5)");
                    v.giveGold(5);
                    pianoKeylid=false;
                }
                v.tell("You start playing an elegant classical piece.");
                v.tell("Satisfied, you stand up. If only you had an audience.");
            }

            else if (option == 'n') { // no option
                v.tell("Maybe another time, you decide.");
            }
        }

        else { // if the steam is not cleared
            v.tell("Trying not to make the same mistake again,");
            v.tell("you feel around you and feel something that resembles a piano.");

            if (pianoKeylid==false) {v.tell("From feeling the keys,");
                v.tell("you can deduce the keylid is open from the last time you played it.");}
            v.tell("An idea pops into your head.");

            char [] ui = {'y', 'n'};
            char option = v.getChoice("Play the piano? (y/n)", ui);

            if (option == 'y') { // yes option
                if (firstVisit==true) {
                    v.tell("You open the keylid and start playing. Not well, however.");
                    v.tell("It, unsurprisingly, sounds awful, given you can't see");
                    v.tell("the keys you're pressing.");
                    pianoKeylid=false;
                }
                else {v.tell("Same old deal. It sounds horrible.");}
            }

            else if (option == 'n') { // no option
                v.tell("Probably your best decision so far,");
                v.tell("given that steam would impair your ability to play.");
            }

        }
    }
}
