package HauntedHouseGame.contributions;

class Room_ec22541 extends Room {

    boolean empty = false;

    Item book = new Item("book");
    Item key = new Item("key");
    Item pk_cards = new Item("pokemon cards");

    public Direction visit (Visitor v, Direction d) {

        v.tell("You are travelling to the Winchester mansion, an abondoned mansion located in San Jones, California in hopes of progressing your research on the behaviour of poltergeist");
        v.tell("When entering the mansion, You feel a mystery chill tingle down your spine, and you notice:");
        v.tell("There is a) a stone statue of a man in the hallway, b) a bookshelf with only one book, c) a small wooden wardrobe, d) a box of pokemon cards");

        char[] option = {'a','b','c','d'};

        char chooseOption = v.getChoice("What would you like to see?" ,option);
        if (chooseOption == 'a') {
            v.tell("You approach the statue and begin inspecting");
            v.tell("The statue has a slender physique, with a ribbon hat on top");
            v.tell("Made of stone, and on the bottom, the words -- My residence of forever: Sarah Winchester --");
            v.tell("You notice on the hip of a statue what seems to be like a lock with a key fit");
            v.tell("[Must be nothing], you tell yourself");
            
            
            
        }


        else if (chooseOption == 'b') {
            v.tell("You take your steps to the bookshelf to inspect the book you saw");
            v.tell("You pick up the book, and begin to read ... blank pages...");
            v.tell("You flip through the entire book, full of blank pages, until you come across:");
            v.tell("[Find it. use 1922. pl_a__, I d__'t w_n_ __ ___]");
            v.tell("The rest of the pages content seem smudged and damaged, so you cannot seem to read the rest");
            v.tell("At the back of the book, you find a small slender key");
            v.tell("[hmmmmmm]");
            v.tell("[...Must be nothing...]");
            v.giveItem(book);
            v.giveItem(key);
            

        }
        
        else if (chooseOption == 'c') {
            if (!empty){
                v.tell("You open the wardrobe and find... 4 GOLD PIECES. WOW!");
                v.giveGold(4);
            }
            else {
                v.tell("You open the wardrobe and find... nothing... you've been had...");
            }
            
        }   
        else if (chooseOption == 'd') {
            v.tell("Nice pick-up!");
            v.giveItem(pk_cards);
            
        }

        v.tell("You are tired of exploring the music room. Let's go somewhere else.");
        v.tell("Oh! A ghost has appeared.");
        if(v.hasIdenticalItem(book)){
            v.tell("YoU h4v£... ThE b0()k...");
            v.tell("go... NOW");
            return d.TO_EAST;
        }
        else {
            return d.opposite(d);
            
        }
    }
}


