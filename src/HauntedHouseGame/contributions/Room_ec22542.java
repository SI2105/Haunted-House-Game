package HauntedHouseGame.contributions;

class Room_ec22542 extends Room{

    @Override
    public Direction visit(Visitor ovisitor, Direction directionVisitorArrivesFrom){
        ovisitor.tell("The room you are in has 4 doors");
        char[] doorChoice = {'N','E', 'S', 'W'};
        char userDecision = ovisitor.getChoice("Which door do you want to choose, {N,E,S,W}", doorChoice);
        if(userDecision=='N'){
            ovisitor.giveGold(5);
            return Direction.TO_NORTH;
        }
        else if(userDecision=='E'){
            ovisitor.takeGold(2);
            return Direction.TO_EAST;
        }
        else if(userDecision=='S'){
            ovisitor.giveGold(1);
            return Direction.TO_SOUTH;
        }

         else if(userDecision=='W'){
            ovisitor.giveGold(3);
            return Direction.TO_WEST;
        }

            ovisitor.tell("Sorry, you did not choose a door to go through.");
            ovisitor.takeGold(7);
            return Direction.TO_SOUTH;



        }
    }
    
    



