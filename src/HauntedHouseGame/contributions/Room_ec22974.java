package HauntedHouseGame.contributions;

class Room_ec22974 extends Room {
    
    public Direction visit(Visitor v, Direction d) {

        v.tell("| You have entered the MysteRoom |");
        v.tell("You see a large diamond-shaped mirror on your right.");
        v.tell("There is a round poker table in the center of the room.");
        v.tell("You see the following cards on the table:");
        v.tell("Heart: 2,8,4,I");
        v.tell("Spades: 5,V,9,5");
        v.tell("Diamond: 2,9,6,X");
        v.tell("Clubs: 7,L,9,4");

        char[] bool_choice = {'y', 'n'};
        char[] options = {'a', 'b', 'c', 'd'}; 

        char choice = v.getChoice("You see a drawer. Do you wish to open it? (y/n)", bool_choice);

        if (choice == 'y') {
            v.tell("You see a notebook and open it.");
            v.tell("You read:\nCODE HINT\nUnknown letters descend from Roman numerals.");
        }
        else {v.tell("You are not curious enough to become the Lord of our ancient treasures!");}

        v.tell("Guess the code and earn lots of gold!\nOptions:\na) 2841\nb) 5595\nc) 75094\nd) 29610");

        choice = v.getChoice("Select a,b,c or d:\n", options);

        if (choice == 'd') {
            v.tell("You are a genius! The spirits in the room are impressed and award you gold.");
            v.tell("Well Done!");
            v.giveGold(10);
        }
        else {
            v.tell("The spirits in the room are fuming! You manage to run off, but drop some of your gold.");
            v.tell("Better Luck Next Time!");
            v.takeGold(5);
        }

        return d.opposite(d);
    }
}
