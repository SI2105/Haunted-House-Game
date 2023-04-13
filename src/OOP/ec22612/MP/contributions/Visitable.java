package OOP.ec22612.MP.contributions;

interface Visitable {
    
    Direction visit( // Returns direction the visitor leaves towards.
        Visitor visitor,
        Direction directionVistorArrivesFrom);
}