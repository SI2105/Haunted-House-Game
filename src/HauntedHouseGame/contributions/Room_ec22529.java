package HauntedHouseGame.contributions;

class Room_ec22529 extends Room{
    
    private int numOfGold = 8;
    
    public Direction visit(Visitor visitor, Direction d) {
        
        //giving options to the user
        char[] options= {'a', 'b'};
        
        //obtain previous direction
        if (d == Direction.FROM_NORTH) {
            visitor.tell("You have arrived from the north.");
        } else if (d == Direction.FROM_EAST) {
            visitor.tell("You have arrived from the east.");
        } else if (d == Direction.FROM_SOUTH) {
            visitor.tell("You have arrived from the south.");
        } else if (d == Direction.FROM_WEST) {
            visitor.tell("You have arrived from the west.");
        }
        else{
            visitor.tell("How did you get here?... spooky");
        }
    
        //print out to the user the story
        visitor.tell("You have now entered room ec22529.");
        visitor.tell("The room is very dark and there is a magical bear sleeping in the corner");
        visitor.tell("Do you choose to (a) go and speak to the bear OR (b) ignore the bear and continue on your journey");
        
        //obtain a choice from the user
        char choice = visitor.getChoice("Type in a or b to select your choice", options);
        
        switch(choice){
            case 'a':
            case 'A':
                //take 9 gold from the user
                visitor.tell("The bear attacks you violently but you manage to escape with your life. However, you lost " + numOfGold + " gold in battle. Continue your journey North");
                visitor.takeGold(numOfGold);
                break;
            case 'b':
            case 'B':
                //give 9 gold to the user
                visitor.tell("Smart choice, the bear seemed hungry. Here is a reward of " + numOfGold + "gold for your rational thinking. Continue your journey North");
                visitor.giveGold(numOfGold);
                break;
            default: 
                visitor.tell("You continue your journey north, ignoring the magical bear");         
        }
        //returns them in the north direction
        return Direction.TO_NORTH;
    }
}
