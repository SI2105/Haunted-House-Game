package HauntedHouseGame.contributions;

abstract class Room_ec22930 extends Room{
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
        visitor.tell("Hi");
        return directionVistorArrivesFrom.opposite(directionVistorArrivesFrom);
    }
        
}