package HauntedHouseGame.contributions;

class Room_ec22827 extends Room {
    public Direction visit(Visitor visitor, Direction entrance){
        boolean friendly = false;
        boolean lights = false;

        visitor.tell("Welcome to the dark room ec22827. Here is 5 gold for you.");
        visitor.giveGold(5);
        visitor.tell("Joking, i'm taking it back.");
        visitor.takeGold(5);



        char [] exits = {'n' , 's' , 'w' , 'e'};
        char guess = visitor.getChoice("Guess which direction is the exit. You have one try.", exits);
        if (guess == exits[3]){
            visitor.tell("Correct!");
            return Direction.TO_EAST;
        }else {
            visitor.tell("Wrong! You may leave the room from where you came from");
            return entrance.opposite(entrance);
        }

    }

}