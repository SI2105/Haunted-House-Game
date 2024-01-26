package HauntedHouseGame.contributions;

class Room_ec22893 extends Room{
    boolean lightsOn;
    int gold;

    public Direction visit(Visitor visitor, Direction directionOfArrival){

        visitor.tell("You enter a room");
        if(lightsOn){
            visitor.tell("This is a bright room");
        }
        else{
            visitor.tell("This is a dark room");
        }

        if(gold>0){
            visitor.tell("There are "+gold+" gold in the room");
        }
        else{
            visitor.tell("There is no gold in the room");
        }

        char[]options={'l','t'};
        String description= ("Would like to light the room?(l) or take the gold(t)?");
        char decision = visitor.getChoice(description, options);

        if (decision=='l'){
            if (lightsOn){
                visitor.tell("The room is already light");
            }
            else{
                visitor.tell("You light the room");
                lightsOn=true;
            }
        }

        if (decision=='t'){
            if (!lightsOn){
                visitor.tell("You can't see anything because the room is dark");
            }
            else {
                if (gold>0){
                    gold = gold-1;
                    visitor.tell("You take 1 gold, there are "+gold+" gold in the room now");
                }
                else {
                    visitor.tell("There is no gold in the room");
                }
            }
        }

        return Direction.opposite(directionOfArrival);

    }

    public static void main(String[] args) {
    }
}
