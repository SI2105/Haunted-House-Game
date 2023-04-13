package OOP.ec22612.MP.contributions;

class Room_ec22793 extends Room {

	public Direction visit(Visitor visitor, Direction directionOfArrival){
        visitor.tell("WELCOME TO MY ROOM.");
        visitor.tell("YOU WILL BE ASKED A VERY IMPORTANT QUESTION. ANSWER CORRECTLY OR ELSE.");
        
        if(askImportantQuestion(visitor)){
            visitor.tell("Correct! Here is some gold and a trophy.");
            Item trophy = new Item("Trophy");
            visitor.giveItem(trophy);
            visitor.giveGold(10);
        } else {
            visitor.tell("YOU ARE INCORRECT!!!! DISGRACEFUL. GIVE ME YOUR GOLD.");
            int goldTaken = visitor.takeGold(10);
            visitor.tell("I TOOK " + goldTaken + " GOLD.");
        }
        
        visitor.tell("Bye");
        return Direction.opposite(directionOfArrival);
    }
    
    public Boolean askImportantQuestion(Visitor visitor){
        char[] choices = {'Y','N'};
        char visitorChoice = visitor.getChoice("IS BORUTO GOATED? Y/N",choices);
        
        if(visitorChoice == 'Y'){
            visitor.tell("Correct.");
            return true;
        } else {
            visitor.tell("INCORRECT.");
            return false;
        }
        
    }
}
