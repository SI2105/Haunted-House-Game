package HauntedHouseGame.contributions;

class Room_ec22576 extends Room{
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
        String lights = "powercut"; //lights have been hit by a powercut attack from Mars
        String Poltergiest = "Discombobulated";

        visitor.tell("Oh what great big ears you have, Grandma " +
                "but I still can't hear who asked...");

        char choice = visitor.getChoice("Where you wanna go bro? ('N' or 'S' or 'W' or 'E')", new char[]{'N', 'S', 'E', 'W'});

        if (choice == 'N'){
            return Direction.TO_NORTH;
        }
        else if (choice == 'W'){
            return Direction.TO_WEST;
        }
        else if (choice == 'E'){
            return Direction.TO_EAST;
        }
        else if (choice == 'S'){
            return Direction.TO_SOUTH;
        }

        return directionVistorArrivesFrom;
    }
}
