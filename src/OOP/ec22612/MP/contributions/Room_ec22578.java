package OOP.ec22612.MP.contributions;

import java.util.Random;


class Room_ec22578 extends Room{


    //Set some default moods and environmental factors for room
     String ghostMood="Happy";
     String firePlace="Smoking";
     boolean seenBefore = false;


    //Creates possible items which can be collected in the room

    static final Item winnersChalice=new Item("winners chalice");
    static final Item looserFolly=new Item("Looser Folly");






    //Direction method lets user explore room then sends them on there way
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {

        String entrance="";
        if(directionVisitorArrivesFrom.equals(Direction.FROM_NORTH)){
            entrance="Door";

        }
        if(directionVisitorArrivesFrom.equals(Direction.FROM_EAST)){
            entrance="Secret Book Case";

        }
        if(directionVisitorArrivesFrom.equals(Direction.FROM_SOUTH)){
            entrance="Window";

        }
        if(directionVisitorArrivesFrom.equals(Direction.FROM_WEST)){
            entrance="One way magic portal";
        }
        String greeting="";
        //Check to see if user has won the game before

        if(seenBefore){    //Check to see if user has entered the room before

            greeting="again";

        }
        seenBefore=true;
        visitor.tell("You enter a " +  entrance + " inside is a large room\n" +
                "to the left of you is a " + firePlace + " fireplace " + "and to your right \n"
               + "you see a stall with a " + ghostMood + " ghost\n");
        if(ghostMood.equals("Happy")){
            visitor.tell("Hello friend its nice to see you " + greeting + "\n" +
                    "would you like to play my game " +  greeting);
        }
        else{
            visitor.tell("Oh......its you ");

            visitor.tell("Well as you are here lets play again");
        }
        char[] gameChoice={'a','b','c'};
        char gameChoiceResp=visitor.getChoice("a)To play b)To decline c)Tell the ghost you are not 5", gameChoice);
        if(gameChoiceResp=='a'){
            if(whichCupIsItUnder(visitor)){
                visitor.tell("\"Dam it you win\"....the ghost seems depressed \"here take this\"" +
                        "\n You have received 100 gold");
                visitor.giveGold(100);
                if(visitor.hasEqualItem(winnersChalice)){
                    visitor.tell("\"You already have the chalice so just take my gold\"");
                }
                else {
                    visitor.tell("\"Here take this too\" you received the winner chalice");
                    visitor.giveItem(winnersChalice);

                }
                ghostMood="Sad";
            }
            else{
                visitor.tell("\"HAHA I win....here take this \" you receive the losers folly\n" +
                        "\"oh and give me 100 gold...\"");
                visitor.giveItem(looserFolly);
                visitor.takeGold(100);
                ghostMood="Happy";

            }

            return exit(visitor,directionVisitorArrivesFrom);
        }
        if(gameChoiceResp=='b'){
            if(visitor.hasEqualItem(Room_ec22889.IMMORTAL_REACTOR)){
                visitor.tell("\"Hey! You dropped something\" you picked up the Immortal reactor (be careful with that)");
                visitor.tell("\"That reminds me one of my friends wanted you to have this\" you are returned your purple mask ");
                visitor.giveItem(Room_ec22919.MASK);
            }

            return exit(visitor,directionVisitorArrivesFrom);
        }
       else {
            visitor.tell("The room grows cold.......");
            if (firePlace.equals("Smoking")) {
                visitor.tell("The flame from the fireplace goes out");
            }
            visitor.tell("\"Oh...fine just leave then I didn't like you anyways\"");
            ghostMood = "Angry";
            firePlace = "cold";
            return exit(visitor, directionVisitorArrivesFrom);
        }
    }


    //Allows the user to exit the room from a couple of different directions
    public static Direction exit(Visitor visitor, Direction arrival){
        visitor.tell("Looks like its time to leave which way should we go");
        char[] exitOptions={'a','b','c','d'};
        char exitChoice=visitor.getChoice("a)Exit through a wooden door b)Exit through a window\n" +
                "c)Exit through a secret bookcase + d)go back the way you game",exitOptions);
        if(exitChoice=='a'){
            return Direction.TO_NORTH;
        }
        else if(exitChoice=='b'){
            return Direction.TO_SOUTH;
        }
        else if(exitChoice=='c'){
            return Direction.TO_EAST;
        }
        else {
            return Direction.opposite(arrival);
        }
    }


    //Play the cup game with the ghost returns true is correct
    public static Boolean whichCupIsItUnder(Visitor visitor){
        visitor.tell(
                "In front of you, you see 8 cups, the ghost places a golden bead\n"+
                        "inside on of them and shuffles the Cups 4\n"+
                        "If you lose you give me 100 gold and I will give you the item 'losers folly'\n"+
                        "If you Win I will give you 100 gold and award you the golden chalice\n");
        int number=randomNum(8);
        char[] choices = {'1','2','3','4','5','6','7','8'};
        char choicesResp=visitor.getChoice("The ghost shuffles the cups, you must pick the correct cup select from 1-8", choices);
        int choiceConv=Integer.parseInt(String.valueOf(choicesResp))-1;
        return choiceConv == number;

    }
    //Generate a random number
    public static int randomNum(int limit){
        Random random = new Random();
        return random.nextInt(limit);
    }

}
