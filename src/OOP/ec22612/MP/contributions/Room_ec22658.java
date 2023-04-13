package OOP.ec22612.MP.contributions;

class Room_ec22658 extends Room{

    boolean visited = false;

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
        Direction directionVisitorLeavesTo = Direction.TO_NORTH;


        char input = visitor.getChoice("Pick where you would like to go in a)Tunnel b)The Dragon Nest c) Monster Cave d) The Dungeon?",new char []{'a','b','c','d'});

        if (input == 'a'){

            directionVisitorLeavesTo = Direction.TO_NORTH;
            visitor.tell("You Chose Tunnel (A)");
            visitor.giveGold(7);

        }

        else if (input == 'b'){

            directionVisitorLeavesTo = Direction.TO_SOUTH;
            visitor.tell("You Chose The Dragon Nest (B) ");
            visitor.giveGold(2);

        }

        else if (input == 'c'){

            directionVisitorLeavesTo = Direction.TO_EAST;
            visitor.tell("You Chose The Monster Cave (C) ");
            visitor.giveItem(new Item("Sword"));


        }

        else if (input == 'd'){

            directionVisitorLeavesTo = Direction.TO_WEST;
            visitor.tell("You Chose The Dungeon");
            visitor.takeGold(4);

        }

        visitor.tell("This is all we have time for. Maybe next time i will invite you later");



        return directionVisitorLeavesTo; 

    }
}
