package OOP.ec22612.MP.contributions;

/************************************
 * Winchester Mystery House: Room_ec22789
 * By Newton Nath
 * Student Id: 220298872
 * ***********************************/

class Room_ec22789 extends Room{
    static final Item Pen = new Item("Pen");
    String directionString;
    boolean lightTheCandle = false;
    final int givenAndTakenGold =3;
    public Direction visit(Visitor visitor, Direction direction){

        char [] options = {'1','2','3','4'};

        //assign a string value to a Direction when leaving the room
        if(direction == Direction.FROM_EAST) directionString="East";
        else if(direction == Direction.FROM_NORTH) directionString="North";
        else if(direction == Direction.FROM_SOUTH) directionString= "South";
        else if(direction == Direction.FROM_WEST) directionString = "West";
        else directionString = "unknown";

        visitor.tell("You arrived in a haunted place from " + directionString);
        visitor.tell("Shit! The light just went off. It is pitch dark now.");

        //visitor's options when he enters into my room
        char optionChoosen= visitor.getChoice("1.Light the candle \n" +
                "2. Pick the hammer \n" +
                "3.Pick the book \n" +
                "4.Leave the room", options);

        //set the state of my room to true
        if(optionChoosen == options[0]){
            lightTheCandle = true;
            visitor.tell("Ah, some light now");

        }

        //ultimately light the candle
        else {
            visitor.tell("You can't see a thing. Help yourself lighting the candle.");

            //visitor needs to light the candle first before trying to leave
            optionChoosen = visitor.getChoice("1.Light the candle \n" +
                    "2. Pick the hammer \n" +
                    "3.Pick the book \n" +
                    "4.Leave the room", options);

            if (optionChoosen == options[0]) {
                lightTheCandle = true;
                visitor.tell("Ah, some light now");
            } else {
                visitor.tell("You lost your ability to light a candle out of fear. Don't worry ,\n I will" +
                        "light the candle for you.");
                lightTheCandle = true;
            }
        }

        optionChoosen= visitor.getChoice("1.Light the candle \n" +
                "2. Pick the hammer \n" +
                "3.Pick the book \n" +
                "4.Leave the room", options);
        //print what happens when you take hammer and set a leaving direction
        if(optionChoosen == options[1] && lightTheCandle){
            visitor.tell("Now fight the creep behind the desk.");
            visitor.tell("You killed the creep. Congrats. Here is some gold for you");
            visitor.giveGold(givenAndTakenGold);
            direction = Direction.FROM_NORTH;
        }

        //check whethere you have pen or not, and assign task accordingly
        else if(optionChoosen == options[2] && lightTheCandle){
            if(visitor.hasEqualItem(Pen)){
                visitor.tell("Draw a picture of your favourite fruit.");
                visitor.tell("Top Notch Work");
                visitor.giveGold(givenAndTakenGold);
                visitor.tell("Here is some gold for you");
                direction = Direction.FROM_WEST;
            }
            else{
                visitor.tell("You don't have any pen. Don't worry");
                visitor.giveItem(Pen);
                visitor.tell("Here is a pen for you");
                direction = direction.opposite(direction);
            }
        }
        else if(optionChoosen == options[3] && lightTheCandle){
            visitor.tell("You are too afraid . I will let you leave. Good Luck...");
            direction = Direction.FROM_EAST;
        }
        else{
            visitor.tell("There is enough light in the room. I can feel you are loosing your sense slowly.");
            direction = Direction.FROM_SOUTH;
        }


        //assigns a string value for leaving direction
        if(direction == Direction.FROM_EAST) directionString="East";
        else if(direction == Direction.FROM_NORTH) directionString="North";
        else if(direction == Direction.FROM_SOUTH) directionString= "South";
        else if(direction == Direction.FROM_WEST) directionString = "West";
        else directionString = "unknown";

        visitor.tell("Your leaving direction is " + directionString);
        return direction;
    }
}
