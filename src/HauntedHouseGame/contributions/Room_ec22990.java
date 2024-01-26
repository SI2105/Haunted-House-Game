package HauntedHouseGame.contributions;

class Room_ec22990 extends Room {
    
    private int gold;
    public Room_ec22990(){
        gold = 5;
    }
    
    public Direction visit(Visitor visitor, Direction direction) {
        
        visitor.tell("Hi, you are in a castle");
        
        char choice = visitor.getChoice("There are 4 bosses, choose the direction ('1', '2', '3', '4')", new char[]{'1', '2', '3', '4'});
        
        if (choice == '1') {
            visitor.tell("You selected boss number 1. He was a powerful enemy, that attacked you. You will need to go to the opposite direction, there is a hospital, where you can get healed");
            visitor.giveGold(1);
            return Direction.TO_SOUTH;
        } else if (choice == '2') {
            visitor.tell("You selected boss number 2. He was a powerful enemy, that attacked you. You will need to go to the opposite direction, there is a hospital, where you can get healed");
            visitor.giveGold(1);
            visitor.giveItem(new Item("Winchester Rifle"));
            return Direction.TO_NORTH;
        } else if (choice == '3') {
            visitor.tell("You selected boss number 3. He was a powerful enemy, that attacked you. You will need to go tothe opposite direction, there is a hospital, where you can get healed");
            visitor.giveGold(1);
            return Direction.TO_WEST;
        } else if (choice == '4') {
            visitor.tell("You selected boss number 4. He was a powerful enemy, that attacked you. You will need to go to the opposite direction, there is a hospital, where you can get healed");
            visitor.giveGold(1);
            return Direction.TO_EAST;
        } 
    return Direction.TO_EAST;
    }
}
