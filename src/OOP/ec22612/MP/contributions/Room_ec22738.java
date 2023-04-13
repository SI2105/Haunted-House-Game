package OOP.ec22612.MP.contributions;

class Room_ec22738 extends Room{
    static final Item TORCH = new Item("Torch");
    public Direction visit (Visitor v1, Direction d1){
            
        if (d1==Direction.FROM_NORTH){
            v1.tell("The room is pitch black, but suddenly torches light up all around the room and you see a chest on your left.");
        }
        else if (d1==Direction.FROM_SOUTH){
            v1.tell("The room is pitch black, but suddenly torches light up all around the room and you see a chest on the far corner on the right.");
        }
        else if (d1==Direction.FROM_WEST){
            v1.tell("The room is pitch black, but suddenly torches light up all around the room and you see a chest on the far corner on the left.");
        }
        else if (d1==Direction.FROM_EAST){
            v1.tell("The room is pitch black, but suddenly torches light up all around the room and you see a chest on your right.");
        }
        
        char c1  = 's';
        
        c1 = v1.getChoice("Would you like to approach the chest and open it? Y/N", new char[]{'Y','N'});

        if (c1 == 'Y'){
            if (v1.hasEqualItem(TORCH)) {
                System.out.println("The chest unfortunately only has a single piece of gold inside it.");
                v1.giveGold(1);
            }
            else{
                System.out.println("Lucky you! The chest has lots of gold inside it.");
                v1.giveGold(10);
            }
        }
        

        c1 = v1.getChoice("What side would you like to leave the room from? N/S/W/E", new char[]{'N','S','W','E'});
        
        if (c1=='N'){
            return Direction.TO_NORTH;
        }
        else if (c1=='S'){
            return Direction.TO_SOUTH;
        }
        else if (c1=='W'){
            return Direction.TO_WEST;
        }
        else if (c1=='E'){
            return Direction.TO_EAST;
        }
        
        return d1;
    }
}
