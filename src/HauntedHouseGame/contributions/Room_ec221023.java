package HauntedHouseGame.contributions;

class Room_ec221023 extends Room {
    
    public Direction visit(Visitor vis, Direction dir){
        
        return Direction.opposite(dir);
        // Thats all I have done.
    }
    
}
