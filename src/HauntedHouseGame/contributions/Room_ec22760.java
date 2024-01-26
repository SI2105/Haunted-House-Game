package HauntedHouseGame.contributions;

class Room_ec22760 extends Room{
    
    static boolean candleOn = false;
    static boolean chestOpen = false;

    public Direction visit(Visitor visitor, Direction direction){
        visitor.tell("Welcome to my room, you have entered from the " + direction);
        
        String firstQ = ("There is a candle in on the side as you enter, would you like to a) light it b) continue walking");
        char[] choices = {'a', 'b'};
        
        String secondQ = ("There is a chest in the middle of the room, would you like to a) open it b) continue walking?");
        
        if(candleOn == true){
            visitor.tell("A candle has been lit up in the room");
        }
        else if(candleOn == false){
            char answer = visitor.getChoice(firstQ, choices);
            if(answer == 'a'){
                visitor.tell("You have lit the candle, the room is now brightly lit!");
                candleOn = true;
            }
            else if(answer == 'b'){
                visitor.tell("You have left the candle off and are making your way towards the middle of the room");
            }
            else{
                visitor.tell("You are making your way towards the middle of the room");
            }
        }
        
        if(chestOpen == true){
            visitor.tell("There is a chest in the middle of the room which has been opened, you missed out on a reward..");
        }
        else if(chestOpen == false){
            char reply = visitor.getChoice(secondQ, choices);
            if(reply == 'a'){
                visitor.tell("You opened the chest and recieved gold coins!");
                visitor.giveGold(4);
                chestOpen = true;
            }
            else if(reply == 'b'){
                visitor.tell("you left the chest and might have missed out on treasure..");
            }
        }
        
        return Direction.opposite(direction);
    }
}
