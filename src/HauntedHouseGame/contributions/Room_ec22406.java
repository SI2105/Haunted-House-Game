package HauntedHouseGame.contributions;

class Room_ec22406 extends Room {

	public Direction visit(Visitor visitor, Direction directionOfArrival){
        visitor.tell("Welcome to Room_ec22406. Prepare for a riddle.");

        if(answerRiddle(visitor)){
            visitor.tell("Well done. Enjoy your rewards.");
            Item amulet = new Item("Amulet");
            visitor.giveItem(amulet);
            visitor.giveGold(20);
        } else {
            visitor.tell("Wrong. Actions have consequences.");
            int goldTaken = visitor.takeGold(5);
            visitor.tell("Say goodbye to " + goldTaken + " gold.");
        }

        visitor.tell("Get out of my sight.");
        return Direction.opposite(directionOfArrival);
    }

    public Boolean answerRiddle(Visitor visitor){
        char[] choices = {'A', 'B', 'C', 'D'};
        char visitorChoice = visitor.getChoice("What is always in front of you but can't be seen? A) Future B) Reflection C) Air D) Shadow", choices);

        if(visitorChoice == 'A'){
            visitor.tell("Correct. Riddle solved.");
            return true;
        } else {
            visitor.tell("WRONG. A next time isn't guaranteed.");
            return false;
        }
    }
}
