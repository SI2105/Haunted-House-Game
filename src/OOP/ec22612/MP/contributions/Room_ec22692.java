package OOP.ec22612.MP.contributions;

class Room_ec22692 extends Room {
	
	Item katana = new Item("Katana");
	Item healthPot = new Item("Healing Potion");
	boolean visited = false;
	boolean option_a = false;
	boolean option_b = false;
	boolean option_c = false;
	boolean trap = false;
	
	public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
		
		if(visited) {
			visitor.tell("You've been here (room ec22692) before");
		} else {
			visitor.tell("You've now entered room ec22692 and imediately find some gold lying on the floor!");
			visitor.giveGold(2);
		}
			
		if(visited) {
			
		} else {
			
		}
		
		char userInput;
		
		if(visited) {
			
			userInput = visitor.getChoice(
			"You see the same desk, cabinet and busted door \na) Search the desk \nb) Search the cabinet \nc) Enter through the door", (new char[] {'a', 'b', 'c'}));
			
		} else {
			
			userInput = visitor.getChoice(
			"As you search around, you see a desk, a cabinet and a busted door. You have some options: \na) Search the desk \nb) Search the cabinet \nc) Enter through the door", (new char[] {'a', 'b', 'c'}));
		}
		
		switch(userInput) {
			
			case 'a':
				
				if(option_a) {
					
					visitor.tell("You dont find anything new.");
					break;
			
				} else {
					
					visitor.tell("You've searched the desk and found a " + healthPot.name + " and some gold!");
					visitor.giveGold(5);

					if(visitor.hasEqualItem(healthPot) || visitor.hasIdenticalItem(healthPot)) {
						visitor.tell("You already have a " + healthPot.name + " and cannot carry another one.");
					} else {
						visitor.giveItem(healthPot);
					}
					option_a = true;
					break;
				}
			
			case 'b':
				
				if(option_b) {
					
					visitor.tell("You dont find anything new.");
					break;
			
				} else {
					
					visitor.tell("You've searched the cabinet and found a " + katana.name + "!");
					if(visitor.hasEqualItem(katana) || visitor.hasIdenticalItem(katana)) {
						visitor.tell("You already have a " + katana.name + " and cannot hold another one.");
					} else {
						
					visitor.giveItem(katana);
					option_b = true;
					break;
					}
				}
					
					
			case 'c':
					
				if(option_c) {
					visitor.tell("You dont fall for the same trap again and find some gold!");
					visitor.giveGold(4);
					break;
			
				} else {
					
					visitor.tell("As you opened the door, there was a skull that rolled infront of you!");
					visitor.tell("You got scared and droped some gold");
					visitor.takeGold(7);
					option_c = true;
					break;
				}
					
		}

		
		
		visitor.tell("After searching the house you try to find a way out");
		userInput = visitor.getChoice("After searching, you find two exits :\na) Door on the left \nb) Door on the right",(new char[] {'a', 'b'}));
		
		switch(userInput) {
			
			case 'a' :
				
				visitor.tell("You make your way through the door.");
				break;
				
			case 'b' :
				
				if(trap) {
					visitor.tell("You remember about the trap and avoid it and make your way through.");
					break;
					
				} else {
					
					visitor.tell("You go through the door and hit a trap. You have water poured all over you and end up dropping some gold!");
					visitor.takeGold(5);
					trap = true;
					break;
			
				}
				
		}

		visitor.tell("You eventually make your way out of the room " + directionVistorArrivesFrom.opposite(directionVistorArrivesFrom).toString() + ".");
		visited = true;
		
		return (directionVistorArrivesFrom.opposite(directionVistorArrivesFrom));
		 
	}
}
										
