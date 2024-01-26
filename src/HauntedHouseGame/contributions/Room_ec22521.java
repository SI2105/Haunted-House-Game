package HauntedHouseGame.contributions;

class Room_ec22521 extends Room
{
    public Direction visit(Visitor visitor, Direction directionFrom){

        if(visitor.hasIdenticalItem(new Item("bananas"))){

        visitor.tell("Nice banana");
        visitor.giveGold(1);
        }

        else if(visitor.hasIdenticalItem(new Item("porridge"))){

        visitor.tell("Have your breakfast");
        visitor.giveGold(1);
        } 

        else{

        visitor.tell("you make no sense");
        visitor.takeGold(1);
        }

        char path = visitor.getChoice("which direction are you going?", new char [] {'N', 'E', 'S', 'W'});

        if(path=='N'){
        return Direction.TO_NORTH;
        }

        else if(path=='E'){
        return Direction.TO_EAST;
        }

        else if(path=='S'){
        return Direction.TO_SOUTH;
        }

        else if(path=='W'){
        return Direction.TO_WEST;
        }
        else{
        System.out.println("You're lose :/");
        return Direction.opposite(directionFrom);
        }

    }

}
