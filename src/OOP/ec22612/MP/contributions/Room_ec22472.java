package OOP.ec22612.MP.contributions;

class Room_ec22472 extends Room {
    public Direction visit(Visitor visitor, Direction arrivesFrom) {
        visitor.tell("Heres some gold for your effort!");
        visitor.takeGold(7);
        char box = visitor.getChoice("There is a box in the middle of the room. Do you:\n"
                          +"\na, kick the box"
                          +"\nb, leave the box"
                          +"\nc, open the box"
                          +"\nd, flip the box", new char[]{'a', 'b', 'c', 'd'});
        
        if (box == 'a'){
            visitor.tell("There was something hard in the box when you kicked it. You really hurt your foot");
        }
        else if (box == 'b'){
            visitor.tell("Good decision. It was probably nothing anyway...");
        }
        else if (box == 'c'){
            visitor.tell("You found 10 gold");
            visitor.giveGold(10);
        }
        else if (box == 'd'){
            visitor.tell("There was a lil gold nuggie under the box"
                        +"You found 3 gold");
            visitor.giveGold(3);
        }
        
        char direction = visitor.getChoice("Which way would you like to go?"
                                           +"\na, north"
                                           +"\nb, east"
                                           +"\nc, south"
                                           +"\nd, west"
                                           , new char[]{'a', 'b', 'c', 'd'});
        if (direction == 'a'){
            return Direction.TO_NORTH;}
        if (direction == 'b'){
            return Direction.TO_EAST;}
        if (direction == 'c'){
            return Direction.TO_SOUTH;}
        if (direction == 'd'){
            return Direction.TO_WEST;}
        
        return Direction.opposite(arrivesFrom);
    }
}
