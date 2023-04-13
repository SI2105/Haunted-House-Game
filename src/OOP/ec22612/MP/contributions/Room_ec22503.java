package OOP.ec22612.MP.contributions;

class Room_ec22503 extends Room {

   
    public Direction visit(Visitor visitor, Direction direction) {

        // Create and declare variables
        int tGold;
        boolean openWindow = true;
        char choices_yn = '0'; // get users choice yes or no (sub choices)
        char choices_la = '0'; // get users choice the letters (main choices)
        final Item Map = new Item("map"); // new Item created is map

        char[] visitorChoiceLa = { 'a', 'b', 'c', }; // create char array for letters options
        char[] visitorChoiceYn = { 'Y', 'N' }; // create char array for yes and no options

        visitor.tell("We're taking a trip back to 1906");

        // Print the first message for the four directions as an introduction

        if (direction == Direction.FROM_SOUTH) {

            visitor.tell(
                    " The south gate led you here, there are many secrets and stories hidden in this old antique room");

        } else if (direction == Direction.FROM_EAST) {

            visitor.tell(
                    "The east gate led you here ,there are many secrets and stories hidden in this old antique room");

        } else if (direction == Direction.FROM_NORTH) {

            visitor.tell(
                    "The north gate led you here ,there are many secrets and stories hidden in this old antique room");

        } else if (direction == Direction.FROM_WEST) {

            visitor.tell(
                    "The west gate led you here, there are many secrets and stories hidden in this old antique room");

        }

        choices_la = visitor.getChoice(
                "Are you going to a) leave and go up stairs b) open the windows c) check the box next to the fireplace",
                visitorChoiceLa);

        if (choices_la == ('a')) { // user choose a

            // Print a message for the selected option
            visitor.tell("Let's go upstairs to the orange bedroom");
            // using getChoice and yes or no should be selected by the user
            choices_yn = visitor.getChoice(" Do you want to open the small wooden box on the dresser? Y or N",
                    visitorChoiceYn);
            if (choices_yn == 'Y') { // if yes users will receive an integer number of gold

                visitor.tell("Some golden have been collected ");
                visitor.giveGold(8);

            } else { // else means no, an integer number of gold will be taken from the user

                visitor.tell("Oops, lost some gold");
                tGold = visitor.takeGold(3);
            }

        }
        if (choices_la == ('b')) { // user choose b

            choices_yn = visitor.getChoice("Do you want the windows to be open? Y or N", visitorChoiceYn);

            if (choices_yn == 'Y') {

                openWindow = true; // open window is true

                // Print a message for the selected option
                visitor.tell("It's time to open the windows and let the light in and Some golden have been collected");
                
                //users will receive an integer number of gold
                visitor.giveGold(4);

            } else {

                openWindow = false;// open window is false

                // Print a message for the selected option
                visitor.tell("We're not opening the window, as you want ");

            }
        }
        if (choices_la == ('c')) { // user choose c

            // Print a message for the selected option
            visitor.tell("Check out what's inside the box");

            if (visitor.hasEqualItem(Map)) { // Check if the user has an equal item first

                // Print a message tell the user he already has the item (map)
                visitor.tell("You've got this item before");
            } else {

                visitor.giveItem(Map); // Give the user the item (map)
            }

            // print a message moving to a different room
            visitor.tell("...... I hear something here!! It's time to leave!");

        }

        // returne to the oppsite direction
        return Direction.opposite(direction);

    }

}
