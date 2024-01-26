package HauntedHouseGame.contributions;

class Room_ec22900 extends Room{
    
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
        
        visitor.tell("Hello traveler. This room has a simple game, I will think of a number");
        visitor.tell("if you guess a number above my number I will take that much gold from you");
        visitor.tell("if you guess a number below my number I will give you that much gold");
        char[] Nums = {1,2,3,4,5,6,7,8};
        int Choice = visitor.getChoice("I have thought of a number, now you must give me your number", Nums);
        
       
        int n = 4;
        
        int IntChoice = Integer.parseInt(String.valueOf(Choice));
    
        if (IntChoice > n){
            visitor.tell("unlucky I take your money, my number was " + n);
            visitor.takeGold(IntChoice);
        }else if( IntChoice == n){
            visitor.tell("our numbers are the same, no one gets anything :(");
        }else if( IntChoice < n){
             visitor.tell("lucky you! You get to take my money, my number was " + n);
            visitor.giveGold(IntChoice);
        }
    
        return Direction.opposite(directionVistorArrivesFrom);
        
        
        
    }
    

}
