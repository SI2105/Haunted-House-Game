package OOP.ec22612.MP.contributions;

class Room_ec221004 extends Room {
	static boolean visited = false;
   public Direction visit(Visitor visitor, Direction from) {
	Direction d = from;
	if(!visited){
	visitor.tell("you enter a decrepit room");
	visitor.tell("there is massive hole in the floor");
	  char [] choices = {'1', '2'};
        char choiceMade = visitor.getChoice(("1.Search the room\n2.leave"), choices);
		if(choiceMade == choices[0]){
			visitor.tell("you find 5 gold under some rubble");
			visitor.giveGold(5);
		} else if(choiceMade == choices[1]){
			visitor.tell("You go to leave the room.");
			 d = Direction.opposite(from);
      		}
		visited = true;
	} else {
          visitor.tell("You've been here before and leave the room.");
           d = Direction.opposite(from);
	} 
	 return d;
  }
}

