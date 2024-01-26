package HauntedHouseGame.contributions;

class Room_ec22739 extends Room {

    int goldInRoom = 10;
    boolean lightStatus = false;
    static final Item SD = new Item("Screwdriver");

    public Direction visit(Visitor v, Direction direction){

        if(direction == Direction.FROM_NORTH){
            v.tell("You came the room from the north.");
        } else if (direction == Direction.FROM_EAST){
            v.tell("You came the room from the east.");
        }else if (direction == Direction.FROM_SOUTH) {
            v.tell("You came the room from the south.");
        }else if (direction == Direction.FROM_WEST) {
                v.tell("You came the room from the west.");
            }

        char[] charArr = {'y', 'n'};
        

        v.tell("This room is formidable... enter at your own risk... (6 golds to enter)");
        
        char visChoice = v.getChoice("Do you wish to enter (y/n)", charArr);
        
        switch(visChoice){
        case 'y':
            lightStatus = true;
            int goldTaken = v.takeGold(6);
            goldInRoom = goldInRoom + goldTaken;
            v.tell("You encounter a elderly looking wise person with a demeaning glare.. he slowly lifts his head to look at you and attempts to engage a conversation");
            if(v.hasEqualItem(SD)){
                v.tell("Ah! you have a screwdriver do you!? Well.. I think you might find this of some help...");
                v.giveItem(new Item("Nails"));
                v.tell("Alright now.. bugger off!");
                v.tell("Leave now. The opposite direction you came from is " + Direction.opposite(direction));
            }
        
        case 'n':{
            v.tell("Well this is awk... proceed to the door opposite then, that" +
            "would be in the " + Direction.opposite(direction) + " direction");
            v.tell("Take some of this gold though.. I have no use of it in a place like this.");
            v.giveGold(3);
            

            }
        }
        return Direction.opposite(direction);
    }


}
